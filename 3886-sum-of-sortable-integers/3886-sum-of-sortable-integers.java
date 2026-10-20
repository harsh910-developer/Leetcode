class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        int ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }
            boolean isValid = true;
            
            for (int start = 0; start < n; start += k) {
                boolean found = false;

                for (int shift = 0; shift < k; shift++) {
                    boolean match = true;

                    for (int j = 0; j < k; j++) {
                        if (nums[start + j] != sortedNums[start + (shift + j) % k]) {
                            match = false;
                            break;
                        }
                    }
                    if (match) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                ans += k;
            }
        }
        return ans;
    }
}