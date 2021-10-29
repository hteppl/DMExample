package me.Ermolay;

import cn.nukkit.plugin.PluginBase;
import me.Ermolay.Commands.SetDonateCommand;
import me.Ermolay.Events.PlayerLoginEvent;
import me.Ermolay.utils.SqLiteManager;

public class RegisterPlayers extends PluginBase {

    @Override
    public void onEnable() {
        new SqLiteManager();//connect to database

        this.getServer().getPluginManager().registerEvents(new PlayerLoginEvent(), this);

        this.getServer().getCommandMap().register("setdonate", new SetDonateCommand());
    }
}
