package com.stdio.hue.yoga.modules.auth.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.stdio.hue.yoga.modules.auth.model.User;


@Dao
public interface UserDao {
    @Insert
    void insertUser(User user);

    @Query("select * from user where email = :email")
    User checkSignup(String email);
}
