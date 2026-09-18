# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Boilerplate del stack que falta

Sin esto no compila ni arranca. Es andamiaje, no toca nada de lo pedagogico:

- **Punto de entrada del stack elegido** — Sin un punto de entrada reconocible, el runtime no tiene por donde arrancar la aplicacion.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/test/java/com/banca/prestamos/controller/LoanControllerTest.java` — `com.fasterxml.jackson`: El import com.fasterxml.jackson.databind.ObjectMapper pertenece a com.fasterxml.jackson, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/test/java/com/banca/prestamos/controller/LoanControllerTest.java` — `org.junit.jupiter`: El import org.junit.jupiter.api.Test pertenece a org.junit.jupiter, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/test/java/com/banca/prestamos/service/LoanServiceTest.java` — `org.junit.jupiter`: El import org.junit.jupiter.api.BeforeEach pertenece a org.junit.jupiter, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/test/java/com/banca/prestamos/service/LoanServiceTest.java` — `org.mockito`: El import org.mockito.ArgumentCaptor pertenece a org.mockito, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/test/java/com/banca/prestamos/service/LoanServiceTest.java` — `org.mockito.junit`: El import org.mockito.junit.jupiter.MockitoExtension pertenece a org.mockito.junit, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/test/java/com/banca/prestamos/service/LoanServiceTest.java` — `org.mockito.ArgumentMatchers`: El import org.mockito.ArgumentMatchers.any pertenece a org.mockito.ArgumentMatchers, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/test/java/com/banca/prestamos/service/LoanServiceTest.java` — `org.mockito.Mockito`: El import org.mockito.Mockito pertenece a org.mockito.Mockito, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/banca/prestamos/service/LoanService.java` — `LoanRepository.save`: Se invoca `save` sobre `LoanRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/prestamos/service/LoanService.java` — `LoanRepository.findById`: Se invoca `findById` sobre `LoanRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/prestamos/service/LoanService.java` — `LoanRepository.findAll`: Se invoca `findAll` sobre `LoanRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/prestamos/service/LoanService.java` — `LoanRepository.existsById`: Se invoca `existsById` sobre `LoanRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/prestamos/service/LoanService.java` — `LoanRepository.deleteById`: Se invoca `deleteById` sobre `LoanRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/banca/prestamos/service/LoanServiceTest.java` — `LoanRepository.save`: Se invoca `save` sobre `LoanRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/banca/prestamos/service/LoanServiceTest.java` — `LoanResponseDTO.monto`: Se invoca `monto` sobre `LoanResponseDTO`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/banca/prestamos/service/LoanServiceTest.java` — `LoanResponseDTO.plazo`: Se invoca `plazo` sobre `LoanResponseDTO`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/banca/prestamos/service/LoanServiceTest.java` — `LoanResponseDTO.tipoInteres`: Se invoca `tipoInteres` sobre `LoanResponseDTO`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/banca/prestamos/service/LoanServiceTest.java` — `LoanResponseDTO.solicitanteId`: Se invoca `solicitanteId` sobre `LoanResponseDTO`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/banca/prestamos/service/LoanServiceTest.java` — `LoanResponseDTO.numeroOperacion`: Se invoca `numeroOperacion` sobre `LoanResponseDTO`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
el comando de build o arranque canonico del stack elegido
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Contexto técnico original
Crear una API REST con Spring Boot, JPA y documentación OpenAPI

