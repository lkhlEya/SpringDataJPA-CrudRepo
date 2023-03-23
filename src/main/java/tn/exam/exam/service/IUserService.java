package tn.exam.exam.service;

import tn.exam.exam.entity.User;

import java.util.List;

public interface IUserService  {
    List<User> getAllUsers();

    User getUser(Long id);

    User addUser(User u);

    User updateUser(User u);

    boolean deleteUSer(Long id);
}
