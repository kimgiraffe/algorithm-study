class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2]; // 삼각형의 크기 ( 1 ~ n 까지 합)
		int[][] tmpArr = new int[n][n];
		
		int tmpRow = -1; 
		int tmpCol = 0; 
		int value = 1;
		
		for(int layer = 0; layer < n; layer++) {
			for(int position = layer; position < n; position++) {
				if(layer % 3 == 0) { //아래
					tmpRow++;
				} else if(layer % 3 == 1) { //오른쪽
					tmpCol++;
				} else if(layer % 3 == 2) { //위
					tmpRow--;
					tmpCol--;
				}
                
				tmpArr[tmpRow][tmpCol] = value++;
			}
		}
		
		int index = 0;
		for(int row = 0; row < n; row++) {
			for(int col = 0; col < n; col++) {
				if(tmpArr[row][col] == 0) 
                    break;
                
				answer[index++] = tmpArr[row][col];
			}
		}
        
        return answer;
    }
}