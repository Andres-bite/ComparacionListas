import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ComparacionListas {
    public static void main(String[] args) {
        probarLista("ArrayList", new ArrayList<>());
        System.out.println("--------------------");
        probarLista("LinkedList", new LinkedList<>());
    }

    public static void probarLista(String nombre, List<String> lista) {
        lista.add("A");
        lista.add("B");
        lista.add("C");
        lista.add(0, "INICIO");
        lista.add("FINAL");

        System.out.println(nombre + ": " + lista);
        System.out.println("Elemento 2: " + lista.get(2));

        lista.remove(1);
        System.out.println("Después de eliminar: " + lista);
    }
}
