package com.main.common;

import net.sf.json.JSONObject;

import java.util.HashMap;


public class ResponseObject {
    public HashMap<String,Object> response = new HashMap<String, Object>();

    public HashMap<String,Object> ResponseObject(){
        return this.response;
    }
    public HashMap<String,Object> fail(){
        this.response.put("code",HttpCode.FAIL);
        return this.response;
    }
    public HashMap<String,Object> ok(){
        this.response.put("code",HttpCode.OK);
        return this.response;
    }
    public HashMap<String,Object> setData(Object obj){
        this.response.put("data",obj);
        return this.response;

    }
    public HashMap<String,Object> setMessage(String str){
        this.response.put("message",str);
        return this.response;
    }
    public String getJson(){
        String json = JSONObject.fromObject(this.response).toString();
        return json;
    }
}