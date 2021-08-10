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
        private final String responseMessage;

        ResponseEnum(Integer responseCode, String responseMessage) {
            this.responseCode = responseCode;
            this.responseMessage = responseMessage;
        }

        public String getResponseMessage() {
            return responseMessage;
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
        return raw(ResponseEnum.SUCCESS.getResponseCode(), ResponseEnum.SUCCESS.getResponseMessage(), result);
    }

   


    /**
     * 失败
     *
     * @param msg 提示语
     * @return Response
     */
    public static Response fail(String msg) {
        //
        return raw(ResponseEnum.FAIL.getResponseCode(), msg, Response.getDefaultObject());
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
        return raw(code, message, Response.getDefaultObject());
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
        return raw(ResponseEnum.FAIL.getResponseCode(), msg, result);
    }


    /**
     * 空对象返回
     *
     * @return
     */
    public static JSONObject getDefaultObject(){
        String jsonStr = "{}";
        return JSONUtil.parseObj(jsonStr);
    }


    /**
     * raw
     * 
     * 
     * @param code 错误码
     * @param message 消息
     * @param result 数据
     * @return Response
     */
    public static Response raw(int code, String message, Object result) {
        Response response = new Response();
        response.setCode(code);
        response.setMessage(message);
        response.setResult(result);
        return response;
    }
}
