package com.SSU.ShkodinMax.services.impl;

import com.SSU.ShkodinMax.repository.UserDAO;
import com.SSU.ShkodinMax.repository.impl.UserDAOImpl;
import com.SSU.ShkodinMax.model.User;
import com.SSU.ShkodinMax.services.UserService;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceImpl(){
        userDAO = new UserDAOImpl();
    }
    @Override
    public void addUser(User user) throws Exception {
        userDAO.save(user);
    }

    @Override
    public boolean checkUser(User user) throws Exception {
        User userToLogin = userDAO.findByLogin(user.getLogin());
        if (userToLogin == null) {
            return false;
        } else {
            if (userToLogin.getPassword() == user.getPassword())
            {
                return  true;
            }
            return false;
        }
    }
}
