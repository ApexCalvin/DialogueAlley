package com.formosa.DialogueAlley.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "Comment")
public class Comment implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer comment_id;
    @Column
    private Timestamp date_time;
    @Column
    private String message;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    @JsonIgnoreProperties("postComments")
    private Post assoc_post;

    public Comment() {}

    public Integer getComment_id() {return comment_id;}

    public void setComment_id(Integer comment_id) {this.comment_id = comment_id;}

    public Timestamp getDate_time() {return date_time;}

    public void setDate_time(Timestamp date_time) {this.date_time = date_time;}

    public String getMessage() {return message;}

    public void setMessage(String message) {this.message = message;}

    public Post getAssoc_post() {return assoc_post;}

    public void setAssoc_post(Post assoc_post) {this.assoc_post = assoc_post;}
}
