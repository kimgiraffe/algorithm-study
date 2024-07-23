import java.util.*;

class Solution {
	static class Person implements Comparable<Person> {
		String name;
		int height;

		public Person(String name, int height) {
			this.name = name;
			this.height = height;
		}

		@Override
		public int compareTo(Person p) {
			return Integer.compare(p.height, this.height);
		}
	}

	public String[] sortPeople(String[] names, int[] heights) {
		Queue<Person> q = new PriorityQueue<>();

		for (int i = 0; i < names.length; i++) {
			q.offer(new Person(names[i], heights[i]));
		}

		String[] answer = new String[names.length];
		int idx = 0;

		while (!q.isEmpty()) {
			answer[idx++] = q.poll().name;
		}

		return answer;
	}
}
