package com.formosa.DialogueAlley.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "Post")
public class Post implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer post_id;
    @Column
    private Timestamp date_time;
    @Column
    private String message;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    @JsonIgnoreProperties("userPosts")
    private Account assoc_account;

    @OneToMany( fetch = FetchType.EAGER, cascade = CascadeType.ALL,
                mappedBy = "assoc_post", targetEntity = Comment.class)
    @JsonIgnoreProperties("assoc_post")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Comment> postComments;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "post")
    private List<PostHashtagCrossReference> crossReferenceToHashtag;

    public Post() {}

    public Integer getPost_id() {return post_id;}

    public void setPost_id(Integer post_id) {this.post_id = post_id;}

    public Timestamp getDate_time() {return date_time;}

    public void setDate_time(Timestamp date_time) {this.date_time = date_time;}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Account getAssoc_account() {return assoc_account;}

    public void setAssoc_account(Account assoc_account) {this.assoc_account = assoc_account;}

    public List<Comment> getPostComments() {return postComments;}

    public void setPostComments(List<Comment> postComments) {this.postComments = postComments;}

    public List<PostHashtagCrossReference> getCrossReferenceToHashtag() {
        return crossReferenceToHashtag;
    }

    public void setCrossReferenceToHashtag(List<PostHashtagCrossReference> crossReferenceToHashtag) {
        this.crossReferenceToHashtag = crossReferenceToHashtag;
    }
}
