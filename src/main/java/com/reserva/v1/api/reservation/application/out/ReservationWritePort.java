package com.reserva.v1.api.reservation.application.out;

import com.reserva.v1.api.reservation.domain.Reservation;

public interface ReservationWritePort {
    void saveReservation(Reservation reservation);

    void deleteReservation(Long id);
}
