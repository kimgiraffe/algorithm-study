import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int numCnt = queue1.length;
        long sum1 = 0;
        long sum2 = 0;
        for(int numIdx = 0; numIdx < numCnt; numIdx++) {
            sum1 += queue1[numIdx];
            sum2 += queue2[numIdx];
        }

        if ((sum1 + sum2) % 2 != 0) 
            return -1;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int numIdx = 0; numIdx < numCnt; numIdx++) {
            q1.add(queue1[numIdx]);
            q2.add(queue2[numIdx]);
        }

        int answer = 0;
        while(sum1 != sum2) {
            if(answer > numCnt * 4)
                return -1;

            int val = 0;
            if(sum1 < sum2) {
                val = q2.poll();
                q1.add(val);
                sum1 += val;
                sum2 -= val;
            } else {
                val = q1.poll();
                q2.add(val);
                sum1 -= val;
                sum2 += val;
            }
            
            answer++;
        }

        return answer;
    }
}
