package com.auch.camel.ftp.template;

/**
 * <p>游戏</p>
 *
 * @author luohuiqi
 * @date 2021/3/29 09:26
 */
public abstract class Game {

    protected abstract void initialize();

    protected abstract void startplay();

    protected abstract void endPlay();

    public final void play() {
        if (isButton()) {
            this.initialize();
        }
        this.startplay();
        this.endPlay();
    }

    protected boolean isButton() {
        return  true;
    }
}
