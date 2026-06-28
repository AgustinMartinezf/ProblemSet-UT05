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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerPivote'");
    }

    @Override
    protected int particion(int[] datos, int i, int j, int pivote) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'particion'");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'heapsort'");
    }

    @Override
    protected void desplazaElemento(int[] datos, int primero, int ultimo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'desplazaElemento'");
    }
    
}
