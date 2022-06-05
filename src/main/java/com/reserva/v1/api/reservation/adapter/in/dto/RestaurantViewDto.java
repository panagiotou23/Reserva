package com.reserva.v1.api.reservation.adapter.in.dto;

import com.reserva.v1.api.reservation.domain.enums.Day;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RestaurantViewDto {

    public String name;

    public String phoneNumber;

    public String address;

    public List<Day> openDays;

    public String openingHour;

    public String closingHour;

}
