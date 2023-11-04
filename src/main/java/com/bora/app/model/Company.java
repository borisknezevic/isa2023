package com.bora.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    private CompanyAddress companyAddress;
    private String description;
    private Float rating;
    @OneToMany
    private List<Appointment> appointmentList;
    @OneToMany
    private List<Manager> managerList;

}
