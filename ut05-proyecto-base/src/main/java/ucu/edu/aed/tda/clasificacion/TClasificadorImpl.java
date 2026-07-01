package ucu.edu.aed.tda.clasificacion;

import java.util.Arrays;

public class TClasificadorImpl extends TClasificador{

    @Override
    void insercionDirecta(int[] datos) {
        //empieza en 1 pq el primer elemento 
        //lo consideramos como ordenado
        for (int i = 1; i < datos.length; i++) {
            int clave = datos[i]; // elemento a insertar
            int j = i - 1;        // último elemento ordenado
            //controlamos que el anterior esté dentro del arreglo
            while (j >= 0 && datos[j] > clave) {
                //si el actual es menor al anterior
                //muevo el anterior a la derecha
                //para dejarle lugar al actual
                datos[j + 1] = datos[j];
                //ahora me fijo en el siguiente a la izquierda
                //hasta ver dónde lo tengo que poner
                j--;
            }
            //si el dato no es menor al anterior
            //lo pongo después del anterior

            //si el dato estaba bien dónde estaba
            //basicamente lo vuelve a reinsertar pero 
            //no cambia nada
            datos[j + 1] = clave;
        }
    }

    public void insercionDirectaPasos(int[] datos) {
        int comparacionesTotales = 0;
        int movimientosTotales = 0;
        System.out.println("Inicial: " + Arrays.toString(datos));
        for (int i = 1; i < datos.length; i++) {
            //por cada pasada acumulo las comparaciones y cambios
            int comparacionesPasada = 0;
            int movimientosPasada = 0;
            int clave = datos[i];
            int j = i - 1;
            //revisa que no haya llegado al final del arreglo
            while (j >= 0) {
                comparacionesPasada++;
                comparacionesTotales++;
                //checkea si tiene que hacer comparación o no
                if (datos[j] > clave) {
                    datos[j + 1] = datos[j];
                    movimientosPasada++;
                    movimientosTotales++;
                    j--;
                } else {
                    break;
                }
            }
            //este if es para evitar contar movimientos cuando
            //la clave no se movió de lugar

            //no contamos el reinsertar de la clave cuando no se movió
            if (j + 1 != i) {
                datos[j + 1] = clave;
                movimientosPasada++;
                movimientosTotales++;
            }
            System.out.println("Pasada " + i + ": "+ Arrays.toString(datos));
            System.out.println("Comparaciones: "+ comparacionesPasada);
            System.out.println("Movimientos: "+ movimientosPasada);
            System.out.println();
        }
        System.out.println("RESULTADO FINAL");
        System.out.println("Arreglo: " + Arrays.toString(datos));
        System.out.println("Comparaciones totales: "+ comparacionesTotales);
        System.out.println("Movimientos totales: "+ movimientosTotales);
    }

    @Override
    void shell(int[] datos, Integer[] incrementos) {
        //hace insertion sort con todos
        //los incrementos de la lista dada
        //(es como si cada vez tuviese un "nuevo arreglo")
        for (int gap : incrementos) {
            //insertion sort normal
            for (int i = gap; i < datos.length; i++) {
                int clave = datos[i]; //elemento a insertar
                int j = i; //posición actual de la clave
                while (j >= gap && datos[j - gap] > clave) {
                    //si el anterior es mayor
                    //entonces lo mueve hacia la derecha
                    datos[j] = datos[j - gap];
                    //comparamos con el siguiente de la izquierda
                    j -= gap;
                }
                //si encontró su posición o ya estaba
                //en su posición lo reinserta
                datos[j] = clave;
            }
        }
    }

    public void shellConPasos(int[] datos, Integer[] incrementos) {
        int compTotal = 0;
        int movTotal = 0;
        System.out.println("Inicial: "+ Arrays.toString(datos));
        for (int gap : incrementos) {
            //se hace el insertion sort para cada gap
            System.out.println("\n===== GAP = "+ gap + " =====");
            for (int i = gap; i < datos.length; i++) {
                int compPasada = 0;
                int movPasada = 0;
                int clave = datos[i];
                int j = i;
                //mientras siga en el arreglo
                while (j >= gap) {
                    compPasada++;
                    compTotal++;
                    //veo si tengo que intercambiar
                    if (datos[j - gap] > clave) {
                        datos[j] = datos[j - gap];
                        movPasada++;
                        movTotal++;
                        j -= gap;
                    } else {
                        break;
                    }
                }
                //este if es para evitar contar movimientos cuando
                //la clave no se movió de lugar

                //no contamos el reinsertar de la clave cuando no se movió
                if (j != i) {
                    datos[j] = clave;
                    movPasada++;
                    movTotal++;
                }
                System.out.println("i = " + i + " -> "+ Arrays.toString(datos));
                System.out.println("Comparaciones: "+ compPasada);
                System.out.println("Movimientos: "+ movPasada);
            }
        }
        System.out.println("\nRESULTADO FINAL");
        System.out.println(Arrays.toString(datos));
        System.out.println("Comparaciones totales: "+ compTotal);
        System.out.println("Movimientos totales: "+ movTotal);
    }

