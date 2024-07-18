/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
	static int answer;
	static final int MAX_DIST = 10;

	public int countPairs(TreeNode root, int distance) {
		answer = 0;
		calc(root, distance);
		return answer;
	}

	static int[] calc(TreeNode node, int distance) {
		if (node == null) {
			return new int[MAX_DIST + 1];
		}

		// if leaf node
		if (node.left == null && node.right == null) {
			int[] res = new int[MAX_DIST + 1];
			res[1] = 1;
			return res;
		}

		int[] left = calc(node.left, distance);
		int[] right = calc(node.right, distance);

		// 왼쪽 + 오른쪽이 주어진 dist 이하인 경우 가짓수 곱해서 합산
		for (int i = 1; i <= distance; i++) {
			for (int j = 1; j <= distance - i; j++) {
				answer += (left[i] * right[j]);
			}
		}

		// 위로 올려주기 위해 거리 1씩 더해주기
		int[] res = new int[MAX_DIST + 1];
		for (int i = 1; i < MAX_DIST; i++) {
			res[i + 1] = left[i] + right[i];
		}

		return res;
	}
}
