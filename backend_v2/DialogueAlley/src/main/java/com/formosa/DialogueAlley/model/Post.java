package com.formosa.DialogueAlley.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date date_time;
    private String message;
    @ManyToOne
    private Account assoc_account;
    @OneToMany
    private List<Comment> postComments;
    @OneToMany
    private List<PostHashtagCrossReference> crossReferenceToHashtag;

    public Post() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate_time() {
        return date_time;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }

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
