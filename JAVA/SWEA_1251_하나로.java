import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_1251_하나로 {
	static class Island {
		int y, x;

		public Island(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static class Edge implements Comparable<Edge> {
		int to;
		long weight;

		public Edge(int to, long weight) {
			this.to = to;
			this.weight = weight;
		}

		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}
	}

	private static int N;
	private static long minEdge[], resMin;
	private static double E;
	private static boolean visited[];
	private static List<Island>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer stt;
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			list = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				list[i] = new ArrayList<Island>();
			}

			visited = new boolean[N];
			minEdge = new long[N];
			int[] input = new int[N * 2];

			int idx = 0;
			for (int i = 0; i < 2; i++) {
				stt = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					input[idx] = Integer.parseInt(stt.nextToken());
					idx++;
				}
			}

			for (int i = 0; i < N; i++) {
				list[i].add(new Island(input[i + N], input[i]));
			}

			E = Double.parseDouble(br.readLine());
			resMin = 0;
			connectIsland();

			System.out.println("#" + test_case + " " + Math.round(E * resMin));
		}
	}

	private static void connectIsland() {
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
		int nodeCnt = 0;
		Arrays.fill(minEdge, Long.MAX_VALUE);
		minEdge[0] = 0;
		queue.offer(new Edge(0, 0));

		while (!queue.isEmpty()) {
			Edge minVertex = queue.poll();
			if (visited[minVertex.to])
				continue;

			resMin += minVertex.weight;
			visited[minVertex.to] = true;
			if (++nodeCnt == N)
				break;

			for (int i = 0; i < N; i++) {
				if (!visited[i]) {
					long tmp = (long) (Math.pow((list[i].get(0).x - list[minVertex.to].get(0).x), 2)
							+ Math.pow((list[i].get(0).y - list[minVertex.to].get(0).y), 2));
					if (minEdge[i] > tmp) {
						minEdge[i] = tmp;
						queue.offer(new Edge(i, minEdge[i]));
					}
				}
			}
		}
	}
}