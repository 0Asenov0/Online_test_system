package com.example.online_test_sys_proj.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class UserRegisterDTO {

    @NotEmpty
    String firstName;

    @NotEmpty
    String lastName;

    @NotEmpty
    @Email
    String email;

    @NotEmpty
    String password;

    @NotEmpty
    String confirmPassword;


    public String getFirstName() {
        return firstName;
    }
    public String getFullName(){
        return getFirstName() +" "+ getLastName();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
