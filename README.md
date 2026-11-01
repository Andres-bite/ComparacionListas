# Comparación de Listas

Java 25. Compilar y ejecutar:

```bash
javac -d out src/*.java
java -cp out BenchmarkListas
java -cp out ColaTrabajos
```

## Tiempos de acceso por índice

|Ejecución|ArrayList|LinkedList|
|---|---:|---:|
|1|4.807 ms|3082.514 ms|
|2|0.161 ms|3100.948 ms|
|3|0.305 ms|3237.997 ms|
|Promedio|1.758 ms|3140.486 ms|

## Recorrido `for-each`

|Ejecución|ArrayList|LinkedList|
|---|---:|---:|
|1|4.609 ms|1.934 ms|
|2|1.091 ms|0.469 ms|
|3|0.949 ms|1.120 ms|
|Promedio|2.216 ms|1.174 ms|

`get(i)` favorece a `ArrayList`; `for-each` recorre ambas sin acceso repetido por posición.

## Inserciones y eliminaciones

|Operación|ArrayList|LinkedList|
|---|---:|---:|
|Insertar 50 000 al inicio|104.411 ms|3.422 ms|
|Insertar 100 000 al final|5.094 ms|2.880 ms|
|Eliminar 50 000 del inicio|79.817 ms|1.908 ms|

Hipótesis confirmada: en el inicio, `ArrayList` desplaza elementos; `LinkedList` modifica enlaces.

## Comparativa final

|Característica|ArrayList|LinkedList|
|---|---|---|
|Estructura|Arreglo dinámico|Lista doblemente enlazada|
|`get(i)` / `set(i,x)`|O(1)|O(n)|
|Agregar al final|O(1) amortizado|O(1)|
|Agregar o eliminar al inicio|O(n)|O(1)|
|Búsqueda y recorrido|O(n)|O(n)|
|`Deque`|No|Sí|
|Memoria por elemento|Menor|Mayor por enlaces|
|Uso recomendado|Acceso por índice|Extremos frecuentes|

## Respuestas

1. `List`.
2. Arreglo dinámico frente a nodos doblemente enlazados.
3. Calcula la posición directamente.
4. Debe recorrer nodos hasta la posición.
5. Desplaza los elementos a la derecha.
6. Solo actualiza enlaces y referencias.
7. Localizar una posición intermedia cuesta O(n).
8. `get(i)` fue muy lento; `for-each` fue rápido.
9. `LinkedList` ganó: 3.422 ms frente a 104.411 ms.
10. Ambas fueron rápidas; `LinkedList` midió 2.880 ms y `ArrayList` 5.094 ms.
11. No exactamente: JVM, memoria y caché afectan las constantes.
12. Referencias al nodo anterior y siguiente.
13. Permite cambiar la implementación sin cambiar la lógica cliente.
14. Expresa inserción, consulta y retiro en los extremos.
15. Lecturas por índice frecuentes y memoria moderada.
16. Operaciones frecuentes en extremos con `Deque`.

## Conclusión

Para acceso aleatorio se prefiere `ArrayList`. Para la cola de trabajos, `Deque` con `LinkedList` representa mejor las operaciones requeridas.
