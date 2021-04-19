import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_5607_조합 {
	static int N, R;
	static final int Q = 1234567891;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int k = 1; k <= T; k++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			System.out.println("#" + k + " " + nCr(N, R, Q));
		}
	}

	static long power(long x, long y, long p) {
		long res = 1;
		x = x % p;
		while (y > 0) {
			if (y % 2 == 1) {
				res = (res * x) % p;
			}
			y = y / 2;
			x = (x * x) % p;
		}
		return res;
	}

	static int nCr(int n, int r, int p) {
		if (r == 0)
			return 1;
		long[] fac = new long[n + 1];
		fac[0] = 1;
		for (int i = 1; i <= n; i++) {
			fac[i] = fac[i - 1] * i % p;
		}
		return (int) ((fac[n] * power(fac[r], p - 2, p) % p * power(fac[n - r], p - 2, p) % p) % p);
	}
}
