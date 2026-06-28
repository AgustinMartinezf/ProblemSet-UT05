# Problem Set UT05 — Ordenación

## Ejercicio 23 — Tabla comparativa de métodos

| Algoritmo | Estrategia | Mejor caso | Peor caso | Memoria auxiliar | Tipo de datos recomendado |
|---|---|---|---|---|---|
| **Inserción directa** | Inserción: inserta cada elemento en la parte ya ordenada | O(n) (vector ya ordenado) | O(n²) (vector ordenado al revés) | O(1) — in place | Vectores chicos o casi ordenados |
| **Shellsort** | Inserción con incrementos decrecientes (grandes saltos) | ≈ O(n log n) | O(n²) con malos incrementos; ≈ O(n^1.5) con buenos | O(1) — in place | Vectores medianos; mejora de inserción directa |
| **Burbuja** | Intercambio: compara adyacentes y los va "subiendo" | O(n) si se usa bandera (ya ordenado); O(n²) la versión básica | O(n²) | O(1) — in place | Didáctico / vectores muy chicos |
| **Selección directa** | Selección: busca el mínimo y lo coloca al frente | O(n²) | O(n²) | O(1) — in place | Cuando mover elementos es caro (hace solo O(n) intercambios) |
| **Quicksort** | Intercambio + divide y vencerás (partición por pivote) | O(n log n) | O(n²) (particiones muy desbalanceadas) | O(log n) (pila de recursión) | Vectores grandes en memoria; propósito general |
| **Heapsort** | Selección usando un árbol parcialmente ordenado (heap) | O(n log n) | O(n log n) | O(1) — in place | Vectores grandes con garantía de peor caso |
| **Cuenta por distribución** | Distribución: cuenta cuántas veces aparece cada clave | O(n + k) | O(n + k) | O(n + k) | Claves enteras en un rango chico y conocido (k = rango) |
| **Radix sort** | Distribución por dígitos (de menos a más significativo) | O(d·(n + b)) | O(d·(n + b)) | O(n + b) | Claves enteras o cadenas de largo fijo (d = dígitos, b = base) |

---

## Ejercicio 24 — Elección de algoritmo según contexto

**a) Vector pequeño de 20 elementos casi ordenado → Inserción directa.**
Con pocos datos y casi ordenados, inserción directa trabaja prácticamente en O(n):
casi no hace movimientos porque cada elemento ya está cerca de su lugar. Además es
muy simple y tiene poco overhead, así que para 20 elementos es más
rápido en la práctica que cualquier algoritmo sofisticado.

**b) Vector de 1.000.000 de elementos en memoria → Quicksort (o Heapsort).**
Para tantos datos necesitamos un método O(n log n). Quicksort es el más rápido en la
práctica y ordena in place (memoria O(log n) por la recursión). Si necesitamos
**garantizar** que nunca caiga en O(n²) —por ejemplo con datos que podrían venir mal
acomodados— conviene Heapsort, que asegura O(n log n) en el peor caso y usa O(1) de
memoria.

**c) Claves enteras entre 0 y 9 → Cuenta por distribución.**
El rango es chiquito y conocido (k = 10). Counting sort ordena en O(n + k) ≈ O(n),
mucho mejor que cualquier método por comparación O(n log n). Simplemente cuenta
cuántas veces aparece cada dígito y reconstruye el vector.

**d) Datos con muchas claves repetidas donde importa mantener el orden original →
método estable: Cuenta por distribución (o Radix).**
Acá lo clave es la **estabilidad**: que dos registros con la misma clave queden en el
mismo orden relativo que tenían. Cuenta por distribución y Radix son estables si se
implementan recorriendo desde el final. Quicksort o Heapsort no garantizan eso.

**e) Conjunto mediano donde se busca mejorar inserción directa sin usar algoritmos
complejos → Shellsort.**
Shellsort es la mejora natural de la inserción directa: con los incrementos grandes
mueve elementos lejanos de a grandes saltos, y cuando llega al incremento 1 el vector
ya está casi ordenado, por lo que la última pasada (inserción directa) es muy barata.
Es bastante más rápido que inserción directa y, aun así, sigue siendo simple de
programar.

---

## Ejercicio 25 — Pregunta integradora

**¿Por qué la ordenación es un problema fundamental en ciencias de la computación?**

La ordenación es fundamental porque ordenar los datos transforma un montón
desordenado en una estructura con la que es mucho más fácil y rápido trabajar.
Muchísimos problemas se vuelven más simples (o directamente solo se pueden resolver de
forma eficiente) si los datos están ordenados de antemano. Por eso ordenar suele ser
un **paso previo** que habilita o acelera la solución de otro problema.

Además, es un problema tan estudiado que sirve para entender conceptos centrales de la
materia: órdenes de ejecución (O(n²), O(n log n), O(n)), uso de memoria, estabilidad,
y la idea de elegir el algoritmo adecuado según el contexto. Sus límites teóricos
(O(n log n) para métodos por comparación) son un resultado clásico de la computación.

**Tres aplicaciones donde ordenar es útil antes de resolver otro problema:**

1. **Búsqueda binaria.** Si el vector está ordenado, podemos buscar un elemento en
   O(log n) en lugar de O(n) recorriéndolo entero. Sin orden, la búsqueda binaria no
   funciona.

2. **Eliminar o detectar duplicados.** Con los datos ordenados, los elementos iguales
   quedan pegados, así que detectar y quitar repetidos es un único recorrido O(n). Sin
   ordenar habría que comparar todos contra todos (O(n²)).

3. **Calcular mediana, mínimos/máximos o percentiles.** Una vez ordenado el conjunto,
   la mediana es el elemento del medio, el mínimo y el máximo están en los extremos y
   cualquier percentil es un acceso directo por índice.

