package com.reserva.v1.api.reservation.adapter.in;

import com.reserva.v1.api.reservation.adapter.in.dto.CreateRestaurantRequestDto;
import com.reserva.v1.api.reservation.adapter.in.dto.EditRestaurantRequestDto;
import com.reserva.v1.api.reservation.application.in.ManageRestaurantsUseCase;
import com.reserva.v1.api.reservation.domain.request.CreateRestaurantRequest;
import com.reserva.v1.api.reservation.domain.request.EditRestaurantRequest;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RestaurantRestController {

    private final ManageRestaurantsUseCase manageRestaurantUseCase;

    @PostMapping("/restaurant")
    void createClient(@RequestBody CreateRestaurantRequestDto dto){
        manageRestaurantUseCase.createRestaurant(
                RestaurantRestControllerMapper.INSTANCE.toDomain(dto)
        );
    }

    @PutMapping("/restaurant/{id}")
    void editClient(
            @PathVariable Long id,
            @RequestBody EditRestaurantRequestDto dto
    ){
        manageRestaurantUseCase.editRestaurant(
                RestaurantRestControllerMapper.INSTANCE.toDomain(
                        dto,
                        id
                )
        );
    }

    @DeleteMapping("/restaurant/{id}")
    void deleteClient(@PathVariable Long id){
        manageRestaurantUseCase.deleteRestaurant(id);
    }

    @Mapper
    abstract static class RestaurantRestControllerMapper {
        private static final RestaurantRestControllerMapper INSTANCE =
                Mappers.getMapper(RestaurantRestControllerMapper.class);

        abstract CreateRestaurantRequest toDomain(CreateRestaurantRequestDto dto);

        abstract EditRestaurantRequest toDomain(EditRestaurantRequestDto dto, Long id);
    }


}
