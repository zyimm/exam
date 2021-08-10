package com.example.exam.common.exception;

import cn.dev33.satoken.exception.NotLoginException;

/**
 *
 * @author ZYIMM
 */
public enum ExceptionEnum {


    /**
     * 未提供token
     */
    NOT_TOKEN(NotLoginException.NOT_TOKEN, NotLoginException.NOT_TOKEN_MESSAGE),

    INVALID_TOKEN(NotLoginException.INVALID_TOKEN,NotLoginException.INVALID_TOKEN_MESSAGE),

    TOKEN_TIMEOUT(NotLoginException.TOKEN_TIMEOUT,NotLoginException.TOKEN_TIMEOUT_MESSAGE),

    BE_REPLACED(NotLoginException.BE_REPLACED,NotLoginException.BE_REPLACED_MESSAGE),

    KICK_OUT(NotLoginException.KICK_OUT, NotLoginException.KICK_OUT_MESSAGE);

    /**
     * code
     */
    private final String exceptionCode;

    /**
     * 错误描述
     */
    private final String exceptionMessage;

    ExceptionEnum(String exceptionCode, String exceptionMessage) {
        this.exceptionCode = exceptionCode;
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public String getExceptionCode(){
        return exceptionCode;
    }


    /**
     * 根据code匹配
     *
     * @param  exceptionCode 错误code
     * @return ExceptionEnum|null
     */
    public static ExceptionEnum matchExceptionMessage(String exceptionCode)
    {
        for (ExceptionEnum item : ExceptionEnum.values()) {
            if (item.getExceptionCode().equals(exceptionCode)) {
                return item;
            }
        }
        return null;
    }
}
