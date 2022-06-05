package com.reserva.v1.api.reservation.domain;

import com.reserva.v1.api.reservation.domain.command.CreateReservationCommand;
import com.reserva.v1.api.reservation.domain.command.EditReservationCommand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reservation {

    private Long id;

    private Client client;

    private Restaurant restaurant;

    private Integer numberOfPeople;

    private LocalDateTime time;

    public Reservation(CreateReservationCommand command) {
        this.client = command.getClient();
        this.restaurant = command.getRestaurant();
        this.numberOfPeople = command.getNumberOfPeople();
        this.time = command.getTime();
    }

    public void edit(EditReservationCommand command){
        if (command.getNumberOfPeople() != null){
            this.numberOfPeople = command.getNumberOfPeople();
        }
        if (command.getTime() != null){
            this.time = command.getTime();
        }
    }
}
