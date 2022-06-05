package com.reserva.v1.api.reservation.application.out;

import com.reserva.v1.api.reservation.domain.Client;

import java.util.List;

public interface ClientReadPort {
    List<Client> getAllClients();

    Client findClientById(Long id);
}
