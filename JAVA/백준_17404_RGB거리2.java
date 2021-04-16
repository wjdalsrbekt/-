import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_17404_RGB거리2 {
	static int n, pmax, ans;
	static int[][] a, dp;
	static StringTokenizer str;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n][3]; 
		dp = new int[n][3]; 
		for (int i = 0; i < n; i++) {
			str = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				a[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		pmax = 1000 * n + 1; 
		ans = 1000001;
		for (int k = 0; k < 3; k++) {
			for (int i = 0; i < 3; i++) {
				if (i == k)
					dp[0][i] = a[0][i]; 
				else
					dp[0][i] = pmax;
			}
			for (int i = 1; i < n; i++) {
				dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + a[i][0];
				dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + a[i][1];
				dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + a[i][2];
			}
			for (int i = 0; i < 3; i++) {
				if (i == k)
					continue; 
				ans = Math.min(ans, dp[n - 1][i]);
			}
		}
		System.out.println(ans);
	}
}
