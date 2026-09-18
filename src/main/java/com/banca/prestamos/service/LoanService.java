package com.banca.prestamos.service;

import com.banca.prestamos.dto.LoanRequestDTO;
import com.banca.prestamos.dto.LoanResponseDTO;
import com.banca.prestamos.event.AuditEvent;
import com.banca.prestamos.model.Loan;
import com.banca.prestamos.repository.LoanRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class LoanService {

    private static final int PLAZO_MINIMO_MESES = 6;
    private static final double MONTO_MINIMO = 0.01;
    private static final String ESTADO_APROBADO = "APROBADO";
    private static final String ESTADO_PENDIENTE = "PENDIENTE";
    private static final String ESTADO_RECHAZADO = "RECHAZADO";

    private final LoanRepository loanRepository;
    private final ApplicationEventPublisher eventPublisher;

    public LoanService(LoanRepository loanRepository, ApplicationEventPublisher eventPublisher) {
        this.loanRepository = loanRepository;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public LoanResponseDTO crearPrestamo(LoanRequestDTO request) {
        validarSolicitud(request);
        verificarIdempotencia(request.numeroOperacion());

        Loan prestamo = mapearEntidad(request);
        Loan prestamoGuardado = loanRepository.save(prestamo);

        emitircEventoAuditoria(prestamoGuardado, "CREADO");

        return mapearRespuesta(prestamoGuardado);
    }

    @Transactional(readOnly = true)
    public LoanResponseDTO obtenerPrestamoPorId(Long id) {
        Loan prestamo = loanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Préstamo no encontrado con ID: " + id));
        return mapearRespuesta(prestamo);
    }

    @Transactional(readOnly = true)
    public List<LoanResponseDTO> listarTodosLosPrestamos() {
        return loanRepository.findAll().stream()
                .map(this::mapearRespuesta)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<LoanResponseDTO> obtenerPrestamosPorSolicitante(String solicitanteId) {
        return loanRepository.findBySolicitanteId(solicitanteId).stream()
                .map(this::mapearRespuesta)
                .toList();
    }

    @Transactional
    public LoanResponseDTO actualizarEstado(Long id, String nuevoEstado) {
        Loan prestamo = loanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Préstamo no encontrado con ID: " + id));

        validarEstado(nuevoEstado);

        String estadoAnterior = prestamo.getEstado();
        prestamo.setEstado(nuevoEstado);
        Loan prestamoActualizado = loanRepository.save(prestamo);

        emitircEventoAuditoria(prestamoActualizado, "ESTADO_MODIFICADO: " + estadoAnterior + " -> " + nuevoEstado);

        return mapearRespuesta(prestamoActualizado);
    }

    @Transactional
    public void eliminarPrestamo(Long id) {
        if (!loanRepository.existsById(id)) {
            throw new IllegalArgumentException("Préstamo no encontrado con ID: " + id);
        }
        loanRepository.deleteById(id);
    }

    private void validarSolicitud(LoanRequestDTO request) {
        if (request.monto() == null || request.monto() < MONTO_MINIMO) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero");
        }

        if (request.plazo() == null || request.plazo() < PLAZO_MINIMO_MESES) {
            throw new IllegalArgumentException("El plazo mínimo es de " + PLAZO_MINIMO_MESES + " meses");
        }

        if (request.tipoInteres() == null || request.tipoInteres().isBlank()) {
            throw new IllegalArgumentException("El tipo de interés es obligatorio");
        }

        if (request.solicitanteId() == null || request.solicitanteId().isBlank()) {
            throw new IllegalArgumentException("El identificador del solicitante es obligatorio");
        }

        if (request.numeroOperacion() == null || request.numeroOperacion().isBlank()) {
            throw new IllegalArgumentException("El número de operación es obligatorio para idempotencia");
        }
    }

    private void verificarIdempotencia(String numeroOperacion) {
        if (loanRepository.existsByNumeroOperacion(numeroOperacion)) {
            throw new IllegalStateException("Ya existe un préstamo con el número de operación: " + numeroOperacion);
        }
    }

    private void validarEstado(String estado) {
        if (estado == null || estado.isBlank()) {
            throw new IllegalArgumentException("El estado no puede estar vacío");
        }

        boolean estadoValido = estado.equals(ESTADO_APROBADO) ||
                              estado.equals(ESTADO_PENDIENTE) ||
                              estado.equals(ESTADO_RECHAZADO);

        if (!estadoValido) {
            throw new IllegalArgumentException("Estado inválido. Estados permitidos: " +
                    ESTADO_PENDIENTE + ", " + ESTADO_APROBADO + ", " + ESTADO_RECHAZADO);
        }
    }

    private Loan mapearEntidad(LoanRequestDTO request) {
        Loan loan = new Loan();
        loan.setMonto(request.monto());
        loan.setPlazo(request.plazo());
        loan.setTipoInteres(request.tipoInteres());
        loan.setSolicitanteId(request.solicitanteId());
        loan.setNumeroOperacion(request.numeroOperacion());
        loan.setFechaCreacion(LocalDateTime.now());
        loan.setEstado(ESTADO_PENDIENTE);
        return loan;
    }

    private LoanResponseDTO mapearRespuesta(Loan loan) {
        return LoanResponseDTO.builder()
                .id(loan.getId())
                .monto(loan.getMonto())
                .plazo(loan.getPlazo())
                .tipoInteres(loan.getTipoInteres())
                .solicitanteId(loan.getSolicitanteId())
                .numeroOperacion(loan.getNumeroOperacion())
                .fechaCreacion(loan.getFechaCreacion() != null ? loan.getFechaCreacion().toString() : null)
                .estado(loan.getEstado())
                .build();
    }

    private void emitircEventoAuditoria(Loan prestamo, String accion) {
        AuditEvent evento = new AuditEvent(
                prestamo.getSolicitanteId(),
                prestamo.getNumeroOperacion(),
                prestamo.getMonto(),
                prestamo.getPlazo(),
                prestamo.getTipoInteres(),
                prestamo.getFechaCreacion(),
                accion,
                LocalDateTime.now().toString()
        );
        eventPublisher.publishEvent(evento);
    }
}