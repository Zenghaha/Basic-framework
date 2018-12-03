package com.ud.basic.system.core.storage;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.ud.basic.common.util.SftpUtil;

/**
 * 本地存储策略实现
 */
@Component
public class RemoteStorage implements Storage {

    private static final Logger logger = LoggerFactory.getLogger(RemoteStorage.class);

    /**
     * 本地存储基础路径
     */
    @Value("${storage.basepath:#{null}}")
    String basePath;

    /**
     * 本地存储基础URL
     */
    @Value("${storage.baseurl:#{null}}")
    String baseUrl;
    
    @Value("${storage.ftp.host}")
    String host;
    @Value("${storage.ftp.port}")
    String port;
    @Value("${storage.ftp.user}")
    String user;
    @Value("${storage.ftp.pwd}")
    String pwd;

    public Type getType() {
        return Type.remote;
    }

    public String put(File file, String prefix, String fileName, MetaData meta) throws Exception {
        if (file == null)
            throw new IllegalArgumentException("file不能为空");
        if (StringUtils.isEmpty(prefix))
            throw new IllegalArgumentException("prefix不能为空");
        if (StringUtils.isEmpty(fileName))
            throw new IllegalArgumentException("fileName不能为空");
        long t1 = System.currentTimeMillis();
        
        String key = prefix + fileName;
        String remote = basePath + prefix + "/";
        SftpUtil.upload(host, Integer.valueOf(port), user, pwd, new FileInputStream(file), remote, fileName);
        
        long t2 = System.currentTimeMillis();
        logger.info("Remote上传文件 key={} 耗时 {} ms", key, t2 - t1);
        return getUrl(key);
    }

    public boolean get(String key, File file) throws Exception {
        if (StringUtils.isEmpty(key))
            throw new IllegalArgumentException("key不能为空");

        if (file == null)
            throw new IllegalArgumentException("file不能为空");

        long t1 = System.currentTimeMillis();

        File source = new File(getLocalPath(key));
        if (!source.exists())
            return false;

        File targetParent = file.getParentFile();
        if (!targetParent.exists()) {
            targetParent.mkdirs();
        }

        FileUtils.copyFile(source, file);
        long t2 = System.currentTimeMillis();
        logger.info("Local下载文件 key={} 耗时 {} ms", key, t2 - t1);
        return true;
    }

    public String copy(String sourceKey, String targetKey) throws Exception {
        if (StringUtils.isEmpty(sourceKey) || StringUtils.isEmpty(targetKey))
            throw new IllegalArgumentException("key不能为空");

        long t1 = System.currentTimeMillis();
        File sourceFile = new File(getLocalPath(sourceKey));
        File targetFile = new File(getLocalPath(targetKey));
        File targetParent = targetFile.getParentFile();
        if (!targetParent.exists()) {
            targetParent.mkdirs();
        }
        FileUtils.copyFile(sourceFile, targetFile);
        long t2 = System.currentTimeMillis();
        logger.info("Local复制文件 key={} 耗时 {} ms", sourceKey, t2 - t1);
        return getUrl(targetKey);
    }

    public void delete(String key) throws Exception {
        if (StringUtils.isEmpty(key))
            throw new IllegalArgumentException("key不能为空");

        long t1 = System.currentTimeMillis();
        File targetFile = new File(getLocalPath(key));
        FileUtils.deleteQuietly(targetFile);
        long t2 = System.currentTimeMillis();
        logger.info("Local删除文件 key={} 耗时 {} ms", key, t2 - t1);
    }

    public String getUrl(String key) throws Exception {
        if (StringUtils.isEmpty(key))
            throw new IllegalArgumentException("key不能为空");
        return baseUrl + key;
    }

    public String getKey(String url) throws Exception {
        if (StringUtils.isEmpty(url))
            throw new IllegalArgumentException("url不能为空");

        int i = url.indexOf(baseUrl);
        if (i < 0)
            return null;

        String target = url.substring(i + baseUrl.length());
        return target;
    }

    private String getLocalPath(String key) {
        if (StringUtils.isEmpty(key))
            throw new IllegalArgumentException("key不能为空");

        return basePath + key;
    }

}
