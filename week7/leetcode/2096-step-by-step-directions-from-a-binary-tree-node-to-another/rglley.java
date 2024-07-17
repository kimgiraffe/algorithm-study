import java.util.*;

class Solution {
    //가장 낮은 공통 조상 탐색
    TreeNode findCommonAncestor(TreeNode root, int startVal, int destVal) {
        if(root == null || startVal == root.val || destVal == root.val)
            return root;
    
        TreeNode left = findCommonAncestor(root.left, startVal, destVal);
        TreeNode right = findCommonAncestor(root.right, startVal, destVal);
        
        //좌 우에 startVal, destVal이 있으면 root가 공통 조상
        if (left != null && right != null)
            return root;
        
        //한쪽에만 있다면 존재하는 서브 트리를 반환
        else
            return left == null ? right : left;
    }

    //탐색 노드까지의 경로 DFS(위에서 아래로)
    void getDirection(TreeNode node, int target, List<String> step, List<String> path) {
        if (node == null)
            return;

        if (node.val == target) {
            path.clear(); 
            path.addAll(step); 
            return;
        }

        if (node.left != null) {
            step.add("L");
            getDirection(node.left, target, step, path);
        }

        if (node.right != null) {
            step.add("R");
            getDirection(node.right, target, step, path);
        }

        step.remove(step.size() - 1);
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode ancestor = findCommonAncestor(root, startValue, destValue);

        List<String> toStart = new ArrayList<>();
        getDirection(ancestor, startValue, new ArrayList<String>(), toStart);

        List<String> toDest = new ArrayList<>();
        getDirection(ancestor, destValue, new ArrayList<String>(), toDest);

        StringBuilder answer = new StringBuilder();
        for (int move = 0; move < toStart.size(); move++) {
            answer.append("U");
        }
            
        for (String path : toDest) {
            answer.append(path);
        }

        return answer.toString();
    }
}
