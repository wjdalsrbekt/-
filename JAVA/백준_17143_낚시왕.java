
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_17143_낚시왕 {
	static int R, C, M;
	static int[][] map;
	static int[][] idx_map;
	static shark[] sh;
	static int fish;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[R + 1][C + 1];
		idx_map = new int[R + 1][C + 1];

		sh = new shark[M];
		for (int i = 1; i <= R; i++)
			Arrays.fill(idx_map[i], -1);
		for (int k = 0; k < M; k++) {
			sh[k] = new shark();
			st = new StringTokenizer(br.readLine());
			sh[k].r = Integer.parseInt(st.nextToken());
			sh[k].c = Integer.parseInt(st.nextToken());
			sh[k].s = Integer.parseInt(st.nextToken());
			sh[k].d = Integer.parseInt(st.nextToken());
			sh[k].z = Integer.parseInt(st.nextToken());
			sh[k].live = true;
			map[sh[k].r][sh[k].c] = 1;
			idx_map[sh[k].r][sh[k].c] = k;
		}
		for (int j = 1; j <= C; j++) {
			for (int i = 1; i <= R; i++) {
//				if (map[i][j] == 1 && sh[idx_map[i][j]].live == true) {
				if (idx_map[i][j] != -1 && sh[idx_map[i][j]].live == true) {
					fish += sh[idx_map[i][j]].z;
					sh[idx_map[i][j]].live = false;
					map[i][j] = 0;
					idx_map[i][j] = -1;
					break;
				}
			}
			move_shark();
		}
		System.out.println(fish);
	}

	static void move_shark() {
		int[][] tmp_map = new int[R + 1][C + 1];
		for (int i = 1; i <= R; i++)
			Arrays.fill(tmp_map[i], -1);
		for (int k = 0; k < M; k++) {
			if (sh[k].live == true) {
				map[sh[k].r][sh[k].c] = 0;
				idx_map[sh[k].r][sh[k].c] = -1;
				if (sh[k].d == 1) {
					if (sh[k].r - sh[k].s >= 1) {
						sh[k].r = sh[k].r - sh[k].s;
					} else {
						int rest = sh[k].s - (sh[k].r - 1);
						int di = rest / (R - 1);
						int ri = rest % (R - 1);
						sh[k].d = di % 2 == 1 ? 1 : 2;
						if (sh[k].d == 1) {
							sh[k].r = R - ri;
						} else {
							sh[k].r = 1 + ri;
						}
					}
				} else if (sh[k].d == 2) {
					if (sh[k].r + sh[k].s > R) {
						int tmp = R - sh[k].r;
						int rest = sh[k].s - tmp;
						int di = rest / (R - 1);
						int ri = rest % (R - 1);
						sh[k].d = di % 2 == 1 ? 2 : 1;
						if (sh[k].d == 2) {
							sh[k].r = 1 + ri;
						} else {
							sh[k].r = R - ri;
						}
					} else {
						sh[k].r = sh[k].r + sh[k].s;
					}
				} else if (sh[k].d == 3) {
					if (sh[k].c + sh[k].s > C) {
						int tmp = C - sh[k].c;
						int rest = sh[k].s - tmp;
						int di = rest / (C - 1);
						int ri = rest % (C - 1);
						sh[k].d = di % 2 == 1 ? 3 : 4;
						if (sh[k].d == 3) {
							sh[k].c = 1 + ri;
						} else {
							sh[k].c = C - ri;
						}
					} else {
						sh[k].c = sh[k].c + sh[k].s;
					}
				} else if (sh[k].d == 4) {
					if (sh[k].c - sh[k].s >= 1) {
						sh[k].c = sh[k].c - sh[k].s;
					} else {
						int rest = sh[k].s - (sh[k].c - 1);
						int di = rest / (C - 1);
						int ri = rest % (C - 1);
						sh[k].d = di % 2 == 1 ? 4 : 3;
						if (sh[k].d == 4) {
							sh[k].c = C - ri;
						} else {
							sh[k].c = 1 + ri;
						}
					}
				}
				if (tmp_map[sh[k].r][sh[k].c] != -1) {
					boolean change = sh[tmp_map[sh[k].r][sh[k].c]].z > sh[k].z ? false : true;
					if (change) {
						sh[tmp_map[sh[k].r][sh[k].c]].live = false;
						tmp_map[sh[k].r][sh[k].c] = k;
					} else {
						sh[k].live = false;
					}
				} else {
					map[sh[k].r][sh[k].c] = 1;
//					idx_map[sh[k].r][sh[k].c] = k;
					tmp_map[sh[k].r][sh[k].c] = k;
				}
			}
		}
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				idx_map[i][j] = tmp_map[i][j];
			}
		}
	}

	static class shark {
		int r, c, s, d, z;
		boolean live;

		public shark(int r, int c, int s, int d, int z, boolean live) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
			this.live = live;
		}

		public shark() {
		}
	}
}
