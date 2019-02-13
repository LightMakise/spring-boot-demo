package com.main.controller.global;
import javax.servlet.http.HttpServletRequest;

import com.main.common.ResponseObject;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;


@ControllerAdvice // 作为一个控制层的切面处理
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class) // 所有的异常都是Exception子类
    @ResponseBody
    public String  defaultErrorHandler(HttpServletRequest request, Exception e) { // 出现异常之后会跳转到此方法
//        ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW); // 设置跳转路径
//        mav.addObject("exception", e); // 将异常对象传递过去
//        mav.addObject("url", request.getRequestURL()); // 获得请求的路径
//        return mav;
        System.out.println("=====================全局异常信息捕获=======================");
        ResponseObject responseObject = new ResponseObject();
        responseObject.setMessage(e.getMessage() == null ? "服务器内部错误" : e.getMessage());
        responseObject.fail();
        return responseObject.getJson();
    }
}
