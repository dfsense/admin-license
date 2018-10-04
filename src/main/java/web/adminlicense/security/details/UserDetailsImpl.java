package web.adminlicense.security.details;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import web.adminlicense.models.Role;
import web.adminlicense.models.State;
import web.adminlicense.models.User;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UserDetailsImpl implements UserDetails {
    private static final Logger logger = LoggerFactory.getLogger(UserDetailsImpl.class);

    private User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        for (Role role : user.getRoles()) {
            logger.info("Role: " + role.getName());
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        logger.info("password: " + user.getPassword());
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        logger.info("name: " + user.getName());
        return user.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !user.getState().equals(State.BLOCKED);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.getState().equals(State.ACTIVE);
    }
}
