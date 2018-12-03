package com.ud.basic.security.domain;

import com.ud.basic.security.model.LoginUserDO;

public interface LoginDomain {

	LoginUserDO getByUserName(String userName);
}
