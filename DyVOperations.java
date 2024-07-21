public class DyVOperations {

    public static int SumaListaDyVBinario(int[] lista, int ini, int end) {
        if (ini > end) {
            return 0;
        } else {
            if (ini == end)
                return lista[ini];
            else {
                int mitad = (end + ini) / 2;
                return SumaListaDyVBinario(lista, ini, mitad) + SumaListaDyVBinario(lista, mitad + 1, end);
            }
        }
    }

    public static int SumaListaDyVTernario(int[] lista, int ini, int end) {
        if (ini > end) {
            return 0;
        } else {
            if (ini == end)
                return lista[ini];
            else {
                int primera_parte = (end + ini) / 3;
                int segunda_parte = primera_parte * 2;
                return SumaListaDyVBinario(lista, ini, primera_parte) + SumaListaDyVBinario(lista, primera_parte + 1, segunda_parte) + SumaListaDyVBinario(lista, segunda_parte + 1, end);
            }
        }
    }

    public static int mediaElementosLista(int[] lista, int ini, int end) {
        if (ini > end) {
            return 0;
        } else {

            if (ini == end)
                return lista[ini];

            else {
                int mitad = (ini + end) / 2;
                return mediaElementosLista(lista, ini, mitad) + mediaElementosLista(lista, mitad + 1, end);
            }

        }
    }


    public static int[][] sumaMatricesNxMBinario(int[][] lista1, int[][] lista2, int[][] resultado, int ini_f, int end_f) {
        if (ini_f > end_f)
            return resultado;

        else {
            if (ini_f == end_f) {
                for (int i = 0; i < lista1[ini_f].length; i++) {
                    resultado[ini_f][i] = lista1[ini_f][i] + lista2[ini_f][i];
                }
                return resultado;
            }
            else {
                int mitad_filas = (ini_f + end_f) / 2;

                sumaMatricesNxMBinario(lista1, lista2, resultado, ini_f, mitad_filas);
                sumaMatricesNxMBinario(lista1, lista2, resultado, mitad_filas + 1, end_f);
                return resultado;
            }
        }
    }


    public static int[] BuscarNumeroMatricesNxMBinario(int[][] lista, int ini_f, int end_f, int n_search) {
        if (ini_f > end_f)
            return null;

        else {
            if (ini_f == end_f) {
                boolean encontrado = false;
                int cont = 0;
                int[] resultado = new int[2];

                while (!encontrado && cont < lista[ini_f].length) {
                    if (lista[ini_f][cont] == n_search) {
                        encontrado = true;
                        resultado[0] = ini_f;
                        resultado[1] = cont;
                    }
                    cont++;
                }

                return encontrado ? resultado : null;

            }

            else {
                int mitad_filas = (end_f + ini_f) / 2;

                int[] resultado = BuscarNumeroMatricesNxMBinario(lista, ini_f, mitad_filas, n_search);
                if (resultado != null)
                    return resultado;

                resultado = BuscarNumeroMatricesNxMBinario(lista,mitad_filas + 1, end_f, n_search);
                return resultado;
            }
        }
    }

    public static void main(String[] args) {
        int[] lista = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int sumaListaBinaria = SumaListaDyVBinario(lista, 0, lista.length - 1);
        int sumaListaTernaria = SumaListaDyVTernario(lista, 0, lista.length - 1);
        int mediaBinaria = mediaElementosLista(lista, 0, lista.length - 1) / lista.length; // Falta por completar

        System.out.println(sumaListaBinaria);
        System.out.println(sumaListaTernaria);
        System.out.println(mediaBinaria);

        int[][] m1 = {{1, 2}, {3, 4}, {5, 6}};
        int[][] m2 = {{7, 8}, {9, 10}, {11, 12}};

        int[][] resultado = new int[m1.length][m2[0].length];
        int[][] res = sumaMatricesNxMBinario(m1, m2, resultado, 0, m1.length - 1);


        for (int i = 0; i < res.length; i++) {
            System.out.print("[");
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j]);
                if (j < res[0].length - 1)
                    System.out.print(" ");
            }
            System.out.print("]");
        }
        System.out.println();

        int n_search = -1;
        int[] buscar = BuscarNumeroMatricesNxMBinario(m1, 0, m1.length - 1,  n_search);

        if (buscar != null)
            System.out.println(buscar[0] + " " + buscar[1]);
        else
            System.out.println("No se ha encontrado elemento MxN");
    }
}
