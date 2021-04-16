import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_2589_보물섬 {
	static int m, n;
	static String[] s;
	static int[][] visit;
	static Queue<node> q;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		s = new String[m];
		for (int i = 0; i < m; i++) {
			s[i] = br.readLine();
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (s[i].charAt(j) == 'L') {
					visit = new int[m][n];
					q = new LinkedList<>();
					q.offer(new node(i, j));
					visit[i][j] = 1;
					bfs(i, j);
				}
			}
		}
		System.out.println(max-1);

	}

	static void bfs(int y, int x) {
		int tmp = 0;
		while (!q.isEmpty()) {
			node pre = q.poll();
			for (int i = 0; i < 4; i++) {
				int tmpy = pre.y + dy[i];
				int tmpx = pre.x + dx[i];
				if (tmpy >= 0 && tmpx >= 0 && tmpy < m && tmpx < n && visit[tmpy][tmpx] == 0
						&& s[tmpy].charAt(tmpx) == 'L') {
					visit[tmpy][tmpx] = visit[pre.y][pre.x] + 1;
					tmp = tmp > visit[tmpy][tmpx] ? tmp : visit[tmpy][tmpx];
					q.offer(new node(tmpy, tmpx));
				}
			}
		}
		max = max > tmp ? max : tmp;
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
