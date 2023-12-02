package com.example.Integrador.Message;

public class LoginMessage {

    private String message;
    private Boolean status;
    private String username;

    public LoginMessage(String message, Boolean status, String username) {
        this.message = message;
        this.status = status;
        this.username = username;
    }

    public LoginMessage(String inicioDeSesionFallida, boolean b) {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "LoginMessage{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", username='" + username + '\'' +
                '}';
    }
}
