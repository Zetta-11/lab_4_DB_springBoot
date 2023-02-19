package com.example.hibernate_lab_4.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Tenants")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Tenant {

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

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "property_id", referencedColumnName = "id")
    private Property property;

    public Tenant(String name, String surname, String phone, User user, Property property) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.user = user;
        this.property = property;
    }
}
