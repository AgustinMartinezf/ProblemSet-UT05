package ucu.edu.aed.tda.clasificacion;

public class Main {
    public static void main(String[] args) {
        GeneradorDatosGenericos gdg = new GeneradorDatosGenericos();
        int[] vectorAleatorio = gdg.generarDatosAleatorios();
        int[] vectorAscendente = gdg.generarDatosAscendentes();
        int[] vectorDescendente = gdg.generarDatosDescendentes();

        TClasificadorImpl clasificador = new TClasificadorImpl();
        //ejercicio5
        int[] ejercicio5 = {256,458,365,298,43,648,778,621,655,19,124,847};
        clasificador.insercionDirectaPasos(ejercicio5);
        //ejercicio9
        int [] ejercicio9 ={256,458,365,298,43,648,778,621,655,19,124,847};
        Integer[] incrementos = {4,2,1};
        clasificador.shellConPasos(ejercicio9,incrementos);
        //ejercicio15
        int [] ejercicio15 ={256,458,365,298,43,648,778,621,655,19,124,847};
        clasificador.clasificacionDirectaConPasos(ejercicio15);
        //ejercicio13
        int[] ejercicio13 = {223,784,376,285,15,440,666,7};
        clasificador.quicksortConPasos(ejercicio13);
        //ejercicio18
        int[] ejercicio18 = {22,11,44,55,88,77,33,1};
        clasificador.heapsortConPasos(ejercicio18);
        //ejercicio20
        int[] ejercicio20 = {2,5,3,0,2,3,0,3};
        clasificador.cuentaPorDistribucionConPasos(ejercicio20);

        /* 
        clasificador.insercionDirecta(vectorAleatorio);
        clasificador.insercionDirecta(vectorAscendente);
        clasificador.insercionDirecta(vectorDescendente);
        for (int value : vectorAleatorio) {
            System.out.print(value + " ");
        }
        System.out.println();

        for (int k : vectorAscendente) {
            System.out.print(k + " ");
        }
        System.out.println();
        for (int j : vectorDescendente) {
            System.out.print(j + " ");
        }
        */

    }
}
