import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_14501_퇴사 {
	static int[][] arr;
	static boolean[] visit;
	static int n;
	static int max = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n][2];
		visit = new boolean[n];
		for (int k = 0; k < n; k++) {
			st = new StringTokenizer(br.readLine());
			arr[k][0] = Integer.parseInt(st.nextToken());
			arr[k][1] = Integer.parseInt(st.nextToken());
		}
		find_ans(0, 0);
		System.out.println(max);
	}

	static void find_ans(int start, int cnt_day) {
		for (int i = start; i < n; i++) {
			if (!visit[i] && cnt_day + arr[i][0] < n + 1 && i + arr[i][0] < n + 1) {
				visit[i] = true;
				find_ans(i + arr[i][0], cnt_day + arr[i][0]);
				visit[i] = false;
			}
		}
		int tmp = 0;
		for (int i = 0; i < n; i++) {
			if (visit[i]) {
				tmp += arr[i][1];
			}
		}
		max = max > tmp ? max : tmp;
		return;
	}
}
