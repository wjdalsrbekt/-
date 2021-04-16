import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_14719_빗물 {
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		arr = new int[h][w];
		int[] rain = new int[w];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < w; i++) {
			rain[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < w; i++) {
			for (int j = h - 1; j >= 0; j--) {
				if (rain[i] == 0) {
					break;
				}
				arr[j][i] = 1;
				rain[i] -= 1;
			}
		}
		boolean flag1 = false;
		boolean flag2 = false;

		int cnt = 0;
		for (int i = h - 1; i >= 0; i--) {
			flag1 = false;
			flag2 = false;
			int start = 0;
			int end = 0;
			for (int j = 0; j < w; j++) {
				if (arr[i][j] == 1 && flag1 == false) {
					flag1 = true;
					start = j;
					break;
				}
			}
			for (int j = w - 1; j >= 0; j--) {
				if (arr[i][j] == 1 && flag2 == false) {
					flag2 = true;
					end = j;
					break;
				}
			}
			if (end == start)
				continue;
			for (int j = start; j < end; j++) {
				if (arr[i][j] == 0)
					arr[i][j] = 2;
			}
		}
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (arr[i][j] == 2) {
					cnt += 1;
				}
			}
		}
		System.out.println(cnt);
	}
}
