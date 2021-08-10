package com.example.exam.common.exception.handler;

import cn.dev33.satoken.exception.NotLoginException;
import com.example.exam.common.exception.ExceptionEnum;
import com.example.exam.common.response.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author ZYIMM
 */
@RestControllerAdvice
public class NotLoginExceptionHandler {
    /**
     * handle 处理
     *
     * @param e 异常
     * @return Result
     */
    @ResponseBody
    @ExceptionHandler(NotLoginException.class)
    public Response notLoginHandler(NotLoginException e) {
        return Response.fail(ExceptionEnum.matchExceptionMessage(e.getType()).getExceptionMessage());
    }
}
