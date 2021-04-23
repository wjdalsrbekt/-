import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 백준_1194_달이차오른다가자 {
	static char[][] map;
	static int R, C;
	static int[] di = { 1, -1, 0, 0 };
	static int[] dj = { 0, 0, 1, -1 };
	static Point start;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] RC = br.readLine().split(" ");
		R = Integer.parseInt(RC[0]);
		C = Integer.parseInt(RC[1]);

		map = new char[R][];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '0') {
					start = new Point(i, j, 0);
					map[i][j] = '.';
				}
			}
		}
		System.out.println(bfs());
	}

	private static int bfs() {
		int ans = 0;
		Queue<Point> queue = new LinkedList<>();
		boolean[][][] visit = new boolean[R][C][1 << 6];// a0,b1,c2,d3,e4,f5;
		queue.add(start);
		visit[start.i][start.j][0] = true;// 키없는 상태
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Point now = queue.poll();

				for (int d = 0; d < 4; d++) {
					int ni = now.i + di[d];
					int nj = now.j + dj[d];

					if (isIn(ni, nj) && !visit[ni][nj][now.key]) {
						if (map[ni][nj] == '.') {
							queue.add(new Point(ni, nj, now.key));
							visit[ni][nj][now.key] = true;
						} else if (map[ni][nj] >= 'a' && map[ni][nj] <= 'f') { // 키획득
							int newKey = now.key | (1 << (map[ni][nj] - 'a'));
							queue.add(new Point(ni, nj, newKey));
							visit[ni][nj][newKey] = true;
						} else if (map[ni][nj] >= 'A' && map[ni][nj] <= 'F'
								&& (1 << (map[ni][nj] - 'A') & now.key) > 0) { // 문 열수 있나 체크
							queue.add(new Point(ni, nj, now.key));
							visit[ni][nj][now.key] = true;
						} else if (map[ni][nj] == '1') {
							return ans + 1;
						}
					}
				}
			}
			ans++;
		}
		return -1;
	}

	static boolean isIn(int i, int j) {
		if (i >= 0 && i < R && j >= 0 && j < C)
			return true;
		return false;
	}

	static class Point {
		int i, j;
		int key; // 5-> 000101 ->a,c

		Point(int i, int j, int key) {
			this.i = i;
			this.j = j;
			this.key = key;
		}
	}
}
