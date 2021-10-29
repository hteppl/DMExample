package me.Ermolay.utils;

import me.hteppl.data.database.SQLiteDatabase;
import org.sql2o.Connection;

public class SqLiteManager {
    private static SQLiteDatabase main;

    public SqLiteManager(){
        main = new DataBase();
    }//create database and tables

    public static Connection getConnection() {
        return main.getConnection();
    }//return connection
}
