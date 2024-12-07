package com.example.finalprojectemran;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UserRepository {
    private UserDao userDao;
    private LiveData<List<User>> allUsers;

    public UserRepository(Application application) {
        MyDataBase db = MyDataBase.getDatabase(application);
        userDao = db.userDAO();
        allUsers = userDao.getAllUsers();
    }

    public void insert(User user) {
        MyDataBase.databaseWriteExecutor.execute(() -> userDao.insert(user));
    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }
}
