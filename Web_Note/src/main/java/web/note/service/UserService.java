package web.note.service;

import web.note.model.Role;
import web.note.model.User;

import java.util.List;

public interface UserService {
    boolean saveUser(User user);
    boolean saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
    boolean deleteUser(Long id);
}