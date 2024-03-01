package ma.enset.jpa.userroles.service;

import jakarta.transaction.Transactional;
import ma.enset.jpa.userroles.entities.Role;
import ma.enset.jpa.userroles.entities.User;
import ma.enset.jpa.userroles.repositories.RoleRepository;
import ma.enset.jpa.userroles.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service // so our service can be injected in other classes and vice versa
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());

        // hash the password with bcrypt we need to add the dependency with the name jbcrypt then use it like this
         user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));

        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }


    @Override
    public Role findByRoleName(String roleName) {
        return roleRepository.findRoleByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = findByUsername(username);
        Role role = findByRoleName(roleName);

//        // user or role isn't found
        if(user == null) throw new RuntimeException("User not found");
        if(role == null) throw new RuntimeException("Role not found");

        // role already added to user
        if(user.getRoles().contains(role)) return;

        // to add a role to the list of roles of a user
        user.getRoles().add(role);

//        not necessary because the jpa will automatically update the database
//        role.getUsers().add(user);
    }

    @Override
    public User authenticate(String username, String password) {
        User user = findByUsername(username);

        if(user == null || !BCrypt.checkpw(password, user.getPassword()))
            throw new RuntimeException("Bad credentials");

        return user;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
