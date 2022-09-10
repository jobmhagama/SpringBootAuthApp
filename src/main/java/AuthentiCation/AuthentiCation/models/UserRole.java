package AuthentiCation.AuthentiCation.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRole {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String username;
    private  String Role;
    private Long uid;
    private String roleName;
    private  UserModel user;
}
