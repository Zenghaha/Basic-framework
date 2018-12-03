package com.ud.basic.system.core.storage;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ud.basic.system.core.storage.Storage.MetaData;

@Component
public class FileUploader {

    private static final Logger logger = LoggerFactory.getLogger(FileUploader.class);

    @Resource
    Storager storager;

    @Value("${upload.file.allow.ext}")
    String exts;
 
    @Value("${upload.file.check.ext.enabled}")
    boolean check;
    
    private String[] allowedExts = new String[0];

    @PostConstruct
    public void init(){
        logger.info("初始化文件拓展名");
        if(StringUtils.isEmpty(exts)){
            logger.info("没有配置拓展名");
            return;
        }
        allowedExts = exts.split("\\|");
        logger.info("允许被上传的文件拓展名为：" + allowedExts);
    }
    
    public boolean download(String key, File file) throws Exception {
        Storage storage = storager.getStorage();
        return storage.get(key, file);
    }

    public void delete(String key) throws Exception {
        Storage storage = storager.getStorage();
        storage.delete(key);
    }

    public String getKey(String url) throws Exception {
        Storage storage = storager.getStorage();
        return storage.getKey(url);
    }

    public boolean isValid(MultipartFile multipartFile) throws Exception {
        return true;
    }

    /**
     * @param file
     * @return
     * @throws Exception
     */
    public FileMetaData upload(MultipartFile file, String prefix) throws Exception {

        if (file == null)
            return null;

        if (file.isEmpty())
            return null;

        String fileNameOrigin = file.getOriginalFilename();
        String fileSuffix = fileNameOrigin.substring(fileNameOrigin.lastIndexOf("."), fileNameOrigin.length());
        if (StringUtils.isEmpty(fileSuffix)) {
            throw new Exception("文件后缀不合法");
        }

        if (check && (ArrayUtils.indexOf(allowedExts, fileSuffix) < 0)) {
            throw new Exception("文件格式不支持");
        }

        if (!isValid(file)) {
            throw new Exception("文件格式不支持");
        }

        // 复制文件
        long t1 = System.currentTimeMillis();
        File uploadTemp = File.createTempFile("upload", fileSuffix);
        file.transferTo(uploadTemp);
        long t2 = System.currentTimeMillis();

        // 上传文件
        t1 = System.currentTimeMillis();
        Storage storage = storager.getStorage();
        MetaData meta = getMetaData(file);
        prefix = getUploadPrefix(prefix);
        String fileName = storager.buildKey(file.getOriginalFilename());
        String url = storage.put(uploadTemp, prefix, fileName, meta);
        String key = prefix + "/" + fileName;
        t2 = System.currentTimeMillis();
        // 删除上传临时文件
        t1 = System.currentTimeMillis();
        if (uploadTemp.exists()) {
            uploadTemp.delete();
        }
        t2 = System.currentTimeMillis();

        return new FileMetaData(url, key, file.getSize(),file.getOriginalFilename());
    }
    
    public FileMetaData upload(MultipartFile file) throws Exception {
    	return this.upload(file, null);
    }

    public String getUploadKey(String key) {
        return "proof/" + storager.buildKey(key);
    }
    
    public String getUploadPrefix(String prefix) {
    	if(StringUtils.isEmpty(prefix)) {
    		return "proof";
    	}
        return prefix;
    }
    
    public String getUploadKey(String prefix, String key) {
    	if(StringUtils.isEmpty(prefix)) {
    		return this.getUploadKey(key);
    	}
        return prefix + "/" + storager.buildKey(key);
    }

    private MetaData getMetaData(MultipartFile file) {
        MetaData uploadInfo = new MetaData();
        uploadInfo.setFileSize(file.getSize());
        uploadInfo.setMime(file.getContentType());
        return uploadInfo;
    }

    private MetaData getMetaData(File file) {
        MetaData uploadInfo = new MetaData();
        uploadInfo.setFileSize(file.length());
        uploadInfo.setMime(null);
        return uploadInfo;
    }
    
    public static class FileMetaData {

        private String fileUrl;

        private long fileSize;

        private String filePath;
        
        private String fileName;

        public FileMetaData() {
            super();
        }

        public FileMetaData(String fileUrl, String filePath,long fileSize, String fileName) {
            super();
            this.fileUrl = fileUrl;
            this.fileSize = fileSize;
            this.filePath = filePath;
            this.fileName = fileName;
        }

        public String getFileUrl() {
            return fileUrl;
        }

        public void setFileUrl(String fileUrl) {
            this.fileUrl = fileUrl;
        }

        public long getFileSize() {
            return fileSize;
        }

        public void setFileSize(long fileSize) {
            this.fileSize = fileSize;
        }

        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

    }
}
