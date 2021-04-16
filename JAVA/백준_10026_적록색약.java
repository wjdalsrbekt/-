import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 백준_10026_적록색약 {
	static int n;
	static String[] s;

	static Queue<Node> q;
	static Queue<Node> q2;
	static boolean[][] visit;
	static boolean[][] visit2;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int manj;
	static int mans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		s = new String[n];

		for (int i = 0; i < n; i++) {
			s[i] = br.readLine();
		}
		visit = new boolean[n][n];
		visit2 = new boolean[n][n];
		q = new LinkedList<>();
		q2 = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visit[i][j] != true) {
					manj += 1;
					q.offer(new Node(i, j));
					visit[i][j] = true;
					bfs_j();
				}
				if (visit2[i][j] != true) {
					mans += 1;
					q2.offer(new Node(i, j));
					visit2[i][j] = true;
					bfs_s();
				}
			}
		}
		System.out.println(manj+" "+mans);
	}

	static void bfs_j() {

		while (!q.isEmpty()) {
			Node pre = q.poll();
			for (int i = 0; i < 4; i++) {
				int tmpy = pre.y + dy[i];
				int tmpx = pre.x + dx[i];
				if (tmpy >= 0 && tmpy < n && tmpx >= 0 && tmpx < n && visit[tmpy][tmpx] == false
						&& s[pre.y].charAt(pre.x) == s[tmpy].charAt(tmpx)) {
					visit[tmpy][tmpx] = true;
					q.offer(new Node(tmpy, tmpx));
				}
			}
		}
	}

	static void bfs_s() {
		while (!q2.isEmpty()) {
			Node pre2 = q2.poll();
			for (int i = 0; i < 4; i++) {
				int tmpy = pre2.y + dy[i];
				int tmpx = pre2.x + dx[i];
				if (tmpy >= 0 && tmpy < n && tmpx >= 0 && tmpx < n && visit2[tmpy][tmpx] == false) {
					if (s[pre2.y].charAt(pre2.x) == 'B' && s[pre2.y].charAt(pre2.x) == s[tmpy].charAt(tmpx)) {
						visit2[tmpy][tmpx] = true;
						q2.offer(new Node(tmpy, tmpx));
					}
					else if(s[pre2.y].charAt(pre2.x) != 'B'&&s[tmpy].charAt(tmpx)!='B') {
						visit2[tmpy][tmpx] = true;
						q2.offer(new Node(tmpy, tmpx));
					}
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
