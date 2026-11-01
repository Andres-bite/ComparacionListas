import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BenchmarkListas {
    private static final int TAMANO_ACCESO = 100_000;
    private static final int INSERCIONES_INICIO = 50_000;
    private static final int INSERCIONES_FINAL = 100_000;
    private static final int ELIMINACIONES = 50_000;
    private static final int REPETICIONES = 3;

    public static void main(String[] args) {
        medirAccesos();
        medirInsercionesYEliminaciones();
    }

    private static void medirAccesos() {
        System.out.println("ACCESO_POR_INDICE");
        for (int i = 1; i <= REPETICIONES; i++) {
            imprimir(i, "ArrayList", medirAccesoPorIndice(crearArrayList(TAMANO_ACCESO)));
            imprimir(i, "LinkedList", medirAccesoPorIndice(crearLinkedList(TAMANO_ACCESO)));
        }

        System.out.println("RECORRIDO_FOR_EACH");
        for (int i = 1; i <= REPETICIONES; i++) {
            imprimir(i, "ArrayList", medirRecorrido(crearArrayList(TAMANO_ACCESO)));
            imprimir(i, "LinkedList", medirRecorrido(crearLinkedList(TAMANO_ACCESO)));
        }
    }

    private static void medirInsercionesYEliminaciones() {
        System.out.println("INSERCION_AL_INICIO");
        imprimir(1, "ArrayList", medirInsercionInicio(new ArrayList<>()));
        imprimir(1, "LinkedList", medirInsercionInicio(new LinkedList<>()));

        System.out.println("INSERCION_AL_FINAL");
        imprimir(1, "ArrayList", medirInsercionFinal(new ArrayList<>()));
        imprimir(1, "LinkedList", medirInsercionFinal(new LinkedList<>()));

        System.out.println("ELIMINACION_AL_INICIO");
        imprimir(1, "ArrayList", medirEliminacionInicio(crearArrayList(ELIMINACIONES)));
        imprimir(1, "LinkedList", medirEliminacionInicio(crearLinkedList(ELIMINACIONES)));
    }

    private static List<Integer> crearArrayList(int tamano) {
        List<Integer> lista = new ArrayList<>(tamano);
        llenar(lista, tamano);
        return lista;
    }

    private static List<Integer> crearLinkedList(int tamano) {
        List<Integer> lista = new LinkedList<>();
        llenar(lista, tamano);
        return lista;
    }

    private static void llenar(List<Integer> lista, int tamano) {
        for (int i = 0; i < tamano; i++) {
            lista.add(i);
        }
    }

    private static double medirAccesoPorIndice(List<Integer> lista) {
        long inicio = System.nanoTime();
        long suma = 0;
        for (int i = 0; i < lista.size(); i++) {
            suma += lista.get(i);
        }
        long fin = System.nanoTime();
        validarSuma(suma);
        return (fin - inicio) / 1_000_000.0;
    }

    private static double medirRecorrido(List<Integer> lista) {
        long inicio = System.nanoTime();
        long suma = 0;
        for (Integer valor : lista) {
            suma += valor;
        }
        long fin = System.nanoTime();
        validarSuma(suma);
        return (fin - inicio) / 1_000_000.0;
    }

    private static double medirInsercionInicio(List<Integer> lista) {
        long inicio = System.nanoTime();
        for (int i = 0; i < INSERCIONES_INICIO; i++) {
            lista.add(0, i);
        }
        long fin = System.nanoTime();
        return (fin - inicio) / 1_000_000.0;
    }

    private static double medirInsercionFinal(List<Integer> lista) {
        long inicio = System.nanoTime();
        for (int i = 0; i < INSERCIONES_FINAL; i++) {
            lista.add(i);
        }
        long fin = System.nanoTime();
        return (fin - inicio) / 1_000_000.0;
    }

    private static double medirEliminacionInicio(List<Integer> lista) {
        long inicio = System.nanoTime();
        while (!lista.isEmpty()) {
            lista.remove(0);
        }
        long fin = System.nanoTime();
        return (fin - inicio) / 1_000_000.0;
    }

    private static void validarSuma(long suma) {
        long esperada = (long) TAMANO_ACCESO * (TAMANO_ACCESO - 1) / 2;
        if (suma != esperada) {
            throw new IllegalStateException("Suma incorrecta: " + suma);
        }
    }

    private static void imprimir(int ejecucion, String tipo, double milisegundos) {
        System.out.printf("%d,%s,%.3f ms%n", ejecucion, tipo, milisegundos);
    }
}
