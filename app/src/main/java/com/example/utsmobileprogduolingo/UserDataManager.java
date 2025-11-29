package com.example.utsmobileprogduolingo;

import java.util.HashMap;

public class UserDataManager {

    private static UserDataManager instance;

    private HashMap<String, String> userPasswords = new HashMap<>();
    private HashMap<String, String> userDisplayNames = new HashMap<>();
    private String currentLoggedInUser = null;

    private UserDataManager() {}

    public static UserDataManager getInstance() {
        if (instance == null) {
            instance = new UserDataManager();
        }
        return instance;
    }

    public boolean registerUser(String username, String password, String displayName) {
        if (userPasswords.containsKey(username)) {
            return false;
        }
        userPasswords.put(username, password);
        userDisplayNames.put(username, displayName);
        return true;
    }

    public boolean loginUser(String username, String password) {
        if (userPasswords.containsKey(username)) {
            boolean passwordMatch = userPasswords.get(username).equals(password);
            if (passwordMatch) {
                this.currentLoggedInUser = username;
            }
            return passwordMatch;
        }
        return false;
    }

    public String getLoggedInUser() {
        return this.currentLoggedInUser;
    }

    public String getLoggedInDisplayName() {
        if (this.currentLoggedInUser == null) {
            return null;
        }
        return userDisplayNames.get(this.currentLoggedInUser);
    }
}