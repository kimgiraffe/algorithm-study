class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int bookCnt = books.length;
        int[] dp = new int[bookCnt + 1];
        dp[0] = 0;

        for (int caseIdx = 1; caseIdx <= bookCnt; caseIdx++) {
            int width = 0;
            int height = 0;
            dp[caseIdx] = Integer.MAX_VALUE;

            for (int bookIdx = caseIdx; bookIdx > 0; bookIdx--) {
                width += books[bookIdx - 1][0];
                
                if (width > shelfWidth) 
                    break;
                
                height = Math.max(height, books[bookIdx - 1][1]);
                dp[caseIdx] = Math.min(dp[caseIdx], dp[bookIdx - 1] + height);
            }
        }

        return dp[bookCnt];
    }
}
