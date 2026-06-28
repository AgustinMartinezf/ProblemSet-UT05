package ucu.edu.aed.tda.clasificacion;

public class Main {
    public static void main(String[] args) {
        GeneradorDatosGenericos gdg = new GeneradorDatosGenericos();
        int[] vectorAleatorio = gdg.generarDatosAleatorios();
        int[] vectorAscendente = gdg.generarDatosAscendentes();
        int[] vectorDescendente = gdg.generarDatosDescendentes();

        TClasificador clasificador = null; // TODO instanciar con implementación

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

    }
}
