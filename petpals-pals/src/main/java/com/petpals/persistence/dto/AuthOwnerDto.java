package com.petpals.persistence.dto;

import com.petpals.persistence.entities.Pals;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

public class AuthOwnerDto {

    private String email;
    private String password;



    public AuthOwnerDto() {
    }

    public AuthOwnerDto(String email, String password) {
        this.email = email;
        this.password = password;
    }


    @Override
    public String toString() {
        return "AuthOwnerDto{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthOwnerDto that = (AuthOwnerDto) o;
        return Objects.equals(email, that.email) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password);
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
}
