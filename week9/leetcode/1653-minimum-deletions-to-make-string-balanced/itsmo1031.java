class Solution {
	public int minimumDeletions(String s) {
		int answer = 0;
		int bCnt = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'b') {
				bCnt += 1;
			} else {
				answer = Math.min(answer + 1, bCnt);
			}
		}

		return answer;
	}
}
