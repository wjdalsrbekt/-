
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//dp
//public class 백준_1463_1로만들기 {
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(br.readLine());
//		int[] d = new int[11];
//		d[0] = 0;
//		d[1] = 0;
//		for (int i = 2; i <= n; i++) {
//			d[i] = d[i - 1] + 1;
//			if (i % 2 == 0 && d[i] > d[i /2] + 1) {
//				d[i] = d[i / 2] + 1;
//			}
//			if (i % 3 == 0 && d[i] > d[i /3] + 1) {
//				d[i] = d[i / 3] + 1;
//			}
//		}
//		System.out.println(d[n]);
//	}
//}
//dfs
//public class 백준_1463_1로만들기 {
//	static int min;
//	public static void main(String[] args) throws IOException{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		min = Integer.MAX_VALUE;
//		dfs(N, 0);
//		System.out.println(min);
//	}
//	
//	public static void dfs(int N, int cnt){
//		if(N == 1){
//			min = min > cnt ? cnt : min;
//			return;
//		}
//
//		// 가지치기
//		// 이미 cnt가 min보다 크거나 같은 경우 더 진행할 필요가 없음
//		if(cnt >= min) return;
//
//		// 2로 나누어 떨어지는 경우 2로 나눠보기
//		if(N % 2 == 0)
//			dfs(N/2, cnt+1);
//		// 3으로 나누어 떨어지는 경우 3으로 나눠보기
//		if(N % 3 == 0)
//			dfs(N/3, cnt+1);
//		dfs(N-1, cnt+1);	// 1 빼보기
//	}
//}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 백준_1463_1로만들기 {
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
//1. X가 3으로 나누어 떨어지면 3으로 나눈다. //2. X가 2로 나누어 떨어지면 2로 나눈다. //3. 1을 뺸다. 
		cnt = 0;
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
//배열 초기화 
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		dist[n] = 0;
		while (!queue.isEmpty()) {
			int idx = queue.poll();
			if (idx < 1)
				continue;
//1이면 pass 
			if (idx % 3 == 0) {
				if (dist[idx / 3] > dist[idx] + 1) {
					dist[idx / 3] = dist[idx] + 1;
					queue.add(idx / 3);
				}
			}
			if (idx % 2 == 0) {
				if (dist[idx / 2] > dist[idx] + 1) {
					dist[idx / 2] = dist[idx] + 1;
					queue.add(idx / 2);
				}
			}
			if (dist[idx - 1] > dist[idx] + 1) {
				dist[idx - 1] = dist[idx] + 1;
				queue.add(idx - 1);
			}
		}
		System.out.println(dist[1]);
	}
}
