package com.reserva.v1.api.reservation.application.out;

import com.reserva.v1.api.reservation.domain.Reservation;

import java.util.List;

public interface ReservationReadPort {
    List<Reservation> getAllReservations();

    List<Reservation> findAllReservationsByClientId(Long clientId);

    List<Reservation> findAllReservationsByRestaurantId(Long restaurantId);

    Reservation findLastReservationByClientId(Long clientId);

    Reservation findReservationById(Long id);
}
