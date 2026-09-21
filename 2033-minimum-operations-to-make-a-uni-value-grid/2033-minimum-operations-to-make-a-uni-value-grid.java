class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;

        int[] nums = new int[m * n];
        int idx = 0;

        for (int[] row : grid) {
            for (int val : row) {
                nums[idx++] = val;
            }
        }

        int remainder = nums[0] % x;

        for (int num : nums) {
            if (num % x != remainder) {
                return -1;
            }
        }

        Arrays.sort(nums);

        int median = nums[nums.length / 2];
        long operations = 0;

        for (int num : nums) {
            operations += Math.abs((long) num - median) / x;
        }
        return (int) operations;
    }
}
