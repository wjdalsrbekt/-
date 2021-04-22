import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1868_파핑파핑지뢰찾기 {
	static int r, c, N;
	static int[] dx = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static int[] dy = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static char[][] arr;
	static boolean[][] visit;
	static char[] alpha = { '0', '1', '2', '3', '4', '5', '6', '7', '8' };
	static Queue<Node> q = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new char[N][N];
			visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				arr[i] = s.toCharArray();
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] != '*')
						get_num(i, j);
				}
			}
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == '0' && visit[i][j] == false) {
						cnt += 1;
						q.offer(new Node(i, j));
						visit[i][j] = true;
						click_num();
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] != '*' && visit[i][j] == false) {
						cnt += 1;
					}
				}
			}
			System.out.println("#"+tc+" "+cnt);
		}
	}

	static void print_arr() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void click_num() {
		while (!q.isEmpty()) {
			Node per = q.poll();
			int i = per.y;
			int j = per.x;
			for (int k = 0; k < 8; k++) {
				int tmpi = i + dy[k];
				int tmpj = j + dx[k];
				if (tmpi >= 0 && tmpi < N && tmpj >= 0 && tmpj < N && visit[tmpi][tmpj] == false) {
					visit[tmpi][tmpj] = true;
					if (arr[tmpi][tmpj] == '0') {
						q.offer(new Node(tmpi, tmpj));
					}
				}
			}
		}
	}

	static void get_num(int i, int j) {
		int cnt = 0;
		int tmpi;
		int tmpj;
		for (int k = 0; k < 8; k++) {
			tmpi = i + dy[k];
			tmpj = j + dx[k];
			if (tmpi >= 0 && tmpi < N && tmpj >= 0 && tmpj < N) {
				if (arr[tmpi][tmpj] == '*') {
					cnt += 1;
				}
			}
		}
		arr[i][j] = (char) (cnt + '0');
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
