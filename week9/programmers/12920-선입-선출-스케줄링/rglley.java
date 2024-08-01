class Solution {
    public int solution(int n, int[] cores) {
        if (n <= cores.length) {
            return n;
        }

        int low = 0;
        int high = 10000 * n;
        int tmpTime = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            
            int workingCnt = cores.length;
            for (int core : cores) {
                workingCnt += mid / core;
            }
            
            if (workingCnt >= n) {
                high = mid - 1;
                tmpTime = mid;
            } else {
                low = mid + 1;
            }
        }

        int completeCnt = cores.length;
        for (int core : cores) {
            completeCnt += (tmpTime - 1) / core;
        }

        int answer = 0;
        for (int coreIdx = 0; coreIdx < cores.length; coreIdx++) {
            if (tmpTime % cores[coreIdx] == 0) {
                completeCnt++;
            }
            if (completeCnt == n) {
                answer = coreIdx + 1;
                break;
            }
        }
        
        return answer;
    }
}
