class Solution {
	public double averageWaitingTime(int[][] customers) {
		double currentTime = 0;
		double totalWaitingTime = 0;

		for (int[] c : customers) {
			if (currentTime < c[0]) {
				currentTime = c[0] + c[1];
				totalWaitingTime += c[1];
				continue;
			}
			currentTime += c[1];
			totalWaitingTime += currentTime - c[0];
		}

		return totalWaitingTime / customers.length;
	}
}
