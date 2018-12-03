package com.ud.basic.system.biz.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.ud.basic.system.controller.model.file.SysFileVO;

public interface FileService {

	SysFileVO upload(MultipartFile file);

	void view(String fileCode, HttpServletResponse response);

	SysFileVO upload2(MultipartFile file);

}
