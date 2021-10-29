package me.Ermolay.Commands;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandParamType;
import cn.nukkit.command.data.CommandParameter;
import me.Ermolay.Manager.DataBaseManager;

public class SetDonateCommand extends Command {

    public SetDonateCommand() {//gives a privilege to the player in the donate table
        super("setdonate", "sets donate");

        this.setPermission("setdonate.do");

        this.commandParameters.clear();
        this.commandParameters.put("default", new CommandParameter[]{
                CommandParameter.newType("player", false, CommandParamType.TARGET),
                CommandParameter.newType("donate", false, CommandParamType.STRING)

        });
    }

    @Override
    public boolean execute(CommandSender commandSender, String command, String[] args) {
        if(args.length == 2){
            String name = args[0];
            String donate = args[1];

            DataBaseManager.setDonate(name, donate);
        }
        return false;
    }
}
