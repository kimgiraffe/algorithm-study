import java.util.*;

class Solution {
	static class Num {
		public int num;
		public int mapped;

		public Num(int num) {
			this.num = num;
			this.mapped = mapping(num);
		}

		private int mapping(int num) {
			String s = Integer.toString(num);

			StringBuilder sb = new StringBuilder();

			for (char c : s.toCharArray()) {
				sb.append(map[c - '0']);
			}

			return Integer.parseInt(sb.toString());
		}
	}

	static int[] map;

	public int[] sortJumbled(int[] mapping, int[] nums) {
		map = mapping;

		Num[] mappedNums = new Num[nums.length];

		for (int i = 0; i < nums.length; i++) {
			mappedNums[i] = new Num(nums[i]);
		}

		Arrays.sort(mappedNums, (o1, o2) -> Integer.compare(o1.mapped, o2.mapped));

		return Arrays.stream(mappedNums)
				.mapToInt(o -> o.num)
				.toArray();
	}
}
