import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3307_최장증가부분수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int k = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= k; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int[] arr2 = new int[n];

			for (int i = 0; i < n; i++) {
				arr2[i] = 1;
				for (int j = 0; j < i; j++) {
					if (arr[i] > arr[j]) {
						arr2[i] = Math.max(arr2[i], arr2[j] + 1);
					}
				}
			}
			int ans = 0;
			for (int i = 0; i < n; i++) {
				ans = Math.max(ans, arr2[i]);
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