    @Override
    void burbuja(int[] datos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'burbuja'");
    }

    @Override
    protected int obtenerPivote(int[] datos, int i, int j) {
        //busco los dos primeros elementos DIFERENTES del rango [i, j]
        //el primero siempre es datos[i]
        int k = i + 1;
        while (k <= j && datos[k] == datos[i]) {
            //salteo los que son iguales al primero
            k++;
        }
        //si son todos iguales no hay pivote válido
        if (k > j) {
            return -1;
        }
        //devuelvo el índice del MAYOR de esos dos elementos diferentes
        return datos[i] > datos[k] ? i : k;
    }

    @Override
    protected int particion(int[] datos, int i, int j, int pivote) {
        //dejo a la izquierda los menores al pivote
        //y a la derecha los mayores o iguales
        while (i <= j) {
            //avanzo desde la izquierda mientras sean menores
            while (datos[i] < pivote) {
                i++;
            }
            //retrocedo desde la derecha mientras sean mayores
            while (datos[j] > pivote) {
                j--;
            }
            if (i <= j) {
                intercambiar(datos, i, j);
                i++;
                j--;
            }
        }
        //i queda como el punto de corte entre las dos particiones
        return i;
    }

    public void quicksortConPasos(int[] datos) {
        System.out.println("Inicial: " + Arrays.toString(datos));
        quicksortConPasos(datos, 0, datos.length - 1);
        System.out.println("\nRESULTADO FINAL");
        System.out.println("Arreglo: " + Arrays.toString(datos));
    }

    private void quicksortConPasos(int[] datos, int i, int j) {
        if (i < j) {
            int indicePivote = obtenerPivote(datos, i, j);
            //debe ser un rango válido
            if (indicePivote >= i && indicePivote < j) {
                int pivote = datos[indicePivote];
                int k = particion(datos, i, j, pivote);
                System.out.println("Partición en [" + i + ", " + j + "] con pivote "
                        + pivote + ": " + Arrays.toString(datos) + "  (corte en " + k + ")");
                quicksortConPasos(datos, i, k - 1);
                quicksortConPasos(datos, k, j);
            }
        }
    }

    @Override
    public void clasificacionDirecta(int[] datos) {
        int n = datos.length;
        //hacemos n-1 pasadas
        for (int i = 0; i < n - 1; i++) {
            //recorremos todo el arreglo
            int posMin = i;
            for (int j = i + 1; j < n; j++) {
                //agarramos el más chico
                if (datos[j] < datos[posMin]) {
                    posMin = j;
                }
            }
            //cambiamos el mínimo por el primero de esa pasada
            intercambiar(datos, i, posMin);
        }
    }
    
    public void clasificacionDirectaConPasos(int[] datos) {
        int comparacionesTotales = 0;
        int movimientosTotales = 0;
        System.out.println("Inicial: "+ Arrays.toString(datos));
        int n = datos.length;
        for (int i = 0; i < n - 1; i++) {
            int comparacionesPasada = 0;
            int movimientosPasada = 0;
            int posMin = i;
            //busacmos el mínimo
            for (int j = i + 1; j < n; j++) {
                comparacionesPasada++;
                comparacionesTotales++;
                if (datos[j] < datos[posMin]) {
                    posMin = j;
                }
            }
            //hacemos el intercambio
            if (posMin != i) {
                intercambiar(datos, i, posMin);
                //el swap lo contamos como 2 movimientos
                //porque dos elementos cambiaron de posición
                movimientosPasada += 2;
                movimientosTotales += 2;
            }
            System.out.println("Pasada " + (i + 1) + ": "+ Arrays.toString(datos));
            System.out.println("Comparaciones: "+ comparacionesPasada);
            System.out.println("Movimientos: "+ movimientosPasada);
            System.out.println();
        }

        System.out.println("RESULTADO FINAL");
        System.out.println("Arreglo: "+ Arrays.toString(datos));
        System.out.println("Comparaciones totales: "+ comparacionesTotales);
        System.out.println("Movimientos totales: "+ movimientosTotales);
    }

