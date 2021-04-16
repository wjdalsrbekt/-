import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Codeforces_0326_A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			double x = Double.parseDouble(st.nextToken());
			cal_num(n, m, x - 1);
		}
	}

	static void cal_num(int n, int m, double x) {
		double tmp1 = (int) (x / n);
		double tmp2 = (x % n);

		double tmp3 = tmp2 * m + tmp1 + 1;
		System.out.println(Math.round(tmp3));
	}

}

