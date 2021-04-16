import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_14500_테트로미노 {
//	static int[][] one_one = { { 0, 1, 2, 3 }, { 0, 0, 0, 0 } }; // ㅡ
//	static int[][] one_two = { { 0, 0, 0, 0 }, { 0, 1, 2, 3 } }; // ㅣ
//
//	static int[][] two_one = { { 0, 1, 0, 1 }, { 0, 0, 1, 1 } }; // ㅁ
//
//	static int[][] three_one = { { 0, 0, 0, 1 }, { 0, 1, 2, 2 } }; // ㄴ(내림획 긴것)
//	static int[][] three_two = { { 0, 1, 2, 2 }, { 0, 0, 0, -1 } }; // 」
//	static int[][] three_three = { { 0, 0, 1, 2 }, { 0, 1, 1, 1 } }; // ㄴ
//	static int[][] three_four = { { 0, 0, 1, 2 }, { 0, 1, 0, 0 } };// 「
//	static int[][] three_five = { { 0, 1, 2, 2 }, { 0, 0, 0, 1 } };// ㄱ
//
//	static int[][] three_six = { { 0, 1, 1, 1 }, { 0, 0, -1, -2 } };// 』
//	static int[][] three_seven = { { 0, 1, 1, 1 }, { 0, 0, 1, 2 } };// ㄱ(내림획 긴것)
//	static int[][] three_eight = { { 0, 1, 0, 0 }, { 0, 0, 1, 2 } };// 『
//
//	static int[][] four_one = { { 0, 0, 1, 1 }, { 0, 1, 1, 2 } };
//	static int[][] four_two = { { 0, 0, -1, -1 }, { 0, 1, 1, 2 } };
//	static int[][] four_three = { { 0, 1, 1, 2 }, { 0, 0, -1, -1 } };
//	static int[][] four_four = { { 0, 1, 1, 2 }, { 0, 0, 1, 1 } };
//
//	static int[][] five_one = { { 0, 1, 2, 1 }, { 0, 0, 0, 1 } }; // ㅜ
//	static int[][] five_two = { { 0, 1, 2, 1 }, { 0, 0, 0, -1 } };// ㅗ
//	static int[][] five_three = { { 0, 0, 0, 1 }, { 0, 1, 2, 1 } };// ㅏ
//	static int[][] five_four = { { 0, 0, 0, -1 }, { 0, 1, 2, 1 } };// ㅓ

	static int[][][] map = { { { 0, 1, 2, 3 }, { 0, 0, 0, 0 } }, // ㅡ
			{ { 0, 0, 0, 0 }, { 0, 1, 2, 3 } }, // ㅣ
			{ { 0, 1, 0, 1 }, { 0, 0, 1, 1 } }, // ㅁ
			{ { 0, 0, 0, 1 }, { 0, 1, 2, 2 } }, // ㄴ(내림획 긴것)
			{ { 0, 1, 2, 2 }, { 0, 0, 0, -1 } }, // 」
			{ { 0, 0, 1, 2 }, { 0, 1, 1, 1 } }, // ㄴ
			{ { 0, 0, 1, 2 }, { 0, 1, 0, 0 } }, // 「
			{ { 0, 1, 2, 2 }, { 0, 0, 0, 1 } }, // ㄱ
			{ { 0, 1, 1, 1 }, { 0, 0, -1, -2 } }, // 』
			{ { 0, 1, 1, 1 }, { 0, 0, 1, 2 } }, // ㄱ(내림획 긴것)
			{ { 0, 1, 0, 0 }, { 0, 0, 1, 2 } }, // 『
			{ { 0, 0, 1, 1 }, { 0, 1, 1, 2 } }, { { 0, 0, -1, -1 }, { 0, 1, 1, 2 } },
			{ { 0, 1, 1, 2 }, { 0, 0, -1, -1 } }, { { 0, 1, 1, 2 }, { 0, 0, 1, 1 } },
			{ { 0, 1, 2, 1 }, { 0, 0, 0, 1 } }, // ㅜ
			{ { 0, 1, 2, 1 }, { 0, 0, 0, -1 } }, // ㅗ
			{ { 0, 0, 0, 1 }, { 0, 1, 2, 1 } }, // ㅏ
			{ { 0, 0, 0, -1 }, { 0, 1, 2, 1 } } };// ㅓ

	static int n, m;
	static int[][] paper;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		paper = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		search();
		System.out.println(max);
	}

	static void search() {
		for (int p = 0; p < 19; p++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					int tmp = 0;
					int cnt = 0;
					for (int k = 0; k < 4; k++) {
						int tmpi = i + map[p][1][k];
						int tmpj = j + map[p][0][k];
						if (tmpi >= 0 && tmpi < n && tmpj >= 0 && tmpj < m) {
							cnt += 1;
							tmp += paper[tmpi][tmpj];
						} else {
							break;
						}
					}
					if (cnt == 4 && tmp > max) {
						max = tmp;
					}
				}
			}
		}
	}
}
