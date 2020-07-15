package coursera.strings;

/**
 * Rabin Karp efficient Algorithm of finding substring based on hashing
 * MonteCarlo - we are not checking char by char what we have after matching hash (extremely slow probability that it will be incorrect)
 * LasVegas - guarantee that it's right substring (extremely low probability that it will be slow)
 * Collision probability 1/Q(in theory 1/N but if q very big(can be overflow))
 * User : Shein G.A.{@reeeray}
 * Date : 13.07.2020
 **/
public class RabinKarp {

    private static final int Radix = 10; //очнование нашей системы счисления
    private static final int Q = 997; // modulus
    private long patHash; // pattern hash value
    private int M; //pattern length
    private long RM; //R^(M-1)%Q


    public RabinKarp(final String pattern) {
        this.M = pattern.length();

        RM = 1;
        for (int i = 1; i <= M - 1; i++)
            RM = (Radix * RM) % Q;
        patHash = hash(pattern, M);
    }

    public int serch(final String text) {
        final int N = text.length();
        long txtHash = hash(text, M);
        if (patHash == txtHash) return 0;
        for (int i = M; i < N; i++) {
            txtHash = (txtHash + Q - RM * text.charAt(i - M) % Q) % Q;
            txtHash = (txtHash + text.charAt(i)) % Q;
            if (patHash == txtHash) return i - M + 1;
        }
        return N;
    }


    /**
     * Compute hash for M-digit key
     * M-digit, base-Radix integer, modulo Q
     *
     * @param key
     * @return
     */
    public long hash(final String key, final int len) {
        long h = 0;
        for (int j = 0; j < len; j++)
            h = (Radix * h + key.charAt(j)) % Q;
        return h;
    }

}
