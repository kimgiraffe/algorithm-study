class Solution {
	public void sort(int start, int end, int[] nums) {
		if (start == end) {
			return;
		}

		int mid = start + (end - start) / 2;

		sort(start, mid, nums);

		sort(mid + 1, end, nums);

		merge(start, mid, end, nums);
	}

	public void merge(int start, int mid, int end, int[] nums) {
		int i = start;
		int j = mid + 1;

		List<Integer> list = new ArrayList<>();

		// 두 sub-array 순회
		while (i <= mid && j <= end) {
			if (nums[i] <= nums[j]) { // 첫 번째 sub-array의 i index 값이 두번째 sub-array의 j index 보다 작거나 같은 경우...
				list.add(nums[i++]);
			} else { // // 첫 번째 sub-array의 i index 값이 두번째 sub-array의 j index 보다 큰 경우...
				list.add(nums[j++]);
			}
		}

		// 첫번째 sub-array의 남은 값들을 list에 담기
		while (i <= mid) {
			list.add(nums[i++]);
		}

		// 두 번째 sub-array의 남은 값들을 list에 담기
		while (j <= end) {
			list.add(nums[j++]);
		}

		// list에 정렬된 숫자들을 다시 nums로 복사
		i = start;
		j = 0;
		while (i <= end) {
			nums[i++] = list.get(j++);
		}
	}

	public int[] sortArray(int[] nums) {
		sort(0, nums.length - 1, nums);

		return nums;
	}
}
