import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> cntMap = new HashMap<>();

        for (int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((num1, num2) -> {
            int freq1 = cntMap.get(num1);
            int freq2 = cntMap.get(num2);

            if (freq1 == freq2) {
                return num2 - num1; 
            } else {
                return freq1 - freq2; 
            }
        });

        for (int num : nums) {
            pq.offer(num);
        }

        int[] answer = new int[nums.length];
        int idx = 0;
        while (!pq.isEmpty()) {
            answer[idx++] = pq.poll();
        }

        return answer;
    }
}
