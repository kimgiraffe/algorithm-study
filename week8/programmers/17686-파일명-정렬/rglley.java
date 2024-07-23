import java.util.*;

class Solution {
    String[] seperate(String name) {
        int numIdx = -1;
        int tailIdx = name.length();    //tail은 빈 문자열일 수 있음
        boolean numFinded = false;
        for (int chIdx = 0; chIdx < name.length(); chIdx++) {
            char ch = name.charAt(chIdx);
            if (Character.isDigit(ch) && !numFinded) {
                numFinded = true;
                numIdx = chIdx;
            }
            
            if (numFinded && !Character.isDigit(ch)) {
                tailIdx = chIdx;
                break;
            }
        }
        
        return new String[]{
            name.substring(0, numIdx),
            name.substring(numIdx, tailIdx),
            name.substring(tailIdx)
        };
    }

    public String[] solution(String[] files) {
        Name[] nameArr = new Name[files.length];
        int nameIdx = 0;
        for (String name : files) {
            String[] seperatedName = seperate(name);
            nameArr[nameIdx++] = new Name(seperatedName[0], seperatedName[1], seperatedName[2]);
        }

        Arrays.sort(nameArr, (name1, name2) -> {
            int compare = name1.head.toLowerCase().compareTo(name2.head.toLowerCase());
            
            if (compare == 0) {
                return Integer.compare(Integer.parseInt(name1.number), Integer.parseInt(name2.number));
            }
            return compare;
        });

        String[] answer = new String[files.length];
        int idx = 0;
        for (Name name : nameArr) {
            answer[idx++] = name.head + name.number + name.tail;
        }

        return answer;
    }
}

class Name {
    String head;
    String number;
    String tail;

    public Name(String head, String number, String tail) {
        this.head = head;
        this.number = number;
        this.tail = tail;
    }
}
