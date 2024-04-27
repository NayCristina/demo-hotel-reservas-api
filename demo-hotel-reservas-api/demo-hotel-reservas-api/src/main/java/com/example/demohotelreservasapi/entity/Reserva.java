package com.example.demohotelreservasapi.entity;

import jakarta.persistence.*;

import lombok.*;

import java.util.Date;

@Table(name = "reserva")
@Entity(name = "Reserva")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
