package com.example.exam.common.exception;

import org.jetbrains.annotations.NotNull;

/**
 * 
 * @author zyimm
 */
public class ExamException extends RuntimeException {

    private final Integer code;

    public  ExamException(@NotNull String message, @NotNull Integer code) {
        super(message);
        this.code = code;
    }

    public  ExamException(@NotNull String message) {
        super(message);
        this.code = 1000;
    }

    public Integer getCode() {
        return code;
    }
}