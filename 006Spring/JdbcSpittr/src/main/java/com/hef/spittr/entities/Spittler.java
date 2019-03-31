package com.hef.spittr.entities;

public class Spittler {

    //username, password, fullname, email, updateByEmail
    private String fullname;
    private String username;
    private String password;
    private String email;
    private Boolean updateByEmail;

    public Spittler() {
    }

    public Spittler(String fullname, String username, String password, String email, Boolean updateByEmail) {
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.updateByEmail = updateByEmail;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getUpdateByEmail() {
        return updateByEmail;
    }

    public void setUpdateByEmail(Boolean updateByEmail) {
        this.updateByEmail = updateByEmail;
    }

    @Override
    public String toString() {
        return "Spittler{" +
                "fullname='" + fullname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", updateByEmail=" + updateByEmail +
                '}';
    }
}