### Reto
- Tema: creación de api rest
- Seniority: junior-l1
- Tipo: practical
- Título: Desarrollo de API REST en dominio de banca
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Aceptación de solicitudes — objetivo: Implementar un endpoint que acepte solicitudes de préstamos y las valide. — entregable (NO resolver): Endpoint REST operativo que acepta y valida solicitudes de préstamos.
- Fase 2: Persistencia de solicitudes — objetivo: Persistir las solicitudes válidas en una base de datos con idempotencia. — entregable (NO resolver): Sistema que persiste solicitudes válidas con idempotencia.
- Fase 3: Emisión de eventos de auditoría — objetivo: Emitir un evento de auditoría por cada solicitud aceptada. — entregable (NO resolver): Sistema que emite eventos de auditoría por cada solicitud aceptada.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.0</version>
        <relativePath/>
    </parent>

    <groupId>com.banca</groupId>
    <artifactId>prestamos</artifactId>
    <version>1.0.0-SNAPSHOT</version>
    <name>prestamos</name>
    <description>API REST para gestión de préstamos bancarios</description>

    <properties>
        <java.version>21</java.version>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <springdoc.version>2.6.0</springdoc.version>
        <lombok.version>1.18.34</lombok.version>
    </properties>

    <dependencies>
        <!-- Spring Boot Web -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!-- Spring Boot Data JPA -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>

        <!-- H2 Database -->
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <version>2.3.230</version>
            <scope>runtime</scope>
        </dependency>

        <!-- Lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>${lombok.version}</version>
            <scope>provided</scope>
        </dependency>

        <!-- Jakarta Validation -->
        <dependency>
            <groupId>jakarta.validation</groupId>
            <artifactId>jakarta.validation-api</artifactId>
            <version>3.1.0</version>
        </dependency>

        <!-- Spring Boot Validation -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>

        <!-- SpringDoc OpenAPI -->
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>${springdoc.version}</version>
        </dependency>

        <!-- Spring Boot Test -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/banca/prestamos/PrestamosApplication.java ===
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

// === ARCHIVO: src/main/resources/application.yml ===
spring:
  application:
    name: prestamos-bancarios-api
  
  datasource:
    url: jdbc:h2:mem:prestamosdb
    driver-class-name: org.h2.Driver
    username: sa
    password: 
    hikari:
      maximum-pool-size: 10
      minimum-idle: 2
      connection-timeout: 30000
      idle-timeout: 600000
      max-lifetime: 1800000
  
  h2:
    console:
      enabled: true
      path: /h2-console
      settings:
        web-allow-others: true
  
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    hibernate:
      ddl-auto: create-drop
    show-sql: false
    properties:
      hibernate:
        format_sql: true
        use_sql_comments: false
        jdbc:
          batch_size: 20
        order_inserts: true
        order_updates: true
    open-in-view: false
  
  jackson:
    serialization:
      indent-output: true
      write-dates-as-timestamps: false
    deserialization:
      fail-on-unknown-properties: false
      fail-on-empty-beans: false
    default-property-inclusion: non_null
  
  mvc:
    throw-exception-if-no-handler-found: true
  web:
    resources:
      add-mappings: false

server:
  port: 8080
  servlet:
    context-path: /
    encoding:
      charset: UTF-8
      enabled: true
      force: true
  compression:
    enabled: true
    mime-types: text/html,text/xml,text/plain,text/css,application/javascript,application/json
    min-response-size: 1024

springdoc:
  api-docs:
    path: /v3/api-docs
    enabled: true
  swagger-ui:
    path: /swagger-ui.html
    enabled: true
    operationsSorter: method
    tagsSorter: alpha
    tryItOutEnabled: true
  show-actuator: false
  model-and-view-allowed: false

springdoc.swagger-ui.tagsSorter: alpha
springdoc.swagger-ui.operationsSorter: method

logging:
  level:
    root: INFO
    com.banca.prestamos: DEBUG
    org.springframework.web: INFO
    org.springframework.security: DEBUG
    org.hibernate.SQL: DEBUG
    org.hibernate.type.descriptor.sql.BasicBinder: TRACE
    org.springframework.jdbc.core: DEBUG
    org.springframework.transaction: DEBUG
  pattern:
    console: "%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"
    file: "%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"
  file:
    name: logs/prestamos.log
    max-size: 10MB
    max-history: 30

management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics
  endpoint:
    health:
      show-details: always
  health:
    db:
      enabled: true


