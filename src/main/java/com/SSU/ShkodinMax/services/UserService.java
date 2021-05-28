package com.SSU.ShkodinMax.services;

import com.SSU.ShkodinMax.model.User;

public interface UserService {
    void addUser(User user) throws Exception;
    boolean checkUser(User user) throws Exception;
}
