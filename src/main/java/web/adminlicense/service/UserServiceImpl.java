package web.adminlicense.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.adminlicense.models.User;
import web.adminlicense.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findOneByLogin(String login) {
        return userRepository.findByName(login);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
