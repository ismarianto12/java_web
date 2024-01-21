package com.restapiSiswa.restapi.models;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "users")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Login(){

    }
    public Login(Long id, String username, String name, String password, String email, Long tmlevelId, String role, Timestamp createdAt, String statusLogin, String token, Timestamp updatedAt, Long userId) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.password = password;
        this.email = email;
        this.tmlevelId = tmlevelId;
        this.role = role;
        this.createdAt = createdAt;
        this.statusLogin = statusLogin;
        this.token = token;
        this.updatedAt = updatedAt;
        this.userId = userId;
    }

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "tmlevel_id", nullable = false)
    private Long tmlevelId;

    @Column(name = "role")
    private String role;

    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;

    @Column(name = "statuslogin")
    private String statusLogin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTmlevelId() {
        return tmlevelId;
    }

    public void setTmlevelId(Long tmlevelId) {
        this.tmlevelId = tmlevelId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatusLogin() {
        return statusLogin;
    }

    public void setStatusLogin(String statusLogin) {
        this.statusLogin = statusLogin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "token")
    @Lob
    private String token;

    @Column(name = "updated_at")
    private java.sql.Timestamp updatedAt;

    @Column(name = "id_user")
    private Long userId;

    // Getter and Setter methods

}
