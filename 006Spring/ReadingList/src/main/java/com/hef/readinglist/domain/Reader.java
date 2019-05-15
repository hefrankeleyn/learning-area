package com.hef.readinglist.domain;

import org.hibernate.annotations.Proxy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

/**
 * Reader实现了UserDetails接口以及其中的方法，这样Reader就能代表Spring Security里的用户了
 * @Date 2019-05-07
 * @Author lifei
 */
@Entity
@Proxy(lazy = false)
public class Reader implements UserDetails, Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    private String username;
    private String fullname;
    private String password;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    /**
     * 授权READER 权限
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_READER"));
    }

    // 不过期， 不加锁，不禁用
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
