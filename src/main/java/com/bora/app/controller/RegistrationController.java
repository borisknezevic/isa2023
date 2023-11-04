package com.bora.app.controller;

import com.bora.app.model.Client;
import com.bora.app.model.dto.ClientRegDTO;
import com.bora.app.service.RegistrationService;
import com.bora.app.service.UtilsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/registration")
public class RegistrationController {

    private final RegistrationService registrationService;
    private final UtilsService utilsService;



    @PostMapping
    public ResponseEntity<ClientRegDTO> registerClient(@RequestBody ClientRegDTO client){
        System.out.println(client.toString());
        Client newClient = Client.builder()
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .email(client.getEmail())
                .password(client.getPassword())
                .city(client.getCity())
                .address(client.getAddress())
                .phoneNumber(client.getPhoneNumber())
                .profession(client.getProfession())
                .information(client.getInformation())
                .build();
        Client client1 = registrationService.registerClient(newClient);
            client.setPassword(client1.getPassword());

        return new ResponseEntity<>(client, HttpStatusCode.valueOf(215));
    }

    @GetMapping("/email")
    public ResponseEntity<Boolean> checkIfEmailAlreadyExistInDB(@RequestBody String email){
        Boolean response = utilsService.checkIfEmailAlreadyExistInDB(email);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
