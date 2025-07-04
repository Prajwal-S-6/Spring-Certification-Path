package com.spring.security.example6.ds;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class RegisteringUser {
    @NotBlank(message = "Username cannot be empty")
    @Pattern(regexp = "[A-Za-z0-9]*", message = "Username contains illegal characters")
    private String username;
    @NotBlank(message = "Password cannot be empty")
    @Pattern(regexp = "[A-Za-z0-9]*", message = "Password contains illegal characters")
    private String password;
    @NotBlank(message = "Repeated password cannot be empty")
    @Pattern(regexp = "[A-Za-z0-9]*", message = "Repeated password contains illegal characters")
    private String repeatedPassword;

    public RegisteringUser() {
    }

    public RegisteringUser(String username, String password, String repeatedPassword) {
        this.username = username;
        this.password = password;
        this.repeatedPassword = repeatedPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }
}
