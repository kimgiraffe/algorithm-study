/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<TreeNode> nodeList = new ArrayList<>();
    Set<Integer> deleteSet = new HashSet<>();

    TreeNode deleteNode(TreeNode node) {
        if (node == null) {
            return null;
        }

        node.left = deleteNode(node.left);
        node.right = deleteNode(node.right);

        if (deleteSet.contains(node.val)) {
            if (node.left != null) {
                nodeList.add(node.left);
            }
            if (node.right != null) {
                nodeList.add(node.right);
            }
            return null;
        }

        return node;
    }
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int num : to_delete) {
            deleteSet.add(num);
        }
        
        if (!deleteSet.contains(root.val)) {
            nodeList.add(root);
        }
        
        deleteNode(root);
        return nodeList;
    }
}