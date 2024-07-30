import java.util.*;

class Solution {
	static private final int INF = (int) 1e9;

	public int findTheCity(int n, int[][] edges, int distanceThreshold) {
		int[][] dist = new int[n][n];

		for (int r = 0; r < n; r++) {
			Arrays.fill(dist[r], INF);
			dist[r][r] = 0;
		}

		for (int[] edge : edges) {
			int from = edge[0];
			int to = edge[1];
			int weight = edge[2];

			dist[from][to] = weight;
			dist[to][from] = weight;
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}

		int answer = -1;
		int min = INF;

		for (int r = 0; r < n; r++) {
			int cnt = 0;
			for (int c = 0; c < n; c++) {
				if (dist[r][c] <= distanceThreshold) {
					cnt += 1;
				}
			}
			if (cnt <= min) {
				answer = r;
				min = cnt;
			}
		}

		return answer;
	}
}
