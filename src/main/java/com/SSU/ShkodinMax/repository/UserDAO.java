package com.SSU.ShkodinMax.repository;

import com.SSU.ShkodinMax.model.User;

public interface UserDAO {

    void save(User user);

    User findByLogin(String login);


}
