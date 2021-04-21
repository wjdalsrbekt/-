import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_15683_감시 {
	static int n, m;
	static int[][] arr;
	static Queue<Node> q = new LinkedList<>();
	static Queue<Node> q2 = new LinkedList<>();
	static Node[] node;
	static int cctv_cnt;
	static int min = 999999;

	static public void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		boolean[][] map = new boolean[n][m];
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 5) {
					map[i][j] = true;
					q.offer(new Node(i, j));
				} else if (arr[i][j] >= 1 && arr[i][j] <= 4) {
					map[i][j] = true;
					q2.offer(new Node(i, j, arr[i][j]));
					cctv_cnt += 1;
				} else if (arr[i][j] == 6)
					map[i][j] = true;
			}
		}
		node = new Node[cctv_cnt];
		int idx = 0;
		while (!q2.isEmpty()) {
			node[idx++] = q2.poll();
		}
		while (!q.isEmpty()) {
			Node tmp = q.poll();

			for (int i = tmp.y; i >= 0; i--) {
				if (arr[i][tmp.x] == 6)
					break;
				map[i][tmp.x] = true;
			}
			for (int i = tmp.y; i < n; i++) {
				if (arr[i][tmp.x] == 6)
					break;
				map[i][tmp.x] = true;
			}
			for (int j = tmp.x; j < m; j++) {
				if (arr[tmp.y][j] == 6)
					break;
				map[tmp.y][j] = true;
			}
			for (int j = tmp.x; j >= 0; j--) {
				if (arr[tmp.y][j] == 6)
					break;
				map[tmp.y][j] = true;
			}
		}
		dfs(0, map);
		System.out.println(min);

	}

	static void dfs(int size, boolean[][] map) {
		if (size == cctv_cnt) {
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == false)
						cnt += 1;
				}
			}
			min = Math.min(min, cnt);
			return;
		}
//		Node per = q2.poll();
		Node per = node[size];
		int y = per.y;
		int x = per.x;
		int cam = per.cam;
		boolean[][] map2 = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map2[i][j] = map[i][j];
			}
		}
		switch (cam) {
		case 1:
			for (int i = 0; i < 4; i++) {
				if (i == 0) {
					dfs(size + 1, dir_right(y, x, map));
				} else if (i == 1) {
					dfs(size + 1, dir_left(y, x, map));
				} else if (i == 2) {
					dfs(size + 1, dir_up(y, x, map));
				} else if (i == 3) {
					dfs(size + 1, dir_down(y, x, map));
				}
//				map = map2;
				for (int a = 0; a < n; a++) {
					for (int b = 0; b < m; b++) {
						map[a][b] = map2[a][b];
					}
				}
			}
			break;
		case 2:
			for (int i = 0; i < 2; i++) {
				if (i == 0) {
					dfs(size + 1, dir_left(y, x, dir_right(y, x, map)));
				} else if (i == 1) {
					dfs(size + 1, dir_up(y, x, dir_down(y, x, map)));
				}
				for (int a = 0; a < n; a++) {
					for (int b = 0; b < m; b++) {
						map[a][b] = map2[a][b];
					}
				}
			}
			break;
		case 3:
			for (int i = 0; i < 4; i++) {
				if (i == 0) {
					dfs(size + 1, dir_up(y, x, dir_right(y, x, map)));
				} else if (i == 1) {
					dfs(size + 1, dir_right(y, x, dir_down(y, x, map)));
				} else if (i == 2) {
					dfs(size + 1, dir_down(y, x, dir_left(y, x, map)));
				} else if (i == 3) {
					dfs(size + 1, dir_left(y, x, dir_up(y, x, map)));
				}
				for (int a = 0; a < n; a++) {
					for (int b = 0; b < m; b++) {
						map[a][b] = map2[a][b];
					}
				}
			}
			break;
		case 4:
			for (int i = 0; i < 4; i++) {
				if (i == 0) {
					dfs(size + 1, dir_left(y, x, dir_right(y, x, dir_up(y, x, map))));
				} else if (i == 1) {
					dfs(size + 1, dir_up(y, x, dir_right(y, x, dir_down(y, x, map))));
				} else if (i == 2) {
					dfs(size + 1, dir_right(y, x, dir_left(y, x, dir_down(y, x, map))));
				} else if (i == 3) {
					dfs(size + 1, dir_down(y, x, dir_left(y, x, dir_up(y, x, map))));
				}
				for (int a = 0; a < n; a++) {
					for (int b = 0; b < m; b++) {
						map[a][b] = map2[a][b];
					}
				}
			}
			break;
		}
	}

	static boolean[][] dir_right(int y, int x, boolean[][] map) {
		for (int j = x; j < m; j++) {
			if (arr[y][j] == 6)
				break;
			map[y][j] = true;
		}
		return map;
	}

	static boolean[][] dir_left(int y, int x, boolean[][] map) {
		for (int j = x; j >= 0; j--) {
			if (arr[y][j] == 6)
				break;
			map[y][j] = true;
		}
		return map;
	}

	static boolean[][] dir_up(int y, int x, boolean[][] map) {
		for (int i = y; i >= 0; i--) {
			if (arr[i][x] == 6)
				break;
			map[i][x] = true;
		}
		return map;
	}

	static boolean[][] dir_down(int y, int x, boolean[][] map) {
		for (int i = y; i < n; i++) {
			if (arr[i][x] == 6)
				break;
			map[i][x] = true;
		}
		return map;
	}

	static void cam_print(boolean[][] map) {
		int tmp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == true && arr[i][j] == 0) {
					System.out.println("#" + " ");
					tmp += 1;
				} else {
					System.out.print(arr[i][j] + " ");
				}
			}
			System.out.println();
		}
		System.out.println(tmp);
	}

	static class Node {
		int y;
		int x;
		int cam;

		public Node(int y, int x, int cam) {
			this.y = y;
			this.x = x;
			this.cam = cam;
		}

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}
}
