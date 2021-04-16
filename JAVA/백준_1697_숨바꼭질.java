import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_1697_숨바꼭질 {
	static int[] arr = new int[100001];
	static boolean[] arr2 = new boolean[100001];
	static int n, k;
	static int[] dx = { -1, 1, 0 };
	static int[] dx2 = { 1, 1, 2 };
	static Queue<Integer> q = new LinkedList<>();
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		arr[n] = 1;
		k = Integer.parseInt(st.nextToken());
		q.offer(n);
		bfs();
		System.out.println(arr[k] - 1);
	}

	static void bfs() {
		while (!q.isEmpty()) {
			int visit = q.poll();
			if (visit == k)
				break;
			arr2[visit] = true;
			for (int i = 0; i < 3; i++) {
				int tmpx = (visit + dx[i]) * dx2[i];
				if (tmpx >= 0 && tmpx <= 100000 && arr2[tmpx] != true && arr[tmpx] == 0) {
					q.offer(tmpx);
					arr[tmpx] = arr[visit] + 1;
					if (tmpx == k) {
						ans = 1;
						break;
					}
				}
			}
			if (ans == 1)
				break;
		}
	}
}
