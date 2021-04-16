import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_15683_감시 {
	static char[][] arr;
	static int n, m;
	static int max;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static Queue<node> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = st.nextToken().charAt(0);
				if (arr[i][j] == '5') {
					q.offer(new node(i, j));
				}
			}
		}
		while (!q.isEmpty()) {
			node per = q.poll();
			for (int i = 0; i < n; i++) {
				if (arr[i][per.x] == '0') {
					arr[i][per.x] = '#';
				}
				if (arr[i][per.x] == '6') {
					break;
				}
			}
			for (int j = 0; j < m; j++) {
				if (arr[per.y][j] == '0')
					arr[per.y][j] = '#';
				if (arr[per.y][j] == '6') {
					break;
				}
			}
		}
		System.out.println(1);
	}

	static void dfs() {
		
	}

	static void cam_one() {
		for (int i = 0; i < 4; i++) {

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
