package com.banca.prestamos.controller;

import com.banca.prestamos.dto.LoanRequestDTO;
import com.banca.prestamos.dto.LoanResponseDTO;
import com.banca.prestamos.service.LoanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/prestamos")
@Tag(name = "Gestión de Préstamos", description = "API para gestionar solicitudes de préstamos bancarios")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    @Operation(summary = "Crear solicitud de préstamo", description = "Registra una nueva solicitud de préstamo con validación de idempotencia")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Préstamo creado exitosamente",
                     content = @Content(schema = @Schema(implementation = LoanResponseDTO.class))),
        @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos", content = @Content),
        @ApiResponse(responseCode = "409", description = "Ya existe un préstamo con ese número de operación", content = @Content)
    })
    public ResponseEntity<LoanResponseDTO> crearPrestamo(
            @Valid @RequestBody @Parameter(description = "Datos de la solicitud de préstamo") LoanRequestDTO request) {
        LoanResponseDTO respuesta = loanService.crearPrestamo(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener préstamo por ID", description = "Recupera los detalles de un préstamo específico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Préstamo encontrado",
                     content = @Content(schema = @Schema(implementation = LoanResponseDTO.class))),
        @ApiResponse(responseCode = "404", description = "Préstamo no encontrado", content = @Content)
    })
    public ResponseEntity<LoanResponseDTO> obtenerPrestamo(
            @Parameter(description = "ID del préstamo") @PathVariable Long id) {
        LoanResponseDTO respuesta = loanService.obtenerPrestamoPorId(id);
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping
    @Operation(summary = "Listar todos los préstamos", description = "Obtiene una lista de todos los préstamos registrados")
    @ApiResponse(responseCode = "200", description = "Lista de préstamos",
                 content = @Content(schema = @Schema(implementation = LoanResponseDTO.class)))
    public ResponseEntity<List<LoanResponseDTO>> listarPrestamos() {
        List<LoanResponseDTO> prestamos = loanService.listarTodosLosPrestamos();
        return ResponseEntity.ok(prestamos);
    }

    @GetMapping("/solicitante/{solicitanteId}")
    @Operation(summary = "Listar préstamos por solicitante", description = "Obtiene todos los préstamos de un solicitante específico")
    @ApiResponse(responseCode = "200", description = "Lista de préstamos del solicitante")
    public ResponseEntity<List<LoanResponseDTO>> obtenerPrestamosPorSolicitante(
            @Parameter(description = "ID del solicitante") @PathVariable String solicitanteId) {
        List<LoanResponseDTO> prestamos = loanService.obtenerPrestamosPorSolicitante(solicitanteId);
        return ResponseEntity.ok(prestamos);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar préstamo", description = "Actualiza el estado de un préstamo existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Préstamo actualizado",
                     content = @Content(schema = @Schema(implementation = LoanResponseDTO.class))),
        @ApiResponse(responseCode = "404", description = "Préstamo no encontrado", content = @Content)
    })
    public ResponseEntity<LoanResponseDTO> actualizarPrestamo(
            @Parameter(description = "ID del préstamo") @PathVariable Long id,
            @RequestBody @Parameter(description = "Nuevo estado del préstamo") String nuevoEstado) {
        LoanResponseDTO respuesta = loanService.actualizarEstado(id, nuevoEstado);
        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar préstamo", description = "Elimina un préstamo por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Préstamo eliminado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Préstamo no encontrado", content = @Content)
    })
    public ResponseEntity<Void> eliminarPrestamo(
            @Parameter(description = "ID del préstamo a eliminar") @PathVariable Long id) {
        loanService.eliminarPrestamo(id);
        return ResponseEntity.noContent().build();
    }
}