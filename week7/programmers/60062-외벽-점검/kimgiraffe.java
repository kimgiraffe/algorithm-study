class Solution {
	static boolean[] visited;
	static int[] checked;
	static int[] selected;
	static int distLength;
	static int answer = Integer.MAX_VALUE;

	static void permutation(int start, int curIdx, int[] dist) {
		if (curIdx == distLength) { // 순열 생성 완료
			answer = Math.min(answer, check(start, start + checked.length / 2));
			return;
		}

		for (int idx = 0; idx < distLength; idx++) {
			if (visited[idx]) {
				continue;
			}
			visited[idx] = true;
			selected[curIdx] = dist[idx];
			permutation(start, curIdx + 1, dist);
			visited[idx] = false;
		}
	}

	static int check(int start, int end) {
		int friend = 1; // 친구 수
		int pos = selected[friend - 1] + checked[start];
		for (int idx = start; idx < end; idx++) {
			if (pos < checked[idx]) { // 점검 위치를 벗어나는 경우...
				friend++; // 친구 수 증가
				if (friend > selected.length) { // 모든 친구를 투입해도 불가능한 경우...
					return Integer.MAX_VALUE;
				}
				pos = selected[friend - 1] + checked[idx];
			}
		}
		return friend;
	}

	public int solution(int n, int[] weak, int[] dist) {
		distLength = dist.length;
		checked = new int[weak.length * 2];
		visited = new boolean[distLength];
		selected = new int[distLength];

		// 원형 구조를 직선으로 변형
		// [1, 5, 6, 10] -> [1, 5, 6, 10, 13, 17, 18, 22]
		for (int idx = 0; idx < weak.length; idx++) {
			checked[idx] = weak[idx];
			checked[idx + weak.length] = weak[idx] + n;
		}

		for (int idx = 0; idx < weak.length; idx++) {
			permutation(idx, 0, dist);
		}

		return answer == Integer.MAX_VALUE ? -1 : answer;
	}
}
