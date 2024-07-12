class Solution {
	static String str;

	public int maximumGain(String s, int x, int y) {
		char first = 'a';
		char second = 'b';

		if (x < y) {
			first = 'b';
			second = 'a';
			int temp = x;
			x = y;
			y = temp;
		}

		str = s;
		int answer = 0;

		answer += calc(first, second, x);
		answer += calc(second, first, y);

		return answer;
	}

	static int calc(char first, char second, int score) {
		int result = 0;
		StringBuilder sb;

		sb = new StringBuilder();
		for (char ch : str.toCharArray()) {
			if (ch == second && sb.length() > 0 && sb.charAt(sb.length() - 1) == first) {
				sb.deleteCharAt(sb.length() - 1);
				result += score;
			} else {
				sb.append(ch);
			}
		}
		str = sb.toString();

		return result;
	}
}
