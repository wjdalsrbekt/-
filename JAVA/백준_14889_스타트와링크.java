import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_14889_스타트와링크 {
	static int[][] arr;
	static int min = 999999;
	static boolean[] visit;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new int[n][n];
		visit = new boolean[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		find(0,0);
		System.out.println(min);
	}

	static void find(int cnt, int start) {
		if (cnt == n / 2) {
			cal();
			return;
		}
		if(start>=n)
			return;
		visit[start] = true;
		find(cnt + 1, start + 1);
		visit[start] = false;
		find(cnt, start + 1);
	}

	static void cal() {
		int tmps = 0;
		int tmpl = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i; j < n; j++) {
				if (visit[i] == true && visit[j] == true) {
					tmps += arr[i][j] + arr[j][i];
				} else if (visit[i] == false && visit[j] == false) {
					tmpl += arr[i][j] + arr[j][i];
				}
			}
		}
		int tmp = Math.abs(tmpl - tmps);
		min = min < tmp ? min : tmp;
	}
}
