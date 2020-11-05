package com.example.logindemo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;


@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    private long userId;
    @ColumnInfo
    private String username;
    @ColumnInfo
    private String password;
    @ColumnInfo
    private Date dob;
    @ColumnInfo
    private String phone;
    @ColumnInfo
    private String email;
    @ColumnInfo
    private boolean gender;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public User() {
    }

    public User(long userId, String username, String password, Date dob, String phone, String email, boolean gender) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
    }
}
