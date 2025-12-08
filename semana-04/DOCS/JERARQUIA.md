# Jerarquía de Clases - Semana 04

## Diagrama

```
                       Person
                          |
                     +----+----+
                     |         |
               |Instructor| |Student|
```

## Justificación
Esta jerarquia representa a algunas de las personas que están involucradas en el centro de Yoga.

## Atributos Heredados
- nombre (String)
- identificacion (int)
- dirección (String)
- email (String)
- edad (int)

## Métodos Sobrescritos
inscribirEnActividad(): Con este metodo se pueden inscribir tanto a instructores como a estudiantes a cualquier actividad impartida por el centro de Yoga.