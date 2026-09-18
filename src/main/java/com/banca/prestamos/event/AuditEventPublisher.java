package com.banca.prestamos.event;

import com.banca.prestamos.model.Loan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AuditEventPublisher {
    
    private static final Logger logger = LoggerFactory.getLogger(AuditEventPublisher.class);
    private final ApplicationEventPublisher eventPublisher;
    
    public AuditEventPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }
    
    public void publishLoanAcceptedEvent(Loan loan) {
        AuditEvent auditEvent = new AuditEvent(
            loan.getSolicitanteId(),
            loan.getNumeroOperacion(),
            loan.getMonto(),
            loan.getPlazo(),
            loan.getTipoInteres(),
            loan.getFechaCreacion(),
            loan.getEstado()
        );
        
        eventPublisher.publishEvent(auditEvent);
        logger.info("Evento de auditoría publicado para operación: {}", loan.getNumeroOperacion());
    }
    
    public void publishLoanRejectedEvent(String solicitanteId, String numeroOperacion, 
                                          String motivoRechazo) {
        AuditEvent auditEvent = new AuditEvent(
            solicitanteId,
            numeroOperacion,
            null,
            null,
            null,
            LocalDateTime.now(),
            "RECHAZADO: " + motivoRechazo
        );
        
        eventPublisher.publishEvent(auditEvent);
        logger.info("Evento de auditoría de rechazo publicado para operación: {}", numeroOperacion);
    }
}