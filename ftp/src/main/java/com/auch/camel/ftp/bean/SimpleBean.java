package com.auch.camel.ftp.bean;

/**
 * <p>简单bean</p>
 *
 * @author luohuiqi
 * @date 2021/3/19 10:15
 */
public class SimpleBean {

    public String hello(String message) throws InterruptedException {
        System.err.println("************* Hello " + message + " ************");
        return "Hello" + message;
    }
}
