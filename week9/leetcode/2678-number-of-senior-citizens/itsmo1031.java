class Solution {
	public int countSeniors(String[] details) {
		int answer = 0;

		for (String detail : details) {
			int age = Integer.parseInt(detail.substring(11, 13));
			if (age > 60) {
				answer += 1;
			}
		}

		return answer;
	}
}
