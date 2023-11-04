package com.bora.app.service.impl;

import com.bora.app.model.User;
import com.bora.app.repository.UserRepository;
import com.bora.app.service.UtilsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UtilsServiceImpl implements UtilsService {

    private final UserRepository userRepository;

    @Override
    public Boolean checkIfEmailAlreadyExistInDB(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.isPresent();
    }
}
