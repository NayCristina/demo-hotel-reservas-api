package com.example.demohotelreservasapi.service;

import com.example.demohotelreservasapi.entity.Reserva;
import com.example.demohotelreservasapi.repository.ReservaRepository;
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


    @Transactional
    public Reserva criarReserva(Reserva reserva) {
        reserva.setStatus("ativa");
        return reservaRepository.save(reserva);
    }
}
