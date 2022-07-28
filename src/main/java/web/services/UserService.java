package web.services;

import exceptions.BigLengthException;
import exceptions.NotFoundException;
import exceptions.UserExistException;
import model.Role;
import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleRepository;
import web.dao.UserRepository;

@Service
public class UserService {

    private static final Logger userServiceLogger = LogManager.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public User getUserByLogin(String login) throws NotFoundException {
        userServiceLogger.info("start getUserByLogin login = " + login);
        User user = userRepository.findByLogin(login);
        if (user != null) {
            userServiceLogger.info("end getUserByLogin login = " + login);
            return user;
        } else {
            userServiceLogger.error("end getUserByLogin login = " + login);
            throw new NotFoundException("такого юзера не существует");
        }
    }

    @Transactional
    public boolean registerUser(String username, String password, String name, String lastName) throws UserExistException, BigLengthException {
        if((username.length() > 16) || (password.length() > 16)) {
            throw new BigLengthException("Длина логина или пароля больше 16 символов");
        }
        userServiceLogger.info("start registerUser ");
        if (userRepository.findByLogin(username) != null) {
            userServiceLogger.error("такой пользователь существует");
            throw new UserExistException("такой пользователь существует");
        } else {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            User user = new User();
            user.setLogin(username);
            user.setPassword(bCryptPasswordEncoder.encode(password));
            user.setName(name);
            user.setLastName(lastName);
            String fullNameRole = "ROLE_USER";
            Role roleInBd = roleRepository.findByRole(fullNameRole);
            user.setRole(roleInBd);
            userRepository.save(user);
            userServiceLogger.info("end registerUser ");
            return true;
        }
    }
}
