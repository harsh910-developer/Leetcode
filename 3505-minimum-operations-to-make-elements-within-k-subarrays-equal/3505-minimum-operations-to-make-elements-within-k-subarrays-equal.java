class Solution {
    TreeMap<Integer, Integer> lo = new TreeMap<>();
    TreeMap<Integer, Integer> hi = new TreeMap<>();

    long sumLo = 0, sumHi = 0;
    int sizeLo = 0, sizeHi = 0;

    void addMap(TreeMap<Integer, Integer> map, int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
    }

    void removeMap(TreeMap<Integer, Integer> map, int val) {
        int count = map.get(val);

        if (count == 1) map.remove(val);
        else map.put(val, count - 1);
    }

    void add(int val) {
        if (lo.isEmpty() || val <= lo.lastKey()) {
            addMap(lo, val);
            sumLo += val;
            sizeLo++;
        } else {
            addMap(hi, val);
            sumHi += val;
            sizeHi++;
        }

        balance();
    }

    void remove(int val) {
        if (lo.containsKey(val)) {
            removeMap(lo, val);
            sumLo -= val;
            sizeLo--;
        } else {
            removeMap(hi, val);
            sumHi -= val;
            sizeHi--;
        }

        balance();
    }

    void balance() {
        int target = (sizeLo + sizeHi + 1) / 2;

        while (sizeLo > target) {
            int val = lo.lastKey();

            removeMap(lo, val);
            sumLo -= val;
            sizeLo--;

            addMap(hi, val);
            sumHi += val;
            sizeHi++;
        }

        while (sizeLo < target) {
            int val = hi.firstKey();

            removeMap(hi, val);
            sumHi -= val;
            sizeHi--;

            addMap(lo, val);
            sumLo += val;
            sizeLo++;
        }
    }

    long getCost() {
        long median = lo.lastKey();

        return median * sizeLo - sumLo
             + sumHi - median * sizeHi;
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        if ((long) x * k > n) return -1;

        long[] cost = new long[n - x + 1];

        for (int i = 0; i < x; i++) {
            add(nums[i]);
        }

        cost[0] = getCost();

        for (int i = x; i < n; i++) {
            remove(nums[i - x]);
            add(nums[i]);

            cost[i - x + 1] = getCost();
        }
        long INF = Long.MAX_VALUE / 4;

        long[] prev = new long[n + 1];
        long[] curr = new long[n + 1];

        for (int j = 1; j <= k; j++) {
            Arrays.fill(curr, INF);

            for (int i = 1; i <= n; i++) {

                curr[i] = curr[i - 1];

                if (i >= x && prev[i - x] != INF) {
                    curr[i] = Math.min(
                        curr[i],
                        prev[i - x] + cost[i - x]
                    );
                }
            }

            long[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n];
    }
}