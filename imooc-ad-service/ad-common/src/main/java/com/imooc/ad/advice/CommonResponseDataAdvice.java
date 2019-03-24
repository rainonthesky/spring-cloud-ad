package com.imooc.ad.advice;

import com.imooc.ad.annotation.IgnoreResponseAdvice;
import com.imooc.ad.vo.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
@RestControllerAdvice
public class CommonResponseDataAdvice implements ResponseBodyAdvice {
    @Override
    @SuppressWarnings("all")
    public boolean supports(MethodParameter returnType, Class converterType) {
        //响应是否被拦截，是否支持拦截

        if(returnType.getDeclaringClass().isAnnotationPresent(
                IgnoreResponseAdvice.class
        )){
            return false;
        }

        if(returnType.getMethod().isAnnotationPresent(
                IgnoreResponseAdvice.class
        )){
            return false;
        }
        return true;
    }

    @Nullable
    @Override
    @SuppressWarnings("all")
    public Object beforeBodyWrite(@Nullable Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        //在写入响应之前做一些操作
        CommonResponse responsecommon=new CommonResponse(0,"");
        if(null==body){
            return  responsecommon;

        }else if(body instanceof CommonResponse){
           responsecommon=(CommonResponse<Object>)body;
        }else {
            responsecommon.setData(body);

        }
        return responsecommon;
    }
}
