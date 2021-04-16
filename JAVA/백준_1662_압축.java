import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백준_1662_압축 {
	static char[] s;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine().toCharArray();
		visit = new boolean[s.length];
		System.out.println(dfs(0));
	}

	static int dfs(int k) {
		int cnt = 0;
		for (int i = k; i < s.length; i++) {
			if (s[i] == '(' && visit[i] != true) {
				visit[i] = true;
				int num = s[i - 1] - '0';
				cnt -= 1;
				cnt = cnt + num * dfs(k + 1);
			} else if (s[i] == ')' && visit[i] != true) {
				visit[i] = true;
				return cnt;
			} else if (visit[i] != true) {
				visit[i] = true;
				cnt += 1;
			}
		}
		return cnt;
	}
}
