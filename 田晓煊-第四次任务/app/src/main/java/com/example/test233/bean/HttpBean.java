package com.example.test233.bean;

import java.util.Map;

public class HttpBean {
    String url;
    String mehton;
    Map<String,String> map;

    public HttpBean(String url,String mehton,Map<String,String> map)
    {
        this.map = map;
        this.mehton = mehton;
        this.url = url;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public String getMehton() {
        return mehton;
    }

    public String getUrl() {
        return url;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setMehton(String mehton) {
        this.mehton = mehton;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
