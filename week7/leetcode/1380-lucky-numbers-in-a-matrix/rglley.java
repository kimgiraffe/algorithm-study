class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> answer = new ArrayList<>(); 
        for(int row1 = 0; row1 < matrix.length; row1++) {
            int checkCol = 0;
            int min = Integer.MAX_VALUE;
            for(int col = 0; col < matrix[0].length; col++) {
                if(matrix[row1][col] < min) {
                    min = matrix[row1][col];
                    checkCol = col;
                }
            }

            boolean flag = true;
            for(int row2 = 0; row2 < matrix.length; row2++) {
                if(matrix[row2][checkCol] > min) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                answer.add(min);
            }
        }

        return answer;
    }
}