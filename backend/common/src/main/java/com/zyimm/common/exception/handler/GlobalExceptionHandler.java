package com.zyimm.common.exception.handler;

import com.zyimm.common.exception.ExamException;
import com.zyimm.common.response.Response;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zyimm
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    
    /**
     * handle 处理
     *
     * @param e 异常
     * @return Result
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Response handleException(Exception e)  {
        String message = e.getMessage();
        if (message == null || message.isEmpty()) {
            message = "服务器出错";
        }
        return Response.fail(message, e.getStackTrace());
    }

    @ExceptionHandler(ExamException.class)
    public Response handleShopException(ExamException e)  {
        String message = e.getMessage();
        if (message == null || message.isEmpty()) {
            message = "服务器出错";
        }
        return Response.fail(e.getCode(), message);
    }

    /**
     * handle 处理
     *
     * @param e 异常
     * @return Response
     */
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        return Response.fail(objectError.getDefaultMessage(), objectError.getArguments());
    }
}
