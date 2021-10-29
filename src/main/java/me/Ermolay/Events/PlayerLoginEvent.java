package me.Ermolay.Events;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerPreLoginEvent;
import cn.nukkit.utils.TextFormat;
import me.Ermolay.Manager.DataBaseManager;

public class PlayerLoginEvent implements Listener {

    @EventHandler
    public void loginEvent(PlayerPreLoginEvent event){
        Player player = event.getPlayer();
        DataBaseManager.registerPlayer(player);//register new players or update name
        String xuid = player.getLoginChainData().getXUID();

        player.setNameTag("(" + DataBaseManager.getDonate(xuid) + ")" + TextFormat.AQUA + player.getName());//sets the privilege to NameTag
    }
}
