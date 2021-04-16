import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_1916_최소비용구하기 {
	static int city, bus;
	static int start, end;
	static int[][] map;
	static final int INF = Integer.MAX_VALUE - 5;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		city = Integer.parseInt(br.readLine());
		bus = Integer.parseInt(br.readLine());
		map = new int[city + 1][city + 1];

		int[] distance = new int[city + 1];
		boolean[] visit = new boolean[city + 1];
		for (int i = 0; i < city + 1; i++) {
			Arrays.fill(map[i], -1);
		}
		for (int k = 0; k < bus; k++) {
			st = new StringTokenizer(br.readLine());
			int point1 = Integer.parseInt(st.nextToken());
			int point2 = Integer.parseInt(st.nextToken());
			int money = Integer.parseInt(st.nextToken());
			if (map[point1][point2] != -1)
				map[point1][point2] = map[point1][point2] < money ? map[point1][point2] : money;
			else {
				map[point1][point2]=money;
			}
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		Arrays.fill(distance, INF - 5);
		distance[start] = 0;
		int min = 0, current = start;
		for (int i = 1; i <= city; i++) {
			min = INF - 1;
			for (int j = 1; j <= city; j++) {
				if (!visit[j] && distance[j] < min) {
					min = distance[j];
					current = j;
				}
			}
			visit[current] = true;
			if (current == end) {
				break;
			}

			for (int j = 1; j <= city; j++) {
				if (!visit[j] && map[current][j] != -1 && distance[j] > min + map[current][j]) {
					distance[j] = min + map[current][j];
				}
			}
		}
		System.out.println(distance[end]);
	}
}
