class Solution {
    String convert(int numeral, int num) {
        if (num == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        int power = 1;
        while (Math.pow(numeral, power) <= num) {
            power++;
        }
        power--;
        
        int tmp = num;
        while (power >= 0) {
            int divideNum = (int) Math.pow(numeral, power);
            int value = tmp / divideNum;

            if (value >= 10) {
                result.append((char) ('A' + value - 10));
            } else {
                result.append(value);
            }

            tmp %= divideNum;
            power--;
        }

        return result.toString();
    }
    
    public String solution(int n, int t, int m, int p) {
        int num = 0;
        int maxLength = m * t;
        StringBuilder numSb = new StringBuilder();
        while(numSb.length() < maxLength) {
            numSb.append(convert(n, num));
            num++;
        }
        
        StringBuilder answer = new StringBuilder();
        int index = p - 1;
        int count = 1;
        while (count <= t) {
            answer.append(numSb.charAt(index));
            count++;
            index += m;
        }
        
        return answer.toString();
    }
}