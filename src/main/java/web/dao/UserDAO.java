package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);
    void updateUser(User updatedUser, Long id);
    void deleteUser(Long id);
    User getUser(Long id);
    List<User> getAllUsers();
}
