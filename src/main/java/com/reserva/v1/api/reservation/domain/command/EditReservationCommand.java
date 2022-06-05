package com.reserva.v1.api.reservation.domain.command;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class EditReservationCommand {

    private final Integer numberOfPeople;

    private final LocalDateTime time;
}
