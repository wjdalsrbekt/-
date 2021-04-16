import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_7576_토마토 {
	static int[][] arr;
	static int n, m;
	static Queue<node> q = new LinkedList<>();
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1)
					q.offer(new node(i, j));
			}
		}
		bfs();
		int max = 0;
		boolean flag = false;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 0) {
					flag = true;
					break;
				}
				max = max > arr[i][j] ? max : arr[i][j];
			}
		}
		int[][] arr2=arr;
		if (flag)
			System.out.println(-1);
		else
			System.out.println(max-1);
	}

	static void bfs() {
		while (!q.isEmpty()) {
			node note = new node();
			note = q.poll();
			for (int i = 0; i < 4; i++) {
				int tmpy = note.y + dy[i];
				int tmpx = note.x + dx[i];
				if (tmpy >= 0 && tmpy < m && tmpx >= 0 && tmpx < n && arr[tmpy][tmpx] == 0) {
					arr[tmpy][tmpx] = arr[note.y][note.x] + 1;
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

		public node() {
		}

	}
}
