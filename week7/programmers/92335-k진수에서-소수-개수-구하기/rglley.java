class Solution {
    String convert(int num, int numeral) {
        int power = 0;
        while(Math.pow(numeral, power) <= num) {
            power++;
        }
        power--;
        
        StringBuilder result = new StringBuilder();
        int tmp = num;
        while(power >= 0) {
            result.append(tmp / (int) Math.pow(numeral, power));
            tmp %= (int) Math.pow(numeral, power);
            power--;
        }
        
        return result.toString();
    }
    
    int getPrime(String convertedNum) {
        int result = 0;
        
        String[] numArr = convertedNum.split("0+");
        for(String num : numArr) {
            if(!num.equals("") && isPrime(Long.valueOf(num)))   //진수 변환 값 Integer 벗어날 수 있음
                result++;
        }
        
        return result;
    }
    
    boolean isPrime(long num) { //진수 변환 값 Integer 벗어날 수 있음
        if(num <= 1)
            return false;
        
        for(int divideNum = 2; divideNum <= Math.sqrt(num); divideNum++) {
            if(num % divideNum == 0)
                return false;
        }
        
        return true;
    }
    
    
    public int solution(int n, int k) {
        String num = convert(n, k);
        return getPrime(num);
    }
}