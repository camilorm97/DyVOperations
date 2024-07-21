public class BuscarNumeroTernario {

    public static int DyV_search_number(int[] lista, int ini, int end, int n_search) {
        if (ini > end)
            return -1;

        else {
            int parte = (end - ini) / 3;

            if (n_search == lista[parte]) {
                return parte;
            }

            else if (n_search < lista[parte]) {
                return DyV_search_number(lista, ini, parte - 1, n_search);
            }

            else {
                int otra_parte = end - parte;

                if (n_search == lista[otra_parte]) {
                    return otra_parte;
                }

                else {
                    if (n_search < lista[otra_parte]) {
                        return DyV_search_number(lista, parte + 1, otra_parte - 1, n_search);
                    }
                    else {
                        return DyV_search_number(lista, otra_parte + 1, end, n_search);
                    }
                }
            }

        }
    }


    public static void main(String[] args) {
        int[] lista = {1,2,3,4,5,6,7,8,9};
        int n_search = 4;

        int pos = DyV_search_number(lista, 0, lista.length - 1, n_search);

        if (pos == -1)
            System.out.println("No se encontró el valor");
        else
            System.out.println("Número introducido: " + n_search + ": El valor " + lista[pos] + ", se encuentra en la posición " + pos);
    }
}
