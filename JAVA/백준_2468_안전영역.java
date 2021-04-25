package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_2468_안전영역 {
	static int N;
	static int[][] map;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int max = 0;
//	static int min = 101;
	static boolean[][] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
//				min = min < map[i][j] ? min : map[i][j];
				max = max > map[i][j] ? max : map[i][j];
			}
		}
		int ans = 0;
		for (int k = 0; k <= max; k++) {
			visit = new boolean[N][N];
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > k && visit[i][j] != true) {
						bfs(k, i, j);
						cnt += 1;
					}
				}
			}
			ans = ans > cnt ? ans : cnt;
		}
		System.out.println(ans);

	}

	static void bfs(int k, int i, int j) {
		Queue<Node> q = new LinkedList<>();
		visit[i][j] = true;
		q.offer(new Node(i, j));
		while (!q.isEmpty()) {
			Node per = q.poll();
			int y = per.y;
			int x = per.x;
			for (int m = 0; m < 4; m++) {
				int tmpy = y + dy[m];
				int tmpx = x + dx[m];
				if (tmpy >= 0 && tmpy < N && tmpx >= 0 && tmpx < N && visit[tmpy][tmpx] != true
						&& map[tmpy][tmpx] > k) {
					visit[tmpy][tmpx] = true;
					q.offer(new Node(tmpy, tmpx));
				}
			}
		}
	}

	static class Node {
		int y;
		int x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}
}
