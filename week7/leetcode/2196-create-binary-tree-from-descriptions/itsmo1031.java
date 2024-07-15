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
	static Map<Integer, TreeNode> map;

	public TreeNode createBinaryTree(int[][] descriptions) {
		map = new HashMap<>();
		Set<Integer> childs = new HashSet<>();

		for (int[] desc : descriptions) {
			int parent = desc[0];
			int child = desc[1];
			boolean isLeft = desc[2] == 1;

			childs.add(child);

			TreeNode parentNode = getNode(parent);
			TreeNode childNode = getNode(child);

			if (isLeft) {
				parentNode.left = childNode;
			} else {
				parentNode.right = childNode;
			}
		}

		for (TreeNode node : map.values()) {
			if (!childs.contains(node.val)) {
				return node;
			}
		}

		return null;
	}

	static TreeNode getNode(int key) {
		if (!map.containsKey(key)) {
			TreeNode res = new TreeNode(key);
			map.put(key, res);
			return res;
		}
		return map.get(key);
	}
}
