/**
 * 1읅 가장 많이 포함하는 최소 window 크기 구하기
 */
class Solution {
	public int minSwaps(int[] nums) {
		int len = nums.length;
		int sum = 0; // 1의 합

		for (int i = 0; i < len; i++) {
			sum += nums[i];
		}

		int count = 0;

		// sliding window 초기화
		for (int i = 0; i < sum; i++) {
			count += nums[i];
		}

		int max = count;

		for (int i = sum; i < len + sum; i++) {
			count += nums[i % len] - nums[(i - sum + len) % len];
			max = Math.max(max, count); // 최댓값 개신
		}

		return sum - max;
	}
}
