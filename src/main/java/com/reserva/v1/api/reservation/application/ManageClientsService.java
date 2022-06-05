package com.reserva.v1.api.reservation.application;

import com.reserva.v1.api.reservation.application.in.ManageClientsUseCase;
import com.reserva.v1.api.reservation.application.out.ClientReadPort;
import com.reserva.v1.api.reservation.application.out.ClientWritePort;
import com.reserva.v1.api.reservation.domain.Client;
import com.reserva.v1.api.reservation.domain.command.CreateClientCommand;
import com.reserva.v1.api.reservation.domain.command.EditClientCommand;
import com.reserva.v1.api.reservation.domain.request.CreateClientRequest;
import com.reserva.v1.api.reservation.domain.request.EditClientRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManageClientsService implements ManageClientsUseCase {

    private final ClientReadPort clientReadPort;
    private final ClientWritePort clientWritePort;

    @Override
    public void createClient(CreateClientRequest request) {
        final var command = CreateClientCommand.builder()
                .name(request.getName())
                .phoneNumber(request.getPhoneNumber())
                .build();

        clientWritePort.saveClient(
                new Client(command)
        );
    }

    @Override
    public void editClient(EditClientRequest request) {
        Client client = clientReadPort.findClientById(request.getId());

        final var command = EditClientCommand.builder()
                .name(request.getName())
                .phoneNumber(request.getPhoneNumber())
                .build();

        client.edit(command);

        clientWritePort.saveClient(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientWritePort.deleteClient(id);
    }
}
