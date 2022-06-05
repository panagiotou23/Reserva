package com.reserva.v1.api.reservation.application.in;

import com.reserva.v1.api.reservation.domain.Restaurant;
import com.reserva.v1.api.reservation.domain.enums.Day;

import java.util.List;

public interface ViewRestaurantsUseCase {
    List<Restaurant> getAllRestaurants();

    List<Restaurant> getOpenRestaurants(Day day, String time);
}
