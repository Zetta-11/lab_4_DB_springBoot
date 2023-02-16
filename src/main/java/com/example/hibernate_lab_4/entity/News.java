package com.example.hibernate_lab_4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "news")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "type")
    private String type;

    @Column(name = "info")
    private String info;

    @ManyToOne
    @JoinColumn(name = "propery_house_id", referencedColumnName = "id")
    private House house;
}