// === ARCHIVO: src/main/java/com/banca/prestamos/dto/LoanRequestDTO.java ===
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

// === ARCHIVO: src/main/java/com/banca/prestamos/dto/LoanResponseDTO.java ===
package com.banca.prestamos.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

@Schema(description = "Respuesta de solicitud de préstamo")
public record LoanResponseDTO(
    @Schema(description = "Identificador único del préstamo", example = "1")
    Long id,
    
    @Schema(description = "Monto aprobado del préstamo", example = "50000.00")
    Double monto,
    
    @Schema(description = "Plazo aprobado en meses", example = "24")
    Integer plazo,
    
    @Schema(description = "Tipo de interés aplicado", example = "FIJO")
    String tipoInteres,
    
    @Schema(description = "Identificador del solicitante", example = "SOL-2024-001")
    String solicitanteId,
    
    @Schema(description = "Número de operación", example = "OP-2024-00001")
    String numeroOperacion,
    
    @Schema(description = "Fecha de creación de la solicitud", example = "2024-01-15T10:30:00")
    LocalDateTime fechaCreacion,
    
    @Schema(description = "Estado del préstamo", example = "APROBADO")
    String estado
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
        private LocalDateTime fechaCreacion;
        private String estado;
        
        public LoanResponseDTOBuilder id(Long id) { this.id = id; return this; }
        public LoanResponseDTOBuilder monto(Double monto) { this.monto = monto; return this; }
        public LoanResponseDTOBuilder plazo(Integer plazo) { this.plazo = plazo; return this; }
        public LoanResponseDTOBuilder tipoInteres(String tipoInteres) { this.tipoInteres = tipoInteres; return this; }
        public LoanResponseDTOBuilder solicitanteId(String solicitanteId) { this.solicitanteId = solicitanteId; return this; }
        public LoanResponseDTOBuilder numeroOperacion(String numeroOperacion) { this.numeroOperacion = numeroOperacion; return this; }
        public LoanResponseDTOBuilder fechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; return this; }
        public LoanResponseDTOBuilder estado(String estado) { this.estado = estado; return this; }
        
        public LoanResponseDTO build() {
            return new LoanResponseDTO(id, monto, plazo, tipoInteres, solicitanteId, numeroOperacion, fechaCreacion, estado);
        }
    }
}

// === ARCHIVO: src/main/java/com/banca/prestamos/model/Loan.java ===
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

// === ARCHIVO: src/main/java/com/banca/prestamos/repository/LoanRepository.java ===
package com.banca.prestamos.repository;

import com.banca.prestamos.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    @Query("SELECT l FROM Loan l WHERE l.numeroOperacion = :numeroOperacion")
    Optional<Loan> findByNumeroOperacion(@Param("numeroOperacion") String numeroOperacion);

    boolean existsByNumeroOperacion(String numeroOperacion);

    java.util.List<Loan> findBySolicitanteId(String solicitanteId);

    java.util.List<Loan> findByEstado(String estado);
}

// === ARCHIVO: src/main/java/com/banca/prestamos/controller/LoanController.java ===
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

// === ARCHIVO: src/main/java/com/banca/prestamos/service/LoanService.java ===
package com.banca.prestamos.service;

