package com.myexample.twotables.helper;

public class DBHelper {

    public static String addPrefix(String tableName, String column) {
        return tableName + "." + column;
    }
}
