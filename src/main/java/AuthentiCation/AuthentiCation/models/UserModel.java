package AuthentiCation.AuthentiCation.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.List;

import static javax.persistence.FetchType.EAGER;

@Getter
@Setter
public class UserModel {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String username;
    private  String Role;
    @ManyToMany(fetch = EAGER)
    private List<RoleModel> roles;
}
