package com.example.Integrador.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class UserDTO {

    private int userid;
    private String username;
    private String userlastname;
    private String email;
    private int number;
    private int idaccount;
    private String idcareer;

    private String password;

    public UserDTO(int userid, String username, String userlastname, String email, int number, int idaccount, String idcareer,String password) {
        this.userid = userid;
        this.username = username;
        this.userlastname = userlastname;
        this.email = email;
        this.number = number;
        this.idaccount = idaccount;
        this.idcareer = idcareer;
        this.password = password;
    }

    public UserDTO() {
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserlastname() {
        return userlastname;
    }

    public void setUserlastname(String userlastname) {
        this.userlastname = userlastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getIdaccount() {
        return idaccount;
    }

    public void setIdaccount(int idaccount) {
        this.idaccount = idaccount;
    }

    public String getIdcareer() {
        return idcareer;
    }

    public void setIdcareer(String idcareer) {
        this.idcareer = idcareer;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", userlastname='" + userlastname + '\'' +
                ", email='" + email + '\'' +
                ", number=" + number +
                ", idaccount=" + idaccount +
                ", idcareer='" + idcareer + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
