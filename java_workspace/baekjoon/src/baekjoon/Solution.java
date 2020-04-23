package baekjoon;

class Solution {
	public double solution(int[] arr) {
		double answer = 0;
		int result = 0;
		for(int a : arr) {
			result += a;
		}
		answer = (double)(result / arr.length);
		return answer;
	}
}
