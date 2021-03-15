package com.auch.camel.timer.test.task;

import java.util.TimerTask;

/**
 * <p>任务类</p>
 *
 * @author luohuiqi
 * @date 2021/3/15 16:55
 */
public class Task extends TimerTask {
    @Override
    public void run() {
        System.out.println("老子执行了");
    }
}
