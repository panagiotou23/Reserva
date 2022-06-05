package com.reserva.v1.api.reservation.application.out;

import com.reserva.v1.api.reservation.domain.Restaurant;
import com.reserva.v1.api.reservation.domain.enums.Day;

import java.util.List;

public interface RestaurantReadPort {
    List<Restaurant> getAllRestaurants();

    List<Restaurant> getOpenRestaurants(Day day, String time);

    Restaurant findRestaurantById(Long id);
}
