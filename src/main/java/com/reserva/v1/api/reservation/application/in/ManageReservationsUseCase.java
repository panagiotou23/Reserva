package com.reserva.v1.api.reservation.application.in;

import com.reserva.v1.api.reservation.domain.request.CreateReservationRequest;
import com.reserva.v1.api.reservation.domain.request.EditReservationRequest;

public interface ManageReservationsUseCase {
    void createReservation(CreateReservationRequest request);

    void editReservation(EditReservationRequest request);

    void deleteReservation(Long id);
}
