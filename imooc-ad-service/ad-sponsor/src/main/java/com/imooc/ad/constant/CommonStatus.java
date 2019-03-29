package com.imooc.ad.constant;

import lombok.Getter;
import org.omg.CORBA.INVALID_ACTIVITY;

@Getter

public enum  CommonStatus {
    VALID(1,"有效状态"),
    INVALID(2,"无效状态");
    private Integer status;
    private String desc;
    CommonStatus(Integer status,String desc){
        this.status=status;
        this.desc=desc;
    }
}
