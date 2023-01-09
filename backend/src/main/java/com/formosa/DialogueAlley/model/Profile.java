package com.formosa.DialogueAlley.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String handle;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "assoc_profile", targetEntity = Post.class)
    @JsonIgnoreProperties("assoc_profile") //ignores printing of assoc_profile_id
    @Fetch(value = FetchMode.SUBSELECT) //tells how to do a select
    private List<Post> userPosts;
    /*
    TODO - Annotation maintains the relationship (fk) between the different objects (profile -> post)
    TODO - Fetch: also pull in the posts(info) when being fetched to userPosts list
    TODO - Cascade:
    TODO - MappedBy: tells this entity how to point to the relationship obj you assoc it to
    TODO - TargetEntity: targetClass
     */

    public Profile() {}

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getHandle() { return handle; }

    public void setHandle(String handle) { this.handle = handle; }

    public List<Post> getUserPosts() {
        return userPosts;
    }

    public void setUserPosts(List<Post> userPosts) {
        this.userPosts = userPosts;
    }
}
