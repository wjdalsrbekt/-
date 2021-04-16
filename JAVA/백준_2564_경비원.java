import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_2564_경비원 {
	static int[][] map;
	static int w, h, n;
	static boolean[][] visit;
	static node[] store;
	static Queue<nod> q = new LinkedList<>();
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(br.readLine());
		map = new int[h + 1][w + 1];
		visit = new boolean[h + 1][w + 1];
		for (int i = 1; i < h; i++) {
			for (int j = 1; j < w; j++) {
				visit[i][j] = true;
			}
		}
		store = new node[n + 1];
		for (int i = 0; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			store[i] = new node();
			store[i].dir = Integer.parseInt(st.nextToken());
			store[i].where = Integer.parseInt(st.nextToken());
			place(i);
		}
		nod tmp = new nod();
		tmp.y = store[n].y;
		tmp.x = store[n].x;
		q.offer(tmp);
		visit[tmp.y][tmp.x] = true;
		bfs();
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			cnt += map[store[i].y][store[i].x];
		}
		System.out.println(cnt);
	}

	static void bfs() {
		while (!q.isEmpty()) {
			nod pre = q.poll();

			for (int i = 0; i < 4; i++) {
				int tmpx = pre.x + dx[i];
				int tmpy = pre.y + dy[i];
				if (tmpy >= 0 && tmpy <= h && tmpx >= 0 && tmpx <= w && visit[tmpy][tmpx] == false) {
					visit[tmpy][tmpx] = true;
					map[tmpy][tmpx] = map[pre.y][pre.x] + 1;
					q.offer(new nod(tmpy, tmpx));
				}
			}
		}
	}

	static void place(int i) {
		if (store[i].dir == 1) {
			store[i].y = 0;
			store[i].x = store[i].where;
		} else if (store[i].dir == 2) {
			store[i].y = h;
			store[i].x = store[i].where;
		} else if (store[i].dir == 3) {
			store[i].x = 0;
			store[i].y = store[i].where;
		} else if (store[i].dir == 4) {
			store[i].x = w;
			store[i].y = store[i].where;
		}
	}

	static class nod {
		int y;
		int x;

		nod() {
		}

		public nod(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static class node {
		int dir;
		int where;
		int y;
		int x;

		node() {
		}
	}
}
