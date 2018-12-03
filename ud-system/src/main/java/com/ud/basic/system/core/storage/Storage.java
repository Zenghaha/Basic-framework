package com.ud.basic.system.core.storage;

import java.io.File;

/**
 * 文件存储策略接口
 * 
 * @author SimonYee
 *
 */
public interface Storage {

    public enum Type {
        local,
        remote;
    }

    /**
     * 文件元数据
     * 
     * @author SimonYee
     *
     */
    public class MetaData {

        private String mime;

        private String encoding;

        private String fileName;

        private long fileSize;

        public String getMime() {
            return mime;
        }

        public void setMime(String mime) {
            this.mime = mime;
        }

        public String getEncoding() {
            return encoding;
        }

        public void setEncoding(String encoding) {
            this.encoding = encoding;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public long getFileSize() {
            return fileSize;
        }

        public void setFileSize(long fileSize) {
            this.fileSize = fileSize;
        }

    }

    /**
     * 上传本地文件至远端
     * 
     * @param file 本地文件
     * @param key 远端存储key
     * @param meta 文件元数据
     * @return 远程存储URI
     * @throws Exception 异常信息
     */
    public String put(File file, String prefix, String fileName, MetaData meta) throws Exception;

    /**
     * 从远端下载文件到本地
     * 
     * @param key 远端存储key
     * @param file 本地文件
     * @return 是否下载成功
     * @throws Exception 异常信息
     */
    public boolean get(String key, File file) throws Exception;

    /**
     * 拷贝远端文件
     * 
     * @param sourceKey 远端存储源key
     * @param targetKey 远端存储目标key
     * @return 远程存储URI
     * @throws Exception 异常信息
     */
    public String copy(String sourceKey, String targetKey) throws Exception;

    /**
     * 删除远程文件
     * 
     * @param key 远程存储key
     * @throws Exception 异常信息
     */
    public void delete(String key) throws Exception;

    /**
     * 根据key返回远程存储URI
     * 
     * @param key 远程存储key
     * @return 远程存储URI
     * @throws Exception 异常信息
     */
    public String getUrl(String key) throws Exception;

    /**
     * 根据URI返回远程存储key
     * 
     * @param url 远程存储URI
     * @return 远程存储key
     * @throws Exception
     */
    public String getKey(String url) throws Exception;

    /**
     * 返回当前文件存储策略类型
     * 
     * @return 文件存储策略类型
     */
    public Type getType();

}
