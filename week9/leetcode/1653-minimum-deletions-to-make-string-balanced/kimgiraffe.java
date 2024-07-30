class Solution {
	public int minimumDeletions(String s) {
		int min = 0;
		int count = 0; // 'b'

		for (char c : s.toCharArray()) {
			if (c == 'b') {
				count++;
			} else if (count > 0) {
				min++;
				count--;
			}
		}

		return min;
	}
}
