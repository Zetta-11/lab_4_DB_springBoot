package com.example.hibernate_lab_4.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Size(min = 3, message = "Login should be longer than 3 symbols!")
    @NotBlank(message = "This field cant be blank!")
    @Column(name = "login")
    private String login;

    @NotBlank(message = "This field cant be blank!")
    @Column(name = "password")
    private String password;

    @Pattern(regexp = "^admin$|^tenant$|^worker$", message = "Role can be only: admin, tenant, worker")
    @NotBlank(message = "This field cant be blank!")
    @Column(name = "account_type")
    private String accountType;

    @OneToOne(mappedBy = "user")
    private Tenant tenant;

    @OneToOne(mappedBy = "user")
    private Worker worker;

    @ManyToOne
    @JoinColumn(name = "property_house_id", referencedColumnName = "id")
    private House house;

    public User(String login, String password, String accountType) {
        this.login = login;
        this.password = password;
        this.accountType = accountType;
    }
}