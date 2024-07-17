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
	public String getDirections(TreeNode root, int startValue, int destValue) {
		TreeNode LCA = findLCA(root, startValue, destValue);

		StringBuilder toStart = new StringBuilder();
		StringBuilder toDest = new StringBuilder();

		findPath(LCA, startValue, toStart);
		findPath(LCA, destValue, toDest);

		StringBuilder answer = new StringBuilder();

		answer.append(reverse(toStart));
		answer.append(toDest);

		return answer.toString();
	}

	static StringBuilder reverse(StringBuilder sb) {
		StringBuilder res = new StringBuilder();

		res.append("U".repeat(sb.length()));

		return res;
	}

	static boolean findPath(TreeNode node, int target, StringBuilder sb) {
		if (node == null) {
			return false;
		}

		if (node.val == target) {
			return true;
		}

		// 왼쪽 재귀
		sb.append("L");
		if (findPath(node.left, target, sb)) {
			return true;
		}
		sb.setLength(sb.length() - 1);

		// 오른쪽 재귀
		sb.append("R");
		if (findPath(node.right, target, sb)) {
			return true;
		}
		sb.setLength(sb.length() - 1);

		return false;
	}

	static TreeNode findLCA(TreeNode node, int val1, int val2) {
		if (node == null) {
			return null;
		}

		// 만약 현재 값과 찾고자 하는 값이 같다면 현재 값이 최소 공통 조상
		if (node.val == val1 || node.val == val2) {
			return node;
		}

		// 일치하지 않을 경우 왼쪽, 오른쪽 서브트리 각각에 대해 재귀 호출
		TreeNode left = findLCA(node.left, val1, val2);
		TreeNode right = findLCA(node.right, val1, val2);

		// 왼쪽 트리에서 찾지 못했다면 오른쪽 트리에서 찾은 값 반환
		if (left == null)
			return right;

		// 오른쪽 트리에서 찾지 못했다면 왼쪽 트리에서 찾은 값 반환
		if (right == null)
			return left;

		// 양쪽에서 찾았다면 현재 값이 LCA
		return node;
	}
}
