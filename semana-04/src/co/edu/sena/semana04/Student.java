package co.edu.sena.semana04;

public class Student extends Person {
    private int clasesActivas;
    private boolean activo;

    public Student(String nombre, String direccion, String email, int identificacion, int edad, int clasesActivas, boolean activo) {
        super(nombre, direccion, email, identificacion, edad); // Llamada al constructor de Persona
        this.clasesActivas = clasesActivas;
        this.activo = activo;
    }

    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Clases activas: " + clasesActivas);
        System.out.println("Estado: " + (activo ? "ACTIVO" : "INACTIVO"));
    }
    @Override
    public void inscribirEnActividad(String actividad) {
        System.out.println(nombre + " ha sido inscrito en la actividad: " + actividad);
    }
}
