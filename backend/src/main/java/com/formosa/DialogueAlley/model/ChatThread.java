package com.formosa.DialogueAlley.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Table(name = "ChatThread")
public class ChatThread {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "assoc_thread", targetEntity = Post.class)
    @JsonIgnoreProperties("assoc_thread") //ignores printing of assoc_profile_id
    @Fetch(value = FetchMode.SUBSELECT) //tells how to do a select
    private List<Post> threadsPosts;

    public ChatThread() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Post> getThreadsPosts() {
        return threadsPosts;
    }

    public void setThreadsPosts(List<Post> threadsPosts) {
        this.threadsPosts = threadsPosts;
    }
}
