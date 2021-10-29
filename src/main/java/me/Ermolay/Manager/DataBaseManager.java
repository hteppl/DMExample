package me.Ermolay.Manager;

import cn.nukkit.Player;
import me.Ermolay.utils.SqLiteManager;
import org.sql2o.Connection;

public class DataBaseManager {

    public static void registerPlayer(Player player){//register new players or update name(the xuid does not change, but the player can change the name)
        String xuid = player.getLoginChainData().getXUID();
        String name = player.getName();

        Long registerTime = System.currentTimeMillis();

        String sql = "INSERT INTO registerPlayers (xuid, name, registerTime) VALUES (:xuid, :name, :registerTime) ON CONFLICT(xuid) \n" +
                "  DO UPDATE SET name=:name;";

        try (Connection connection = SqLiteManager.getConnection()) {
            connection.createQuery(sql)
                    .addParameter("xuid", xuid)
                    .addParameter("name", name)
                    .addParameter("registerTime", registerTime)
                    .executeUpdate();
        }
    }

    public static String getXUIDByName(String name){//will help you find out the xuid by name
        String sql = "SELECT xuid FROM registerPlayers WHERE name=:name;";

        try (Connection connection = SqLiteManager.getConnection()) {
            return connection.createQuery(sql)
                    .addParameter("name", name)
                    .executeScalar(String.class);
        }
    }

    public static void setDonate(String name, String donate){//gives a privilege to the player in the donate table
        String xuid = getXUIDByName(name);

        String sql = "INSERT INTO donate (xuid, donateName) VALUES (:xuid, :donate) ON CONFLICT(xuid) \n" +
                "  DO UPDATE SET donateName=:donate;";

        try (Connection connection = SqLiteManager.getConnection()) {
            connection.createQuery(sql)
                    .addParameter("xuid", xuid)
                    .addParameter("donate", donate)
                    .executeUpdate();
        }
    }

    public static String getDonate(String xuid){//we get the player's donation
        String sql = "SELECT donateName FROM donate WHERE xuid=:xuid;";

        try (Connection connection = SqLiteManager.getConnection()) {
            return connection.createQuery(sql)
                    .addParameter("xuid", xuid)
                    .executeScalar(String.class);
        }catch (Exception exception){
            return "Player";
        }
    }
}
