class Solution {
    public int minSwaps(int[] nums) {
        int oneCnt = 0;
        for (int num : nums) {
            if (num == 1) 
                oneCnt++;
        }

        //슬라이딩 윈도우 풀이, 초기 윈도우 1의 개수 저장
        int maxOneCnt = 0;
        int currentOneCnt = 0;
        int numCnt = nums.length;
        for (int numIdx = 0; numIdx < oneCnt; numIdx++) {
            if (nums[numIdx] == 1) 
                currentOneCnt++;
        }
        maxOneCnt = currentOneCnt;

        // 슬라이딩 윈도우로 배열을 순회, 윈도우 별 1 최대 개수 저장
        for (int numIdx = oneCnt; numIdx < numCnt + oneCnt; numIdx++) {
            if (nums[numIdx % numCnt] == 1) //원형이므로 numCnt로 나눠준다. 
                currentOneCnt++;
            if (nums[(numIdx - oneCnt) % numCnt] == 1) 
                currentOneCnt--;
            maxOneCnt = Math.max(maxOneCnt, currentOneCnt);
        }

        //1이 제일 많은 곳을 기준으로 나머지 1들을 swap
        return oneCnt - maxOneCnt;
    }
}
