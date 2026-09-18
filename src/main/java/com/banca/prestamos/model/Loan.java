package com.banca.prestamos.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "prestamos")
@Schema(description = "Entidad de préstamo bancario")
public class Loan {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único del préstamo", example = "1")
    private Long id;
    
    @Column(nullable = false)
    @Schema(description = "Monto del préstamo", example = "50000.00")
    private Double monto;
    
    @Column(nullable = false)
    @Schema(description = "Plazo del préstamo en meses", example = "24")
    private Integer plazo;
    
    @Column(length = 50, nullable = false)
    @Schema(description = "Tipo de interés aplicado", example = "FIJO")
    private String tipoInteres;
    
    @Column(length = 50, nullable = false)
    @Schema(description = "Identificador del solicitante", example = "SOL-2024-001")
    private String solicitanteId;
    
    @Column(length = 50, nullable = false, unique = true)
    @Schema(description = "Número de operación para idempotencia", example = "OP-2024-00001")
    private String numeroOperacion;
    
    @Column(nullable = false)
    @Schema(description = "Fecha de creación del registro", example = "2024-01-15T10:30:00")
    private LocalDateTime fechaCreacion;
    
    @Column(length = 20, nullable = false)
    @Schema(description = "Estado del préstamo", example = "APROBADO")
    private String estado;
    
    public Loan() {
    }
    
    public Loan(Double monto, Integer plazo, String tipoInteres, String solicitanteId, 
                String numeroOperacion, LocalDateTime fechaCreacion, String estado) {
        this.monto = monto;
        this.plazo = plazo;
        this.tipoInteres = tipoInteres;
        this.solicitanteId = solicitanteId;
        this.numeroOperacion = numeroOperacion;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Double getMonto() {
        return monto;
    }
    
    public void setMonto(Double monto) {
        this.monto = monto;
    }
    
    public Integer getPlazo() {
        return plazo;
    }
    
    public void setPlazo(Integer plazo) {
        this.plazo = plazo;
    }
    
    public String getTipoInteres() {
        return tipoInteres;
    }
    
    public void setTipoInteres(String tipoInteres) {
        this.tipoInteres = tipoInteres;
    }
    
    public String getSolicitanteId() {
        return solicitanteId;
    }
    
    public void setSolicitanteId(String solicitanteId) {
        this.solicitanteId = solicitanteId;
    }
    
    public String getNumeroOperacion() {
        return numeroOperacion;
    }
    
    public void setNumeroOperacion(String numeroOperacion) {
        this.numeroOperacion = numeroOperacion;
    }
    
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
}