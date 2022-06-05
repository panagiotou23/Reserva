package com.reserva.v1.api.reservation.application.in;

import com.reserva.v1.api.reservation.domain.request.CreateClientRequest;
import com.reserva.v1.api.reservation.domain.request.EditClientRequest;

public interface ManageClientsUseCase {
    void createClient(CreateClientRequest request);

    void editClient(EditClientRequest request);

    void deleteClient(Long id);
}
