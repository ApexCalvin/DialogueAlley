package com.formosa.DialogueAlley.model;

import jakarta.persistence.*;

@Entity
public class PostHashtagCrossReference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Post post;
    @ManyToOne
    private Hashtag hashtag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Hashtag getHashtag() {
        return hashtag;
    }

    public void setHashtag(Hashtag hashtag) {this.hashtag = hashtag;}
}
