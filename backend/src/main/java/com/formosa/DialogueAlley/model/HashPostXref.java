package com.formosa.DialogueAlley.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "HashPostXref")
public class HashPostXref {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("HashXrefList")
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("HashXrefList")
    @JoinColumn(name = "hashtag_id")
    //@JoinColumn(name = "fk_hashtag_id", referencedColumnName = "hashtag_id")
    private Hashtag hashtag;

    public HashPostXref() {}

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

    public void setHashtag(Hashtag hashtag) {
        this.hashtag = hashtag;
    }
}
