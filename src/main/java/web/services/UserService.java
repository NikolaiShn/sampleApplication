package web.services;

import exceptions.NotFoundException;
import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserRepository;

@Service
public class UserService {

    private static final Logger userServiceLogger = LogManager.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

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
}
