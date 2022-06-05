package com.reserva.v1.api.reservation.adapter.out;

import com.reserva.v1.api.reservation.application.out.*;
import com.reserva.v1.api.reservation.domain.Client;
import com.reserva.v1.api.reservation.domain.Reservation;
import com.reserva.v1.api.reservation.domain.Restaurant;
import com.reserva.v1.api.reservation.domain.enums.Day;
import com.reserva.v1.repository.client.ClientEntity;
import com.reserva.v1.repository.client.ClientRepository;
import com.reserva.v1.repository.reservation.ReservationEntity;
import com.reserva.v1.repository.reservation.ReservationRepository;
import com.reserva.v1.repository.restaurant.RestaurantEntity;
import com.reserva.v1.repository.restaurant.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ReservationAdapter implements ClientReadPort,
        RestaurantReadPort,
        ReservationReadPort,
        ClientWritePort,
        RestaurantWritePort,
        ReservationWritePort
{

    private final ClientRepository clientRepository;
    private final RestaurantRepository restaurantRepository;
    private final ReservationRepository reservationRepository;


    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll().stream()
                .map(ReservationAdapterMapper.INSTANCE::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Client findClientById(Long id) {
        return clientRepository.findById(id)
                .map(ReservationAdapterMapper.INSTANCE::toDomain)
                .orElseThrow(() -> new RuntimeException("Could not find client with id " + id));
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll().stream()
                .map(ReservationAdapterMapper.INSTANCE::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Reservation> findAllReservationsByClientId(Long clientId) {
        return reservationRepository.findAllByClientId(clientId).stream()
                .map(ReservationAdapterMapper.INSTANCE::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Reservation> findAllReservationsByRestaurantId(Long restaurantId) {
        return reservationRepository.findAllByRestaurantId(restaurantId).stream()
                .map(ReservationAdapterMapper.INSTANCE::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Reservation findLastReservationByClientId(Long clientId) {
        return reservationRepository.findAllByClientId(clientId).stream()
                .max(Comparator.comparing(ReservationEntity::getTime))
                .map(ReservationAdapterMapper.INSTANCE::toDomain)
                .orElseThrow(() -> new RuntimeException("Could not find last reservation for client " + clientId));
    }

    @Override
    public Reservation findReservationById(Long id) {
        return reservationRepository.findById(id)
                .map(ReservationAdapterMapper.INSTANCE::toDomain)
                .orElseThrow(() -> new RuntimeException("Could not find reservation with id " + id));
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll().stream()
                .map(ReservationAdapterMapper.INSTANCE::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Restaurant> getOpenRestaurants(Day day, String time) {
        return restaurantRepository.findAll().stream()
                .filter(res -> res.getOpenDays().contains(day))
                .filter(res -> {
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                    try {
                        Date requestedTime = sdf.parse(time);
                        Date openingTime = sdf.parse(res.getOpeningHour());
                        Date closingTime = sdf.parse(res.getClosingHour());
                        return requestedTime.after(openingTime) &&
                                closingTime.after(requestedTime);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return false;
                })
                .map(ReservationAdapterMapper.INSTANCE::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Restaurant findRestaurantById(Long id) {
        return restaurantRepository.findById(id)
                .map(ReservationAdapterMapper.INSTANCE::toDomain)
                .orElseThrow(() -> new RuntimeException("Could not find restaurant with id " + id));
    }

    @Override
    public void saveClient(Client client) {
        clientRepository.save(
                ReservationAdapterMapper.INSTANCE.fromDomain(client)
        );
    }

    @Override
    public void deleteClient(Long id) {
        ClientEntity client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find client with id " + id));
        clientRepository.delete(client);
    }

    @Override
    public void saveRestaurant(Restaurant restaurant) {
        restaurantRepository.save(
                ReservationAdapterMapper.INSTANCE.fromDomain(restaurant)
        );
    }

    @Override
    public void deleteRestaurant(Long id) {
        RestaurantEntity entity = restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find restaurant with id " + id));
        restaurantRepository.delete(entity);
    }

    @Override
    public void saveReservation(Reservation reservation) {
        reservationRepository.save(
                ReservationAdapterMapper.INSTANCE.fromDomain(reservation)
        );
    }

    @Override
    public void deleteReservation(Long id) {
        ReservationEntity entity = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find reservation with id " + id));
        reservationRepository.delete(entity);
    }

    @Mapper
    abstract static class ReservationAdapterMapper {
        private static final ReservationAdapterMapper INSTANCE =
                Mappers.getMapper(ReservationAdapterMapper.class);

        abstract Client toDomain(ClientEntity entity);

        abstract ClientEntity fromDomain(Client domain);

        abstract Restaurant toDomain(RestaurantEntity entity);

        abstract RestaurantEntity fromDomain(Restaurant domain);

        abstract Reservation toDomain(ReservationEntity entity);

        abstract ReservationEntity fromDomain(Reservation domain);
    }
}
