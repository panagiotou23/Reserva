package com.reserva.v1.repository.restaurant;

import com.reserva.v1.api.reservation.domain.enums.Day;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "restaurant")
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phoneNumber;

    private String address;

    @ElementCollection(targetClass = Day.class)
    @JoinTable(name = "restaurant_open_days_mapping", joinColumns = @JoinColumn(name = "restaurantId"))
    @Column(name = "day", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<Day> openDays;

    private String openingHour;

    private String closingHour;

}
