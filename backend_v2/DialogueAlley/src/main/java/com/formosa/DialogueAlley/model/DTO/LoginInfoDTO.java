package com.formosa.DialogueAlley.model.DTO;

public record LoginInfoDTO(String username, String password) {

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
