package com.reserva.v1.api.reservation.application.in;

import com.reserva.v1.api.reservation.domain.request.CreateRestaurantRequest;
import com.reserva.v1.api.reservation.domain.request.EditRestaurantRequest;

public interface ManageRestaurantsUseCase {

    void createRestaurant(CreateRestaurantRequest request);

    void editRestaurant(EditRestaurantRequest request);

    void deleteRestaurant(Long id);
}
