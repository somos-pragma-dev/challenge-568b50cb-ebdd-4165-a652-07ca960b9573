# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Desarrollo de API REST en dominio de banca**.

| | |
|---|---|
| Tema | creación de api rest |
| Nivel | junior-l1 |
| Chapter | Generico |
| Especialidad | Inferido del contexto |
| Stack | Java / Spring Boot 3.4 |
| Patron arquitectonico | capas estándar (controller-service-repository) |
| Tiempo estimado | 8 horas |

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `el comando de build o arranque canonico del stack elegido` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `el comando de build o arranque canonico del stack elegido` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Aceptación de solicitudes**: Endpoint REST operativo que acepta y valida solicitudes de préstamos.
- **Fase 2 — Persistencia de solicitudes**: Sistema que persiste solicitudes válidas con idempotencia.
- **Fase 3 — Emisión de eventos de auditoría**: Sistema que emite eventos de auditoría por cada solicitud aceptada.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Lo que falta y tenes que completar

### 1. Boilerplate del stack (1)

Sin esto el proyecto no compila ni arranca. **Es tu trabajo crearlo**, y no toca nada de lo pedagogico: es andamiaje del stack.

- [ ] **Punto de entrada del stack elegido** — Sin un punto de entrada reconocible, el runtime no tiene por donde arrancar la aplicacion.

### 2. Referencias colgando (18)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/test/java/com/banca/prestamos/controller/LoanControllerTest.java` — `com.fasterxml.jackson`
      El import com.fasterxml.jackson.databind.ObjectMapper pertenece a com.fasterxml.jackson, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/test/java/com/banca/prestamos/controller/LoanControllerTest.java` — `org.junit.jupiter`
      El import org.junit.jupiter.api.Test pertenece a org.junit.jupiter, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/test/java/com/banca/prestamos/service/LoanServiceTest.java` — `org.junit.jupiter`
      El import org.junit.jupiter.api.BeforeEach pertenece a org.junit.jupiter, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/test/java/com/banca/prestamos/service/LoanServiceTest.java` — `org.mockito`
      El import org.mockito.ArgumentCaptor pertenece a org.mockito, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/test/java/com/banca/prestamos/service/LoanServiceTest.java` — `org.mockito.junit`
      El import org.mockito.junit.jupiter.MockitoExtension pertenece a org.mockito.junit, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/test/java/com/banca/prestamos/service/LoanServiceTest.java` — `org.mockito.ArgumentMatchers`
      El import org.mockito.ArgumentMatchers.any pertenece a org.mockito.ArgumentMatchers, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/test/java/com/banca/prestamos/service/LoanServiceTest.java` — `org.mockito.Mockito`
      El import org.mockito.Mockito pertenece a org.mockito.Mockito, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/banca/prestamos/service/LoanService.java` — `LoanRepository.save`
      Se invoca `save` sobre `LoanRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/prestamos/service/LoanService.java` — `LoanRepository.findById`
      Se invoca `findById` sobre `LoanRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/prestamos/service/LoanService.java` — `LoanRepository.findAll`
      Se invoca `findAll` sobre `LoanRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/prestamos/service/LoanService.java` — `LoanRepository.existsById`
      Se invoca `existsById` sobre `LoanRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/prestamos/service/LoanService.java` — `LoanRepository.deleteById`
      Se invoca `deleteById` sobre `LoanRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/banca/prestamos/service/LoanServiceTest.java` — `LoanRepository.save`
      Se invoca `save` sobre `LoanRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/banca/prestamos/service/LoanServiceTest.java` — `LoanResponseDTO.monto`
      Se invoca `monto` sobre `LoanResponseDTO`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/banca/prestamos/service/LoanServiceTest.java` — `LoanResponseDTO.plazo`
      Se invoca `plazo` sobre `LoanResponseDTO`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/banca/prestamos/service/LoanServiceTest.java` — `LoanResponseDTO.tipoInteres`
      Se invoca `tipoInteres` sobre `LoanResponseDTO`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/banca/prestamos/service/LoanServiceTest.java` — `LoanResponseDTO.solicitanteId`
      Se invoca `solicitanteId` sobre `LoanResponseDTO`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/banca/prestamos/service/LoanServiceTest.java` — `LoanResponseDTO.numeroOperacion`
      Se invoca `numeroOperacion` sobre `LoanResponseDTO`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Presentes (14)

- `pom.xml`
- `src/main/java/com/banca/prestamos/PrestamosApplication.java`
- `src/main/resources/application.yml`
- `src/main/java/com/banca/prestamos/dto/LoanRequestDTO.java`
- `src/main/java/com/banca/prestamos/dto/LoanResponseDTO.java`
- `src/main/java/com/banca/prestamos/model/Loan.java`
- `src/main/java/com/banca/prestamos/repository/LoanRepository.java`
- `src/main/java/com/banca/prestamos/controller/LoanController.java`
- `src/main/java/com/banca/prestamos/service/LoanService.java`
- `src/main/java/com/banca/prestamos/event/AuditEvent.java`
- `src/main/java/com/banca/prestamos/event/AuditEventPublisher.java`
- `src/main/java/com/banca/prestamos/config/OpenApiConfig.java`
- `src/test/java/com/banca/prestamos/controller/LoanControllerTest.java`
- `src/test/java/com/banca/prestamos/service/LoanServiceTest.java`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/main/java/com/banca/prestamos`
- `src/main/java/com/banca/prestamos/controller`
- `src/main/java/com/banca/prestamos/service`
- `src/main/java/com/banca/prestamos/repository`
- `src/main/java/com/banca/prestamos/dto`
- `src/main/java/com/banca/prestamos/model`
- `src/main/java/com/banca/prestamos/event`
- `src/main/java/com/banca/prestamos/config`
- `src/main/resources`
- `src/test/java/com/banca/prestamos`

## Verificacion

```bash
el comando de build o arranque canonico del stack elegido
```

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **capas estándar (controller-service-repository)**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Brecha que el reto ataca: Crear una API REST con Spring Boot, JPA y documentación OpenAPI

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
