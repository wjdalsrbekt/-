import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_17779_게리맨더링2 {
	static int N;
	static int[][] map;
	static int sum = 0;
	static int min = 999999;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				sum += map[i][j];
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int d1 = 1; d1 < N; d1++) {
					for (int d2 = 1; d2 < N; d2++) {
						if (i + d1 + d2 > N)
							continue;
						if (j - d1 < 1 || j + d2 > N)
							continue;
						findMap(i, j, d1, d2);
					}
				}
			}
		}
		System.out.println(min);
	}

	static void findMap(int x, int y, int d1, int d2) {
		boolean[][] findborder = new boolean[N + 1][N + 1];
		int[] people = new int[5];
		for (int i = 0; i <= d1; i++) {
			findborder[x + i][y - i] = true; // 1번경계선
			findborder[x + d2 + i][y + d2 - i] = true; // 4번경계
		}
		for (int i = 0; i <= d2; i++) {
			findborder[x + i][y + i] = true; // 2번경계선
			findborder[x + d1 + i][y - d1 + i] = true; // 3번경계선
		}
		// 인구찾기
		for (int i = 0; i < x + d1; i++) { // 1
			for (int j = 0; j <= y; j++) {
				if (findborder[i][j] == true)
					break;
				people[0] += map[i][j];
			}
		}
		for (int i = 0; i <= x + d2; i++) { // 2
			for (int j = N - 1; j > y; j--) {
				if (findborder[i][j] == true)
					break;
				people[1] += map[i][j];
			}
		}
		for (int i = x + d1; i < N; i++) { // 3
			for (int j = 0; j < y - d1 + d2; j++) {
				if (findborder[i][j] == true)
					break;
				people[2] += map[i][j];
			}
		}
		for (int i = x + d2 + 1; i < N; i++) {// 4
			for (int j = N - 1; j >= y - d1 + d2; j--) {
				if (findborder[i][j] == true)
					break;
				people[3] += map[i][j];
			}
		}
		people[4] = sum;
		int tmp = 0;
		for (int i = 0; i < 4; i++) {
			tmp += people[i];
		}
		people[4] -= tmp;
		Arrays.sort(people);
		min = Math.min(min, people[4] - people[0]);
	}
}
