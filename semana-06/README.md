# Semana 06: Abstracción e Interfaces

## Dominio
Nombre de tu dominio: Centro de Yoga "Equilibrio y Bienestar"

## Descripción
El sistema debe ser capaz de procesar la inscripción de nuevos estudiantes (aproximadamente 100 estudiantes activos), programar clases y terapias, asignar responsabilidades de los 8 instructores certificados y realizar procesos de facturación o gestión de horarios, permitiendo una comunicación clara entre analistas, directivos y el personal operativo.

## Clases Abstractas Implementadas

### WellnessClass.java
- **Propósito:** Con esta clase, se gestionan los diferentes cursos impartidos por el centro de yoga.
- **Métodos abstractos:**
    - `realizarClase()`: Permite iniciar las clases a las que el estudiante este inscrito.
- **Métodos concretos:**
    - `mostrarInformacion()`: Muestra toda la informacion recolectada sobre las clases.
- **Subclases:**
    - `YogaClass.java`
    - `MeditationClass.java`

### WellnessService.java
- **Propósito:** Con esta clase, se gestionan los diferentes servicios que ofrece el centro de yoga.
- **Métodos abstractos:**
    - `brindarServicio()`: Permite iniciar las clases a las que el estudiante este inscrito.
- **Métodos concretos:**
    - `mostrarInformacion()`: Muestra toda la informacion recolectada sobre las clases.
- **Subclases:**
    - `HolisticTherapy.java`
    - `nutritionalplan.java`


## Interfaces Implementadas

### Reservable.java
- **Capacidad:** Permitir que un objeto pueda ser reservado
- **Métodos:**
    - `realizarReserva()`: Permite realizar la reserva de una clase o servicio
    - `cancelarReserva()`: Permite cancelar una clase o servicio
- **Implementada por:**
    - `YogaClass.java`
    - `HolisticTherapy.java`

### Calificable.java
- **Capacidad:** Permitir que un objeto pueda ser calificado
- **Métodos:**
    - `calificar()`: Permite dar una calificacion a una clase o servicio
    - `obtenerCalificacionPromedio()`: Permite obtener un promedio de todas las calificaciones obtenidas.
- **Implementada por:**
    - `YogaClass.java`
    - `HolisticTherapy.java`

### Pagable.java
- **Capacidad:** Permitir que un objeto pueda ser pagado
- **Métodos:**
    - `procesarPago()`: Permite procesar un pago realizado por una clase o servicio
    - `verificarPago()`: Permite realizar la debida verificacion de un pago por una clase o servicio
- **Implementada por:**
    - `YogaClass.java`
    - `HolisticTherapy.java`
      
## Jerarquía de Clases

```
                                              <<abstract>>
                                             WellnessClass
                                                   |
                                            +------+------+
                                            |             |
                                      YogaClass         MeditationClass
                                                   |
               +-- implements Reservable +-- implements Calificable +-- implements Pagable




                                              <<abstract>>
                                            WellnessService
                                                   |
                                            +------+------+
                                            |             |
                                    HolisticTherapy    NutritionalPlan
                                                   |
               +-- implements Reservable +-- implements Calificable +-- implements Pagable


```

## Principios SOLID Aplicados

**1. SRP:**
Cada clase tiene una única razón de cambio:

- `WellnessClass` define solo el comportamiento común de cualquier clase de bienestar.
- `YogaClass `se enfoca exclusivamente en las características específicas del yoga.
- `MeditationClass`, `HolisticTherapy`, `NutritionalPlan` se ocupan únicamente de la lógica propia de su tipo de actividad.
- Las interfaces (`Pagable`, `Calificable`, `Reservable`) definen capacidades separadas en lugar de mezclarlas.

Esto evita que una clase mezcle responsabilidades como pagos, reservas, calificaciones y lógica de negocio.

**2. OCP:**
El sistema permite agregar nuevas actividades sin modificar código existente:

- `WellnessClass` está diseñada para que sus subclases extiendan el comportamiento sin tener que modificarla.
- Puedes agregar nuevos tipos de actividades wellness (por ejemplo *AromatherapyClass*) sin tocar `YogaClass`, `MeditationClass`, etc.
- Las interfaces (`Pagable`, `Calificable`, `Reservable`) permiten añadir capacidades adicionales a nuevas clases sin cambiar clases ya creadas.

Las clases están cerradas a modificación pero abiertas a extensión.

**3. LSP:** 
Cualquier subclase puede reemplazar a su superclase sin alterar el funcionamiento:

- Un objeto `YogaClass` puede ser usado donde se espera un `WellnessClass`, sin romper el flujo.

- `HolisticTherapy` y `NutritionalPlan` pueden usarse donde se espere un `WellnessService (su padre).

No se rompen contratos ni anula métodos de forma incompatible, por lo que el sistema puede tratar todas las wellness classes de forma polimórfica.

**4. ISP:**
Se dividen las capacidades en interfaces pequeñas y específicas:

- `Pagable` solo tiene métodos de pago.
- `Calificable` solo define métodos relacionados con calificaciones.
- `Reservable` solo define la capacidad de realizar reservas.

De esta forma:

- `YogaClass` implementa solo lo que necesita: por ejemplo `Pagable`, `Calificable` y `Reservable`.
- `HolisticTherapy` implementa únicamente `Pagable` y `Calificable `si corresponde, sin tener que implementar métodos que no usa.

**5. DIP:** 
Las clases dependen de abstracciones.

Por ejemplo:

- Un módulo de facturación puede trabajar con cualquier objeto que implemente `Pagable` sin saber si es un `YogaClass` o un `HolisticTherapy`.
- El módulo de reservas opera sobre `Reservable`, no sobre clases concretas.
- Un sistema de feedback trabaja con objetos `Calificable`.

Esto desacopla el código, permite sustituir clases concretas fácilmente y facilita la escalabilidad del sistema.

