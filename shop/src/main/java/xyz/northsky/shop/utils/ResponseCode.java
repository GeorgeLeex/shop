package xyz.northsky.shop.utils;

import java.io.Serializable;

public enum ResponseCode implements Serializable {
    OK("操作成功"), NO("操作失败"), NOT_FOUND("未查询到符合条件的数据");

    private String value;


    ResponseCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
