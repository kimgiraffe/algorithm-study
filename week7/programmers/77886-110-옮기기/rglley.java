import java.util.*;

class Solution {
    String move(String s){
        StringBuilder result = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        
        for(int charIdx = 0; charIdx < s.length(); charIdx++){
            char ch = s.charAt(charIdx);
            
            //110추출
            if(result.length() >= 2 && ch =='0' && result.charAt(result.length()-2)=='1' && result.charAt(result.length()-1)=='1'){
                tmp.append("110");
                result.delete(result.length() - 2, result.length());
            } else{
                result.append(ch);
            }
        }
        
        if(tmp.length() > 0){
            if(result.indexOf("0") == -1){  //0이 없으면 맨 앞으로
                result.insert(0, tmp);
            }
            else{   //0이 있으면 0 뒤로
                result.insert(result.lastIndexOf("0") + 1, tmp);
            }
        }
        
        return result.toString();
    }
    
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for(int strIdx = 0; strIdx < s.length; strIdx++){
            String result = move(s[strIdx]);   
            answer[strIdx] = result;
        }
        
        return answer;
    }   
}
