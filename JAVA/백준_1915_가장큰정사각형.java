import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1915_가장큰정사각형 {
	static int N, M;
	static String[] arr;
//	static int[][] memory;
	static int ans=0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new String[N];
//		memory = new int[N][M];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		int max = N < M ? N : M;
		StringBuilder sb;
		for (int i = max; i >= 1; i--) {
			sb = new StringBuilder();
			for (int j = 0; j < i; j++)
				sb.append(1);
			String s = sb.toString();
			searchSquare(s, i);
			if (ans != 0) {
				System.out.println(ans);
				return;
			}
		}
	}

	static void searchSquare(String compareString, int num) {
		boolean flag;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				flag = true;
				if (j + num <= M && i + num <= N) {
					for (int k = i; k < i + num; k++) {
						String tmp = arr[k].substring(j, j + num);
						if (!tmp.equals(compareString)) {
							flag = false;
							break;
						}
					}
					if (flag) {
//						memory[i][j] = num * num;
						ans = (int) Math.pow(num, 2);
						return;
					}
				}
			}
		}
	}
}
