package com.qz.common;

/**
 * Created by Administrator on 2018/4/23.
 */
public class Config {
    private static String ip;
    private static Integer port;
    private static String username;
    private static String password;

    public static String getIp() {
        return ip;
    }

    public static void setIp(String ip) {
        Config.ip = ip;
    }

    public static Integer getPort() {
        return port;
    }

    public static void setPort(Integer port) {
        Config.port = port;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        Config.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Config.password = password;
    }
}
