class Solution {
    boolean[] nodeArr;

    int possible(int from, int to, boolean isDummy) {
        int mid = (from + to) / 2;
        if (isDummy && nodeArr[mid]) { //루트가 0이면 자식노드들에서 1이 나오면 안됨
            return 0;
        }

        // 내가 마지막 노드가 아니면 재귀
        if (from != to) {
            int left = possible(from, mid - 1, !nodeArr[mid]); // 왼쪽 서브트리
            int right = possible(mid + 1, to, !nodeArr[mid]); // 오른쪽 서브트리
            return left & right; // 왼쪽 모두 1이어야 1 반환
        }

        return 1; // 조건을 만족하면 1 반환
    }

    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for (int numIdx = 0; numIdx < numbers.length; numIdx++) {
            String tmpTree = Long.toBinaryString(numbers[numIdx]);

            int length = tmpTree.length();
            int height = 1;
            while (Math.pow(2, height) - 1 < length) {
                height++;
            }
            int treeSize = (int) Math.pow(2, height) - 1; // 포화 이진트리 크기 = 2^h - 1

            nodeArr = new boolean[treeSize];
            int idx = treeSize - length;
            for (int charIdx = 0; charIdx < length; charIdx++) {
                nodeArr[idx++] = tmpTree.charAt(charIdx) == '1';
            }

            int result = possible(0, treeSize - 1, false);
            answer[numIdx] = result;
        }

        return answer;
    }
}
