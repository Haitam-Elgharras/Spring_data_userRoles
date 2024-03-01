package ma.enset.jpa.userroles.service;

import ma.enset.jpa.userroles.entities.Role;
import ma.enset.jpa.userroles.entities.User;

import java.util.List;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findByUsername(String username);
    Role findByRoleName(String roleName);
    void addRoleToUser(String username, String roleName);
    User authenticate(String username, String password);

    List<User> findAll();
}
