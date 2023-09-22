package com.heshanthenura.passman.Services;

public class UserManager {
    private static UserManager instance;
    private String username;

    private UserManager() {
        // Private constructor to enforce Singleton pattern
    }

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

