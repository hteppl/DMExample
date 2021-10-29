package me.Ermolay.utils;

import me.hteppl.data.database.SQLiteDatabase;

public class DataBase extends SQLiteDatabase {
    public DataBase(){
        super("players");//database name

        String sql = "CREATE TABLE IF NOT EXISTS registerPlayers (\n"
                + "	xuid STRING UNIQUE,\n"
                + "	name STRING NOT NULL,\n"
                + " registerTime LONG\n"
                + ");\n"
                + "CREATE TABLE IF NOT EXISTS donate (\n"
                + "	xuid STRING UNIQUE,\n"
                + "	donateName STRING NOT NULL\n"
                + ");";

        try{
            this.executeScheme(sql);//creates tables
        } catch (Exception exception){

        }
    }
}
