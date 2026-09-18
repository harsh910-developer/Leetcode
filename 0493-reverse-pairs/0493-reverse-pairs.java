class Solution {
    private int count = 0;

    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    public void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        countPairs(arr, left, mid, right);
        merge(arr, left, mid, right);
    }

    public void countPairs(int[] nums, int l, int mid, int r) {
        int right = mid + 1;
        for (int i = l; i <= mid; i++) {
            while (right <= r && nums[i] > 2.0 * nums[right]) {
                right++;
            }
            count += (right - (mid + 1));
        }
    }

    public void merge(int[] nums, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0;
        
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= r) {
            temp[k++] = nums[j++];
        }
        
        for (int p = 0; p < temp.length; p++) {
            nums[l + p] = temp[p];
        }
    }
}