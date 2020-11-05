package com.example.logindemo;

import androidx.room.Database;

@Database(entities = {User.class}, version = 1)
public abstract class MyDataBase {
    public abstract UserDAO createUserDAO();
}
