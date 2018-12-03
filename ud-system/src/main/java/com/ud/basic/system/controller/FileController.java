package com.ud.basic.system.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ud.basic.common.model.ResultBean;
import com.ud.basic.system.biz.service.FileService;
import com.ud.basic.system.controller.model.file.SysFileVO;
import com.ud.basic.system.core.storage.FileUploader;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(tags={"文件接口"})
@Controller
@RequestMapping(value="/file")
public class FileController {
    
    @Resource
    FileUploader fileUploader;
    @Autowired
    FileService fileService;
    
    @ApiOperation(value = "文件上传")
	@RequestMapping(value="/upload", method = {RequestMethod.POST})
	@ResponseBody
	public ResultBean<SysFileVO> upload(@RequestParam(value="file",required=false) MultipartFile file){
		return new ResultBean<SysFileVO>(fileService.upload(file));
	}
	
    @ApiOperation(value = "文件视图")
	@RequestMapping(value="/view", method = {RequestMethod.GET})
    public void view(String fileCode, HttpServletResponse response) {
    	fileService.view(fileCode, response);
    }
    
    @ApiOperation(value = "文件上传2")
	@RequestMapping(value="/upload2", method = {RequestMethod.POST})
	@ResponseBody
	public ResultBean<SysFileVO> upload2(@RequestParam(value="file",required=false) MultipartFile file){
		return new ResultBean<SysFileVO>(fileService.upload2(file));
	}
	
}
