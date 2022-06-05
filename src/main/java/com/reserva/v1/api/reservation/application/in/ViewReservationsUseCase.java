package com.reserva.v1.api.reservation.application.in;

import com.reserva.v1.api.reservation.domain.Reservation;

import java.util.List;

public interface ViewReservationsUseCase {

    List<Reservation> getAllReservations();

    List<Reservation> getAllClientReservations(Long clientId);

    List<Reservation> getAllRestaurantReservations(Long restaurantId);

    Reservation getLastReservation(Long clientId);

}
