public class FastMath {

    private FastMath() {}

    // compute i32 log2.
    public static int fastI32Log2(int k) {
        int d = k;
        d |= (d >> 1);
        d |= (d >> 2);
        d |= (d >> 4);
        d |= (d >> 8);
        d |= (d >> 16);
        return d;
    }
}