import com.banca.prestamos.dto.LoanRequestDTO;
import com.banca.prestamos.dto.LoanResponseDTO;
import com.banca.prestamos.event.AuditEvent;
import com.banca.prestamos.event.AuditEventPublisher;
import com.banca.prestamos.model.Loan;
import com.banca.prestamos.repository.LoanRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class LoanService {

    private static final int PLAZO_MINIMO_MESES = 6;
    private static final double MONTO_MINIMO = 0.01;
    private static final String ESTADO_APROBADO = "APROBADO";
    private static final String ESTADO_PENDIENTE = "PENDIENTE";
    private static final String ESTADO_RECHAZADO = "RECHAZADO";

    private final LoanRepository loanRepository;
    private final ApplicationEventPublisher eventPublisher;

    public LoanService(LoanRepository loanRepository, ApplicationEventPublisher eventPublisher) {
        this.loanRepository = loanRepository;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public LoanResponseDTO crearPrestamo(LoanRequestDTO request) {
        validarSolicitud(request);
        verificarIdempotencia(request.numeroOperacion());

        Loan prestamo = mapearEntidad(request);
        Loan prestamoGuardado = loanRepository.save(prestamo);

        emitircEventoAuditoria(prestamoGuardado, "CREADO");

        return mapearRespuesta(prestamoGuardado);
    }

    @Transactional(readOnly = true)
    public LoanResponseDTO obtenerPrestamoPorId(Long id) {
        Loan prestamo = loanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Préstamo no encontrado con ID: " + id));
        return mapearRespuesta(prestamo);
    }

    @Transactional(readOnly = true)
    public List<LoanResponseDTO> listarTodosLosPrestamos() {
        return loanRepository.findAll().stream()
                .map(this::mapearRespuesta)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<LoanResponseDTO> obtenerPrestamosPorSolicitante(String solicitanteId) {
        return loanRepository.findBySolicitanteId(solicitanteId).stream()
                .map(this::mapearRespuesta)
                .toList();
    }

    @Transactional
    public LoanResponseDTO actualizarEstado(Long id, String nuevoEstado) {
        Loan prestamo = loanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Préstamo no encontrado con ID: " + id));

        validarEstado(nuevoEstado);

        String estadoAnterior = prestamo.getEstado();
        prestamo.setEstado(nuevoEstado);
        Loan prestamoActualizado = loanRepository.save(prestamo);

        emitircEventoAuditoria(prestamoActualizado, "ESTADO_MODIFICADO: " + estadoAnterior + " -> " + nuevoEstado);

        return mapearRespuesta(prestamoActualizado);
    }

    @Transactional
    public void eliminarPrestamo(Long id) {
        if (!loanRepository.existsById(id)) {
            throw new IllegalArgumentException("Préstamo no encontrado con ID: " + id);
        }
        loanRepository.deleteById(id);
    }

    private void validarSolicitud(LoanRequestDTO request) {
        if (request.monto() == null || request.monto() < MONTO_MINIMO) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero");
        }

        if (request.plazo() == null || request.plazo() < PLAZO_MINIMO_MESES) {
            throw new IllegalArgumentException("El plazo mínimo es de " + PLAZO_MINIMO_MESES + " meses");
        }

        if (request.tipoInteres() == null || request.tipoInteres().isBlank()) {
            throw new IllegalArgumentException("El tipo de interés es obligatorio");
        }

        if (request.solicitanteId() == null || request.solicitanteId().isBlank()) {
            throw new IllegalArgumentException("El identificador del solicitante es obligatorio");
        }

        if (request.numeroOperacion() == null || request.numeroOperacion().isBlank()) {
            throw new IllegalArgumentException("El número de operación es obligatorio para idempotencia");
        }
    }

    private void verificarIdempotencia(String numeroOperacion) {
        if (loanRepository.existsByNumeroOperacion(numeroOperacion)) {
            throw new IllegalStateException("Ya existe un préstamo con el número de operación: " + numeroOperacion);
        }
    }

    private void validarEstado(String estado) {
        if (estado == null || estado.isBlank()) {
            throw new IllegalArgumentException("El estado no puede estar vacío");
        }

        boolean estadoValido = estado.equals(ESTADO_APROBADO) ||
                              estado.equals(ESTADO_PENDIENTE) ||
                              estado.equals(ESTADO_RECHAZADO);

        if (!estadoValido) {
            throw new IllegalArgumentException("Estado inválido. Estados permitidos: " +
                    ESTADO_PENDIENTE + ", " + ESTADO_APROBADO + ", " + ESTADO_RECHAZADO);
        }
    }

    private Loan mapearEntidad(LoanRequestDTO request) {
        Loan loan = new Loan();
        loan.setMonto(request.monto());
        loan.setPlazo(request.plazo());
        loan.setTipoInteres(request.tipoInteres());
        loan.setSolicitanteId(request.solicitanteId());
        loan.setNumeroOperacion(request.numeroOperacion());
        loan.setFechaCreacion(LocalDateTime.now());
        loan.setEstado(ESTADO_PENDIENTE);
        return loan;
    }

    private LoanResponseDTO mapearRespuesta(Loan loan) {
        return LoanResponseDTO.builder()
                .id(loan.getId())
                .monto(loan.getMonto())
                .plazo(loan.getPlazo())
                .tipoInteres(loan.getTipoInteres())
                .solicitanteId(loan.getSolicitanteId())
                .numeroOperacion(loan.getNumeroOperacion())
                .fechaCreacion(loan.getFechaCreacion() != null ? loan.getFechaCreacion().toString() : null)
                .estado(loan.getEstado())
                .build();
    }

    private void emitircEventoAuditoria(Loan prestamo, String accion) {
        AuditEvent evento = new AuditEvent(
                UUID.randomUUID().toString(),
                prestamo.getId(),
                accion,
                "PRESTAMO",
                prestamo.getSolicitanteId(),
                LocalDateTime.now().toString()
        );
        eventPublisher.publishEvent(evento);
    }
}


// === ARCHIVO: src/main/java/com/banca/prestamos/event/AuditEvent.java ===
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

// === ARCHIVO: src/main/java/com/banca/prestamos/event/AuditEventPublisher.java ===
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

// === ARCHIVO: src/main/java/com/banca/prestamos/config/OpenApiConfig.java ===
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

// === ARCHIVO: src/test/java/com/banca/prestamos/controller/LoanControllerTest.java ===
package com.banca.prestamos.controller;

import com.banca.prestamos.dto.LoanRequestDTO;
import com.banca.prestamos.dto.LoanResponseDTO;
import com.banca.prestamos.model.Loan;
import com.banca.prestamos.repository.LoanRepository;
import com.banca.prestamos.service.LoanService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
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

// === ARCHIVO: src/test/java/com/banca/prestamos/service/LoanServiceTest.java ===
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

// === ARCHIVO: pom.xml ===
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.0</version>
        <relativePath/>
    </parent>
    
    <groupId>com.banca</groupId>
    <artifactId>prestamos</artifactId>
    <version>1.0.0</version>
    <name>prestamos</name>
    <description>Sistema de Gestión de Préstamos Bancarios</description>
    
    <properties>
        <java.version>21</java.version>
    </properties>
    
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <version>3.4.0</version>
            <scope>compile</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
            <version>3.4.0</version>
            <scope>compile</scope>
        </dependency>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <version>2.3.230</version>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.34</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>2.6.0</version>
            <scope>compile</scope>
        </dependency>
        <dependency>
            <groupId>jakarta.validation</groupId>
            <artifactId>jakarta.validation-api</artifactId>
            <version>3.1.0</version>
            <scope>compile</scope>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.17.2</version>
            <scope>compile</scope>
        </dependency>
        <dependency>
            <groupId>io.swagger.core.v3</groupId>
            <artifactId>swagger-annotations</artifactId>
            <version>2.2.22</version>
            <scope>compile</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <version>3.4.0</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
    
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/banca/prestamos/service/LoanService.java ===
package com.banca.prestamos.service;

import com.banca.prestamos.dto.LoanRequestDTO;
import com.banca.prestamos.dto.LoanResponseDTO;
import com.banca.prestamos.event.AuditEvent;
import com.banca.prestamos.model.Loan;
import com.banca.prestamos.repository.LoanRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class LoanService {

    private static final int PLAZO_MINIMO_MESES = 6;
    private static final double MONTO_MINIMO = 0.01;
    private static final String ESTADO_APROBADO = "APROBADO";
    private static final String ESTADO_PENDIENTE = "PENDIENTE";
    private static final String ESTADO_RECHAZADO = "RECHAZADO";

    private final LoanRepository loanRepository;
    private final ApplicationEventPublisher eventPublisher;

    public LoanService(LoanRepository loanRepository, ApplicationEventPublisher eventPublisher) {
        this.loanRepository = loanRepository;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public LoanResponseDTO crearPrestamo(LoanRequestDTO request) {
        validarSolicitud(request);
        verificarIdempotencia(request.numeroOperacion());

        Loan prestamo = mapearEntidad(request);
        Loan prestamoGuardado = loanRepository.save(prestamo);

        emitircEventoAuditoria(prestamoGuardado, "CREADO");

        return mapearRespuesta(prestamoGuardado);
    }

    @Transactional(readOnly = true)
    public LoanResponseDTO obtenerPrestamoPorId(Long id) {
        Loan prestamo = loanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Préstamo no encontrado con ID: " + id));
        return mapearRespuesta(prestamo);
    }

    @Transactional(readOnly = true)
    public List<LoanResponseDTO> listarTodosLosPrestamos() {
        return loanRepository.findAll().stream()
                .map(this::mapearRespuesta)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<LoanResponseDTO> obtenerPrestamosPorSolicitante(String solicitanteId) {
        return loanRepository.findBySolicitanteId(solicitanteId).stream()
                .map(this::mapearRespuesta)
                .toList();
    }

    @Transactional
    public LoanResponseDTO actualizarEstado(Long id, String nuevoEstado) {
        Loan prestamo = loanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Préstamo no encontrado con ID: " + id));

        validarEstado(nuevoEstado);

        String estadoAnterior = prestamo.getEstado();
        prestamo.setEstado(nuevoEstado);
        Loan prestamoActualizado = loanRepository.save(prestamo);

        emitircEventoAuditoria(prestamoActualizado, "ESTADO_MODIFICADO: " + estadoAnterior + " -> " + nuevoEstado);

        return mapearRespuesta(prestamoActualizado);
    }

    @Transactional
    public void eliminarPrestamo(Long id) {
        if (!loanRepository.existsById(id)) {
            throw new IllegalArgumentException("Préstamo no encontrado con ID: " + id);
        }
        loanRepository.deleteById(id);
    }

    private void validarSolicitud(LoanRequestDTO request) {
        if (request.monto() == null || request.monto() < MONTO_MINIMO) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero");
        }

        if (request.plazo() == null || request.plazo() < PLAZO_MINIMO_MESES) {
            throw new IllegalArgumentException("El plazo mínimo es de " + PLAZO_MINIMO_MESES + " meses");
        }

        if (request.tipoInteres() == null || request.tipoInteres().isBlank()) {
            throw new IllegalArgumentException("El tipo de interés es obligatorio");
        }

        if (request.solicitanteId() == null || request.solicitanteId().isBlank()) {
            throw new IllegalArgumentException("El identificador del solicitante es obligatorio");
        }

        if (request.numeroOperacion() == null || request.numeroOperacion().isBlank()) {
            throw new IllegalArgumentException("El número de operación es obligatorio para idempotencia");
        }
    }

    private void verificarIdempotencia(String numeroOperacion) {
        if (loanRepository.existsByNumeroOperacion(numeroOperacion)) {
            throw new IllegalStateException("Ya existe un préstamo con el número de operación: " + numeroOperacion);
        }
    }

    private void validarEstado(String estado) {
        if (estado == null || estado.isBlank()) {
            throw new IllegalArgumentException("El estado no puede estar vacío");
        }

        boolean estadoValido = estado.equals(ESTADO_APROBADO) ||
                              estado.equals(ESTADO_PENDIENTE) ||
                              estado.equals(ESTADO_RECHAZADO);

        if (!estadoValido) {
            throw new IllegalArgumentException("Estado inválido. Estados permitidos: " +
                    ESTADO_PENDIENTE + ", " + ESTADO_APROBADO + ", " + ESTADO_RECHAZADO);
        }
    }

    private Loan mapearEntidad(LoanRequestDTO request) {
        Loan loan = new Loan();
        loan.setMonto(request.monto());
        loan.setPlazo(request.plazo());
        loan.setTipoInteres(request.tipoInteres());
        loan.setSolicitanteId(request.solicitanteId());
        loan.setNumeroOperacion(request.numeroOperacion());
        loan.setFechaCreacion(LocalDateTime.now());
        loan.setEstado(ESTADO_PENDIENTE);
        return loan;
    }

    private LoanResponseDTO mapearRespuesta(Loan loan) {
        return LoanResponseDTO.builder()
                .id(loan.getId())
                .monto(loan.getMonto())
                .plazo(loan.getPlazo())
                .tipoInteres(loan.getTipoInteres())
                .solicitanteId(loan.getSolicitanteId())
                .numeroOperacion(loan.getNumeroOperacion())
                .fechaCreacion(loan.getFechaCreacion() != null ? loan.getFechaCreacion().toString() : null)
                .estado(loan.getEstado())
                .build();
    }

    private void emitircEventoAuditoria(Loan prestamo, String accion) {
        AuditEvent evento = new AuditEvent(
                prestamo.getSolicitanteId(),
                prestamo.getNumeroOperacion(),
                prestamo.getMonto(),
                prestamo.getPlazo(),
                prestamo.getTipoInteres(),
                prestamo.getFechaCreacion(),
                accion,
                LocalDateTime.now().toString()
        );
        eventPublisher.publishEvent(evento);
    }
}

// === ARCHIVO: src/test/java/com/banca/prestamos/controller/LoanControllerTest.java ===
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


// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.0</version>
        <relativePath/>
    </parent>
    
    <groupId>com.banca</groupId>
    <artifactId>prestamos</artifactId>
    <version>1.0.0</version>
    <name>prestamos</name>
    <description>Sistema de gestión de préstamos bancarios</description>
    
    <properties>
        <java.version>21</java.version>
        <springdoc.version>2.6.0</springdoc.version>
        <swagger.version>2.2.23</swagger.version>
    </properties>
    
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <version>2.3.230</version>
            <scope>runtime</scope>
        </dependency>
        
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.34</version>
            <scope>provided</scope>
        </dependency>
        
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>2.6.0</version>
        </dependency>
        
        <dependency>
            <groupId>io.swagger.core.v3</groupId>
            <artifactId>swagger-annotations</artifactId>
            <version>2.2.23</version>
        </dependency>
        
        <dependency>
            <groupId>jakarta.validation</groupId>
            <artifactId>jakarta.validation-api</artifactId>
            <version>3.1.0</version>
        </dependency>
    </dependencies>
    
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.0</version>
        <relativePath/>
    </parent>
    
    <groupId>com.banca</groupId>
    <artifactId>prestamos</artifactId>
    <version>1.0.0</version>
    <name>prestamos</name>
    <description>API de Gestión de Préstamos Bancarios</description>
    
    <properties>
        <java.version>21</java.version>
        <springdoc.version>2.6.0</springdoc.version>
    </properties>
    
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>
        
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <scope>provided</scope>
        </dependency>
        
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>${springdoc.version}</version>
        </dependency>
        
        <dependency>
            <groupId>jakarta.validation</groupId>
            <artifactId>jakarta.validation-api</artifactId>
            <version>3.1.0</version>
        </dependency>
        
        <!-- Dependencias necesarias para resolver referencias -->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
        </dependency>
        
        <dependency>
            <groupId>io.swagger.core.v3</groupId>
            <artifactId>swagger-core</artifactId>
            <version>2.2.21</version>
        </dependency>
    </dependencies>
    
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/banca/prestamos/dto/LoanResponseDTO.java ===
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

```
