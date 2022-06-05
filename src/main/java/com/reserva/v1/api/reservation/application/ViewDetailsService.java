package com.reserva.v1.api.reservation.application;

import com.reserva.v1.api.reservation.application.in.ViewClientsUseCase;
import com.reserva.v1.api.reservation.application.in.ViewReservationsUseCase;
import com.reserva.v1.api.reservation.application.in.ViewRestaurantsUseCase;
import com.reserva.v1.api.reservation.application.out.ClientReadPort;
import com.reserva.v1.api.reservation.application.out.ReservationReadPort;
import com.reserva.v1.api.reservation.application.out.RestaurantReadPort;
import com.reserva.v1.api.reservation.domain.Client;
import com.reserva.v1.api.reservation.domain.Reservation;
import com.reserva.v1.api.reservation.domain.Restaurant;
import com.reserva.v1.api.reservation.domain.enums.Day;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ViewDetailsService implements ViewClientsUseCase, ViewRestaurantsUseCase, ViewReservationsUseCase {

    private final ClientReadPort clientReadPort;
    private final RestaurantReadPort restaurantReadPort;
    private final ReservationReadPort reservationReadPort;

    @Override
    public List<Client> getAllClients() {
        return clientReadPort.getAllClients();
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationReadPort.getAllReservations();
    }

    @Override
    public List<Reservation> getAllClientReservations(Long clientId) {
        return reservationReadPort.findAllReservationsByClientId(clientId);
    }

    @Override
    public List<Reservation> getAllRestaurantReservations(Long restaurantId) {
        return reservationReadPort.findAllReservationsByRestaurantId(restaurantId);
    }

    @Override
    public Reservation getLastReservation(Long clientId) {
        return reservationReadPort.findLastReservationByClientId(clientId);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantReadPort.getAllRestaurants();
    }

    @Override
    public List<Restaurant> getOpenRestaurants(Day day, String time) {
        return restaurantReadPort.getOpenRestaurants(day, time);
    }
}
