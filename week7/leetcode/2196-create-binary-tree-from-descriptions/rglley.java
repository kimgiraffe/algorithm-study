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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> childSet = new HashSet<>();
        for (int[] info : descriptions) {
            int parentVal = info[0];
            int childVal = info[1];
            int isLeft = info[2];

            if(!nodeMap.containsKey(parentVal)) {
                nodeMap.put(parentVal, new TreeNode(parentVal));
            }

            if(!nodeMap.containsKey(childVal)) {
                nodeMap.put(childVal, new TreeNode(childVal));
            }

            childSet.add(childVal);

            if (isLeft == 1) {
                nodeMap.get(parentVal).left = nodeMap.get(childVal);
            } else {
                nodeMap.get(parentVal).right = nodeMap.get(childVal);
            }
        }

        int rootVal = 0;
        for (int[] info : descriptions) {
            if (!childSet.contains(info[0])) {
                rootVal = info[0];
            }
        }

        return nodeMap.get(rootVal); 
    }
}