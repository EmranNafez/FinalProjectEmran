package com.example.finalprojectemran;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private UserRepository userRepository;
    private LiveData<List<User>> allUsers;
    private MutableLiveData<Boolean> loginResult = new MutableLiveData<>();

    public UserViewModel(Application application) {
        super(application);
        userRepository = new UserRepository(application);
        allUsers = userRepository.getAllUsers();
    }

    public void insert(User user) {
        userRepository.insert(user);
    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    public LiveData<Boolean> checkLogin(String email, String password) {
        new Thread(() -> {
            User user = userRepository.getUserByEmailAndPassword(email, password);
            if (user != null) {
                loginResult.postValue(true); // user found, valid login
            } else {
                loginResult.postValue(false); // user not found, invalid login
            }
        }).start();
        return loginResult;
    }
}
