class Solution {
    void mergeSort(int[] nums, int left, int right) {
        if (left >= right) 
            return;

        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    void merge(int[] nums, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int leftIdx = left, rightIdx = mid + 1, mergeIdx = 0;

        while (leftIdx <= mid && rightIdx <= right) {
            if (nums[leftIdx] <= nums[rightIdx]) {
                tmp[mergeIdx++] = nums[leftIdx++];
            } else {
                tmp[mergeIdx++] = nums[rightIdx++];
            }
        }

        while (leftIdx <= mid) {
            tmp[mergeIdx++] = nums[leftIdx++];
        }

        while (rightIdx <= right) {
            tmp[mergeIdx++] = nums[rightIdx++];
        }

        System.arraycopy(tmp, 0, nums, left, tmp.length);
    }
    
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
}
