package com.api.jwtlogin.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cep;
    private String street;
    private String neighbourhood;
    private String city;
    @Column(length = 2)
    private String uf;
}
