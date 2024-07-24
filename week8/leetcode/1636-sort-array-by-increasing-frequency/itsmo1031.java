import java.util.*;

class Solution {
	public int[] frequencySort(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		List<Integer> key = new ArrayList<>(map.keySet());
		key.sort((o1, o2) -> {
			int f1 = map.get(o1);
			int f2 = map.get(o2);

			if (f1 == f2) {
				return Integer.compare(o2, o1);
			}
			return Integer.compare(f1, f2);
		});

		int[] answer = new int[nums.length];
		int idx = 0;

		for (int k : key) {
			int freq = map.get(k);
			for (int i = 0; i < freq; i++) {
				answer[idx++] = k;
			}
		}

		return answer;
	}
}
