import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_9251__LCS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String s1 = br.readLine();
		int len = s.length();
		int len1 = s1.length();
		int[][] d = new int[len + 1][len1 + 1];
		for (int i = 1; i <= len; i++) {
			for (int j = 1; j <= len1; j++) {
				if (s.charAt(i - 1) == s1.charAt(j - 1)) {
					d[i][j] = d[i - 1][j - 1] + 1;
				} else {
					d[i][j] = Math.max(d[i - 1][j], d[i][j - 1]);
				}
			}
		}
		System.out.println(d[len][len1]);
	}
}
