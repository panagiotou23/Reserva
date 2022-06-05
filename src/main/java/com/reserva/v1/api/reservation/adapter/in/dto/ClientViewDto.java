package com.reserva.v1.api.reservation.adapter.in.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientViewDto {

    public String name;

    public String phoneNumber;

}
