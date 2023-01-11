package com.formosa.DialogueAlley.model;

import jakarta.persistence.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Hashtag")
public class Hashtag implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hashtag_id;
    @Column(nullable = false)
    private String hashtag;

    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true,
                mappedBy = "hashtag") //targetEntity = PostHashtagCrossReference.class
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<PostHashtagCrossReference> crossReferenceToPost;

    public Hashtag() {}

    public Integer getHashtag_id() {return hashtag_id;}

    public void setHashtag_id(Integer hashtag_id) {this.hashtag_id = hashtag_id;}

    public String getHashtag() { return hashtag; }

    public void setHashtag(String hashtag) { this.hashtag = hashtag; }

    public List<PostHashtagCrossReference> getCrossReferenceToPost() {
        return crossReferenceToPost;}

    public void setCrossReferenceToPost(List<PostHashtagCrossReference> crossReferenceToPost) {
        this.crossReferenceToPost = crossReferenceToPost;
    }
}
