package com.reserva.v1.api.reservation.domain;

import com.reserva.v1.api.reservation.domain.command.CreateRestaurantCommand;
import com.reserva.v1.api.reservation.domain.command.EditRestaurantCommand;
import com.reserva.v1.api.reservation.domain.enums.Day;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Restaurant {

    private Long id;

    private String name;

    private String phoneNumber;

    private String address;

    private List<Day> openDays;

    private String openingHour;

    private String closingHour;

    public Restaurant(CreateRestaurantCommand command) {
        this.name = command.getName();
        this.phoneNumber = command.getPhoneNumber();
        this.address = command.getAddress();
        this.openDays = command.getOpenDays();
        this.openingHour = command.getOpeningHour();
        this.closingHour = command.getClosingHour();
    }

    public void edit(EditRestaurantCommand command){
        if (command.getName() != null){
            this.name = command.getName();
        }
        if (command.getPhoneNumber() != null){
            this.phoneNumber = command.getPhoneNumber();
        }
        if (command.getAddress() != null){
            this.address = command.getAddress();
        }
        if (command.getOpenDays() != null){
            this.openDays = command.getOpenDays();
        }
        if (command.getOpeningHour() != null){
            this.openingHour = command.getOpeningHour();
        }
        if (command.getClosingHour() != null){
            this.closingHour = command.getClosingHour();
        }
    }
}
