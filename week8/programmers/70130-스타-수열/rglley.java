import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int[] cntArr = new int[a.length];
        for(int numIdx = 0; numIdx < a.length; numIdx++){
            cntArr[a[numIdx]]++;
        }
        
        for(int cntIdx = 0; cntIdx < cntArr.length; cntIdx++){
            if(cntArr[cntIdx] <= answer) //이미 등장한 숫자보다 더 빈도가 적거나 같은 경우
                continue; 
            
            int count = 0;
            for(int numIdx = 0; numIdx < a.length-1; numIdx++){ //a의 숫자를 기준으로, 최대 몇 쌍이 나올 수 있는지 계산
                if(a[numIdx] != a[numIdx+1] && (cntIdx == a[numIdx] || cntIdx == a[numIdx+1])){
                    count++;
                    numIdx++;
                }
            }
            
            answer = Math.max(answer, count);
        }
        
        return answer * 2;
    }
}
