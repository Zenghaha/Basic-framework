package com.ud.basic.common.util;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.io.File;
import java.io.InputStream;
import java.util.Properties;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Sftp工具类
 * @author xianyongjie
 * @date 2017年2月8日下午3:57:47
 * @see
 * @since
 */
@Slf4j
public class SftpUtil {

  private static ChannelSftp getChannel(String host, int port,
      String userName, String password) throws Exception {
    JSch jsch = new JSch(); // 创建JSch对象
    Session session = jsch.getSession(userName, host, port); // 根据用户名，主机ip，端口获取一个Session对象
    session.setPassword(password); // 设置密码
    Properties config = new Properties();
    config.put("StrictHostKeyChecking", "no");
    session.setConfig(config); // 为Session对象设置properties
    // session.setTimeout(timeout); // 设置timeout时间
    session.connect(); // 通过Session建立链接
    Channel channel = session.openChannel("sftp"); // 打开SFTP通道
    channel.connect(); // 建立SFTP通道的连接
    return (ChannelSftp) channel;
  }

  /**
   * 上传文件到FTP服务器
   *
   * @param local 本地文件或者目录
   * @param remote 远程目录
   */
  public static void upload(String host, int port, String userName,
      String password, String local, String remote) throws Exception {
    File file = new File(local);
    if (!file.exists()) {
      throw new RuntimeException("文件不存在");
    }
    ChannelSftp channel = null;
    try {
      channel = getChannel(host, port, userName, password);
      uploadFile(channel, file, remote);
    } catch (Exception e) {
      throw e;
    } finally {
      closeChannel(channel);
    }

  }

  /**
   * 上传文件到ftp服务器
   *
   * @param remote 远程目录
   * @param fileName 文件名
   */
  public static void upload(String host, int port, String userName,
      String password, InputStream inputStream, String remote, String fileName) throws Exception {
    ChannelSftp channel = null;
    try {
      channel = getChannel(host, port, userName, password);
      createDir(channel, remote);
      channel.put(inputStream, remote + "/" + fileName);
    } catch (Exception e) {
      throw e;
    } finally {
      closeChannel(channel);
      if (inputStream != null) {
        inputStream.close();
      }
    }
  }

  /**
   * @param file 本地文件或者目录
   * @param remote 远程目录
   */
  private static void uploadFile(ChannelSftp channel, File file, String remote)
      throws Exception {
    if (file.isDirectory()) {
      remote += "/" + file.getName();
      File[] files = file.listFiles();
      for (File f : files) {
        uploadFile(channel, f, remote + "/" + f.getName());
      }
    } else {
      createDir(channel, remote);
      channel.put(file.getPath(), remote + "/" + file.getName());
    }
  }

  /**
   * 下载文件
   *
   * @param remote 远程文件或者目录
   * @param local 本地目录
   */
  public static void download(String host, int port, String userName,
      String password, String remote, String local) throws Exception {
    ChannelSftp channel = null;
    try {
      channel = getChannel(host, port, userName, password);
      downloadFile(channel, remote, local);
    } catch (Exception e) {
      throw e;
    } finally {
      closeChannel(channel);
    }

  }

  /**
   * @param remote 远程文件或者目录
   * @param local 本地目录
   */
  private static void downloadFile(ChannelSftp channel, String remote,
      String local) throws Exception {

    String remoteFileName = remote.substring(remote.lastIndexOf("/") + 1,
        remote.length());
    File loFile = new File(local + "/" + remoteFileName);

    if (!channel.lstat(remote).isDir()) {
      //remote是文件
      File parentFile = loFile.getParentFile();
      if (parentFile != null && !parentFile.exists()) {
        parentFile.mkdirs();
      }

      channel.get(remote, loFile.getPath());

    } else {
      java.util.Vector<LsEntry> vector = null;
      vector = channel.ls(remote);
      if (vector != null) {// remote是目录时
        for (LsEntry bean : vector) {
          if (".".equals(bean.getFilename()) || "..".equals(bean.getFilename())) {
            continue;
          }
          String rfPath = remote + "/" + bean.getFilename();
          if (bean.getAttrs().isDir()) {
            downloadFile(channel, rfPath, loFile.getPath());
          } else {
            if (loFile != null && !loFile.exists()) {
              loFile.mkdirs();
            }
            channel.get(rfPath,
                loFile.getPath() + "/" + bean.getFilename());
          }

        }
      }
    }


  }

  /**
   * 关闭连接通道
   */
  private static void closeChannel(Channel channel) {
    if (channel == null) {
      return;
    }
    channel.disconnect();
    try {
      // 关闭会话
      if (channel.getSession() != null) {
        channel.getSession().disconnect();
      }
    } catch (Exception e) {
      log.error("关闭连接通道失败",e);
    }
  }

  /**
   * 检测ftp服务器目录是否存在
   *
   * @param remoteDir ftp远程目录
   */
  private static boolean isDirExist(ChannelSftp channel, String remoteDir)
      throws Exception {
    boolean isDirExistFlag = false;
    try {
      isDirExistFlag = channel.lstat(remoteDir).isDir();
      return isDirExistFlag;
    } catch (Exception e) {
      isDirExistFlag = false;
    }
    return isDirExistFlag;
  }

  /**
   * 创建远程目录
   *
   * @param remoteDir 远程目录
   */
  private static void createDir(ChannelSftp channel, String remoteDir)
      throws Exception {
    int index = remoteDir.lastIndexOf("/");
    if (index > 0 && !isDirExist(channel, remoteDir)) {
      String parentDir = remoteDir.substring(0, index);
      createDir(channel, parentDir);
      channel.mkdir(remoteDir);
    }
  }

}
