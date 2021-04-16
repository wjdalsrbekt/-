import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_10703_유성 {
	static char[][] arr;
	static int[][] arr2;
	static int n;
	static int m;
	static int shortest = 99999;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		arr2 = new int[2][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = s.charAt(j);
				if (arr[i][j] == 'X') {
					arr2[0][j] = i;
				} else if (arr[i][j] == '#' && arr2[1][j] == 0) {
					arr2[1][j] = i;
				}
			}
		}
		check();
		move();
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}
	}

	static void check() {
		int tmp = 99999;
		for (int i = 0; i < m; i++) {
			if (arr[arr2[0][i]][i] == 'X') {
				tmp = arr2[1][i] - arr2[0][i];
			}
			shortest = shortest < tmp ? shortest : tmp;
		}
	}

	static void move() {
		for (int j = 0; j < m; j++) {
			for (int i = n - 1; i >= 0; i--) {
				if (arr[i][j] == '#') {
					continue;
				}
				if (arr[i][j] == 'X') {
					arr[i + shortest - 1][j] = 'X';
					arr[i][j] = '.';
				}
			}
		}
	}
}
