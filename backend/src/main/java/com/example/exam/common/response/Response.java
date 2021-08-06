package com.example.exam.common.response;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
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

    private String message;

    private Object result;

    public enum ResponseEnum{
        //成功
        SUCCESS(200, "请求成功!"),
        //请求失败
        FAIL(400,"请求失败!");

        private final Integer responseCode;

        /**
         * 错误描述
         */
        private final String responseMsg;

        ResponseEnum(Integer responseCode, String responseMsg) {
            this.responseCode = responseCode;
            this.responseMsg = responseMsg;
        }

        public String getResponseMsg() {
            return responseMsg;
        }

        public Integer getResponseCode(){
            return responseCode;
        }
    }

    /**
     * success
     *
     * @param result 数据
     * @return Response
     * @author zyimm
     */
    public static Response success(Object result) {
        return success(ResponseEnum.SUCCESS.getResponseCode(), ResponseEnum.SUCCESS.getResponseMsg(), result);
    }

    public static Response success(int code, String msg, Object result) {
        Response Response = new Response();
        Response.setCode(code);
        Response.setMessage(msg);
        Response.setResult(result);
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
        return fail(ResponseEnum.FAIL.getResponseCode(), msg, Response.getDefaultObject());
    }

    /**
     * 失败
     *
     * @param code code
     * @param message message
     * @return Response
     */
    public static Response fail(Integer code, String message) {
        //
        return fail(code, message, Response.getDefaultObject());
    }

    /**
     * 失败
     *
     * @param msg 提示语
     * @param result 数据
     * @return Response
     */
    public static Response fail(String msg, Object result) {
        //
        return fail(ResponseEnum.FAIL.getResponseCode(), msg, result);
    }

    /**
     * 失败
     *
     * @param code 错误码
     * @param msg 消息
     * @param result 数据
     * @return Response
     */
    public static Response fail(int code, String msg, Object result) {
        Response Response = new Response();
        Response.setCode(code);
        Response.setMessage(msg);
        Response.setResult(result);
        return Response;
    }

    public static JSONObject getDefaultObject(){
        String jsonStr = "{}";
        return JSONUtil.parseObj(jsonStr);
    }
}
