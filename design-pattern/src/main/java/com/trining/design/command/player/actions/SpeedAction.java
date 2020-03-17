package com.trining.design.command.player.actions;


import com.trining.design.command.player.GPlayer;
import com.trining.design.command.player.IAction;

public class SpeedAction implements IAction {
    private GPlayer gplayer;

    public SpeedAction(GPlayer gplayer) {
        this.gplayer = gplayer;
    }

    public void execute() {
        gplayer.speed();
    }
}
