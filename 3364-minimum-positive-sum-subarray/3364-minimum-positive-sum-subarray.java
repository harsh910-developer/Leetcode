
class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();

        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums.get(i);
        }

        TreeMap<Long, Integer> map = new TreeMap<>();
        long ans = Long.MAX_VALUE;

        for (int i = l; i <= n; i++) {
            long add = prefix[i - l];
            map.put(add, map.getOrDefault(add, 0) + 1);
            int removeIdx = i - r - 1;

            if (removeIdx >= 0) {
                long remove = prefix[removeIdx];

                if (map.get(remove) == 1) {
                    map.remove(remove);
                } else {
                    map.put(remove, map.get(remove) - 1);
                }
            }
            Long largest = map.lowerKey(prefix[i]);
            if (largest != null) {
                long sum = prefix[i] - largest;
                ans = Math.min(ans, sum);
            }
        }

        return ans == Long.MAX_VALUE ? -1 : (int) ans;
    }
}
