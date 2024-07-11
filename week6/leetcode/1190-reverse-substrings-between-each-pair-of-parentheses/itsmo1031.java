import java.util.*;

class Solution {
	static Deque<Character> q;

	public String reverseParentheses(String s) {
		q = new ArrayDeque<>();

		for (char c : s.toCharArray()) {
			if (c == ')') {
				flip();
			} else {
				q.offerLast(c);
			}
		}

		return print();
	}

	static void flip() {
		Deque<Character> temp = new ArrayDeque<>();

		char next;
		while ((next = q.pollLast()) != '(') {
			temp.offerLast(next);
		}

		while (!temp.isEmpty()) {
			q.offerLast(temp.pollFirst());
		}
	}

	static String print() {
		StringBuilder sb = new StringBuilder();

		for (char c : q) {
			sb.append(c);
		}

		return sb.toString();
	}
}
