package com.auch.camel.ftp.bean;

/**
 * <p>简单bean</p>
 *
 * @author luohuiqi
 * @date 2021/3/19 10:15
 */
public class Simple001Bean {

    public String hello(String message) {
        System.err.println("************* SB就是你: " + message + " ************");
        return "Hello" + message;
    }
}
