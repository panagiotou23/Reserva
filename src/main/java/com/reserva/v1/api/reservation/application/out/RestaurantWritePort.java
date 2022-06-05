package com.reserva.v1.api.reservation.application.out;

import com.reserva.v1.api.reservation.domain.Restaurant;

public interface RestaurantWritePort {
    void saveRestaurant(Restaurant restaurant);

    void deleteRestaurant(Long id);
}
