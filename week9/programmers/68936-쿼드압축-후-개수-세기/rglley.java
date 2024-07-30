class Solution {
    int[][] input;
    int[] answer;
    
    boolean zip(int fromRow, int fromCol, int size) {
        int value = input[fromRow][fromCol];
        
        for(int row = fromRow; row < fromRow + size; row++) {
            for(int col = fromCol; col < fromCol + size; col++) {
                if(input[row][col] != value)
                    return false;
            }    
        }
            
        return true;
    }
    
    public void divide(int currentRow, int currentCol, int size){
        if(zip(currentRow, currentCol, size)){
            if(input[currentRow][currentCol] == 1)
                answer[1]++;
            else 
                answer[0]++;
            
            return;
        }
        
        divide(currentRow, currentCol, size / 2);
        divide(currentRow, currentCol + size / 2, size / 2);
        divide(currentRow + size / 2, currentCol, size / 2);
        divide(currentRow + size / 2, currentCol + size / 2, size / 2);
    }
    
    public int[] solution(int[][] arr) {
        input = arr;
        answer = new int[2];
        
        divide (0, 0, arr.length);
        
        return answer;
    }
}
