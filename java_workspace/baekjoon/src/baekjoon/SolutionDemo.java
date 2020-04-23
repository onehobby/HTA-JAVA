package baekjoon;

public class SolutionDemo {
	public long[] solution(int x, int n) {
		long[] answer = {};

		if(x > 0) {
            int ax = x;
			long[] a = new long[n];
			for(int i=0; i<n; i++) {
				a[i] = x;
				x += ax;
			}
			answer = a;
		} else if(x < 0) {
            int ax = -x;
			long[] a = new long[n];
			for(int i=0; i<n; i++) {
				a[i] = x;
				x -= ax;
			}
			answer = a;
		}
		return answer;
	}
}

