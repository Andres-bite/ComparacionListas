import java.util.LinkedList;
import java.util.List;

public class EjemploLinkedList {
    public static void main(String[] args) {
        List<String> tareas = new LinkedList<>();

        tareas.add("Preparar presentación");
        tareas.add("Revisar código");
        tareas.add("Actualizar documentación");
        tareas.add("Ejecutar pruebas");
        tareas.add("Publicar versión");

        tareas.add(0, "Revisar correo");
        tareas.set(2, "Revisar código Java");

        System.out.println(tareas);
        System.out.println("Primera: " + tareas.get(0));
        System.out.println("Tercera: " + tareas.get(2));
    }
}
