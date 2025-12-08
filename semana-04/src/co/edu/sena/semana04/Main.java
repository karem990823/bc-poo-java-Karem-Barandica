package co.edu.sena.semana04;

public class Main {
    public static void main(String[] args) {
        // Array polimórfico
        Person[] people = new Person[3];

        people[0] = new Student("Ana Mejia", "cl 70 3 25","amejia@hotmail.com", 1015243012, 33,3,true);
        people[1] = new Instructor("Luis torres","cr 24 36 20","ltorres@email.com", 79450123,23, "Meditacióm","09:00AM-13:30PM");
        people[2] = new Instructor("María Aldana","cl 70b 60 33", "maldana@gmail.com", 37451260, 45,"Pilates", "8:30AM-14:30PM");

        // Polimorfismo en acción
        for (Person per : people) {
            per.mostrarInformacion();
            System.out.println("edad:" + per.esMayorDeEdad());
            System.out.println("\n--- Inscripción  ---");
            per.inscribirEnActividad("Pilates");
            System.out.println("---");
}
}
}