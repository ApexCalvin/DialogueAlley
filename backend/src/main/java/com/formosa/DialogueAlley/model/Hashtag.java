package com.formosa.DialogueAlley.model;

import jakarta.persistence.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.List;

@Entity
public class Hashtag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String hashtag;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "hashtag")
    private List<HashPostXref> postsXref;

    public Hashtag() {}

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getHashtag() { return hashtag; }

    public void setHashtag(String hashtag) { this.hashtag = hashtag; }

    public List<HashPostXref> getPostsXref() { return postsXref; }

    public void setPostsXref(List<HashPostXref> postsXref) { this.postsXref = postsXref; }
}
