package com.formosa.DialogueAlley.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private String handle;
    @OneToMany
    private List<Post> userPosts;

    public Account() {}

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getFirst_name() {return first_name;}

    public void setFirst_name(String first_name) {this.first_name = first_name;}

    public String getLast_name() {return last_name;}

    public void setLast_name(String last_name) {this.last_name = last_name;}

    public String getHandle() {return handle;}

    public void setHandle(String handle) {this.handle = handle;}

    public List<Post> getUserPosts() {return userPosts;}

    public void setUserPosts(List<Post> userPosts) {this.userPosts = userPosts;}
}
