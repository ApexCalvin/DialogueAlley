package com.formosa.DialogueAlley.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date date_time;
    private String message;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("userPosts")
    private Profile assoc_profile;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("threadPosts")
    private ChatThread assoc_thread;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "post")
    private List<HashPostXref> HashXrefList;

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

    public List<HashPostXref> getHashXrefList() {
        return HashXrefList;
    }

    public void setHashXrefList(List<HashPostXref> hashXrefList) {
        HashXrefList = hashXrefList;
    }

    public Profile getAssoc_profile() { return assoc_profile; }

    public void setAssoc_profile(Profile assoc_profile) { this.assoc_profile = assoc_profile; }

    public ChatThread getAssoc_thread() { return assoc_thread; }

    public void setAssoc_thread(ChatThread assoc_thread) { this.assoc_thread = assoc_thread; }
}
