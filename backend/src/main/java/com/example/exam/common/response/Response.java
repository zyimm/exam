package com.example.exam.common.response;

import lombok.Data;


/**
 * 统一返回
 *
 * @author ZYIMM
 */
@Data

public class Response {

    /**
     *  code 200是正常，非200表示异常
     */
    private int code;

    private String msg;

    private Object data;

    public enum ResponseEnum{
        //成功
        SUCCESS(200, "请求成功!"),
        //请求失败
        FAIL(400,"请求失败!");

        private final Integer ResponseCode;

        /**
         * 错误描述
         */
        private final String ResponseMsg;

        ResponseEnum(Integer ResponseCode, String ResponseMsg) {
            this.ResponseCode = ResponseCode;
            this.ResponseMsg = ResponseMsg;
        }

        public String getResponseMsg() {
            return ResponseMsg;
        }

        public Integer getResponseCode(){
            return ResponseCode;
        }
    }

    /**
     * success
     *
     * @param data 数据
     * @return Response
     * @author zyimm
     */
    @org.jetbrains.annotations.NotNull
    public static Response success(Object data) {
        return success(ResponseEnum.SUCCESS.getResponseCode(), ResponseEnum.SUCCESS.getResponseMsg(), data);
    }

    public static Response success(int code, String msg, Object data) {
        Response Response = new Response();
        Response.setCode(code);
        Response.setMsg(msg);
        Response.setData(data);
        return Response;
    }


    /**
     * 失败
     *
     * @param msg 提示语
     * @return Response
     */
    public static Response fail(String msg) {
        //
        return fail(ResponseEnum.FAIL.getResponseCode(), msg, null);
    }


    /**
     * 失败
     *
     * @param code code
     * @param msg msg
     * @return Response
     */
    public static Response fail(Integer code, String msg) {
        //
        return fail(code, msg, null);
    }

    /**
     * 失败
     *
     * @param msg 提示语
     * @param data 数据
     * @return Response
     */
    public static Response fail(String msg, Object data) {
        //
        return fail(ResponseEnum.FAIL.getResponseCode(), msg, data);
    }

    /**
     * 失败
     *
     * @param code 错误码
     * @param msg 消息
     * @param data 数据
     * @return Response
     */
    public static Response fail(int code, String msg, Object data) {
        Response Response = new Response();
        Response.setCode(code);
        Response.setMsg(msg);
        Response.setData(data);
        return Response;
    }
}
