import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_19622_회의실배정3 {
	static node[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		arr = new node[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			node room = new node();
			room.start = Integer.parseInt(st.nextToken());
			room.end = Integer.parseInt(st.nextToken());
			room.person = Integer.parseInt(st.nextToken());
			arr[i] = room;
		}
		Arrays.sort(arr);
		int ans = 0;
		int[] d = new int[n];
		d[0] = arr[0].person;
		ans = d[0];
		if (n >= 2) {
			d[1] = Math.max(d[1], arr[1].person);
			ans = Math.max(ans, d[1]);
		}
		if (n >= 3) {
			d[2] = arr[2].person + d[0];
			ans = Math.max(ans, d[2]);
		}
		for (int i = 3; i < n; i++) {
			d[i] = Math.max(d[i - 2], d[i - 3]) + arr[i].person;
			ans = Math.max(ans, d[i]);
		}
		System.out.println(ans);

	}

	static class node implements Comparable<node> {
		int start;
		int end;
		int person;

		public node(int start, int end, int person) {
			this.start = start;
			this.end = end;
			this.person = person;
		}

		public node() {
		}

		public int compareTo(node o) {
			if (this.end == o.end)
				return this.person - o.person;
			return this.end - o.end;
		}
	}
}
