import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 백준_3190_뱀 {
	static int N, K;
	static int[][] arr;
	static Deque<Node> dq = new ArrayDeque<>();
	static Time[] time;
	static int[] whattime = new int[10001];
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			arr[y-1][x-1] = 9; //사과위치ㅠㅠㅠㅠ
		}
		int L = Integer.parseInt(br.readLine());
		time = new Time[L];
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = new Time();
			time[i].sec = Integer.parseInt(st.nextToken());
			time[i].dir = st.nextToken().charAt(0);
			whattime[time[i].sec] = i + 1;
		}
		dq.addFirst(new Node(0, 0, 2));
		arr[0][0] = 1;
		move();
	}

	static void move() {
		while (true) {
			Node per = dq.peek();
			Node next = new Node();
			int tmpy = per.y + dy[per.dir];
			int tmpx = per.x + dx[per.dir];
			if (tmpy < 0 || tmpy >= N || tmpx < 0 || tmpx >= N || arr[tmpy][tmpx] == 1) {
				System.out.println(ans + 1);
				return;
			} else {
				ans += 1;
				next.y = tmpy;
				next.x = tmpx;
				next.dir = per.dir;
//				int tmp=arr[per.y][per.x];
				if (arr[tmpy][tmpx] != 9) {
					Node last = dq.pollLast();
					arr[last.y][last.x] = 0;
				}
				arr[tmpy][tmpx] = 1;
				if (whattime[ans] != 0) { // x초후 방향전환
					int tmpdir;
					if (time[whattime[ans] - 1].dir == 'L') {
						tmpdir = (per.dir + 1) % 4;
					} else {
						tmpdir = (per.dir + 3) % 4;
					}
					next.dir = tmpdir;
				}
				dq.addFirst(next);
			}
		}
	}

	static class Time {
		int sec;
		char dir;

		public Time(int sec, char dir) {
			this.sec = sec;
			this.dir = dir;
		}

		public Time() {
		}

	}

	static class Node {
		int y;
		int x;
		int dir;

		public Node(int y, int x, int dir) {
			this.y = y;
			this.x = x;
			this.dir = dir;
		}

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

		public Node() {
		}

	}
}
