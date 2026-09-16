class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[] { first, last };
    }

    public int findFirst(int[] nums, int target) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        int ans = -1;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (nums[mid] == target) {
                ans = mid;
                j = mid - 1;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return ans;
    }

    public int findLast(int[] nums, int target) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        int ans = -1;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (nums[mid] == target) {
                ans = mid;
                i = mid + 1;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return ans;
    }
}