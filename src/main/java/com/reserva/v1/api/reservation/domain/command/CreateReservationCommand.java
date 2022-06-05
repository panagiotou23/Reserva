package com.reserva.v1.api.reservation.domain.command;

import com.reserva.v1.api.reservation.domain.Client;
import com.reserva.v1.api.reservation.domain.Restaurant;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CreateReservationCommand {

    private final Client client;

    private final Restaurant restaurant;

    private final Integer numberOfPeople;

    private final LocalDateTime time;
}
