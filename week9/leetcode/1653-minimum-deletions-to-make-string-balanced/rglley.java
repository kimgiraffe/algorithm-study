class Solution {
    public int minimumDeletions(String s) {
        int[] dp = new int[s.length() + 1];
        int bCount = 0;
        for (int idx = 0; idx < s.length(); idx++) {
            if (s.charAt(idx) == 'b') {
                dp[idx + 1] = dp[idx];
                bCount++;
            } else {
                //a를 만난 시점에서 이전의 b들을 삭제할지, a를 삭제할지 판단
                dp[idx + 1] = Math.min(dp[idx] + 1, bCount);
            }
        }

        return dp[s.length()];
    }
}