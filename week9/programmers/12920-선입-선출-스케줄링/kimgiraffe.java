import java.util.*;

class Solution {
    static int answer;
    static int coreSize; // 코어의 수

    public int process(int time, int[] cores) {
        int count = coreSize; // t = 0에 모든 코어에서 작업 수행
        for(int i = 0; i < coreSize; i++) {
            count += (time / cores[i]);
        }

        return count;
    }

    public int binarySearch(int n, int[] cores) {
        int lo = 1;
        int hi = 50000;
        int work = 0;
        int time = 0;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int count = process(mid, cores);

            if(count >= n) { // n 개의 작업을 모두 처리할 수 있는 경우
                hi = mid - 1;
                time = mid; // 해당 시간 저장
                work = count; // 작업량 저장
            } else {
                lo = mid + 1;
            }
        }

        work -= n; // 처리한 작업량과 작업의 수 차이 갱신
        for(int i = coreSize - 1; i >= 0; i--) {
            if(time % cores[i] == 0) {
                if(work == 0) {
                    answer = i + 1;
                    break;
                }
                work--;
            }
        }

        return answer;
    }

    public int solution(int n, int[] cores) {
        coreSize = cores.length;

        answer = binarySearch(n, cores);

        return answer;
    }
}
