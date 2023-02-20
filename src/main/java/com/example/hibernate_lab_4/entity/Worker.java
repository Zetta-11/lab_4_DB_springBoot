package com.example.hibernate_lab_4.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "workers")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "specialization")
    private String specialization;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "worker")
    private List<Maintenance> maintenances;

    public Worker(String name, String surname, String phone, String specialization, User user) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.specialization = specialization;
        this.user = user;
    }
}
