import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SWEA_5604_구간합수열 {
	static int T;
	static long A, B, S;
	static HashMap<Long, Long> m = new HashMap<Long, Long>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		m.clear();
		for (int i = 1; i < 17; i++) {
			long v = pow10(0 + i);
			m.put((v - 1), h(v - 1));
		}
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			A = Long.parseLong(st.nextToken());
			B = Long.parseLong(st.nextToken());
			S = cal(B, A);
			System.out.println("#" + i + " " + S);
		}
	}

	public static long h(long n) {
		long len = len(n) + 1L;
		// f(9) 20f(9) 300f(9) 4000f(9)
		return ((45L) * (len) * (1L + n)) / (10L);
	}

	public static long cal(long B, long A) {
		if (A <= 1) {
			return f(B);
		} else if (A == B) {
			return f(B) - f(A - 1); // 버그 수정
		} else {
			return f(B) - f(A - 1);
		}
	}

	public static long g(long n) {
		if (n <= 9) {
			return e(n);
		} else {
			long v = pow10(len(n));
			return (n / v) * (n % v + 1) + f(n % v);
		}
	}

	public static long f(long n) {
		if (m.containsKey(n)) {
			return m.get(n);
		} else if (n <= 9) {
			return e(n);
		} else {
			long v = pow10(len(n));
			m.put(n, f(n - 1 - n % v) + g(n));
			return m.get(n);
		}
	}

	public static long e(long n) {
		return n * (n + 1) / 2;
	}

	public static long len(long n) {
		return 0 + (n + "").length() - 1;
	}

	public static long pow10(long n) {
		return (long) Math.pow(10, n);
	}
}
