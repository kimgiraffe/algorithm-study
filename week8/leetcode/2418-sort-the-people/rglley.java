class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Info[] infoArr = new Info[names.length];
        for(int idx = 0; idx < names.length; idx++) {
            infoArr[idx] = new Info(names[idx], heights[idx]);
        }

        Arrays.sort(infoArr, (o1, o2) -> o2.height - o1.height);
        String[] answer = new String[names.length];
        for(int idx = 0; idx < names.length; idx++) {
            answer[idx] = infoArr[idx].name;
        }

        return answer;
    }
}

class Info {
    String name;
    int height;

    public Info(String name, int height) {
        this.name = name;
        this.height = height;
    }
}