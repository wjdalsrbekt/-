import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_17471_게리맨더링 {
	static int N;
	static int[] people; // 각 구역의 인구수
	static boolean[][] adj;// 구역의 인접정보
	static boolean[] select; // 각 구역의 뽑고 안뽑고(뽑으면 선거구 ㄱ 선거구 나머지는 ㄴ선거구)
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		people = new int[N + 1];// 1~N번까지의 인구수
		adj = new boolean[N + 1][N + 1];
		select = new boolean[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {// 인구수 입력
			people[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++) { // 지역 인접 정보
			st = new StringTokenizer(br.readLine());
			int tmp = Integer.parseInt(st.nextToken());
			for (int j = 0; j < tmp; j++) {
				int next = Integer.parseInt(st.nextToken());
				adj[i][next] = true;
				adj[next][i] = true;
			}
		}
		ans = Integer.MAX_VALUE;
		powerset(1, 0);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}

	static void powerset(int idx, int cnt) {
		if (idx > N) {
			if (cnt == 0 || cnt == N) {
				return;
			}
			// 나누어진 두 선거구 각각이 모두 연결된 상태인지 확인
			int starta = 0, startb = 0;
			for (int i = 1; i <= N; i++) {
				if (select[i])
					starta = i;
				else
					startb = i;
			}
			int people_a = bfs(starta, cnt);
			int people_b = bfs(startb, N - cnt);

			if (people_a > 0 && people_b > 0) {
				ans = Math.min(ans, Math.abs(people_a - people_b));
			}
			return;
		}
		select[idx] = true;
		powerset(idx + 1, cnt + 1);
		select[idx] = false;
		powerset(idx + 1, cnt);
	}

	static int bfs(int start, int cnt) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visit = new boolean[N + 1];
		queue.add(start);
		visit[start] = true;

		int linkCnt = 1;// start 에서 출발해서 연결된 점들의 갯수. start
		int peopleCnt = people[start]; // 연결된 지역의 인구수합

		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int i = 1; i <= N; i++) {
				if (adj[now][i] && select[now] == select[i] && !visit[i]) {
					queue.add(i);
					visit[i] = true;
					linkCnt++;
					peopleCnt += people[i];
				}
			}
		}
		if (linkCnt == cnt) {
			return peopleCnt;
		}
		return -1;
	}
}
