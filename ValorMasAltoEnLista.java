public class ValorMasAltoEnLista {

    public static int DyV(int[] m, int init, int end) {
        if (init > end)
            return 0;

        else {
            if (init == end)
                return m[init];

            else {
                int middle = init + (end - init) / 2;

                int left_ = DyV(m, init, middle);
                int right_ = DyV(m, middle + 1, end);
                return Math.max(left_, right_);

            }
        }
    }

    public static void main(String[] args) {
        int[] m = {4, 10, 21, 7, 8, 14, 20, 1, 2, 9, 3};

        System.out.println(DyV(m, 0, m.length - 1));
    }

}
