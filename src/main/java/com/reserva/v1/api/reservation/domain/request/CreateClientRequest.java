package com.reserva.v1.api.reservation.domain.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateClientRequest {

    private final String name;

    private final String phoneNumber;

}
