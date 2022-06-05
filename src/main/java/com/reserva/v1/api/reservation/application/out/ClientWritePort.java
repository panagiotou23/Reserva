package com.reserva.v1.api.reservation.application.out;

import com.reserva.v1.api.reservation.domain.Client;

public interface ClientWritePort {
    void saveClient(Client client);

    void deleteClient(Long id);
}
