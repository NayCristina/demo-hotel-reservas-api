package com.example.demohotelreservasapi.service;

import com.example.demohotelreservasapi.entity.Reserva;
import com.example.demohotelreservasapi.repository.ReservaRepository;
import com.example.demohotelreservasapi.web.dto.ReservaResponseDto;
import com.example.demohotelreservasapi.web.dto.mapper.ReservaMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    @Transactional(readOnly = true)
    public List<Reserva> buscarTodos() {
        List<Reserva> reservas = reservaRepository.findAll();
        if (reservas.isEmpty()) {
            throw new EntityNotFoundException("Nenhuma reserva encontrada");
        }
        return reservas;
    }

    @Transactional(readOnly = true)
    public Reserva buscarPorId(int id){
        return reservaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Reserva id=%s não encontrado", id))
        );
    }
    @Transactional
    public List<Reserva> buscarPorStatus(String status) {
        return reservaRepository.findByStatus(status);
    }

    /*@Transactional
    public boolean existeReservaDuplicada(ReservaResponseDto reservaResponseDto) {
        return reservaRepository.findByCheckInLessThanEqualAndCheckOutGreaterThanEqualAndStatusNotAndHotelId(reservaResponseDto.getHotelId(), reservaResponseDto.getCheckIn());
    }*/

    /*@Transactional
    public ReservaResponseDto criarReserva(ReservaResponseDto reservaResponseDto) throws ReservaDuplicadaException {
        if (existeReservaDuplicada(reservaResponseDto)) {
            throw new ReservaDuplicadaException("Já existe uma reserva para o mesmo hotel e período");
        }
        Reserva reserva = ReservaMapper.toEntity(reservaResponseDto);
        reserva = reservaRepository.save(reserva);
        return ReservaMapper.toDto(reserva);
    }*/


    @Transactional()
    public ReservaResponseDto criarReserva(ReservaResponseDto reservaResponseDto) {
        Reserva reserva = new Reserva();

        System.out.println(">>>>>>>>>>>>>>>>>>" + reservaResponseDto.getStatus());
        reserva.setHotelId(reservaResponseDto.getHotelId());

        reserva = reservaRepository.save(reserva);

        ReservaResponseDto novaReserva = new ReservaResponseDto();

        novaReserva.setHotelId(reserva.getHotelId());

        return novaReserva;

        //return reservaResponseDto;
    }
}
