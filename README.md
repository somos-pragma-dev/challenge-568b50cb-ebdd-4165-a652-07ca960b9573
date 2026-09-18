# Desarrollo de API REST en dominio de banca

Una institución financiera necesita una API REST para gestionar solicitudes de préstamos. La API debe aceptar solicitudes de préstamos, validar los datos de entrada, persistir las solicitudes en una base de datos y emitir eventos de auditoría. Los préstamos tienen campos específicos: monto, plazo, tipo de interés, identificador del solicitante. La validación debe rechazar montos negativos y plazos menores a 6 meses. La persistencia debe asegurar idempotencia por número de operación. El sistema debe emitir un evento de auditoría por cada solicitud aceptada.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | creación de api rest |
| **Nivel** | junior-l1 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Aceptación de solicitudes

**Objetivo:** Implementar un endpoint que acepte solicitudes de préstamos y las valide.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Diseña un endpoint REST que reciba una solicitud de préstamo con los campos requeridos.
- Valida que el monto sea positivo y el plazo no sea menor a 6 meses.
- Devuelve un mensaje de error si la validación falla.

**Entregable:** Endpoint REST operativo que acepta y valida solicitudes de préstamos.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo estructurar la solicitud para que sea fácil de validar.
- Piensa en cómo manejar los errores de validación de forma amigable para el usuario.

</details>

### Fase 2: Persistencia de solicitudes

**Objetivo:** Persistir las solicitudes válidas en una base de datos con idempotencia.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Implementa la persistencia de las solicitudes válidas en una base de datos.
- Asegura que la persistencia sea idempotente por número de operación.
- Devuelve la misma respuesta ante reintentos con el mismo número de operación dentro de 24 horas.

**Entregable:** Sistema que persiste solicitudes válidas con idempotencia.

<details>
<summary>Pistas de conocimiento</summary>

- Piensa en cómo garantizar la idempotencia en la persistencia.
- Considera cómo manejar los reintentos dentro de la ventana de 24 horas.

</details>

### Fase 3: Emisión de eventos de auditoría

**Objetivo:** Emitir un evento de auditoría por cada solicitud aceptada.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Implementa la emisión de un evento de auditoría por cada solicitud aceptada.
- Asegúrate de que el evento contenga toda la información relevante de la solicitud.

**Entregable:** Sistema que emite eventos de auditoría por cada solicitud aceptada.

<details>
<summary>Pistas de conocimiento</summary>

- Piensa en qué información es relevante incluir en el evento de auditoría.
- Considera cómo asegurar que el evento se emita correctamente.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es una solicitud de préstamo y cuáles son sus campos?
- **paraQueSirve**: ¿Para qué sirve validar los campos de una solicitud de préstamo?
- **comoSeUsa**: ¿Cómo se usa la idempotencia en la persistencia de solicitudes?
- **erroresComunes**: ¿Cuáles son los errores comunes al implementar una API REST?
- **queDecisionesImplica**: ¿Qué decisiones implica la emisión de eventos de auditoría?

## Criterios de Evaluacion

- Implementar un endpoint REST que acepte y valide solicitudes de préstamos.
- Persistir las solicitudes válidas en una base de datos con idempotencia.
- Emitir un evento de auditoría por cada solicitud aceptada.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
el comando de build o arranque canonico del stack elegido
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
