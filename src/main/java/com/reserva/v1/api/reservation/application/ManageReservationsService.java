package com.reserva.v1.api.reservation.application;

import com.reserva.v1.api.reservation.application.in.ManageReservationsUseCase;
import com.reserva.v1.api.reservation.application.out.ClientReadPort;
import com.reserva.v1.api.reservation.application.out.ReservationReadPort;
import com.reserva.v1.api.reservation.application.out.ReservationWritePort;
import com.reserva.v1.api.reservation.application.out.RestaurantReadPort;
import com.reserva.v1.api.reservation.domain.Reservation;
import com.reserva.v1.api.reservation.domain.command.CreateReservationCommand;
import com.reserva.v1.api.reservation.domain.command.EditReservationCommand;
import com.reserva.v1.api.reservation.domain.request.CreateReservationRequest;
import com.reserva.v1.api.reservation.domain.request.EditReservationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManageReservationsService implements ManageReservationsUseCase {

    private final ReservationReadPort reservationReadPort;
    private final ReservationWritePort reservationWritePort;
    private final ClientReadPort clientReadPort;
    private final RestaurantReadPort restaurantReadPort;

    @Override
    public void createReservation(CreateReservationRequest request) {
        final var client = clientReadPort.findClientById(request.getClientId());
        final var restaurant = restaurantReadPort.findRestaurantById(request.getRestaurantId());

        final var command = CreateReservationCommand.builder()
                .client(client)
                .restaurant(restaurant)
                .numberOfPeople(request.getNumberOfPeople())
                .time(request.getTime())
                .build();

        reservationWritePort.saveReservation(
                new Reservation(command)
        );

    }

    @Override
    public void editReservation(EditReservationRequest request) {
        Reservation reservation = reservationReadPort.findReservationById(request.getId());

        final var command = EditReservationCommand.builder()
                .numberOfPeople(request.getNumberOfPeople())
                .time(request.getTime())
                .build();

        reservation.edit(command);

        reservationWritePort.saveReservation(reservation);

    }

    @Override
    public void deleteReservation(Long id) {
        reservationWritePort.deleteReservation(id);
    }
}
