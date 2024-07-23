import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int lastValue = 1; 
        HashMap<String, Integer> dictionary = new HashMap<>();
        for(char ch = 'A'; ch <= 'Z'; ch++){
            dictionary.put(ch + "", lastValue++);
        }
        
        List<Integer> answer = new ArrayList<>();
        int charIdx = 0;
        while (charIdx < msg.length()) {
            int expandIdx = 1;
            //사전에 없을때까지 확장
            while (charIdx + expandIdx <= msg.length() && dictionary.containsKey(msg.substring(charIdx, charIdx + expandIdx))) {
                expandIdx++;
            }
            
            answer.add(dictionary.get(msg.substring(charIdx, charIdx + expandIdx - 1)));
            
            //사전에 등록
            if (charIdx + expandIdx <= msg.length()) {
                dictionary.put(msg.substring(charIdx, charIdx + expandIdx), lastValue++);
            }

            charIdx += expandIdx - 1;
        }
        
        return answer.stream().mapToInt(num -> num).toArray();
    }
}
