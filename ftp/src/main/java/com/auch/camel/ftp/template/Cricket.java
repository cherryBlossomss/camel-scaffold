package com.auch.camel.ftp.template;

import lombok.Data;

/**
 * <p>板球</p>
 *
 * @author luohuiqi
 * @date 2021/3/29 09:30
 */
@Data
public class Cricket extends Game {

    private boolean buttonFlag = true;

    @Override
    protected void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    protected void startplay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }

    @Override
    protected void endPlay() {
        System.out.println("Cricket Game Finished!");
    }

    @Override
    protected boolean isButton() {
        return this.buttonFlag;
    }
}
