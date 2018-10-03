package web.adminlicense.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import web.adminlicense.models.User;
import web.adminlicense.repositories.UserRepository;

import java.util.Optional;


public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!login: " + login);
        Optional<User> candidate = userRepository.findByName(login);
        if (!candidate.isPresent()){
            throw new UsernameNotFoundException("User not authorized.");
        }
        return new UserDetailsImpl(candidate.get());
    }
}
