class Solution {
	public int findTheWinner(int n, int k) {
		Deque<Integer> game = new ArrayDeque<>();

		for (int i = 1; i <= n; i++) {
			game.offerLast(i);
		}

		int left = k;
		while (game.size() > 1) {
			left -= 1;
			int current = game.pollFirst();
			if (left == 0) {
				left = k;
				continue;
			}
			game.offerLast(current);
		}

		return game.pollFirst();
	}
}