    @Override
    public void heapsort(int[] datos) {
        int n = datos.length;
        //1) construyo el heap máximo de abajo hacia arriba
        //empiezo en el último nodo que tiene hijos
        for (int i = n / 2 - 1; i >= 0; i--) {
            desplazaElemento(datos, i, n - 1);
        }
        //2) extraigo la raíz (el máximo) una y otra vez
        for (int ultimo = n - 1; ultimo > 0; ultimo--) {
            //la raíz es el mayor, la mando al final
            intercambiar(datos, 0, ultimo);
            //reacomodo el heap sin contar la parte ya ordenada
            desplazaElemento(datos, 0, ultimo - 1);
        }
    }

    @Override
    protected void desplazaElemento(int[] datos, int primero, int ultimo) {
        int padre = primero;
        int hijo = 2 * padre + 1; //hijo izquierdo (vector base 0)
        //mientras el padre tenga al menos un hijo dentro del heap
        while (hijo <= ultimo) {
            //si existe el hijo derecho y es mayor, me quedo con ese
            if (hijo < ultimo && datos[hijo] < datos[hijo + 1]) {
                hijo++;
            }
            //si el padre ya es mayor o igual que el hijo mayor, terminé
            if (datos[padre] >= datos[hijo]) {
                break;
            }
            //si no, bajo el padre e sigo desplazando hacia abajo
            intercambiar(datos, padre, hijo);
            padre = hijo;
            hijo = 2 * padre + 1;
        }
    }

    public void heapsortConPasos(int[] datos) {
        int n = datos.length;
        System.out.println("Inicial: " + Arrays.toString(datos));
        //construcción del heap máximo
        for (int i = n / 2 - 1; i >= 0; i--) {
            desplazaElemento(datos, i, n - 1);
        }
        System.out.println("Heap inicial construido: " + Arrays.toString(datos));
        System.out.println();
        //extracciones sucesivas de la raíz
        for (int ultimo = n - 1; ultimo > 0; ultimo--) {
            intercambiar(datos, 0, ultimo);
            desplazaElemento(datos, 0, ultimo - 1);
            System.out.println("Tras extraer la raíz a la posición " + ultimo
                    + ": " + Arrays.toString(datos));
        }
        System.out.println("\nRESULTADO FINAL");
        System.out.println("Arreglo: " + Arrays.toString(datos));
    }

    public void cuentaPorDistribucion(int[] datos) {
        int n = datos.length;
        int max = 0;
        for (int v : datos) {
            if (v > max) max = v;
        }
        //conteo de apariciones de cada clave
        int[] conteo = new int[max + 1];
        for (int v : datos) {
            conteo[v]++;
        }
        //acumulo para saber la posición final de cada clave
        for (int i = 1; i < conteo.length; i++) {
            conteo[i] += conteo[i - 1];
        }
        //recorro desde el final para que el método sea estable
        int[] salida = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int v = datos[i];
            conteo[v]--;
            salida[conteo[v]] = v;
        }
        System.arraycopy(salida, 0, datos, 0, n);
    }

    public void cuentaPorDistribucionConPasos(int[] datos) {
        int n = datos.length;
        System.out.println("Inicial: " + Arrays.toString(datos));
        int max = 0;
        for (int v : datos) {
            if (v > max) max = v;
        }
        //1) tabla de conteo: cuántas veces aparece cada clave
        int[] conteo = new int[max + 1];
        for (int v : datos) {
            conteo[v]++;
        }
        System.out.println("\nTabla de conteo (cuántas veces aparece cada clave):");
        imprimirTablaDistribucion(conteo);
        //2) tabla acumulada: posición final de cada clave
        for (int i = 1; i < conteo.length; i++) {
            conteo[i] += conteo[i - 1];
        }
        System.out.println("\nTabla acumulada (última posición + 1 de cada clave):");
        imprimirTablaDistribucion(conteo);
        //3) reconstruyo el vector ordenado (recorriendo desde el final = estable)
        int[] salida = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int v = datos[i];
            conteo[v]--;
            salida[conteo[v]] = v;
        }
        System.arraycopy(salida, 0, datos, 0, n);
        System.out.println("\nRESULTADO FINAL");
        System.out.println("Arreglo: " + Arrays.toString(datos));
    }

    private void imprimirTablaDistribucion(int[] tabla) {
        StringBuilder claves = new StringBuilder("Clave:  ");
        StringBuilder valores = new StringBuilder("Valor:  ");
        for (int i = 0; i < tabla.length; i++) {
            claves.append(String.format("%3d", i));
            valores.append(String.format("%3d", tabla[i]));
        }
        System.out.println(claves);
        System.out.println(valores);
    }

}
