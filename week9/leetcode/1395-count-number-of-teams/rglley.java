class Solution {
    public int numTeams(int[] rating) {
        int answer = 0;
        for(int idx = 1; idx < rating.length - 1; idx++) {
            int standard = rating[idx];

            int leftLess = 0;
            int leftGreater = 0;
            int rightLess = 0;
            int rightGreater = 0;
            for(int leftIdx = 0; leftIdx < idx; leftIdx++) {
                if(standard > rating[leftIdx])
                    leftLess++;
                else
                    leftGreater++;
            }    

            for(int rightIdx = idx + 1; rightIdx < rating.length; rightIdx++) {
                if(standard > rating[rightIdx])
                    rightLess++;
                else
                    rightGreater++;
            }

            answer += leftLess * rightGreater + leftGreater * rightLess;
        }

        return answer;
    }
}
