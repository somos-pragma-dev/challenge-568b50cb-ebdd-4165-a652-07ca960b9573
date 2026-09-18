package com.banca.prestamos.service;

import com.banca.prestamos.dto.LoanRequestDTO;
import com.banca.prestamos.dto.LoanResponseDTO;
import com.banca.prestamos.event.AuditEventPublisher;
import com.banca.prestamos.model.Loan;
import com.banca.prestamos.repository.LoanRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LoanServiceTest {

    @Mock
    private LoanRepository loanRepository;

    @Mock
    private AuditEventPublisher auditEventPublisher;

    @InjectMocks
    private LoanService loanService;

    private LoanRequestDTO requestValido;
    private Loan loanPersistido;

    @BeforeEach
    void setUp() {
        requestValido = new LoanRequestDTO(
                10000.0,
                12,
                "FIJO",
                "SOL-001",
                "OP-2024-001"
        );

        loanPersistido = new Loan();
        loanPersistido.setId(1L);
        loanPersistido.setMonto(10000.0);
        loanPersistido.setPlazo(12);
        loanPersistido.setTipoInteres("FIJO");
        loanPersistido.setSolicitanteId("SOL-001");
        loanPersistido.setNumeroOperacion("OP-2024-001");
        loanPersistido.setEstado("APROBADO");
        loanPersistido.setFechaCreacion(LocalDateTime.now());
    }

    @Test
    void testCrearPrestamoExitoso() {
        when(loanRepository.findByNumeroOperacion("OP-2024-001"))
                .thenReturn(Optional.empty());
        when(loanRepository.save(any(Loan.class))).thenReturn(loanPersistido);

        LoanResponseDTO resultado = loanService.crearPrestamo(requestValido);

        assertNotNull(resultado);
        assertEquals(10000.0, resultado.monto());
        assertEquals(12, resultado.plazo());
        assertEquals("FIJO", resultado.tipoInteres());
        assertEquals("SOL-001", resultado.solicitanteId());
        assertEquals("OP-2024-001", resultado.numeroOperacion());

        verify(loanRepository).findByNumeroOperacion("OP-2024-001");
        verify(loanRepository).save(any(Loan.class));
        verify(auditEventPublisher).publishEvent(any());
    }

    @Test
    void testCrearPrestamoIdempotente() {
        when(loanRepository.findByNumeroOperacion("OP-2024-001"))
                .thenReturn(Optional.of(loanPersistido));

        assertThrows(IllegalStateException.class, () -> {
            loanService.crearPrestamo(requestValido);
        });

        verify(loanRepository, never()).save(any());
        verify(auditEventPublisher, never()).publishEvent(any());
    }

    @Test
    void testValidarMontoNegativo() {
        LoanRequestDTO requestInvalido = new LoanRequestDTO(
                -1000.0,
                12,
                "FIJO",
                "SOL-001",
                "OP-2024-002"
        );

        assertThrows(IllegalArgumentException.class, () -> {
            loanService.crearPrestamo(requestInvalido);
        });
    }

    @Test
    void testValidarPlazoMinimo() {
        LoanRequestDTO requestInvalido = new LoanRequestDTO(
                5000.0,
                3,
                "FIJO",
                "SOL-001",
                "OP-2024-003"
        );

        assertThrows(IllegalArgumentException.class, () -> {
            loanService.crearPrestamo(requestInvalido);
        });
    }

    @Test
    void testValidarCamposRequeridos() {
        LoanRequestDTO requestNulo = new LoanRequestDTO(
                null,
                null,
                null,
                null,
                null
        );

        assertThrows(NullPointerException.class, () -> {
            loanService.crearPrestamo(requestNulo);
        });
    }

    @Test
    void testEventosAuditadosEmitidos() {
        when(loanRepository.findByNumeroOperacion("OP-2024-001"))
                .thenReturn(Optional.empty());
        when(loanRepository.save(any(Loan.class))).thenReturn(loanPersistido);

        loanService.crearPrestamo(requestValido);

        ArgumentCaptor<Loan> loanCaptor = ArgumentCaptor.forClass(Loan.class);
        verify(loanRepository).save(loanCaptor.capture());

        Loan loanGuardado = loanCaptor.getValue();
        assertEquals("APROBADO", loanGuardado.getEstado());
    }
}