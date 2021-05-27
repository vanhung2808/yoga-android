package com.stdio.hue.yoga.modules.auth.repository;

import com.stdio.hue.yoga.modules.auth.dao.UserDao;
import com.stdio.hue.yoga.modules.auth.model.User;

public class UserRepositoryImpl {
    private UserDao userDao;

    public UserRepositoryImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    public boolean signup(String email) {
        return userDao.checkSignup(email) != null;
    }
}
