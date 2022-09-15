package ru.korsa.pp_3_1_1_springboot.DAO;


import ru.korsa.pp_3_1_1_springboot.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    void addUser(User user);
    void removeUserById(Integer id);
    void updateUser(User user, Integer id);
    User getUserById(Integer id);
}
