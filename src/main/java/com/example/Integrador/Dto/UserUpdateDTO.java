package com.example.Integrador.Dto;

import com.example.Integrador.Entity.User;

public class UserUpdateDTO {

    private String email;
    private String password;
    private String newName;
    private String newPassword;

    public UserUpdateDTO(String email, String password, String newName, String newPassword){
        this.email = email;
        this.password = password;
        this.newName = newName;
        this.newPassword = newPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }


    @Override
    public String toString(){
        return "UserUpdateDTO{" +
                "useremail='"+email+"'"+
                "usercontraseña='"+password+"'"+
                "nuevoname='"+newName+"'"+
                "newPassword='"+newPassword+"'"+
                "}";
    }
}
