package com.reserva.v1.api.reservation.adapter.in.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ReservationViewDto {

    private ClientViewDto client;

    private RestaurantViewDto restaurant;

    private Integer numberOfPeople;

    private LocalDateTime time;

}
