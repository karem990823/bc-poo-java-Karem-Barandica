package co.edu.sena.semana04;

public class Person {
    protected String nombre;
    protected String direccion;
    protected String email;
    protected int identificacion;
    private int edad;

    // Constructor
    public Person(String nombre, String direccion, String email, int identificacion, int edad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.identificacion = identificacion;
        this.edad = edad;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    // Método para mostrar la información general
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Direccion: " + direccion);
        System.out.println("Email: " + email);
        System.out.println("Identificacion: " + identificacion);
    }
    public boolean esMayorDeEdad() {
        return edad >= 18; // Regresa true si la persona tiene 18 años o más
    }
    public void inscribirEnActividad(String actividad) {
        System.out.println(nombre + " ha sido inscrito en la actividad: " + actividad);
    }
}
