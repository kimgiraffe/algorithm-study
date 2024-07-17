import java.util.*;

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
	static List<TreeNode> answer;

	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		Set<Integer> toDelete = new HashSet<>();

		for (int target : to_delete) {
			toDelete.add(target);
		}

		answer = new ArrayList<>();

		if (!post(root, toDelete)) {
			answer.add(root);
		}

		return answer;
	}

	static boolean post(TreeNode node, Set<Integer> targets) {
		if (node == null) {
			return false;
		}

		boolean left = post(node.left, targets);
		boolean right = post(node.right, targets);

		if (left) {
			node.left = null;
		}

		if (right) {
			node.right = null;
		}

		if (targets.contains(node.val)) {
			targets.remove(node.val);
			if (node.left != null) {
				answer.add(node.left);
			}
			if (node.right != null) {
				answer.add(node.right);
			}
			return true;
		}

		return false;
	}
}
