package com.reserva.v1.repository.reservation;

import com.reserva.v1.repository.client.ClientEntity;
import com.reserva.v1.repository.restaurant.RestaurantEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "reservation")
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="client_id", nullable=false)
    private ClientEntity client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="restaurant_id", nullable=false)
    private RestaurantEntity restaurant;

    private Integer numberOfPeople;

    private LocalDateTime time;


}
