import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1238_Contact {
	static int[][] arr;
	static int start;
	static Queue<Integer> queue;
	static int[] visit;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int k = 1; k <= 10; k++) {
			st = new StringTokenizer(br.readLine());
			arr = new int[101][101];
			queue = new LinkedList<>();
			visit = new int[101];
			check = new boolean[101];
			int n = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				arr[from][to] = 1;
				if (check[from] != true) {
					check[from] = true;
				}
				if (check[to] != true) {
					check[to] = true;
				}
			}
			int max = 0;
			int tmp = 0;
			queue.offer(start);
			visit[start] = 1;
			bfs();
			for (int i = 100; i > 0; i--) {
				if (check[i] == true && visit[i] != 0) {
					if (visit[i] >= tmp) {
						tmp = visit[i];
					}
				}
			}
			for (int i = 100; i > 0; i--) {
				if (visit[i] == tmp) {
					max = max > i ? max : i;
				}
			}
			System.out.println("#" + k + " " + max);
		}
	}

	static void bfs() {
		while (!queue.isEmpty()) {
			int v = queue.poll();
			for (int i = 1; i < 101; i++) {
				if (visit[i] == 0 && arr[v][i] == 1 && check[i] == true) {
					visit[i] = visit[v] + 1;
					queue.offer(i);
				}
			}
		}

	}
}
