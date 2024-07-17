class Solution {
    int[] weak;
    int[] dist;
    int[][] weakCaseArr;
    int length;
    int answer;
    
    //원형이므로 기준점에 따라 표기가 달라질 수 있다 ex) length : 12, 1 >> 13(1 + 12)
    //가능한 모든 경우를 생성(최대 15개이므로 가능)
    void makeWeakCases(){
        int[] tmp = this.weak.clone();
        weakCaseArr[0] = tmp.clone();
        
        for(int weakCase = 1; weakCase < weak.length; weakCase++){
            int first = tmp[0];
            
            for(int weakIdx = 1; weakIdx < weak.length; weakIdx++){
                tmp[weakIdx-1] = tmp[weakIdx];
            }
            tmp[tmp.length-1] = first + length;
            
            weakCaseArr[weakCase] = tmp.clone();
        }
    }

    //투입 순서를 모두 고려하기 위해 생성
    void makeDistCases(boolean[] visited, int[] distCase, int depth){
        //distCase가 완성되면 모든 weakCase에 투입
        if(depth == dist.length){
            for(int[] weakCase: weakCaseArr) {
                check(distCase, weakCase);
            }  
        }
        
        for(int distIdx = 0; distIdx < dist.length; distIdx++){
            if(visited[distIdx])
                continue;
            
            visited[distIdx] = true;
            distCase[depth] = dist[distIdx];
            makeDistCases(visited, distCase, depth+1);
            visited[distIdx] = false;
            distCase[depth] = 0;
        }
    }

    void check(int[] distCase, int[] weakCase){
        int curWeakIdx = 0;
        int nextWeakIdx = 0;
        int distIdx = 0;
        while(curWeakIdx < weakCase.length && distIdx < distCase.length){
            nextWeakIdx = curWeakIdx + 1;
            
            while(nextWeakIdx < weakCase.length && weakCase[curWeakIdx] + distCase[distIdx] >= weakCase[nextWeakIdx]){
               nextWeakIdx++;
            }
            curWeakIdx = nextWeakIdx;
            distIdx++;
        }

        if(curWeakIdx == weakCase.length && distIdx < answer)
            answer = distIdx;
    }
    
    public int solution(int n, int[] weak, int[] dist) {
        this.weak = weak;
        this.dist = dist;
        this.answer = dist.length+1;
        this.length = n;
        
        weakCaseArr = new int[weak.length][weak.length];
        makeWeakCases();
        
        makeDistCases(new boolean[dist.length], new int[dist.length], 0);
        
        if(answer == dist.length + 1)
            return -1;
        else
            return answer;
    }
}