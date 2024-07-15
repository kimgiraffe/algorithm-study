class Solution {
	public int minOperations(String[] logs) {
		int step = 0;

		for (String log : logs) {
			if ("../".equals(log)) {
				if (step > 0) {
					step--;
				}
			} else if (!"./".equals(log)) {
				step++;
			}
		}

		return step;
	}
}
