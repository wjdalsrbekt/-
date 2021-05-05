
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_1449_수리공항승 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int pipe[] = new int[1001]; //**--------------------------------------
		int cnt = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			pipe[Integer.parseInt(st.nextToken())] = 1;//<==구멍난 거 표시
		}

		for (int i = 1; i <= 1000; i++) {
			if (pipe[i] != 0) {
				i += L - 1;
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}
