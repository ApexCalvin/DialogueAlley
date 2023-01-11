package com.formosa.DialogueAlley.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Account")
public class Account implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer account_id;
    @Column(nullable = false)
    private String username;
    @Column
    private String password;
    @Column
    private String first_name;
    @Column
    private String last_name;
    @Column
    private String handle;

    @OneToMany( fetch = FetchType.EAGER, cascade = CascadeType.ALL,
                mappedBy = "assoc_account", targetEntity = Post.class)
    @JsonIgnoreProperties("assoc_account")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Post> userPosts;

    public Account() {}

    public Integer getAccount_id() {return account_id;}

    public void setAccount_id(Integer account_id) {this.account_id = account_id;}

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
