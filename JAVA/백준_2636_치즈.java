import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_2636_치즈 {
	static int[][] arr;
	static int time;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static boolean[][] hole_arr;
	static boolean[][] visit;
	static Queue<node> q;
	static int n, m;

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
		int tmp = 0;
		int tmp1 = 0;
		tmp = check();
		tmp1 = tmp;
		while (tmp != 0) {
			basic();
			hole();
			melt();
			tmp1 = tmp;
			tmp = check();
		}
		System.out.println(time);
		System.out.println(tmp1);
	}

	static int check() {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1) {
					cnt += 1;
				}
			}
		}
		return cnt;
	}

	static void basic() {
		hole_arr = new boolean[n][m];
		visit = new boolean[n][m];
		q = new LinkedList<node>();
		for (int i = 0; i < m; i++) {
			hole_arr[0][i] = true;
			hole_arr[n - 1][i] = true;
		}
		for (int i = 0; i < n; i++) {
			hole_arr[i][0] = true;
			hole_arr[i][m - 1] = true;
		}

	}

	static void melt() {
		time += 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1) {
					boolean flag = false;
					for (int k = 0; k < 4; k++) {
						int tmpi = i + dy[k];
						int tmpj = j + dx[k];
						if (hole_arr[tmpi][tmpj] == true) {
							flag = true;
							break;
						}
					}
					if (flag == true) {
						arr[i][j] = 0;
					}
				}
			}
		}
	}

	static void hole() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0 && hole_arr[i][j] == true && visit[i][j] == false) {
					q.offer(new node(i, j));
					visit[i][j] = true;
					hole_bfs();
				}
			}
		}
	}

	static void hole_bfs() {
		while (!q.isEmpty()) {
			int y = q.peek().y;
			int x = q.peek().x;
			q.poll();
			for (int i = 0; i < 4; i++) {
				int tmpy = y + dy[i];
				int tmpx = x + dx[i];
				if (tmpy >= 0 && tmpx >= 0 && tmpy < n && tmpx < m && arr[tmpy][tmpx] == 0
						&& visit[tmpy][tmpx] == false) {
					visit[tmpy][tmpx] = true;
					hole_arr[tmpy][tmpx] = true;
					q.offer(new node(tmpy, tmpx));
				}
			}
		}
	}

	static class node {
		int y;
		int x;

		public node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
