package com.imooc.ad.vo;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommonResponse<T>implements Serializable {

    private Integer code;

    private String message;
    private T data;
    public CommonResponse(Integer code,String message){
        this.code=code;
        this.message=message;
    }


}
