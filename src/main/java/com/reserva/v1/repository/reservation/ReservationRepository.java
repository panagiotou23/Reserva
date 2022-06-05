package com.reserva.v1.repository.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {

    @Query("select r " +
            "from ReservationEntity r " +
            "where r.client.id = :clientId")
    List<ReservationEntity> findAllByClientId(Long clientId);

    @Query("select r " +
            "from ReservationEntity r " +
            "where r.restaurant.id = :restaurantId")
    List<ReservationEntity> findAllByRestaurantId(Long restaurantId);
}
