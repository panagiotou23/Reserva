package com.reserva.v1.api.reservation.domain.request;

import com.reserva.v1.api.reservation.domain.enums.Day;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CreateRestaurantRequest {

    private final String name;

    private final String phoneNumber;

    private final String address;

    private final List<Day> openDays;

    private final String openingHour;

    private final String closingHour;

}
