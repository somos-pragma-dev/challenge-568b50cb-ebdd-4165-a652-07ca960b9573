package com.banca.prestamos.event;

import java.time.LocalDateTime;

public class AuditEvent {
    
    private final String solicitanteId;
    private final String numeroOperacion;
    private final Double monto;
    private final Integer plazo;
    private final String tipoInteres;
    private final LocalDateTime fechaSolicitud;
    private final String estado;
    private final String timestamp;
    
    public AuditEvent(String solicitanteId, String numeroOperacion, Double monto, 
                      Integer plazo, String tipoInteres, LocalDateTime fechaSolicitud, 
                      String estado) {
        this.solicitanteId = solicitanteId;
        this.numeroOperacion = numeroOperacion;
        this.monto = monto;
        this.plazo = plazo;
        this.tipoInteres = tipoInteres;
        this.fechaSolicitud = fechaSolicitud;
        this.estado = estado;
        this.timestamp = LocalDateTime.now().toString();
    }
    
    public String getSolicitanteId() {
        return solicitanteId;
    }
    
    public String getNumeroOperacion() {
        return numeroOperacion;
    }
    
    public Double getMonto() {
        return monto;
    }
    
    public Integer getPlazo() {
        return plazo;
    }
    
    public String getTipoInteres() {
        return tipoInteres;
    }
    
    public LocalDateTime getFechaSolicitud() {
        return fechaSolicitud;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public String getTimestamp() {
        return timestamp;
    }
    
    @Override
    public String toString() {
        return "AuditEvent{" +
                "solicitanteId='" + solicitanteId + '\'' +
                ", numeroOperacion='" + numeroOperacion + '\'' +
                ", monto=" + monto +
                ", plazo=" + plazo +
                ", tipoInteres='" + tipoInteres + '\'' +
                ", fechaSolicitud=" + fechaSolicitud +
                ", estado='" + estado + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}