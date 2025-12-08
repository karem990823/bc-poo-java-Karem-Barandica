package co.edu.sena.semana04;

public class Instructor extends Person {
    private String especialidad;
    private String horario;

    public Instructor(String nombre, String direccion, String email, int identificacion, int edad, String especialidad, String horario) {
        super(nombre, direccion, email, identificacion, edad); // Llamada al constructor de Persona
        this.especialidad = especialidad;
        this.horario = horario;
    }

    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Horario: " + horario);
    }
    @Override
    public void inscribirEnActividad(String actividad) {
        System.out.println(nombre + " ha sido inscrito en la actividad: " + actividad);
    }
}


