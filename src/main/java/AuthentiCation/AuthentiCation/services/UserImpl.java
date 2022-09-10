package AuthentiCation.AuthentiCation.services;

import AuthentiCation.AuthentiCation.entities.Role;
import AuthentiCation.AuthentiCation.entities.User;
import AuthentiCation.AuthentiCation.models.RoleModel;
import AuthentiCation.AuthentiCation.models.UserModel;
import AuthentiCation.AuthentiCation.models.UserRole;
import AuthentiCation.AuthentiCation.repository.RoleRepo;
import AuthentiCation.AuthentiCation.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class UserImpl implements UserService{


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private  RoleRepo roleRepo;
    @Override
    public User addOrUpdateUser(UserModel userModel) {

        Optional<User> existingUser = Optional.ofNullable(userRepository.findByUsername(userModel.getUsername()));
        if(existingUser.isPresent()){
            try {
                throw new  Exception ("The user already exist");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User  user = new User();
        user.setLastName(userModel.getLastName());
        user.setFirstName(userModel.getFirstName());
        user.setEmail(userModel.getEmail());
        user.setUsername(userModel.getUsername());
        System.out.println(userModel.getRole() );
        String hashedpassword=passwordEncoder.encode(userModel.getPassword());
        System.out.println("inside the service");
        user.setPassword(hashedpassword);
        userRepository.save(user);
        System.out.println(hashedpassword);

            return user;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Role addRoleToUser(UserRole userRole) {
        System.out.println("|--------------------------------------|");
        List<Role> newUserRoles = null;
        User user = userRepository.findByUsername( userRole.getUsername() );
        Role role = roleRepo.findByRoleName( userRole.getRoleName() );
        // Attaching new role to existing roles
        if(! user.getRoles().contains(role)){
            user.getRoles().add(role);
            newUserRoles = user.getRoles();
        }
        user.getRoles().forEach(r -> {
            System.out.println("USER ROLES "+r.getRoleName());
        });
        assert newUserRoles != null;
        for (Role r : newUserRoles) {
            System.out.println("NEW USER ROLES "+r);
        }
        user.setRoles(newUserRoles);
        userRepository.save(user);
        return role;
    }

    @Override
    public Role saveRole(RoleModel role) {
         Role role1 = new Role();
         role1.setRoleName(role.getRoleName());
         roleRepo.save(role1);
        System.out.println(role1.getRoleName());
         return  role1;
    }

    @Override
    public List<Role> getAlLRoles() {
        return roleRepo.findAll();
    }

    @Override
    public User getUser(String Username) {
        return userRepository.findByUsername(Username);
    }
}
