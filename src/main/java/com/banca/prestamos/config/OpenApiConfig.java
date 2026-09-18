package com.banca.prestamos.config;

import com.banca.prestamos.dto.LoanRequestDTO;
import com.banca.prestamos.dto.LoanResponseDTO;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.media.NumberSchema;
import io.swagger.v3.oas.models.media.IntegerSchema;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class OpenApiConfig {
    
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestión de Préstamos Bancarios")
                        .version("1.0.0")
                        .description("""
                                API REST para la gestión de solicitudes de préstamos bancarios.
                                Permite crear nuevas solicitudes de préstamos, validar los datos
                                de entrada, persistir las solicitudes y mantener un registro
                                de auditoría de todas las operaciones.
                                """)
                        .contact(new Contact()
                                .name("Equipo de Desarrollo Banca")
                                .email("desarrollo@banca.com")
                                .url("https://www.banca.com"))
                        .license(new License()
                                .name("Licencia Proprietaria")
                                .url("https://www.banca.com/licencia")))
                .components(new Components()
                        .addSchemas("LoanRequestDTO", createLoanRequestSchema())
                        .addSchemas("LoanResponseDTO", createLoanResponseSchema())
                        .addSecuritySchemes("bearerAuth", createBearerAuthScheme()));
    }
    
    private Schema<LoanRequestDTO> createLoanRequestSchema() {
        Schema<LoanRequestDTO> schema = new Schema<>();
        schema.type("object");
        schema.description("Solicitud de préstamo bancario");
        schema.addProperty("monto", new NumberSchema()
                .example(50000.00)
                .description("Monto del préstamo en la moneda base")
                .minimum("0"));
        schema.addProperty("plazo", new IntegerSchema()
                .example(24)
                .description("Plazo del préstamo en meses")
                .minimum("6"));
        schema.addProperty("tipoInteres", new StringSchema()
                .example("FIJO")
                .description("Tipo de interés: FIJO o VARIABLE"));
        schema.addProperty("solicitanteId", new StringSchema()
                .example("SOL-001")
                .description("Identificador único del solicitante"));
        schema.addProperty("numeroOperacion", new StringSchema()
                .example("OP-2024-0001")
                .description("Número de operación único para idempotencia"));
        return schema;
    }
    
    private Schema<LoanResponseDTO> createLoanResponseSchema() {
        Schema<LoanResponseDTO> schema = new Schema<>();
        schema.type("object");
        schema.description("Respuesta de préstamo creado");
        schema.addProperty("id", new NumberSchema()
                .example(1)
                .description("Identificador único del préstamo"));
        schema.addProperty("monto", new NumberSchema()
                .example(50000.00)
                .description("Monto aprobado del préstamo"));
        schema.addProperty("plazo", new IntegerSchema()
                .example(24)
                .description("Plazo aprobado en meses"));
        schema.addProperty("tipoInteres", new StringSchema()
                .example("FIJO")
                .description("Tipo de interés del préstamo"));
        schema.addProperty("solicitanteId", new StringSchema()
                .example("SOL-001")
                .description("Identificador del solicitante"));
        schema.addProperty("numeroOperacion", new StringSchema()
                .example("OP-2024-0001")
                .description("Número de operación único"));
        schema.addProperty("estado", new StringSchema()
                .example("APROBADO")
                .description("Estado actual del préstamo"));
        schema.addProperty("fechaCreacion", new StringSchema()
                .example("2024-01-15T10:30:00")
                .description("Fecha de creación del registro"));
        return schema;
    }
    
    private io.swagger.v3.oas.models.security.SecurityScheme createBearerAuthScheme() {
        return new io.swagger.v3.oas.models.security.SecurityScheme()
                .type(io.swagger.v3.oas.models.security.SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")
                .description("Token JWT para autenticación");
    }
    
    @Bean
    public OpenApiCustomizer globalHeaderCustomizer() {
        return openApi -> {
            if (openApi.getPaths() != null) {
                openApi.getPaths().forEach((path, pathItem) -> {
                    if (pathItem.getGet() != null) {
                        pathItem.getGet().addExtension("x-summary", "Obtener " + path);
                    }
                    if (pathItem.getPost() != null) {
                        pathItem.getPost().addExtension("x-summary", "Crear " + path);
                    }
                    if (pathItem.getPut() != null) {
                        pathItem.getPut().addExtension("x-summary", "Actualizar " + path);
                    }
                    if (pathItem.getDelete() != null) {
                        pathItem.getDelete().addExtension("x-summary", "Eliminar " + path);
                    }
                });
            }
        };
    }
}