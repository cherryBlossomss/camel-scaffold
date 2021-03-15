package com.auch.camel.timer.test;

import com.auch.camel.timer.test.task.Task;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Timer;

/**
 * <p>定时器测试</p>
 *
 * @author luohuiqi
 * @date 2021/3/15 16:48
 */
public class TimerTest {

    /**
     * <p>设定指定任务task在指定时间time执行,只执行一次
     * schedule(TimerTask task, Date time)
     * </p>
     *
     * @author luohuiqi
     * @date : 2021/3/15 16:57
     **/
    public static void timer1() {
        // 设定指定的时间time,此处为2000毫秒
        new Timer().schedule(new Task(), 2000);
    }

    /**
     * <p>设定指定任务task在指定时间执行
     * schedule(TimerTask task, Date time)
     * </p>
     *
     * @author luohuiqi
     * @date : 2021/3/15 17:00
     **/
    public static void timer2() {
        LocalDateTime localDateTime = LocalDateTime.now().plusMinutes(1);
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        new Timer().schedule(new Task(), date);
    }

    /**
     * <p>设定指定任务task在指定延迟delay后进行固定延迟peroid的执行,意即在delay执行一次后，按固定period间隔执行
     * schedule(TimerTask task, long delay, long period)
     * </p>
     *
     * @author luohuiqi
     * @date : 2021/3/15 17:00
     **/
    public static void timer3() {
        new Timer().schedule(new Task(), 1000, 5000);
    }

    /**
     * <p>设定指定任务task在指定时间开始，且以period重复执行
     * schedule(TimerTask task, Date time)
     * </p>
     *
     * @author luohuiqi
     * @date : 2021/3/15 17:00
     **/
    public static void timer4() {
        LocalDateTime localDateTime = LocalDateTime.now().plusMinutes(1);
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        new Timer().schedule(new Task(), date, 1000);
    }

    /**
     * <p>设定指定任务task在指定时间执行
     * schedule(TimerTask task, Date time)
     * </p>
     *
     * @author luohuiqi
     * @date : 2021/3/15 17:00
     **/
    public static void timer5() {
        LocalDateTime localDateTime = LocalDateTime.now().plusMinutes(1);
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        new Timer().scheduleAtFixedRate(new Task(), date, 1000);
    }

    public static void main(String[] args) {

        timer4();
//        timer5();
    }

}
