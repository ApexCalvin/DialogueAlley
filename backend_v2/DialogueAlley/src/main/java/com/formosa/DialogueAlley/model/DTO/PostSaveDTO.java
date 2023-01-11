package com.formosa.DialogueAlley.model.DTO;

import java.util.Date;

public class PostSaveDTO {

    private Integer account_id;

    private Date date_time;

    private String message;

    public PostSaveDTO() {}

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
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
}
