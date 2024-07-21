public class PrimerValorPar {


    public static int search_DyV(int[] lista, int ini, int end) {
        if (ini > end)
            return -1;

        else {
            if (lista[ini] % 2 == 0)
                return ini;

            else if (ini == end)
                return -1;

            else {
                int mitad = ini + (end - ini) / 2;
                int left = search_DyV(lista, ini, mitad);

                if (left != -1)
                    return left;
                else
                    return search_DyV(lista, mitad + 1, end);
            }
        }
    }


    public static void main(String[] args) {
        int[] lista = {1, 3, 5, 7, 9, 4, 2, 6};
        int position = search_DyV(lista, 0, lista.length - 1);

        if (position != -1) {
            System.out.println("El primer número par: '" + lista[position] + "', se encuentra en la posición: " + position);
        } else
            System.out.println("No se han encontrado número pares");
    }

}
