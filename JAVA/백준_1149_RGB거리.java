import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1149_RGB거리 {
	static int[][] arr;
	static int[][] d;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		arr = new int[n + 1][n];
		d = new int[n + 1][n];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i <= n; i++) {
			d[i][0] = Math.min(d[i - 1][1], d[i - 1][2]) + arr[i][0];
			d[i][1] = Math.min(d[i - 1][0], d[i - 1][2]) + arr[i][1];
			d[i][2] = Math.min(d[i - 1][0], d[i - 1][1]) + arr[i][2];
		}
		int ans = Math.min(Math.min(d[n][0], d[n][1]), d[n][2]);
		System.out.println(ans);
	}
}
