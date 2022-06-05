package com.reserva.v1.api.reservation.domain.request;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class EditReservationRequest {

    private final Long id;

    private final Integer numberOfPeople;

    private final LocalDateTime time;
}
