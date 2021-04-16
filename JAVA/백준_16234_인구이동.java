import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_16234_인구이동 {
	static int n, l, r;
	static int[][] arr;
	static int[][] arr2;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static Queue<country> queue = new LinkedList<>();
	static int idx;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		arr2 = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		while (true) {
			arr2 = new int[n][n];
			idx = 1;
			cnt++;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr2[i][j] == 0) {
						for (int k = 0; k < 4; k++) {
							int tmpi = i + dy[k];
							int tmpj = j + dx[k];
							if (tmpi >= 0 && tmpi < n && tmpj >= 0 && tmpj < n&&arr2[i][j] == 0) {
								int tmp = Math.abs(arr[i][j] - arr[tmpi][tmpj]);
								if (tmp >= l && tmp <= r) {
									queue.offer(new country(i, j));
									bfs();
									break;
								}
							}
						}
					}
				}
			}
			if(idx==1)
				break;
			make();
		}
		System.out.println(cnt-1);
	}

	static void make() {
		int[] plus = new int[idx];
		int[] cnt = new int[idx];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr2[i][j] != 0) {
					cnt[arr2[i][j]] += 1;
					plus[arr2[i][j]] += arr[i][j];
				}
			}
		}
		for (int k = 1; k < idx; k++) {
			plus[k] = plus[k] / cnt[k];
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr2[i][j] != 0) {
					arr[i][j] = plus[arr2[i][j]];
				}
			}
		}
	}

	static void bfs() {
		while (!queue.isEmpty()) {
			country c = new country(queue.peek().y, queue.peek().x);
			queue.poll();
			arr2[c.y][c.x] = idx;
			for (int k = 0; k < 4; k++) {
				int tmpi = c.y + dy[k];
				int tmpj = c.x + dx[k];
				if (tmpi >= 0 && tmpi < n && tmpj >= 0 && tmpj < n) {
					int tmp = Math.abs(arr[c.y][c.x] - arr[tmpi][tmpj]);
					if (tmp >= l && tmp <= r && arr2[tmpi][tmpj] == 0) {
						queue.offer(new country(tmpi, tmpj));
					}
				}
			}
		}
		idx++;
	}



	static class country {
		int y;
		int x;

		public country(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}

}
