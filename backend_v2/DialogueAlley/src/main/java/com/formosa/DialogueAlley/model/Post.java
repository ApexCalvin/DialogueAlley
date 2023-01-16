package com.formosa.DialogueAlley.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.formosa.DialogueAlley.model.DTO.PostListDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Post")
//"NAMED" CUSTOM QUERY, QUERY SET UP
@NamedNativeQuery(name = "query_name",
        query = """
        SELECT a.first_name, a.last_name, a.handle, p.date_time, p.message FROM account a
        JOIN post p
        ON p.account_id = a.account_id
        WHERE :handle = a.handle
        ORDER BY date_time DESC
        """,
        resultSetMapping = "result_set_name")
// TELLING NAMED QUERY WHAT RESULT SET TO MAP TO
@SqlResultSetMapping(
        name = "result_set_name",
        classes = @ConstructorResult(targetClass = PostListDTO.class,columns = {
                @ColumnResult(name = "first_name", type = String.class),
                @ColumnResult(name = "last_name", type = String.class),
                @ColumnResult(name = "handle", type = String.class),
                @ColumnResult(name = "date_time", type = Date.class),
                @ColumnResult(name = "message", type = String.class)})
)
//--------------------------------------------------
@NamedNativeQuery(name = "query_name2",
        query = """
        SELECT a.first_name, a.last_name, a.handle, p.date_time, p.message
        FROM hashtag h
        JOIN post_hashtag_xref r ON r.hashtag_id = h.hashtag_id
        JOIN post p ON p.post_id = r.post_id
        JOIN account a ON a.account_id = p.account_id
        WHERE :hashtag = h.hashtag
        ORDER BY date_time DESC;
                """,
        resultSetMapping = "result_set_name")
@NamedNativeQuery(name = "query_name4",
        query = """
                SELECT a.first_name, a.last_name, a.handle, p.date_time, p.message
                FROM Post p
                JOIN Account a ON a.account_id = p.account_id
                ORDER BY date_time DESC;
                """,
        resultSetMapping = "result_set_name")

public class Post implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer post_id;

    @Column
    private Date date_time;
    @Column(nullable = false)
    private String message;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    @JsonIgnoreProperties("userPosts")
    private Account assoc_account;

    @OneToMany( fetch = FetchType.EAGER, cascade = CascadeType.ALL,
                mappedBy = "assoc_post", targetEntity = Comment.class)
    @JsonIgnoreProperties("assoc_post")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Comment> postComments;

    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true,
                mappedBy = "post") //targetEntity = PostHashtagCrossReference.class
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<PostHashtagCrossReference> crossReferenceToHashtag;

    public Post() {}

    public Integer getPost_id() {return post_id;}

    public void setPost_id(Integer post_id) {this.post_id = post_id;}

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
