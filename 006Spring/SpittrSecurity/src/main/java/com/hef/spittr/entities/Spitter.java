package com.hef.spittr.entities;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 用户
 */
public class Spitter {

    private Long sId;
    @NotNull
    @Size(min=2, max=16, message = "{username.size}")
    private String username;
    @NotNull
    @Size(min=6, max=25, message = "{password.size}")
    private String password;
    @NotNull
    @Size(min = 2, max = 30, message = "{firstName.size}")
    private String firstName;
    @NotNull
    @Size(min = 3, max = 30, message = "{lastName.size}")
    private String lastName;

    public Spitter(){}
    public Spitter(String username, String password, String firstName, String lastName) {
        this.sId = null;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Spitter(Long sId, String username, String password, String firstName, String lastName) {
        this.sId = sId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Spitter(String username) {
        this.username = username;
        this.password = "password";
        this.firstName = "Xiao";
        this.lastName = "Ming";
        this.sId = Long.parseLong(Math.random() * 100 +"");
    }

    public Long getsId() {
        return sId;
    }

    public void setsId(Long sId) {
        this.sId = sId;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Spitter{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, "firstName", "lastName", "username", "password");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "firstName", "lastName", "username", "password");
    }
}
