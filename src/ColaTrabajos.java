import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class ColaTrabajos {
    public static void main(String[] args) {
        Deque<String> trabajos = new LinkedList<>();
        Scanner entrada = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = leerOpcion(entrada);
            ejecutar(opcion, trabajos, entrada);
        } while (opcion != 7);
    }

    private static void mostrarMenu() {
        System.out.println("\n1. Agregar trabajo normal");
        System.out.println("2. Agregar trabajo urgente");
        System.out.println("3. Procesar siguiente trabajo");
        System.out.println("4. Consultar siguiente trabajo");
        System.out.println("5. Mostrar trabajos pendientes");
        System.out.println("6. Mostrar número de trabajos");
        System.out.println("7. Salir");
        System.out.print("Opción: ");
    }

    private static int leerOpcion(Scanner entrada) {
        if (!entrada.hasNextLine()) {
            return 7;
        }
        try {
            return Integer.parseInt(entrada.nextLine().trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static void ejecutar(int opcion, Deque<String> trabajos, Scanner entrada) {
        switch (opcion) {
            case 1 -> agregarNormal(trabajos, entrada);
            case 2 -> agregarUrgente(trabajos, entrada);
            case 3 -> procesar(trabajos);
            case 4 -> consultar(trabajos);
            case 5 -> System.out.println("Pendientes: " + trabajos);
            case 6 -> System.out.println("Número de trabajos: " + trabajos.size());
            case 7 -> System.out.println("Sistema finalizado.");
            default -> System.out.println("Opción no válida.");
        }
    }

    private static void agregarNormal(Deque<String> trabajos, Scanner entrada) {
        System.out.print("Trabajo: ");
        if (entrada.hasNextLine()) {
            String trabajo = entrada.nextLine().trim();
            if (!trabajo.isEmpty()) {
                trabajos.addLast(trabajo);
                System.out.println("Trabajo normal agregado.");
            }
        }
    }

    private static void agregarUrgente(Deque<String> trabajos, Scanner entrada) {
        System.out.print("Trabajo urgente: ");
        if (entrada.hasNextLine()) {
            String trabajo = entrada.nextLine().trim();
            if (!trabajo.isEmpty()) {
                trabajos.addFirst(trabajo);
                System.out.println("Trabajo urgente agregado.");
            }
        }
    }

    private static void procesar(Deque<String> trabajos) {
        String procesado = trabajos.pollFirst();
        System.out.println(procesado == null ? "No hay trabajos pendientes." : "Procesando: " + procesado);
    }

    private static void consultar(Deque<String> trabajos) {
        String siguiente = trabajos.peekFirst();
        System.out.println(siguiente == null ? "No hay trabajos pendientes." : "Siguiente: " + siguiente);
    }
}
