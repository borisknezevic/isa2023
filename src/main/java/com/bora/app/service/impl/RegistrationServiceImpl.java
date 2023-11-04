package com.bora.app.service.impl;

import com.bora.app.exception.EmailAlreadyExistException;
import com.bora.app.model.Client;
import com.bora.app.model.Role;
import com.bora.app.model.User;
import com.bora.app.repository.ClientRepository;
import com.bora.app.repository.UserRepository;
import com.bora.app.service.RegistrationService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final ClientRepository clientRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationServiceImpl(ClientRepository clientRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.clientRepository = clientRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Client registerClient(Client client) {

        Optional<User> userByEmail = userRepository.findByEmail(client.getEmail());
        if(userByEmail.isPresent()) throw new EmailAlreadyExistException("Email: " + client.getEmail());
        client.setPassword(passwordEncoder.encode(client.getPassword()));

        client.setRole(Role.CLIENT);
        return clientRepository.save(client);
    }
}
