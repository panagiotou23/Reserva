package com.reserva.v1.api.reservation.domain.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EditClientRequest {

    private final Long id;

    private final String name;

    private final String phoneNumber;

}
