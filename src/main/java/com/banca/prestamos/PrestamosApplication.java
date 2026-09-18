package com.banca.prestamos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import jakarta.validation.Validator;

/**
 * Punto de entrada principal de la aplicación de gestión de préstamos bancarios.
 *
 * Esta aplicación expone una API REST para la creación de solicitudes de préstamos
 * con validación de datos, persistencia en base de datos H2 y emisión de eventos
 * de auditoría para cada operación aceptada.
 *
 * La arquitectura sigue el patrón de capas estándar de Spring Boot:
 * - Controller: expose la API REST y maneja las peticiones HTTP
 * - Service: contiene la lógica de negocio
 * - Repository: gestiona la persistencia en base de datos
 *
 * La aplicación está configurada para usar H2 en memoria para desarrollo y pruebas,
 * con generación automática de esquema al inicio.
 *
 * @author Banca Préstamos
 * @version 1.0.0
 * @since 2024
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.banca.prestamos"})
@EnableJpaAuditing
public class PrestamosApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrestamosApplication.class, args);
    }

    /**
     * Bean de validación de Jakarta Validation para validar DTOs en la capa de controller.
     * Este validador se inyecta automáticamente en los métodos de los controllers
     * que utilizan @Valid en sus parámetros.
     *
     * @return Validator configurado para la aplicación
     */
    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }

    /**
     * Verificación de salud de la aplicación al iniciar.
     * Imprime información relevante sobre los componentes configurados.
     *
     * @param eventPublisher el publicador de eventos de Spring
     */
    @Bean
    public ApplicationEventPublisher healthCheck(ApplicationEventPublisher eventPublisher) {
        System.out.println("==============================================");
        System.out.println("  PRÉSTAMOS BANCARIOS API - INICIANDO");
        System.out.println("==============================================");
        System.out.println("  Versión: 1.0.0");
        System.out.println("  Java: 21");
        System.out.println("  Spring Boot: 3.4.0");
        System.out.println("  Base de datos: H2 (en memoria)");
        System.out.println("  OpenAPI: http://localhost:8080/swagger-ui.html");
        System.out.println("==============================================");
        return eventPublisher;
    }
}