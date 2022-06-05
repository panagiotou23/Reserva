package com.reserva.v1.api.reservation.adapter.in.dto;

import com.sun.istack.NotNull;

public class CreateReservationRequestDto {

    @NotNull
    public Long clientId;

    @NotNull
    public Long restaurantId;

    @NotNull
    public Integer numberOfPeople;

    @NotNull
    public String time;
}
