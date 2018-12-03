package com.ud.basic.common.enums;

import com.ud.basic.common.model.ResultCodeModel;

import lombok.Getter;

/**
 * 结果编码
 * @author lzp
 */
@Getter
public enum ResultCode {
	//-------------------------------- 0*** 默认结果编码 ------------------------------
	SUCCESS("0000","成功"),
	FAIL("0004", "失败"),
	//-------------------------------- 1*** 基础错误码 ------------------------------
	REQUEST_PARAM_ILLEGAL("1001","请求参数非法"),
	NOT_LOGIN("1100", "尚未登录"),
	LOGIN_USER_NOT_EXIST("1101", "登录用户不存在"),
	LOGIN_PWD_ERROR("1102", "登录密码错误"),
	LOGIN_USER_LOCKED("1103", "登录用户已被锁定"),
	LOGIN_OTHER_ERROR("1104", "登录其他错误"),
	LOGIN_AUTHCODE_ERROR("1105", "验证码错误"),
	LOGIN_NO_AUTH("1106", "没有权限访问"),
	//-------------------------------- 2*** 业务错误码 ------------------------------

	//-------------------------------- 3*** 后台系统错误码 ------------------------------
	SYSUSER_EXIST("3001","用户已存在"),
	EXIST_CHILD("3002","含有子级"),
	ROLE_INUSE("3003","角色使用中"),
	FILE_UPLOAD_ERROR("3004", "文件上传异常"),
	FILE_NOT_EXIST("3005", "文件不存在"),
	GET_FILE_STREAM_ERROR("3006", "获取文件流异常"),
	ORG_ENGLISHNAME_NOT_STANDARD("3007","组织英文名称不规范"),
	ORG_NAME_EXIST("3008","组织名称已存在"),
	ORG_ENGLISHNAME_EXTST("3009","组织英文名已存在"),
	USERNAME_NOT_STANDARD("3007","用户名不规范"),
	
	//-------------------------------- 9*** 系统错误码 ------------------------------
	SYS_EXCEPTION("9999","系统异常"),
	
	;
	
	private final String code;

    private final String desc;

    private ResultCode(String code, String desc){
        this.code = code;
        this.desc = desc;
    }
    
    public ResultCodeModel getModel() {
    	return new ResultCodeModel(this.code, this.desc);
    }
}
