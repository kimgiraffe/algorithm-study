class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int numIdx = 0; numIdx < numbers.length; numIdx++) {
            long result = numbers[numIdx];
            String target = Long.toBinaryString(numbers[numIdx]);
            
            if (result % 2 == 0) {
                answer[numIdx] = result + 1;
            } else {
                int lastZeroIdx = target.lastIndexOf("0");
                
                if (lastZeroIdx == -1) {
                    String tmp = "10" + target.substring(1, target.length());
                    answer[numIdx] = Long.valueOf(tmp, 2);
                } else {
                    String tmp = target.substring(0, lastZeroIdx) + "10" + target.substring(lastZeroIdx + 2, target.length());
                    answer[numIdx] = Long.valueOf(tmp, 2);
                }
            }
        }
        
        return answer;
    }
}
