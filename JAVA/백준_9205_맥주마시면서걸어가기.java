import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_9205_맥주마시면서걸어가기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			int n = Integer.parseInt(br.readLine());
			node[] location = new node[n + 2];
			boolean[] check = new boolean[n + 2];
			Queue<node> q = new LinkedList<node>();
			boolean happy = false;
			for (int i = 0; i < n + 2; i++) {
				st = new StringTokenizer(br.readLine());
				location[i] = new node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			node home = location[0];
			node rock = location[n + 1];
			q.offer(home);

			while (!q.isEmpty()) {
				node per = q.poll();
				if (per.equals(rock)) {
					happy = true;
					break;
				}
				for (int i = 1; i < n + 2; i++) {
					if (check[i] == false
							&& Math.abs(per.x - location[i].x) + Math.abs(per.y - location[i].y) <= 1000) {
						q.offer(location[i]);
						check[i] = true;

					}
				}
			}
			if(happy==true) {
				System.out.println("happy");
			}
			else {
				System.out.println("sad");
			}
		}
	}

	static class node {
		int y;
		int x;

		public node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
