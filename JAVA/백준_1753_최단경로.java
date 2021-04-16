import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_1753_최단경로 {
	static int N, K;
	static int start;
	static LinkedList<Node>[] adList;
	static StringBuilder sb;
	static boolean[] visit;
	static int[] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		adList = new LinkedList[N + 1];
		for (int i = 1; i <= N; i++) {
			adList[i] = new LinkedList<>();
		}
		sb = new StringBuilder();
		visit = new boolean[N + 1];
		distance = new int[N + 1];

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			adList[from].add(new Node(to, weight));
		}
		final int INF = Integer.MAX_VALUE - 1;
		Arrays.fill(distance, INF);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		distance[start] = 0;

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (visit[now.vertax])
				continue;
			visit[now.vertax] = true;
			for (Node next : adList[now.vertax]) {
				if (distance[next.vertax] > distance[now.vertax] + next.weight) {
					distance[next.vertax] = distance[now.vertax] + next.weight;
					pq.add(new Node(next.vertax, distance[next.vertax]));
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			sb.append(distance[i] == INF ? "INF" : distance[i]);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static class Node implements Comparable<Node> {
		int vertax, weight;

		public Node(int vertax, int weight) {
			this.vertax = vertax;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}

	}
}
