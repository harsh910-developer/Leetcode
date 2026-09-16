class Solution {
    static final long MOD = 1_000_000_007L;

    public long power(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1L) != 0) {
                result = result * base % MOD;
            }
            base = base * base % MOD;
            exp >>= 1;
        }
        return result;
    }

    public int numberOfSets(int n, int k) {
        long N = n + k - 1;
        long R = 2L * k;

        R = Math.min(R, N - R);

        long numr = 1;
        long denor = 1;

        for (long i = 1; i <= R; i++) {
            numr = numr * (N - R + i) % MOD;
            denor = denor * i % MOD;
        }
        long inverse = power(denor, MOD - 2);

        return (int) (numr * inverse % MOD);

    }
}