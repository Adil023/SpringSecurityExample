package org.example.springsecurityexample.modle;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="myusers")
public class User {
    @Id
    private Integer id;
    private String username;
    private String password;


    public User(Integer id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;

    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }


}
