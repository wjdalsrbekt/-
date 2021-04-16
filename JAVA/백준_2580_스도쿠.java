import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 백준_2580_스도쿠 {
	static int[][] board;
	static ArrayList<Integer> emptyList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[9][9];
		emptyList = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			String line = br.readLine();
			for (int j = 0; j < 9; j++) {
				board[i][j] = line.charAt(j) - '0';
				if (board[i][j] == 0)
					emptyList.add(i * 9 + j);
			}
		}
		dfs(0); // 채워야하는 빈칸의 번호
	}

	static boolean dfs(int target) {
		if (target == emptyList.size()) { // 빈칸 다채움
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
			return true;
		}
		int now = emptyList.get(target);
		for (int n = 1; n <= 9; n++) {
			if (check(now / 9, now % 9, n)) {
				board[now / 9][now % 9] = n;
				if (dfs(target + 1))
					return true;
			}
		}
		board[now / 9][now % 9] = 0;
		return false;
	}

	static boolean check(int nowi, int nowj, int n) {
		for (int idx = 0; idx < 9; idx++) {
			if (board[idx][nowj] == n || board[nowi][idx] == n)
				return false;
		}
		int si = nowi / 3 * 3;
		int sj = nowj / 3 * 3;
		for (int i = si; i < si + 3; i++) {
			for (int j = sj; j < sj + 3; j++) {
				if (board[i][j] == n)
					return false;
			}
		}
		return true;
	}
}
