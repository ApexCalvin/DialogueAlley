package com.formosa.DialogueAlley.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.formosa.DialogueAlley.model.DTO.PostListDTO;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Comment")
@NamedNativeQuery(name = "query_name3",
        query = """
        SELECT a.first_name, a.last_name, a.handle, c.date_time, c.message
        FROM comment c
        JOIN post p ON c.post_id = p.post_id
        JOIN account a ON a.account_id = p.account_id
        WHERE :id = c.post_id
        ORDER BY date_time ASC;
                """,
        resultSetMapping = "result_set_name1")
// TELLING NAMED QUERY WHAT RESULT SET TO MAP TO
@SqlResultSetMapping(
        name = "result_set_name1",
        classes = @ConstructorResult(targetClass = PostListDTO.class,columns = {
                @ColumnResult(name = "first_name", type = String.class),
                @ColumnResult(name = "last_name", type = String.class),
                @ColumnResult(name = "handle", type = String.class),
                @ColumnResult(name = "date_time", type = Date.class),
                @ColumnResult(name = "message", type = String.class)})
)
public class Comment implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer comment_id;
    @Column
    private Date date_time;
    @Column(nullable = false)
    private String message;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    @JsonIgnoreProperties("postComments")
    private Account assoc_account;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    @JsonIgnoreProperties("postComments")
    private Post assoc_post;

    public Comment() {}

    public Integer getComment_id() {return comment_id;}

    public void setComment_id(Integer comment_id) {this.comment_id = comment_id;}

    public Date getDate_time() {
        return date_time;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }

    public String getMessage() {return message;}

    public void setMessage(String message) {this.message = message;}

    public Post getAssoc_post() {return assoc_post;}

    public void setAssoc_post(Post assoc_post) {this.assoc_post = assoc_post;}

    public Account getAssoc_account(Account account) {
        return assoc_account;
    }

    public void setAssoc_account(Account assoc_account) {
        this.assoc_account = assoc_account;
    }


}
