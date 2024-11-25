import java.util.ArrayList;
import java.util.Scanner;


public class GestorDeTareas {
    public static class Tarea {

        public static int id;
        public String descripcion;
        public boolean completada;


        public Tarea() {

        }

        public Tarea(int id, String descripcion) {
            this.id = id;
            this.descripcion = descripcion;
            this.completada = false;
        }

        public static int getId() {
            return id;
        }

        public static void setId(int id) {
            Tarea.id = id;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public boolean isCompletada() {
            return completada;
        }

        public void setCompletada(boolean completada) {
            this.completada = completada;
        }

        public static void marcarCompletada(boolean completada) {
            completada = true;
        }


        @Override
        public String toString() {
            return STR."ID: \{id}, descripcion: \{descripcion}, completada: \{completada}";
        }

        // Lista para almacenar las tareas
        private static ArrayList<Tarea> listaDeTareas = new ArrayList<>();
        private static int contadorDeTareas = 1; // Para asignar IDs únicos a las tareas

        //metodos
        public static void mostrarMenu() {
            System.out.println("\n--- Gestor de Tareas ---");
            System.out.println("1. Agregar Tarea");
            System.out.println("2: Listar Tareas");
            System.out.println("3: Marcar Tarea como Completada");
            System.out.println("4: Eliminar Tarea");
            System.out.println("5: Salir");
        }

        public static void agregarTarea(Scanner scanner) {
            System.out.println("Agrega una descripcion para la tarea");
            String descripcion = scanner.nextLine();
            Tarea nuevaTarea = new Tarea(contadorDeTareas++, descripcion);
            listaDeTareas.add(nuevaTarea);
            System.out.println("Tarea agregada con exito");
        }

        public static void listarTareas() {
            if (listaDeTareas.isEmpty()) {
                System.out.println("No hay tareas");
            } else {
                System.out.println("\n--- Lista de Tareas ---");
                for (Tarea tarea : listaDeTareas) {
                    System.out.println(tarea);
                }
            }
        }

        public static Tarea buscarTareaPorId(int id) {
            for (Tarea tarea : listaDeTareas) {
                if (Tarea.getId() == id) {
                    return tarea;
                }
            }
            return null;
        }

        public static int leerEntero(Scanner scanner) {
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada invalida. Ingresar un numero: ");
                scanner.next();
            }
            return scanner.nextInt();
        }

        public static void marcarTarea(Scanner scanner) {
            System.out.println("Selecciona el ID de la tarea a completar");
            int id = leerEntero(scanner);
            Tarea tarea = buscarTareaPorId(id);
            if (tarea != null) {
                Tarea.marcarCompletada(true);
                System.out.println("La tarea ha sido marcada como completada");
            } else {
                System.out.println("Tarea no encontrada");
            }
        }

        public static void eliminarTarea(Scanner scanner) {
            System.out.println("Seleccionar el Id de la tarea a eliminar");
            int id = leerEntero(scanner);
            Tarea tarea = buscarTareaPorId(id);
            if (tarea != null) {
                listaDeTareas.remove(tarea);
                System.out.println("Tarea eliminada con exito");
            } else {
                System.out.println("Tarea no encontrada");
            }
        }

    }
}
