import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_14888_연산자끼워넣기 {
	static int N;
	static int[] arr;
	static int[] col = new int[4];
	static int max = -999999;
	static int min = 999999;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			col[i] = Integer.parseInt(st.nextToken());
		}
		dfs(col[0], col[1], col[2], col[3], 1, arr[0]);
		System.out.println(max);
		System.out.println(min);
	}

	static void dfs(int plus, int minus, int mul, int mod, int idx, int sum) {
		if (idx == N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
		}
		if (plus >= 1) {
			dfs(plus - 1, minus, mul, mod, idx + 1, sum + arr[idx]);
		}
		if (minus >= 1) {
			dfs(plus, minus - 1, mul, mod, idx + 1, sum - arr[idx]);
		}
		if (mul >= 1) {
			dfs(plus, minus, mul -1, mod, idx + 1, sum * arr[idx]);
		}
		if (mod >= 1) {
			dfs(plus, minus, mul, mod - 1, idx + 1, sum / arr[idx]);
		}
	}
}
