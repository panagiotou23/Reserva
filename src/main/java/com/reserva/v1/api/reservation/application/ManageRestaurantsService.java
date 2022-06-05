package com.reserva.v1.api.reservation.application;

import com.reserva.v1.api.reservation.application.in.ManageRestaurantsUseCase;
import com.reserva.v1.api.reservation.application.out.RestaurantReadPort;
import com.reserva.v1.api.reservation.application.out.RestaurantWritePort;
import com.reserva.v1.api.reservation.domain.Restaurant;
import com.reserva.v1.api.reservation.domain.command.CreateRestaurantCommand;
import com.reserva.v1.api.reservation.domain.command.EditRestaurantCommand;
import com.reserva.v1.api.reservation.domain.request.CreateRestaurantRequest;
import com.reserva.v1.api.reservation.domain.request.EditRestaurantRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManageRestaurantsService implements ManageRestaurantsUseCase {

    private final RestaurantReadPort restaurantReadPort;
    private final RestaurantWritePort restaurantWritePort;

    @Override
    public void createRestaurant(CreateRestaurantRequest request) {
        final var command = CreateRestaurantCommand.builder()
                .name(request.getName())
                .phoneNumber(request.getPhoneNumber())
                .address(request.getAddress())
                .openDays(request.getOpenDays())
                .openingHour(request.getOpeningHour())
                .closingHour(request.getClosingHour())
                .build();

        restaurantWritePort.saveRestaurant(
                new Restaurant(command)
        );

    }

    @Override
    public void editRestaurant(EditRestaurantRequest request) {
        Restaurant restaurant = restaurantReadPort.findRestaurantById(request.getId());

        final var command = EditRestaurantCommand.builder()
                .name(request.getName())
                .phoneNumber(request.getPhoneNumber())
                .address(request.getAddress())
                .openDays(request.getOpenDays())
                .openingHour(request.getOpeningHour())
                .closingHour(request.getClosingHour())
                .build();

        restaurant.edit(command);

        restaurantWritePort.saveRestaurant(
                restaurant
        );

    }

    @Override
    public void deleteRestaurant(Long id) {
        restaurantWritePort.deleteRestaurant(id);
    }
}
