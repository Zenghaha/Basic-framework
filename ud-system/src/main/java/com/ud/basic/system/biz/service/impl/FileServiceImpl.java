package com.ud.basic.system.biz.service.impl;


import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ud.basic.system.biz.domain.FileDomain;
import com.ud.basic.system.biz.service.FileService;
import com.ud.basic.system.controller.model.file.SysFileVO;
import com.ud.basic.system.core.storage.FileUploader;
import com.ud.basic.system.core.storage.FileUploader.FileMetaData;
import com.ud.basic.system.persistence.sys.auto.model.SysFile;
import com.ud.basic.common.core.exception.CommonBizException;
import com.ud.basic.common.enums.ResultCode;
import com.ud.basic.common.util.IdGenUtil;
import com.ud.basic.common.util.SftpUtil;

import lombok.extern.slf4j.Slf4j;
import net.sf.jmimemagic.Magic;
import net.sf.jmimemagic.MagicMatch;

@Service
@Slf4j
public class FileServiceImpl implements FileService{

	@Autowired
    FileUploader fileUploader;
	@Autowired
	FileDomain fileDomain;
	@Value("${storage.baseurl}")
	String baseurl;
	@Value("${storage.visit.baseurl}")
	String viewUrl;
	
	
	@Override
	public SysFileVO upload(MultipartFile file){
		SysFileVO vo = null;
		if(null == file){
			throw new CommonBizException(ResultCode.REQUEST_PARAM_ILLEGAL.getModel(), "参数[file]不能为空");
		}
		FileMetaData metaData = null;
		try {
			metaData = fileUploader.upload(file);
		} catch (Exception e) {
			throw new CommonBizException(ResultCode.FILE_UPLOAD_ERROR.getModel());
		}
		SysFile sysFile = new SysFile();
		String fileCode = String.valueOf(IdGenUtil.getId());
		sysFile.setFileCode(fileCode);
		sysFile.setFileName(metaData.getFileName());
		sysFile.setFileSize(metaData.getFileSize());
		sysFile.setFilePath(metaData.getFilePath());
		String fileUrl = viewUrl + fileCode;
		sysFile.setFileUrl(fileUrl);
		fileDomain.add(sysFile);
		vo = new SysFileVO();
		vo.setFileUrl(fileUrl);
		return vo;
	}
	
	@Override
	public void view(String fileCode, HttpServletResponse response) {
//		response.setContentType("image/jpeg");
		InputStream fis = null;
		SysFile sysFile = fileDomain.getByFileCode(fileCode);
		if(null == sysFile) {
			throw new CommonBizException(ResultCode.FILE_NOT_EXIST.getModel());
		}
		String fileUrl = baseurl + sysFile.getFilePath();
		try {
            ServletOutputStream outStream = response.getOutputStream();
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(fileUrl);
            HttpResponse httpResponse = httpClient.execute(httpget);
            HttpEntity entity = httpResponse.getEntity();
            response.setContentType(entity.getContentType().getValue());
            fis = entity.getContent();
//            System.out.println(entity.getContentType().getValue());
            byte[] buffer = new byte[1024];
            int len = 0;
//            MagicMatch match = Magic.getMagicMatch(buffer);
//            String mimeType = match.getMimeType();
//            response.setContentType(mimeType);

            while ((len = fis.read(buffer)) != -1) {
            	outStream.write(buffer,0,len);
            }
            
        } catch (Exception ex) {
        	throw new CommonBizException(ResultCode.GET_FILE_STREAM_ERROR.getModel(),ex);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                	log.error("文件流关闭异常");
                }
            }
        }
	}
	
	@Override
	public SysFileVO upload2(MultipartFile file){
		SysFileVO vo = null;
		if(null == file){
			throw new CommonBizException(ResultCode.REQUEST_PARAM_ILLEGAL.getModel(), "参数[file]不能为空");
		}
//		FileMetaData metaData = null;
		String fileName = IdGenUtil.get32UUID();
		String remote = "/opt/apache-tomcat-cheat/webapps/data/temp";
		try {
//			metaData = fileUploader.upload(file);
			SftpUtil.upload("192.168.1.125", 22, "root", "admin", file.getInputStream(), remote, fileName);
			
		} catch (Exception e) {
			throw new CommonBizException(ResultCode.FILE_UPLOAD_ERROR.getModel());
		}
		SysFile sysFile = new SysFile();
		String fileCode = String.valueOf(IdGenUtil.getId());
		sysFile.setFileCode(fileCode);
		sysFile.setFileName(file.getName());
		sysFile.setFileSize(file.getSize());
		sysFile.setFilePath("temp/"+fileName);
		String fileUrl = viewUrl + fileCode;
		sysFile.setFileUrl(fileUrl);
		fileDomain.add(sysFile);
		vo = new SysFileVO();
		vo.setFileUrl(fileUrl);
		return vo;
	}
	
}
