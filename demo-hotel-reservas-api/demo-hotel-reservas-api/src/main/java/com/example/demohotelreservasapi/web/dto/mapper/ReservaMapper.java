package com.example.demohotelreservasapi.web.dto.mapper;

import com.example.demohotelreservasapi.entity.Reserva;
import com.example.demohotelreservasapi.web.dto.ReservaResponseDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import java.util.List;
import java.util.stream.Collectors;

public class ReservaMapper {

    public static ReservaResponseDto toDto(Reserva reserva){
        ModelMapper mapperMain = new ModelMapper();
        TypeMap<Reserva, ReservaResponseDto> propertyMapper = mapperMain.createTypeMap(Reserva.class, ReservaResponseDto.class);
        return mapperMain.map(reserva, ReservaResponseDto.class);
    }

    public static List<ReservaResponseDto> toListDto(List<Reserva>reservas){
        return reservas.stream().map(reserva -> toDto(reserva)).collect(Collectors.toList());
    }
}
