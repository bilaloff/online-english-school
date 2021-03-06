package com.english.model;

import java.time.LocalDateTime;

public class User extends Model {

    private Role role;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String newPassword;
    private String newPasswordRepeat;
    private String image;
    private String skype;
    private LocalDateTime createdAt;
    private boolean verified;
    private boolean logged;

    public User() {
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPasswordRepeat() {
        return newPasswordRepeat;
    }

    public void setNewPasswordRepeat(String newPasswordRepeat) {
        this.newPasswordRepeat = newPasswordRepeat;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    @Override
    public String toString() {
        return String.format("%s [id: %d, email: %s, firstname: %s, isLogged:%b]", getClass().getSimpleName(), getId(), getEmail(), getFirstname(), isLogged());
    }

    public User getPublicProfile() {
        User user = new User();
        user.setId(this.getId());
        user.setFirstname(this.getFirstname());
        user.setLastname(this.getLastname());
        user.setEmail(this.getEmail());
        user.setRole(this.getRole());
        user.setImage(this.getImage());
        return user;
    }
}
