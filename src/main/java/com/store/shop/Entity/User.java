package com.store.shop.Entity;


import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String email;
    @Column
    private String Mobile;
    @Column
    private String password;
    @Column
    private String role;
    @Column
    private String tgName;
    private boolean anonymStatus;


    public Integer getId() {
        return id;
    }

    public User() {

    }

    public User(String firstName, String lastName, String email, String mobile, String password, String role, String tgName, boolean anonymStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        Mobile = mobile;
        this.password = password;
        this.role = role;
        this.tgName = tgName;
        this.anonymStatus = anonymStatus;
    }

    public String getFirstName() {
        return firstName;
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

    public void setId(Integer id) {
        this.id = id;
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

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTgName() {
        return tgName;
    }

    public void setTgName(String tgName) {
        this.tgName = tgName;
    }

    public boolean isAnonymStatus() {
        return anonymStatus;
    }

    public void setAnonymStatus(boolean anonymStatus) {
        this.anonymStatus = anonymStatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", Mobile='" + Mobile + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", tgName='" + tgName + '\'' +
                ", anonymStatus=" + anonymStatus +
                '}';
    }
}
