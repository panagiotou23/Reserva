package com.reserva.v1.api.reservation.domain.command;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateClientCommand {

    private final String name;

    private final String phoneNumber;
}
