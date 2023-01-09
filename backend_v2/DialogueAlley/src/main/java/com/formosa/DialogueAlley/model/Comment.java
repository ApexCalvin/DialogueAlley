package com.formosa.DialogueAlley.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date date_time;
    private String message;
    @ManyToOne
    private Post assoc_post;

    public Comment() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate_time() {return date_time;}

    public void setDate_time(Date date_time) {this.date_time = date_time;}

    public String getMessage() {return message;}

    public void setMessage(String message) {this.message = message;}

    public Post getAssoc_post() {return assoc_post;}

    public void setAssoc_post(Post assoc_post) {this.assoc_post = assoc_post;}
}
