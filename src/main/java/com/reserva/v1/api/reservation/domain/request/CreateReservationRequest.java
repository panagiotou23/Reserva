package com.reserva.v1.api.reservation.domain.request;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CreateReservationRequest {

    private final Long clientId;

    private final Long restaurantId;

    private final Integer numberOfPeople;

    private final LocalDateTime time;
}
