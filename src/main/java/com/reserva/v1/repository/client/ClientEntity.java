package com.reserva.v1.repository.client;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "client")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phoneNumber;


}
