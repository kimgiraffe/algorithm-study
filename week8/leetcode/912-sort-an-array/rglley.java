class Solution {
    int[] numArr;
    int[] tmp;
    
    public int[] sortArray(int[] nums) {
        numArr = nums;
        tmp = new int[nums.length];
        mergeSort(0, nums.length - 1);
        return nums;
    }

    void mergeSort(int left, int right) {
        if (left >= right)
            return;

        int mid = (left + right) / 2;
        mergeSort(left, mid);
        mergeSort(mid + 1, right);
        merge(left, mid, right);
    }

    void merge(int left, int mid, int right) {
        int leftIdx = left;
        int rightIdx = mid + 1;
        int tmpIdx = left;

        while (leftIdx <= mid && rightIdx <= right) {
            if (numArr[leftIdx] <= numArr[rightIdx]) {
                tmp[tmpIdx++] = numArr[leftIdx++];
            } else {
                tmp[tmpIdx++] = numArr[rightIdx++];
            }
        }

        while (leftIdx <= mid) {
            tmp[tmpIdx++] = numArr[leftIdx++];
        }

        while (rightIdx <= right) {
            tmp[tmpIdx++] = numArr[rightIdx++];
        }

        for (int numIdx = left; numIdx <= right; numIdx++) {
            numArr[numIdx] = tmp[numIdx];
        }
    }
}