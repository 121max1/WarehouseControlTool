package com.SSU.ShkodinMax.dao;

import com.SSU.ShkodinMax.model.User;

public interface UserRepository {

    void save(User user);

    User findByLogin(String login);


}
