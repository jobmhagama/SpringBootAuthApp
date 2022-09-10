package AuthentiCation.AuthentiCation.entities;

import com.sun.xml.bind.v2.runtime.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private  Long Id;
    @Column(name = "role_name",nullable = false)
    private  String roleName;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private List<User> user;

}
