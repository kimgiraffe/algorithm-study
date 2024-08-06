import java.util.*;

class Solution {
	public String kthDistinct(String[] arr, int k) {
		Map<String, Integer> map = new HashMap<>();

		for (String s : arr) {
			map.put(s, map.getOrDefault(s, 0) + 1);
		}

		int idx = 0;
		for (String s : arr) {
			if (map.get(s) == 1) {
				idx += 1;
			}
			if (idx == k) {
				return s;
			}
		}

		return "";
	}
}
