package com.banca.prestamos.dto;

import java.time.LocalDateTime;

public record LoanResponseDTO(
    Long id,
    Double monto,
    Integer plazo,
    String tipoInteres,
    String solicitanteId,
    String numeroOperacion,
    String estado,
    LocalDateTime fechaCreacion
) {
    public static LoanResponseDTOBuilder builder() {
        return new LoanResponseDTOBuilder();
    }
    
    public static class LoanResponseDTOBuilder {
        private Long id;
        private Double monto;
        private Integer plazo;
        private String tipoInteres;
        private String solicitanteId;
        private String numeroOperacion;
        private String estado;
        private LocalDateTime fechaCreacion;
        
        public LoanResponseDTOBuilder id(Long id) {
            this.id = id;
            return this;
        }
        
        public LoanResponseDTOBuilder monto(Double monto) {
            this.monto = monto;
            return this;
        }
        
        public LoanResponseDTOBuilder plazo(Integer plazo) {
            this.plazo = plazo;
            return this;
        }
        
        public LoanResponseDTOBuilder tipoInteres(String tipoInteres) {
            this.tipoInteres = tipoInteres;
            return this;
        }
        
        public LoanResponseDTOBuilder solicitanteId(String solicitanteId) {
            this.solicitanteId = solicitanteId;
            return this;
        }
        
        public LoanResponseDTOBuilder numeroOperacion(String numeroOperacion) {
            this.numeroOperacion = numeroOperacion;
            return this;
        }
        
        public LoanResponseDTOBuilder estado(String estado) {
            this.estado = estado;
            return this;
        }
        
        public LoanResponseDTOBuilder fechaCreacion(LocalDateTime fechaCreacion) {
            this.fechaCreacion = fechaCreacion;
            return this;
        }
        
        public LoanResponseDTO build() {
            return new LoanResponseDTO(id, monto, plazo, tipoInteres, solicitanteId, 
                numeroOperacion, estado, fechaCreacion);
        }
    }
}