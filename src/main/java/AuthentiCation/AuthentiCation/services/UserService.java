package AuthentiCation.AuthentiCation.services;

import AuthentiCation.AuthentiCation.entities.Role;
import AuthentiCation.AuthentiCation.entities.User;
import AuthentiCation.AuthentiCation.models.RoleModel;
import AuthentiCation.AuthentiCation.models.UserModel;
import AuthentiCation.AuthentiCation.models.UserRole;


import java.util.List;

public interface UserService {

    User addOrUpdateUser(UserModel Usermodel);

    Role saveRole(RoleModel role);
    Role addRoleToUser(UserRole userRole);
    User getUser(String Username);
    List<User> getUsers();

    List<Role> getAlLRoles();

}
