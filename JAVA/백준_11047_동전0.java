import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_11047_동전0 {
	static int N, K;
	static int[] coin;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		coin=new int[N];
		for (int i = N - 1; i >= 0; i--) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		Cal();
		System.out.println(ans);
	}

	static void Cal() {
		int tmp = K;
		for (int i = 0; i < N; i++) {
			if (tmp / coin[i] == 0)
				continue;
			ans += tmp / coin[i];
			tmp %= coin[i];
			if (tmp == 0)
				break;
		}
	}

}
