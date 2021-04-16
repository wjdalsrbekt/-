import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_16988_Baaaaaaaaaduk2 {
	static int n, m;
	static int[][] arr;
	static boolean[][] arr2;
	static int max = 0;
	static Queue<baduk> queue = new LinkedList<>();
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		put();
		System.out.println(max);

	}

	static void put() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = 1;
					for (int k = i; k < n; k++) {
						for (int t = 0; t < m; t++) {
							if (arr[k][t] == 0) {
								arr[k][t] = 1;
								kill();
								arr[k][t] = 0;
							}
						}
					}
					arr[i][j] = 0;
				}
			}
		}
	}

	static void kill() {
		arr2 = new boolean[n][m];
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0 && arr2[i][j] != true) {
					check(i, j);
					arr2[i][j] = false;
				}
				if (arr[i][j] == 2)
					cnt += 1;
			}
		}
		int tmp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr2[i][j] == true) {
					tmp++;
				}
			}
		}
		int ans = cnt - tmp;
		max = max > ans ? max : ans;
	}

	static void check(int i, int j) {
		arr2[i][j] = true;

		for (int k = 0; k < 4; k++) {
			int tmpi = i + dy[k];
			int tmpj = j + dx[k];
			if (tmpi >= 0 && tmpj >= 0 && tmpi < n && tmpj < m) {
				if (arr[tmpi][tmpj] == 2 && arr2[tmpi][tmpj] != true) {
					check(tmpi, tmpj);
				}
			}
		}
	}

	static class baduk {
		int y;
		int x;

		public baduk(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}
}
