package com.reserva.v1.api.reservation.adapter.in;

import com.reserva.v1.api.reservation.adapter.in.dto.CreateReservationRequestDto;
import com.reserva.v1.api.reservation.adapter.in.dto.EditReservationRequestDto;
import com.reserva.v1.api.reservation.application.in.ManageReservationsUseCase;
import com.reserva.v1.api.reservation.domain.request.CreateReservationRequest;
import com.reserva.v1.api.reservation.domain.request.EditReservationRequest;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequiredArgsConstructor
public class ReservationRestController {

    private final ManageReservationsUseCase manageReservationsUseCase;

    @PostMapping("/reservation")
    void createReservation(@RequestBody CreateReservationRequestDto dto){
        manageReservationsUseCase.createReservation(
                ReservationRestControllerMapper.INSTANCE.toDomain(dto)
        );
    }

    @PutMapping("reservation/{id}")
    void editReservation(
            @PathVariable Long id,
            @RequestBody EditReservationRequestDto dto
    ){
        manageReservationsUseCase.editReservation(
                ReservationRestControllerMapper.INSTANCE.toDomain(dto, id)
        );
    }

    @DeleteMapping("reservation/{id}")
    void deleteReservation(@PathVariable Long id){
        manageReservationsUseCase.deleteReservation(id);
    }


    @Mapper
    abstract static class ReservationRestControllerMapper{
        private static final ReservationRestControllerMapper INSTANCE =
                Mappers.getMapper(ReservationRestControllerMapper.class);

        @Mapping(target = "time", expression = "java( parseTime(dto.time) )")
        abstract CreateReservationRequest toDomain(CreateReservationRequestDto dto);

        @Mapping(target = "time", expression = "java( parseTime(dto.time) )")
        abstract EditReservationRequest toDomain(EditReservationRequestDto dto, Long id);

        LocalDateTime parseTime(String time){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            return LocalDateTime.parse(time, formatter);
        }

    }

}
