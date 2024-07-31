class Solution {
	static final int W = 0, H = 1;

	public int minHeightShelves(int[][] books, int shelfWidth) {
		// DP배열 선언 (dp[i] = i번째까지 책을 넣었을 때 가능한 최소 높이)
		int[] dp = new int[books.length + 1];

		dp[1] = books[0][H];

		for (int i = 2; i <= books.length; i++) {
			// 1. 새로운 선반 만들기
			int leftWidth = shelfWidth - books[i - 1][W]; // 현재 책을 넣고 남은 너비
			int maxHeight = books[i - 1][H]; // 현재 책의 높이

			dp[i] = books[i - 1][H] + dp[i - 1]; // dp배열 갱신(새로운 책장이므로 책 높이만큼 추가)

			// 2. 기존 책장에 책 넣기
			for (j = i - 1; j > 0; j--) {
				if (leftWidth < books[j - 1][W]) {
					break;
				}

				maxHeight = Math.max(maxHeight, books[j - 1][H]); // 최대 높이 갱신
				leftWidth -= books[j - 1][W]; // 이전 책 넣고 남은 너비
				dp[i] = Math.min(dp[i], dp[j - 1] + maxHeight); // dp 재계산 (현재 dp(새 책장)와 기존 책장의 최대 높이 비교)
			}
		}

		return dp[books.length];
	}
}
