package com.twu.biblioteca;

import java.util.HashMap;

public class Authenticator {
    private HashMap<String, String> credentials;

    public Authenticator(HashMap<String, String> credentials) {

        this.credentials = credentials;
    }

    public boolean isAuthorized(String username, String password) {
        return true;
    }
}
