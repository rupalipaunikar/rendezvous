package com.rendezvous.entity;

public class DeviceToken {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "DeviceToken{" +
                "token='" + token + '\'' +
                '}';
    }
}
