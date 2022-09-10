package AuthentiCation.AuthentiCation.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uid;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Column(unique = true)
    private String username;

    @ManyToMany(fetch = FetchType.EAGER,mappedBy= "user")
   private List<Role> roles ;
}
