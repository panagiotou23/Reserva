package com.reserva.v1.api.reservation.adapter.in;

import com.reserva.v1.api.reservation.adapter.in.dto.CreateClientRequestDto;
import com.reserva.v1.api.reservation.adapter.in.dto.EditClientRequestDto;
import com.reserva.v1.api.reservation.application.in.ManageClientsUseCase;
import com.reserva.v1.api.reservation.domain.request.CreateClientRequest;
import com.reserva.v1.api.reservation.domain.request.EditClientRequest;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ClientRestController {

    private final ManageClientsUseCase manageClientsUseCase;

    @PostMapping("/client")
    void createClient(@RequestBody CreateClientRequestDto dto){
        manageClientsUseCase.createClient(
                ClientRestControllerMapper.INSTANCE.toDomain(dto)
        );
    }

    @PutMapping("/client/{id}")
    void editClient(
            @PathVariable Long id,
            @RequestBody EditClientRequestDto dto
    ){
        manageClientsUseCase.editClient(
                ClientRestControllerMapper.INSTANCE.toDomain(
                        dto,
                        id
                )
        );
    }

    @DeleteMapping("/client/{id}")
    void deleteClient(@PathVariable Long id){
        manageClientsUseCase.deleteClient(id);
    }

    @Mapper
    abstract static class ClientRestControllerMapper {
        private static final ClientRestControllerMapper INSTANCE =
                Mappers.getMapper(ClientRestControllerMapper.class);

        abstract CreateClientRequest toDomain(CreateClientRequestDto dto);

        abstract EditClientRequest toDomain(EditClientRequestDto dto, Long id);
    }

}
