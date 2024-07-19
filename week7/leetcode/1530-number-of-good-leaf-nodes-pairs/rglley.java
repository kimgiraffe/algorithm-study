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
    int result = 0;
    //거리별 노드 수 저장
    int[] dfs(TreeNode node, int distance) {
        if (node == null) 
            return new int[distance + 1];

        if (node.left == null && node.right == null) {
            int[] leafDistance = new int[distance + 1];
            leafDistance[1] = 1; // 리프 노드는 거리 1
            return leafDistance;
        }

        int[] leftDistance = dfs(node.left, distance);
        int[] rightDistance = dfs(node.right, distance);

        for (int leftIdx = 1; leftIdx <= distance; leftIdx++) {
            for (int rightIdx = 1; rightIdx <= distance; rightIdx++) {
                if (leftIdx + rightIdx <= distance) {   //거리 내 쌍의 수 계산
                    result += leftDistance[leftIdx] * rightDistance[rightIdx];
                }
            }
        }

        //현재 노드 거리 배열 생성
        int[] currentDistance = new int[distance + 1];
        for (int distanceIdx = 1; distanceIdx < distance; distanceIdx++) {
            currentDistance[distanceIdx + 1] = leftDistance[distanceIdx] + rightDistance[distanceIdx];
        }

        return currentDistance;
    }

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return result;
    }
}