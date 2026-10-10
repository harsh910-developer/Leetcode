class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int maxDiff = 0;
        long total = 0;
        long k = (long) k1 + k2;

        int[] diff = new int[n];

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            total += diff[i];
            maxDiff = Math.max(maxDiff, diff[i]);
        }
        if (total <= k) {
            return 0;
        }
        long[] freq = new long[maxDiff + 1];
        for (int d : diff) {
            freq[d]++;
        }
        for (int d = maxDiff; d > 0 && k > 0; d--) {
            long count = freq[d];
            long operations = Math.min(k, count);

            freq[d] -= operations;
            freq[d - 1] += operations;
            k -= operations;
        }
        long result = 0;
        for (int d = 1; d <= maxDiff; d++) {
            result += freq[d] * d * d;
        }
        return result;
    }
}