package com.example.logindemo;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class MyDataBase extends RoomDatabase {
    public abstract UserDAO createUserDAO();
}
