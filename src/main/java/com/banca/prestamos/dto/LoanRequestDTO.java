package com.banca.prestamos.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Schema(description = "Solicitud de préstamo bancario")
public record LoanRequestDTO(
    @Schema(description = "Monto del préstamo", example = "50000.00")
    @NotNull(message = "El monto es obligatorio")
    @Positive(message = "El monto debe ser positivo")
    Double monto,
    
    @Schema(description = "Plazo del préstamo en meses", example = "24")
    @NotNull(message = "El plazo es obligatorio")
    @Min(value = 6, message = "El plazo mínimo es de 6 meses")
    Integer plazo,
    
    @Schema(description = "Tipo de interés aplicado", example = "FIJO")
    @NotBlank(message = "El tipo de interés es obligatorio")
    String tipoInteres,
    
    @Schema(description = "Identificador del solicitante", example = "SOL-2024-001")
    @NotBlank(message = "El identificador del solicitante es obligatorio")
    String solicitanteId,
    
    @Schema(description = "Número de operación para idempotencia", example = "OP-2024-00001")
    @NotBlank(message = "El número de operación es obligatorio")
    String numeroOperacion
) {
    public LoanRequestDTO {
        if (monto != null && monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo");
        }
        if (plazo != null && plazo < 6) {
            throw new IllegalArgumentException("El plazo mínimo es de 6 meses");
        }
    }
}