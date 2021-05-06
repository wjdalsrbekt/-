import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_2609_최대공약수와최소공배수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int tmp = M < N ? M : N;
		int tmp2 = tmp;
		int rest = 1;
		boolean flag = true;
		int M2 = 1;
		int N2 = 1;
		while (flag) {
			if (M % tmp2 == 0 && N % tmp2 == 0) {
				M2 = M / tmp2;
				N2 = N / tmp2;
				flag = false;
			} else {
				rest += 1;
				while ((tmp % rest) != 0) {
					rest += 1;
				}
				tmp2 = tmp / rest;
			}
		}
		System.out.println(tmp2);
		System.out.println(M2 * N2 * tmp2);
	}
}
