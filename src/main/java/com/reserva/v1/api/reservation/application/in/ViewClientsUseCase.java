package com.reserva.v1.api.reservation.application.in;

import com.reserva.v1.api.reservation.domain.Client;

import java.util.List;

public interface ViewClientsUseCase {
    List<Client> getAllClients();
}
