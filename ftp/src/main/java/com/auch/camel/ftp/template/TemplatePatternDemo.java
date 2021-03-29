package com.auch.camel.ftp.template;

/**
 * <p></p>
 *
 * @author luohuiqi
 * @date 2021/3/29 09:32
 */
public class TemplatePatternDemo {
    public static void main(String[] args) {
        Cricket cricket = new Cricket();
        cricket.setButtonFlag(false);
        cricket.play();
        System.out.println("*****************************我是分割线****************************");
        Football football = new Football();
//        football.setButtonFlag(true);
        football.play();
    }
}
