package com.reserva.v1.api.reservation.domain;

import com.reserva.v1.api.reservation.domain.command.CreateClientCommand;
import com.reserva.v1.api.reservation.domain.command.EditClientCommand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {

    private Long id;

    private String name;

    private String phoneNumber;

    public Client(CreateClientCommand command) {
        this.name = command.getName();
        this.phoneNumber = command.getPhoneNumber();
    }

    public void edit(EditClientCommand command) {
        if (command.getName() != null){
            this.name = command.getName();
        }
        if (command.getPhoneNumber() != null){
            this.phoneNumber = command.getPhoneNumber();
        }
    }
}
