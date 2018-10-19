package com.infotech.exceptionhandlerdemo.service;

import com.infotech.exceptionhandlerdemo.model.User;
import com.infotech.exceptionhandlerdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vend.internal.exceptionhandler.errortype.SignUpErrorType;
import org.vend.internal.exceptionhandler.exception.ValidationException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {

        if (user.getUsername().length() < 3) {
            String id = "2";

            String msgParams = "ali12 | 6";

            // make your custom message and pass to enum
            throw new ValidationException(SignUpErrorType.INVALID_USERNAME_LENGTH, msgParams);
        }

        userRepository.save(user);

        return user;
    }

}
