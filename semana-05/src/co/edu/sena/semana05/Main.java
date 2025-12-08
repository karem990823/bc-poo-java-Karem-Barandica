package co.edu.sena.semana05;

public class Main {
    public static void main(String[] args) {
        PersonManager manager = new PersonManager();

        // Crear personas (Instructor y Student)
        Instructor instructor1 = new Instructor("Juan Pérez", "Calle 123", "juan@ejemplo.com", 12345, 40, "Pilates", "Lunes a Viernes, 9am - 6pm");
        Student student1 = new Student("Ana Gómez", "Calle 456", "ana@ejemplo.com", 54321, 22, 5, true);
        Student student2 = new Student("Luis Sánchez", "Calle 789", "luis@ejemplo.com", 67890, 18, 3, false);

        // Agregar personas al manager
        manager.addPerson(instructor1);
        manager.addPerson(student1);
        manager.addPerson(student2);

        // Listar todas las personas
        System.out.println("Listado de todas las personas:");
        manager.listPeople();
        System.out.println();

        // Listar solo instructores
        System.out.println("Listado de instructores:");
        manager.listInstructors();
        System.out.println();

        // Listar solo estudiantes
        System.out.println("Listado de estudiantes:");
        manager.listStudents();
        System.out.println();

        // Buscar por nombre
        System.out.println("Buscar persona por nombre (Ana Gómez):");
        Person foundPerson = manager.findByName("Ana Gómez");
        if (foundPerson != null) {
            foundPerson.mostrarInformacion();
        } else {
            System.out.println("Persona no encontrada.");
        }
        System.out.println();

        // Inscribir persona en actividad
        System.out.println("Inscribir persona en actividad:");
        manager.inscribirPersonaEnActividad("Ana Gómez", "Pilates");
        manager.inscribirPersonaEnActividad("Luis Sánchez", "Yoga");

        // Crear algunos instructores


        // Crear algunas salas de yoga
        YogaRoom yogaRoom1 = new YogaRoom("Sala 1", 101, instructor1, 20, true, "Colchonetas", 30);
        YogaRoom yogaRoom2 = new YogaRoom("Sala 2", 102, instructor1, 15, false, "Colchonetas", 20);
        YogaRoom yogaRoom3 = new YogaRoom("Sala 3", 103, instructor1, 25, true, "Pesas", 10);
        YogaRoom yogaRoom4 = new YogaRoom("Sala 4", 104, instructor1, 30, true, "Colchonetas", 25);

        // Crear un centro de yoga
        YogaCenter yogaCenter = new YogaCenter("Equilibrio y Bienestar");

        // Agregar salas al centro de yoga
        yogaCenter.agregarYogaRoom(yogaRoom1);
        yogaCenter.agregarYogaRoom(yogaRoom2);
        yogaCenter.agregarYogaRoom(yogaRoom3);
        yogaCenter.agregarYogaRoom(yogaRoom4);

        System.out.println("\n---- Mostrar todas las salas registradas ----");
        yogaCenter.mostrarYogaRooms();

        // Buscar una sala por ID
        System.out.println("\n---- Buscar sala por ID 102 ----");
        YogaRoom roomById = yogaCenter.buscarYogaRoom(102);
        if (roomById != null) {
            roomById.showInfo();
        }

        // Buscar una sala por nombre
        System.out.println("\n---- Buscar sala por nombre 'Sala 3' ----");
        YogaRoom roomByName = yogaCenter.buscarYogaRoom("Sala 3");
        if (roomByName != null) {
            roomByName.showInfo();
        }

        // Buscar salas por capacidad mínima
        System.out.println("\n---- Buscar salas con capacidad mínima de 20 ----");
        yogaCenter.buscarYogaRoom(20, true);

        // Buscar salas con capacidad máxima
        System.out.println("\n---- Buscar salas con capacidad máxima de 20 ----");
        yogaCenter.buscarYogaRoom(20, false);

        // Buscar por capacidad exacta
        System.out.println("\n---- Buscar salas con capacidad exacta de 25 ----");
        yogaCenter.buscarYogaRoomExacta(25);
    }
}



