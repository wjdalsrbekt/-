import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_1600_말이되고픈원숭이 {
	static int[][] arr;
	static int k, w, h;
	static int[][][] visit;
	static Queue<node> q = new LinkedList<>();
	static int[] dy = { 0, -1, 0, 1, -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dx = { -1, 0, 1, 0, -2, -1, 1, 2, -2, -1, 1, 2 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		k = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		arr = new int[h][w];
		visit = new int[k + 1][h][w];
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int a=0;a<=k;a++) {
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					visit[a][i][j]=999999;
				}
			}
		}
		for (int i = 0; i <= k; i++) {
			visit[i][0][0] = 1;
		}
		q.offer(new node(0, 0, k));
		bfs();
	}

	static void bfs() {
		while (!q.isEmpty()) {
			node per = q.poll();
			for (int i = 0; i < 12; i++) {
				int tmpy = per.y + dy[i];
				int tmpx = per.x + dx[i];
				if (tmpy >= 0 && tmpx >= 0 && tmpy < h && tmpx < w && arr[tmpy][tmpx] == 0) {
					if (i < 4 && visit[per.skill][tmpy][tmpx] > visit[per.skill][per.y][per.x] + 1) {
						visit[per.skill][tmpy][tmpx] = visit[per.skill][per.y][per.x] + 1;
						q.offer(new node(tmpy, tmpx, per.skill));
					} else if (i >= 4 && per.skill > 0
							&& visit[per.skill - 1][tmpy][tmpx] > visit[per.skill][per.y][per.x] + 1) {
						visit[per.skill - 1][tmpy][tmpx] = visit[per.skill][per.y][per.x] + 1;
						q.offer(new node(tmpy, tmpx, per.skill - 1));
					}
//					if (i < 4 && visit[per.skill][tmpy][tmpx]==0) {
//						visit[per.skill][tmpy][tmpx] = visit[per.skill][per.y][per.x] + 1;
//						q.offer(new node(tmpy, tmpx, per.skill));
//					} else if (i >= 4 && per.skill > 0
//							&& visit[per.skill - 1][tmpy][tmpx] ==0) {
//						visit[per.skill - 1][tmpy][tmpx] = visit[per.skill][per.y][per.x] + 1;
//						q.offer(new node(tmpy, tmpx, per.skill - 1));
//					}
				}
			}
		}
		int min = 999999;
		for (int i = 0; i <= k; i++) {
			if (visit[i][h - 1][w - 1] != 0)
				min = min < visit[i][h - 1][w - 1] ? min : visit[i][h - 1][w - 1];
		}
		if (min == 999999)
			System.out.println(-1);
		else {
			System.out.println(min-1);
		}
	}

	static class node {
		int y;
		int x;
		int skill;

		public node(int y, int x, int skill) {
			this.y = y;
			this.x = x;
			this.skill = skill;
		}

	}
}
