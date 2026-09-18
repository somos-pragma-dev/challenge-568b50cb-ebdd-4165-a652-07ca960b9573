package com.banca.prestamos.controller;

import com.banca.prestamos.dto.LoanRequestDTO;
import com.banca.prestamos.repository.LoanRepository;
import com.banca.prestamos.service.LoanService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class LoanControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private LoanService loanService;

    @Test
    void testCrearPrestamoExitoso() throws Exception {
        LoanRequestDTO request = new LoanRequestDTO(
                10000.0,
                12,
                "FIJO",
                "SOL-001",
                "OP-2024-001"
        );

        mockMvc.perform(post("/api/prestamos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.monto").value(10000.0))
                .andExpect(jsonPath("$.plazo").value(12))
                .andExpect(jsonPath("$.tipoInteres").value("FIJO"))
                .andExpect(jsonPath("$.solicitanteId").value("SOL-001"))
                .andExpect(jsonPath("$.numeroOperacion").value("OP-2024-001"));
    }

    @Test
    void testCrearPrestamoMontoNegativo() throws Exception {
        LoanRequestDTO request = new LoanRequestDTO(
                -1000.0,
                12,
                "FIJO",
                "SOL-002",
                "OP-2024-002"
        );

        mockMvc.perform(post("/api/prestamos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testCrearPrestamoPlazoInvalido() throws Exception {
        LoanRequestDTO request = new LoanRequestDTO(
                5000.0,
                3,
                "VARIABLE",
                "SOL-003",
                "OP-2024-003"
        );

        mockMvc.perform(post("/api/prestamos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testCrearPrestamoIdempotente() throws Exception {
        LoanRequestDTO request = new LoanRequestDTO(
                15000.0,
                24,
                "FIJO",
                "SOL-004",
                "OP-2024-004"
        );

        mockMvc.perform(post("/api/prestamos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated());

        mockMvc.perform(post("/api/prestamos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isConflict());
    }

    @Test
    void testCrearPrestamoCamposNulos() throws Exception {
        LoanRequestDTO request = new LoanRequestDTO(
                null,
                null,
                null,
                null,
                null
        );

        mockMvc.perform(post("/api/prestamos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }
}