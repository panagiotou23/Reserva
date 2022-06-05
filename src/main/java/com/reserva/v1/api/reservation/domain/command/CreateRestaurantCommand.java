package com.reserva.v1.api.reservation.domain.command;

import com.reserva.v1.api.reservation.domain.enums.Day;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CreateRestaurantCommand {
    private final String name;

    private final String phoneNumber;

    private final String address;

    private final List<Day> openDays;

    private final String openingHour;

    private final String closingHour;

}
