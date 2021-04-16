import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_2531_회전초밥 {
	static int N, d, k, c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int[] plate = new int[N];
		int[] kinds = new int[d+1];
		for (int i = 0; i < N; i++) {
			plate[i] = Integer.parseInt(br.readLine());
		}
		int notOnly;
		int Coupon;
		int ans = 0;
		for (int i = 0; i < N; i++) {
			notOnly = 0;
			Coupon = 1;
			for (int j = i; j < i + k; j++) {
				if (kinds[plate[j % N]] == 0) {
					kinds[plate[j % N]] += 1;
				} // 중복이 아닐시
				else {
					notOnly += 1;
				}
				if (plate[j % N] == c)
					Coupon = 0;
			}
			ans = Math.max(ans, k - notOnly + Coupon);
			Arrays.fill(kinds, 0);
		}
		System.out.println(ans);
	}
}
