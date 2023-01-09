package com.formosa.DialogueAlley.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Hashtag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String hashtag;
    @OneToMany
    private List<PostHashtagCrossReference> crossReferenceToPost;

    public Hashtag() {}

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getHashtag() { return hashtag; }

    public void setHashtag(String hashtag) { this.hashtag = hashtag; }

    public List<PostHashtagCrossReference> getCrossReferenceToPost() {
        return crossReferenceToPost;}

    public void setCrossReferenceToPost(List<PostHashtagCrossReference> crossReferenceToPost) {
        this.crossReferenceToPost = crossReferenceToPost;
    }
}
