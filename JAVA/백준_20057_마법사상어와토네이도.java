import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_20057_마법사상어와토네이도 {
	static int[][] arr;
	static int n;
	static int center;
	static double[] tornado = { 0.05, 0.1, 0.1, 0.02, 0.07, 0.07, 0.02, 0.01, 0.01 };
	static int[][] dx = { 
			{ -2, -1, -1, 0, 0, 0, 0, 1, 1 }, 
			{ 0, -1, 1, -2, -1, 1, 2, -1, 1 },
			{ 2, 1, 1, 0, 0, 0, 0, -1, -1 }, 
			{ 0, -1, 1, -2, -1, 1, 2, -1, 1 } };
	static int[][] dy = {
			{ 0, -1, 1, -2, -1, 1, 2, -1, 1 }, 
			{ 2, 1, 1, 0, 0, 0, 0, -1, -1 },
			{ 0, -1, 1, -2, -1, 1, 2, -1, 1 },
			{ -2, -1, -1, 0, 0, 0, 0, 1, 1 } };
	static int prex;
	static int prey;
	static int mi = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		center = n / 2;
		arr = new int[n][n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				sum += arr[i][j];
			}
		}
		move();

		System.out.println(mi);
	}

	static void dust(int i, int j, int dir_y, int dir_x, int rotation) {
		int tmp = arr[i][j];
		arr[i][j] = 0;
		int tmp11 = 0;
		for (int k = 0; k < 10; k++) {
			if (k <= 8) {
				int tmpi = i + dy[rotation][k];
				int tmpj = j + dx[rotation][k];
				tmp11 += (int) (tmp * tornado[k]);
				if (tmpi >= 0 && tmpj >= 0 && tmpi < n && tmpj < n) {
					arr[tmpi][tmpj] = arr[tmpi][tmpj] + (int) (tmp * tornado[k]);
				} else {
					mi += tmp * tornado[k];
				}
			} else if (k == 9) {
				int tmpi = i + dir_y;
				int tmpj = j + dir_x;
				if (tmpi >= 0 && tmpj >= 0 && tmpi < n && tmpj < n) {
					arr[tmpi][tmpj] = arr[tmpi][tmpj] + (tmp - tmp11);
				} else {
					mi += tmp - tmp11;
				}
			}
		}

	}

	static void move() {
		prex = center;
		prey = center;
		int tmp = 1;
		while (tmp != n) {
			move1(tmp);
			move2(tmp);
			tmp += 1;
			move3(tmp);
			move4(tmp);
			tmp += 1;
		}
		move1(tmp - 1);
	}

	static void move1(int cnt) {
		for (int k = 0; k < cnt; k++) {
			prex = prex - 1;
			dust(prey, prex, 0, -1, 0);
		}
	}

	static void move2(int cnt) {
		for (int k = 0; k < cnt; k++) {
			prey = prey + 1;
			dust(prey, prex, 1, 0, 1);
		}
	}

	static void move3(int cnt) {
		for (int k = 0; k < cnt; k++) {
			prex = prex + 1;
			dust(prey, prex, 0, 1, 2);
		}
	}

	static void move4(int cnt) {
		for (int k = 0; k < cnt; k++) {
			prey = prey - 1;
			dust(prey, prex, -1, 0, 3);
		}
	}

}
