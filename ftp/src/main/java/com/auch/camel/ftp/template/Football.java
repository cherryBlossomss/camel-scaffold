package com.auch.camel.ftp.template;

import lombok.Data;

/**
 * <p>足球</p>
 *
 * @author luohuiqi
 * @date 2021/3/29 09:30
 */
@Data
public class Football extends Game {

    private boolean buttonFlag = true;

    @Override
    protected void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    protected void startplay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }

    @Override
    protected void endPlay() {
        System.out.println("Football Game Finished!");
    }

    @Override
    protected boolean isButton() {
        return this.buttonFlag;
    }
}
