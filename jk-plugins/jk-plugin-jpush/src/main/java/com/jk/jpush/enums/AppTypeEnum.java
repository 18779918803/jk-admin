package com.jk.jpush.enums;

/**
 * APP类型
 *
 * @author 缪隽峰
 * @version 1.0
 * @date 2018年07月03日
 */
public enum AppTypeEnum {

    /**
     * 安卓
     */
    ANDROID("android"),

    /**
     * ios
     */
    IOS("ios");

    AppTypeEnum(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }
}
