package com.example.Integrador.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_id", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;

    @Column(name = "user_name",length = 255)
    private String username;

    @Column(name = "user_lastname",length = 255)
    private String userlastname;

    @Column(name = "user_email",length = 255)
    private String email;

    @Column(name = "user_number",length = 9)
    private int number;

    @Column(name = "user_idaccount",length = 6)
    private int idaccount;

    @Column(name = "user_idcareer",length = 3)
    private String idcareer;

    @Column(name = "user_password",length = 50)
    private String password;

    public User(int userid, String username, String userlastname, String email, int number, int idaccount, String idcareer, String password) {
        this.userid = userid;
        this.username = username;
        this.userlastname = userlastname;
        this.email = email;
        this.number = number;
        this.idaccount = idaccount;
        this.idcareer = idcareer;
        this.password = password;
    }

    public User() {
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

}
