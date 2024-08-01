class Solution {
    public int countSeniors(String[] details) {
        int answer = 0;
        for(String info : details) {
            int age = Integer.valueOf(info.substring(11, 13));

            if(age > 60)
                answer++;
        }

        return answer;
    }
}
