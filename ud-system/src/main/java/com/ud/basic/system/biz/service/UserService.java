package com.ud.basic.system.biz.service;

import com.ud.basic.common.model.PageData;
import com.ud.basic.system.controller.model.user.DeleteUserRequest;
import com.ud.basic.system.controller.model.user.EditUserRequest;
import com.ud.basic.system.controller.model.user.ListUserVO;
import com.ud.basic.system.controller.model.user.ListUsersRequest;
import com.ud.basic.system.controller.model.user.SaveUserRequest;
import com.ud.basic.system.controller.model.user.SysUserVO;
import com.ud.basic.system.controller.model.user.UserDetailRequest;

public interface UserService {

	SysUserVO getLoginUser();

	PageData<ListUserVO> listUsers(ListUsersRequest request);

	Void deleteUser(DeleteUserRequest request);

	Void saveUser(SaveUserRequest request);

	SysUserVO userDetail(UserDetailRequest request);

	Void editUser(EditUserRequest request);

}
