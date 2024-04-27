package com.example.demohotelreservasapi.web.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReservaResponseDto {
    private int id;
    private int idQuarto;
    private int idHotel;
    @NonNull
    private Date checkIn;
    @NonNull
    private Date checkout;
    @NonNull
    private String status;
}
