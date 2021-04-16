import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_17845_수강과목 {
	static schedule[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		arr = new schedule[k + 1];
		for (int i = 1; i <= k; i++) {
			st = new StringTokenizer(br.readLine());
			int import_k = Integer.parseInt(st.nextToken());
			int import_t = Integer.parseInt(st.nextToken());
			arr[i] = new schedule(import_k, import_t);
		}
		int[][] d = new int[k + 1][n + 1]; 
		//knapsack 알고리즘 
		//d[i][j] = 과목 i를 중요도 j인 시간표에 넣었을때, 중요도의 최대값
		int ans = 0;
		for (int i = 1; i <= k; i++) {
			for (int j = 0; j <= n; j++) {
				if (arr[i].time > j) { //현재 과목의 시간이 j보다 큰 경우
					d[i][j] = d[i - 1][j];
					//현재 시간표에 넣을지 고민, 과목의 시간이 시간표가 허용하는 최대 시간이 넘으면, i-1번째 과목을 선택한경우 중 시간이 j인 값 넣기
				} else {
					d[i][j] = Math.max(d[i - 1][j], d[i - 1][j - arr[i].time] + arr[i].imp);
					//현재 시간표의 시간이 j보다 작거나 같은경우
					//d[i][j] = max(d[i-1][j],d[i-1][j-(과목 i의 시간)]+i과목의 중요도))
					//시간표에 과목을 넣을수도 있고, 넣지않을수도 있다.
					//max
				}
				ans = Math.max(ans, d[i][j]);
			}
		}
		System.out.println(ans);
	}

	static class schedule {
		int imp;
		int time;

		public schedule(int imp, int time) {
			this.imp = imp;
			this.time = time;
		}

	}
}
