package com.ud.basic.system.biz.enums;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum UserTypeEnum {
	NORMAL_USER("1", "普通用户"),
    ADMIN_USER("2", "管理员用户");

    private final String code;

    private final String desc;

    private UserTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static List<String> getDescs() {
        List<String> list = new ArrayList<>();
        for (UserTypeEnum e : UserTypeEnum.values()) {
            list.add(e.getDesc());
        }
        return list;
    }

    public static String getDescByCode(String code) {
        for (UserTypeEnum e : UserTypeEnum.values()) {
            if (e.getCode().equals(code))
                return e.getDesc();
        }
        return null;
    }
}
