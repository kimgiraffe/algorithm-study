class Solution {
    Map<Integer, Integer> sortMap = new HashMap<>();
    void map(int num, int[] mapping) {
        String str = num + "";
        StringBuilder result = new StringBuilder();
        for(int chIdx = 0; chIdx < str.length(); chIdx++) {
            result.append(mapping[str.charAt(chIdx) - '0']);
        }

        sortMap.put(num, Integer.valueOf(result.toString()));
    }
    
    public int[] sortJumbled(int[] mapping, int[] nums) {
        for(int num : nums) {
            map(num, mapping);    
        }

        Queue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> {
            int std1 = sortMap.get(arr1[0]);
            int std2 = sortMap.get(arr2[0]);
            if(std1 == std2) {
                return arr1[1] - arr2[1];
            } else {
                return std1 - std2;
            }
        });
        
        for(int numIdx = 0; numIdx < nums.length; numIdx++) {
            pq.offer(new int[]{nums[numIdx], numIdx});    
        }

        int[] answer = new int[nums.length];
        int idx = 0;
        while(!pq.isEmpty()) {
            answer[idx++] = pq.poll()[0];
        }

        return answer;
    }
}