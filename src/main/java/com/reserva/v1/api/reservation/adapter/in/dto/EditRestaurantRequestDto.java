package com.reserva.v1.api.reservation.adapter.in.dto;

import com.reserva.v1.api.reservation.domain.enums.Day;

import java.util.List;

public class EditRestaurantRequestDto {

    public String name;

    public String phoneNumber;

    public String address;

    public List<Day> openDays;

    public String openingHour;

    public String closingHour;

}
