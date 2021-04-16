import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_15961_회전초밥 {
	static int N, d, k, c;
	static int[] plate;
	static int[] check;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		plate = new int[N];
		check = new int[d + 1];

		for (int i = 0; i < N; i++) {
			plate[i] = Integer.parseInt(br.readLine());
		}
		find();
		System.out.println(ans);
	}

	static void find() {
		int total = 0;
		for (int i = 0; i < k; i++) {
			if (check[plate[i]] == 0)
				total += 1;
			check[plate[i]] += 1;
		}
		ans = total; // 중복되지않는 최대의스시수

		for (int i = 1; i < N; i++) {
			if (ans <= total) {
				if (check[c] == 0) // 최대음식수 쿠폰에 포함되어잇지않을때.
					ans = total + 1;
				else
					ans = total;
			}
			check[plate[i - 1]] -= 1;// 한개씩 이동 제외
			if (check[plate[i - 1]] == 0)
				total -= 1;
			if (check[plate[(i + k - 1) % N]] == 0)
				total += 1;
			check[plate[(i + k - 1) % N]] += 1; // 새로운것 추가
		}
	}
}
