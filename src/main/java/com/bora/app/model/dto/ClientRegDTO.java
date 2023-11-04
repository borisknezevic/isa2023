package com.bora.app.model.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ClientRegDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String city;
    private String state;
    private String address;
    private String phoneNumber;
    private String profession;
    private String information;
}
