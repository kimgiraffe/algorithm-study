class Solution {
    char[][] newBoard;
    boolean[][] toRemove;
    
    int mark(int rowSize, int colSize) {
        int count = 0;
        for (int row = 0; row < rowSize - 1; row++) {
            for (int col = 0; col < colSize - 1; col++) {
                char ch = newBoard[row][col];
                if (ch != ' ' && newBoard[row + 1][col] == ch && newBoard[row][col + 1] == ch && newBoard[row + 1][col + 1] == ch) {
                    toRemove[row][col] = true;
                    toRemove[row + 1][col] = true;
                    toRemove[row][col + 1] = true;
                    toRemove[row + 1][col + 1] = true;
                }
            }
        }

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (toRemove[row][col]) {
                    count++;
                }
            }
        }

        return count;
    }

    void remove(int rowSize, int colSize) {
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (toRemove[row][col]) {
                    newBoard[row][col] = ' ';
                }
            }
        }
    }

    void drop(int rowSize, int colSize) {
        for (int col = 0; col < colSize; col++) {
            for (int row = rowSize - 1; row >= 0; row--) {
                if (newBoard[row][col] == ' ') {
                    int changeIdx = row - 1;
                    while (changeIdx >= 0 && newBoard[changeIdx][col] == ' ') {
                        changeIdx--;
                    }

                    if (changeIdx >= 0) {
                        newBoard[row][col] = newBoard[changeIdx][col];
                        newBoard[changeIdx][col] = ' ';
                    }
                }
            }
        }
    }

    public int solution(int m, int n, String[] board) {
        newBoard = new char[m][n];
        for (int row = 0; row < m; row++) {
            newBoard[row] = board[row].toCharArray();
        }

        int answer = 0;
        while (true) {
            toRemove = new boolean[m][n];
            int count = mark(m, n);
            if (count == 0) {
                break;
            }

            answer += count;
            remove(m, n);
            drop(m, n);
        }
        
        return answer;
    } 
}
