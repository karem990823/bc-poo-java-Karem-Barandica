# Análisis de Diseño - Semana 06: Centro de Yoga "Bienestar y Equilibrio"

## 1. Identificación de Abstracciones

### Clase(s) Abstracta(s)
**Nombre:** `WellnessClass`

**¿Por qué es abstracta?**
- Elegí hacer `WellnessClass` abstracta porque representa un concepto general de “clase de bienestar”, pero no existe de forma concreta en la realidad. Solo tiene sentido instanciar tipos específicos como `YogaClass` o `MeditationClass`.
- **Comportamiento común:**
  - Atributos compartidos: nombre, duración, instructor, nivel, capacidad.
  - Métodos comunes: `mostrarInformacio()`.
  - Lógica base para todas las clases de bienestar.
- **Comportamiento que varía en las subclases:**
  - El tipo de actividad (yoga, meditación, etc.).
  - Reglas o dinámicas específicas de cada clase.
  - Diferentes implementaciones de precio o interacción.   

**Jerarquía:**

```

WellnessClass.java
├── YogaClass.java
└── MeditationClass.java

```

---

**Nombre:** `WellnessServices`

**¿Por qué es abstracta?**
- Elegí `WellnessService` como abstracta porque representa servicios de bienestar que no pueden instanciarse por sí mismos, como terapias o planes, pero comparten atributos comunes.
- **Comportamiento común:**
    - Atributos generales: nombre del servicio, duración, especialista, precio base.
    - Métodos comunes para describir el servicio o asignarlo.
- **Comportamiento que varía en subclases:**
    - El tipo de servicio (Holistic Therapy vs Nutritional Plan).
    - Forma en que se calcula el precio o se ofrece el servicio.

**Jerarquía:**

```

WellnessService.java
├── HolisticTherapy.java
└── NutritionalPlan.java

```

---

## 2. Interfaces Implementadas

### Interface 1: `Reservable`
**Capacidad que define:** Permite que el objeto pueda ser **reservado**, incluyendo métodos como reservar, cancelar y verificar disponibilidad.

**Clases que la implementan:**
- `YogaClass`: porque los alumnos reservan clases grupales en horarios específicos.
- `HolisticTherapy`: porque las terapias requieren una reserva individual.

### Interface 2: `Calificable`
**Capacidad que define:** Permite que el objeto sea **calificado** por el usuario, asignando notas o evaluaciones.

**Clases que la implementan:**
- `YogaClass`: los estudiantes evalúan la experiencia o al instructor.
- `HolisticTherapy`: los clientes califican la sesión recibida.

### Interface 3: `Pagable`
**Capacidad que define:** Define la capacidad de **procesar pagos**, calcular tarifas o generar cargos.

**Clases que la implementan:**
- `YogaClass`: se paga por clase o membresía.
- `HolisticTherapy`: se cobra como servicio especializado.

---

## 3. Decisiones de Diseño

### ¿Por qué Clase Abstracta vs Interface?

**Elegí clases abstractas para `WellnessClass` y `WellnessService` porque:**

- Existe una relación “es-un” clara con sus subclases.
- Necesitan compartir atributos y parte de la implementación.
- Permiten crear plantillas base que las subclases pueden extender.

**Elegí interfaces para `Pagable`, `Reservable` y `Calificable` porque:**

- Son capacidades independientes de la jerarquía.
- Deben poder implementarse en distintas clases sin relación.
- No necesitan atributos, solo métodos (contratos).
- Permiten múltiples implementaciones simultáneas.
  
---

## 4. Principios SOLID Aplicados

### Single Responsibility Principle (SRP)

Cada clase cumple una única responsabilidad:
- `YogaClass`: gestionar clases de yoga.
- `HolisticTherapy`: gestionar terapias.
- Interfaces separan pago, reserva y calificación.

### Open/Closed Principle (OCP)

El sistema permite añadir nuevas clases (ej. `AromatherapyClass`) sin modificar código existente, gracias a la abstracción en clases base e interfaces.

### Liskov Substitution Principle (LSP)

Cualquier subclase puede sustituir a la clase abstracta sin romper nada:
- `YogaClass` funciona donde se espera un `WellnessClass`.
- `HolisticTherapy` funciona como `WellnessService`.

### Interface Segregation Principle (ISP)

Las interfaces son pequeñas y específicas:
- Ninguna clase tiene métodos que no necesita.
- Se pueden combinar libremente según la capacidad.

### Dependency Inversion Principle (DIP)
El sistema depende de interfaces (`Pagable`, `Reservable`, `Calificable`) en lugar de implementaciones concretas.

Esto permite cambiar clases concretas sin alterar el código cliente.

---

## 5. Mejoras Logradas

**Antes (Semana 05):**
- Las clases tenían múltiples responsabilidades juntas.
- No había interfaces claras.
- Las clases dependían entre sí directamente.
- No existía una jerarquía lógica entre servicios y actividades.

**Después (Semana 06):**
- Separación clara en clases abstractas e interfaces.
- Mejor cohesión y bajo acoplamiento.
- Polimorfismo real aplicado en actividades y servicios.
- Flexibilidad para agregar nuevos servicios y clases.
- Código más limpio, mantenible y escalable.

---

## 6. Diagrama de Clases


```
                     <<abstract>>
                     WellnessClass
                          |
                +---------+---------+
                |                   |
           YogaClass        MeditationClass


                     <<abstract>>
                    WellnessService
                          |
                +---------+---------+
                |                   |
         HolisticTherapy     NutritionalPlan


Interfaces:
+----------------+     +----------------+     +----------------+
|   Reservable   |     |   Calificable  |     |    Pagable     |
+----------------+     +----------------+     +----------------+

Implementaciones:
YogaClass -------- implements -------- Reservable, Calificable, Pagable
HolisticTherapy -- implements -------- Reservable, Calificable, Pagable

```

