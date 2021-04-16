import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_1504_특정한최단경로 {
	static int N, E;
	static boolean[] visited;
	static int[] dist;
	static PriorityQueue<node> q;

	static ArrayList<node>[] arr;
	static int[][] map;
	static final int MAX_VALUE = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N + 1];
		dist = new int[N + 1];
		visited = new boolean[N + 1];
		map = new int[N + 1][N + 1];
		for (int i = 0; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		E = Integer.parseInt(st.nextToken());
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			arr[to].add(new node(from, distance));
			arr[from].add(new node(to, distance));
			map[to][from] = 1;
			map[from][to] = 1;
		}
		st = new StringTokenizer(br.readLine());
		int need_visit1 = Integer.parseInt(st.nextToken());
		int need_visit2 = Integer.parseInt(st.nextToken());

		int ans = solve(need_visit1, need_visit2);
		System.out.println(ans);
	}

	static int solve(int need1, int need2) {
		int tmp1 = 0;
		int tmp2 = 0;
		tmp1 = tmp1 + dijkstra(1, need1);
		tmp1 = tmp1 + dijkstra(need1, need2);
		tmp1 = tmp1 + dijkstra(need2, N);

		tmp2 = tmp2 + dijkstra(1, need2);
		tmp2 = tmp2 + dijkstra(need2, need1);
		tmp2 = tmp2 + dijkstra(need1, N);

		if (tmp1 < 0)
			tmp1 = MAX_VALUE;
		if (tmp2 < 0)
			tmp2 = MAX_VALUE;
		if (tmp1 >= MAX_VALUE && tmp2 >= MAX_VALUE)
			return -1;
		else
			return Math.min(tmp1, tmp2);

	}

	static int dijkstra(int start, int end) {
		Arrays.fill(dist, MAX_VALUE);
		Arrays.fill(visited, false);
		q = new PriorityQueue<>();
		q.add(new node(start, 0));
		dist[start] = 0;

		while (!q.isEmpty()) {
			node current = q.poll();
			int preVer = current.from;
			int preDis = current.distance;
			if (visited[preVer] == true)
				continue;
			visited[preVer] = true;
			for (int i = 0; i < arr[preVer].size(); i++) {
				int nextVer = arr[preVer].get(i).from;
				int nextDis = arr[preVer].get(i).distance;
				if (visited[nextVer] == false && map[preVer][nextVer] == 1 && dist[nextVer] > preDis + nextDis) {
					dist[nextVer] = preDis + nextDis;
					q.add(new node(nextVer, dist[nextVer]));
				}
			}
		}
		return dist[end];

	}

	static class node implements Comparable<node> {
		int from;
		int distance;

		public node(int from, int distance) {
			this.from = from;
			this.distance = distance;
		}

		public node() {
		}

		public int compareTo(node o) {
			return this.distance - o.distance;
		}

	}
}
