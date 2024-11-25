import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            GestorDeTareas.Tarea.mostrarMenu();
            System.out.println("Elige una opcion: ");
            opcion = GestorDeTareas.Tarea.leerEntero(scanner);

            switch (opcion) {
                case 1 -> GestorDeTareas.Tarea.agregarTarea(scanner);
                case 2 -> GestorDeTareas.Tarea.listarTareas();
                case 3 -> GestorDeTareas.Tarea.marcarTarea(scanner);
                case 4 -> GestorDeTareas.Tarea.eliminarTarea(scanner);
                case 5 -> System.out.println("¡Gracias por usar el gestor de tareas! Saliendo...");
                default -> System.out.println("Opción inválida. Inténtalo de nuevo.");
            }
        }while (opcion != 5);

        scanner.close();
    }
}