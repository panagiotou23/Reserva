package com.reserva.v1.api.reservation.adapter.in;

import com.reserva.v1.api.reservation.adapter.in.dto.ClientViewDto;
import com.reserva.v1.api.reservation.adapter.in.dto.ReservationViewDto;
import com.reserva.v1.api.reservation.adapter.in.dto.RestaurantViewDto;
import com.reserva.v1.api.reservation.application.in.ViewClientsUseCase;
import com.reserva.v1.api.reservation.application.in.ViewReservationsUseCase;
import com.reserva.v1.api.reservation.application.in.ViewRestaurantsUseCase;
import com.reserva.v1.api.reservation.domain.Client;
import com.reserva.v1.api.reservation.domain.Reservation;
import com.reserva.v1.api.reservation.domain.Restaurant;
import com.reserva.v1.api.reservation.domain.enums.Day;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ViewDetailsRestController {

    private final ViewClientsUseCase viewClientsUseCase;
    private final ViewRestaurantsUseCase viewRestaurantsUseCase;
    private final ViewReservationsUseCase viewReservationsUseCase;

    @GetMapping("/client/all")
    List<ClientViewDto> getAllClients() {
        return viewClientsUseCase.getAllClients().stream()
                .map(ViewClientRestControllerMapper.INSTANCE::fromDomain)
                .collect(Collectors.toList());
    }

    @GetMapping("/restaurant/all")
    List<RestaurantViewDto> getAllRestaurants() {
        return viewRestaurantsUseCase.getAllRestaurants().stream()
                .map(ViewClientRestControllerMapper.INSTANCE::fromDomain)
                .collect(Collectors.toList());
    }

    @GetMapping("restaurant/open")
    List<RestaurantViewDto> getAllOpenRestaurants(
            @RequestParam Day day,
            @RequestParam String time
    ) {
        return viewRestaurantsUseCase.getOpenRestaurants(day, time).stream()
                .map(ViewClientRestControllerMapper.INSTANCE::fromDomain)
                .collect(Collectors.toList());
    }

    @GetMapping("/reservation/all")
    List<ReservationViewDto> getAllReservations() {
        return viewReservationsUseCase.getAllReservations().stream()
                .map(ViewClientRestControllerMapper.INSTANCE::fromDomain)
                .collect(Collectors.toList());
    }

    @GetMapping("/reservation/client/{clientId}/all")
    List<ReservationViewDto> getAllClientReservations(@PathVariable Long clientId) {
        return viewReservationsUseCase.getAllClientReservations(clientId).stream()
                .map(ViewClientRestControllerMapper.INSTANCE::fromDomain)
                .collect(Collectors.toList());
    }

    @GetMapping("/reservation/client/{clientId}/last")
    ReservationViewDto getLastClientReservations(@PathVariable Long clientId) {
        return ViewClientRestControllerMapper.INSTANCE.fromDomain(
                viewReservationsUseCase.getLastReservation(clientId)
        );
    }

    @GetMapping("/reservation/restaurant/{restaurantId}/all")
    List<ReservationViewDto> getAllRestaurantReservations(@PathVariable Long restaurantId) {
        return viewReservationsUseCase.getAllRestaurantReservations(restaurantId).stream()
                .map(ViewClientRestControllerMapper.INSTANCE::fromDomain)
                .collect(Collectors.toList());
    }


    @Mapper
    abstract static class ViewClientRestControllerMapper {
        private static final ViewClientRestControllerMapper INSTANCE =
                Mappers.getMapper(ViewClientRestControllerMapper.class);

        abstract ClientViewDto fromDomain(Client domain);

        abstract RestaurantViewDto fromDomain(Restaurant domain);

        abstract ReservationViewDto fromDomain(Reservation domain);
    }
}
