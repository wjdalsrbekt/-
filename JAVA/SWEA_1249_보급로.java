import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1249_보급로 {
	static int k;
	static int[][] map;
	static int[][] dp;
	static Queue<node> q;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		String s;
		for (int p = 1; p <= tc; p++) {
			k = Integer.parseInt(br.readLine());
			map = new int[k][k];
			dp = new int[k][k];
			for (int i = 0; i < k; i++) {
				s = br.readLine();
				for (int j = 0; j < k; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}
			for (int i = 0; i < k; i++)
				Arrays.fill(dp[i], Integer.MAX_VALUE - 1);
			dp[0][0] = 0;
			q = new LinkedList<>();
			q.offer(new node(0, 0));
			bfs();
			System.out.println("#"+p+" "+dp[k - 1][k - 1]);
		}
	}

	static void bfs() {
		while (!q.isEmpty()) {
			node pre = q.poll();

			for (int i = 0; i < 4; i++) {
				int tmpy = pre.y + dy[i];
				int tmpx = pre.x + dx[i];
				if (tmpy >= 0 && tmpy < k && tmpx >= 0 && tmpx < k
						&& dp[tmpy][tmpx] > dp[pre.y][pre.x] + map[tmpy][tmpx]) {
					dp[tmpy][tmpx] = dp[pre.y][pre.x] + map[tmpy][tmpx];
//					if (tmpy == k - 1 && tmpx == k - 1)
//						return;
					q.offer(new node(tmpy, tmpx));
				}
			}
		}
	}

	static class node {
		int y, x;

		node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
