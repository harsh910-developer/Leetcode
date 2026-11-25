import java.util.*;

class Solution {

    static final long MOD1 = 1000000007L;
    static final long MOD2 = 1000000009L;
    static final long BASE1 = 911382323L;
    static final long BASE2 = 97266353L;

    long[] p1, p2, pow1, pow2;
    int n;

    public int smallestUniqueSubarray(int[] nums) {
        n = nums.length;

        if (n == 0) return -1;

        p1 = new long[n + 1];
        p2 = new long[n + 1];
        pow1 = new long[n + 1];
        pow2 = new long[n + 1];

        pow1[0] = 1;
        pow2[0] = 1;

        for (int i = 0; i < n; i++) {
            long v1 = Math.floorMod((long) nums[i], MOD1);
            long v2 = Math.floorMod((long) nums[i], MOD2);

            p1[i + 1] = (p1[i] * BASE1 + v1) % MOD1;
            p2[i + 1] = (p2[i] * BASE2 + v2) % MOD2;

            pow1[i + 1] = (pow1[i] * BASE1) % MOD1;
            pow2[i + 1] = (pow2[i] * BASE2) % MOD2;
        }

        int low = 1, high = n;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (check(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    boolean check(int len) {

        Map<Long, Integer> map = new HashMap<>();
        int unique = 0;

        for (int i = 0; i <= n - len; i++) {

            long h1 = (p1[i + len]
                    - p1[i] * pow1[len] % MOD1 + MOD1) % MOD1;

            long h2 = (p2[i + len]
                    - p2[i] * pow2[len] % MOD2 + MOD2) % MOD2;

            long key = (h1 << 32) | h2;

            int count = map.getOrDefault(key, 0);

            if (count == 0) {
                unique++;
                map.put(key, 1);
            } 
            else if (count == 1) {
                unique--;
                map.put(key, 2);
            }
        }

        return unique > 0;
    }
}