package com.formosa.DialogueAlley.model.DTO;

import java.util.Date;

public class PostListDTO {

    private String first_name;

    private String last_name;

    private String handle;

    private Date date_time;

    private String message;

    public PostListDTO() {
    }

    public PostListDTO(String first_name, String last_name, String handle, Date date_time, String message) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.handle = handle;
        this.date_time = date_time;
        this.message = message;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
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
