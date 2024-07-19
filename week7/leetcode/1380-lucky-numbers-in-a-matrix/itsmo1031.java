import java.util.*;

class Solution {
	public List<Integer> luckyNumbers(int[][] matrix) {
		List<Integer> row = new ArrayList<>();
		List<Integer> col = new ArrayList<>();

		for (int r = 0; r < matrix.length; r++) {
			int min = Integer.MAX_VALUE;
			for (int c = 0; c < matrix[0].length; c++) {
				min = Math.min(min, matrix[r][c]);
			}
			row.add(min);
		}

		for (int c = 0; c < matrix[0].length; c++) {
			int max = Integer.MIN_VALUE;
			for (int r = 0; r < matrix.length; r++) {
				max = Math.max(max, matrix[r][c]);
			}
			col.add(max);
		}

		row.retainAll(col);

		return row;
	}
}
