package AuthentiCation.AuthentiCation.config;

import AuthentiCation.AuthentiCation.entities.Role;
import AuthentiCation.AuthentiCation.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CustomUserDetails implements org.springframework.security.core.userdetails.UserDetails {
   private final User user;
   public CustomUserDetails(User user) {
         super();
         this.user = user;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

       List<Role> roles = user.getRoles();
       List<SimpleGrantedAuthority> authorities = new ArrayList<>();
       for (Role role:roles){
           authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
       }
       return  authorities;
    }

    @Override
    public String getPassword() {
        return  user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
