package web.adminlicense.service;

import web.adminlicense.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findOneByLogin (String login);
    List<User> findAll();
}
