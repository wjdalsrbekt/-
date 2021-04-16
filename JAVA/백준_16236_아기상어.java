import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_16236_아기상어 {
	static int n;
	static int[][] arr;
	static int[][] arr2;
	static Queue<where> queue = new LinkedList<>();
	static int shark = 2;
	static int cnt = 0;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int time;
	static int fish;
	static where shark_pos = new where();
	static int flag2 = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) {
					queue.offer(new where(i, j));
					shark_pos.x = j;
					shark_pos.y = i;
				} else if (arr[i][j] > 0 && arr[i][j] < 7) {
					fish += 1;
				}
			}
		}
		while (fish > 0 && flag2 == 0) {
			bfs();
		}
		System.out.println(time);

	}

	static void bfs() {
		arr2 = new int[n][n];
		int flag = 0;
		if (!queue.isEmpty()) {
			int ty = queue.peek().y;
			int tx = queue.peek().x;
			arr2[ty][tx] = 1;
		} else {
			flag2 = 1;
			return;
		}
		while (!queue.isEmpty()) {
			int y = queue.peek().y;
			int x = queue.peek().x;
			queue.poll();
			for (int i = 0; i < 4; i++) {
				int tmpy = y + dy[i];
				int tmpx = x + dx[i];
				if (tmpx >= 0 && tmpy >= 0 && tmpx < n && tmpy < n && arr[tmpy][tmpx] <= shark
						&& arr2[tmpy][tmpx] == 0) {
					arr2[tmpy][tmpx] = arr2[y][x] + 1;
					if (arr[tmpy][tmpx] > 0 && arr[tmpy][tmpx] < shark) {
						arr[tmpy][tmpx] = 9;

						arr[shark_pos.y][shark_pos.x] = 0;
						shark_pos.y = tmpy;
						shark_pos.x = tmpx;

						time += arr2[tmpy][tmpx] - 1;
						queue = new LinkedList<>();
						queue.offer(new where(tmpy, tmpx));
						flag = 1;
						fish -= 1;
						break;
					} else if (arr[tmpy][tmpx] == shark) {
						arr[tmpy][tmpx] = 9;
						arr[shark_pos.y][shark_pos.x] = 0;
						shark_pos.y = tmpy;
						shark_pos.x = tmpx;
						time += arr2[tmpy][tmpx] - 1;
						queue = new LinkedList<>();
						queue.offer(new where(tmpy, tmpx));
						cnt += 1;
						fish -= 1;
						if (cnt == shark) {
							shark += 1;
							cnt = 0;
						}
						flag = 1;
						break;
					} else {
						arr[tmpy][tmpx] = 0;
					}
					queue.offer(new where(tmpy, tmpx));
				}
			}
			if (flag == 1)
				break;
		}
	}

	static class where {
		int y;
		int x;

		public where(int y, int x) {
			this.y = y;
			this.x = x;
		}

		public where() {
		}

	}
}
