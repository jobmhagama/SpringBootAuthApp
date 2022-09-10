package AuthentiCation.AuthentiCation.Controller;

import AuthentiCation.AuthentiCation.entities.Role;
import AuthentiCation.AuthentiCation.entities.User;
import AuthentiCation.AuthentiCation.models.RoleModel;
import AuthentiCation.AuthentiCation.models.UserModel;
import AuthentiCation.AuthentiCation.models.UserRole;
import AuthentiCation.AuthentiCation.repository.UserRepository;
import AuthentiCation.AuthentiCation.services.UserImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    UserImpl userImplementation;



    @Autowired
    UserRepository userRepository;

    @GetMapping("home")
    public String home(){
        System.out.println("Hellow");
        return "This is home";
    }

    @GetMapping("getAllUsers")
    public List<User> getAllUsers(){
    return  userImplementation.getUsers();
    }


    @PostMapping("register")
    public User registerUser(@RequestBody  UserModel userModel) throws Exception {
        if(userModel==null){
            throw new Exception("The user models is Empy please enter data");
        }

        return  userImplementation.addOrUpdateUser(userModel);
    }


    @PostMapping("test")
    public void testPost(@RequestBody UserModel user){
        System.out.println(user);
        System.out.println("TEST POST ROUTE");
    }


    @PostMapping("saveRole")
    public Role testPost(@RequestBody RoleModel roleModel){
      return  userImplementation.saveRole(roleModel);

    }


    @PostMapping("addRoleToUser")
    public Role addRoleToUser(@RequestBody UserRole userRolel){
        return userImplementation.addRoleToUser(userRolel);

    }

    @GetMapping("listRoles")
    public List<Role> getAllRoles(){
      return   userImplementation.getAlLRoles();
    }

}
