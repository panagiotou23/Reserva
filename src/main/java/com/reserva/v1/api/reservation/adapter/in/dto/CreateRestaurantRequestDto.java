package com.reserva.v1.api.reservation.adapter.in.dto;

import com.reserva.v1.api.reservation.domain.enums.Day;
import com.sun.istack.NotNull;

import java.util.List;

public class CreateRestaurantRequestDto {

    @NotNull
    public String name;

    @NotNull
    public String phoneNumber;

    @NotNull
    public String address;

    @NotNull
    public List<Day> openDays;

    @NotNull
    public String openingHour;

    @NotNull
    public String closingHour;


}
