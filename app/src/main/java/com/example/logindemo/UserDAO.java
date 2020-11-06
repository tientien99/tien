package com.example.logindemo;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDAO {
    @Transaction
    @Insert
    public long insert(User user);

    @Update
    public void update(User user);

    @Delete
    public void delete(User user);

    @Query("SELECT * FROM user")
    public List<User> getAllUser();

    @Query("SELECT username FROM user where 1=1 and username =:x")
    public String checkUserName(String x);

}
