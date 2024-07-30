class Solution {
	public int numTeams(int[] rating) {
		int answer = 0;

		for (int i = 0; i < rating.length - 2; i++) {
			for (int j = i + 1; j < rating.length - 1; j++) {
				for (int k = j + 1; k < rating.length; k++) {
					if (rating[i] < rating[j] && rating[j] < rating[k]) {
						answer += 1;
					} else if (rating[i] > rating[j] && rating[j] > rating[k]) {
						answer += 1;
					}
				}
			}
		}

		return answer;
	}
}
