package com.SSU.ShkodinMax.services.impl;

import com.SSU.ShkodinMax.dao.UserRepository;
import com.SSU.ShkodinMax.dao.impl.UserRepositoryImpl;
import com.SSU.ShkodinMax.model.User;
import com.SSU.ShkodinMax.services.UserService;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(){
        userRepository = new UserRepositoryImpl();
    }
    @Override
    public void addUser(User user){
         String hashed = Hashing.sha256()
                .hashString(user.getPassword(), StandardCharsets.UTF_8)
                .toString();
         user.setPassword(hashed);
        userRepository.save(user);
    }

    @Override
    public boolean checkUser(User user){
        User userToLogin = userRepository.findByLogin(user.getLogin());
        if (userToLogin == null) {
            return false;
        } else {
            return Hashing.sha256().
                    hashString(user.getPassword(), StandardCharsets.UTF_8).
                    toString().equals(userToLogin.getPassword());

        }
    }
}
