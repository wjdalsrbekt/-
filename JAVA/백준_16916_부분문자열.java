import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_16916_부분문자열 {
	static String s;
	static String p;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		p = br.readLine();
		kmp();
		System.out.println(ans);
	}

	static void kmp() {
		int[] fail = new int[p.length()];
		int j = 0;
		for (int i = 1; i < p.length(); i++) {
			while (j > 0 && p.charAt(i) != p.charAt(j)) {
				j = fail[j - 1];
			}
			if (p.charAt(i) == p.charAt(j)) {
				fail[i] = ++j;
			}
		}
		j = 0;
		for (int i = 0; i < s.length(); i++) {
			while (j > 0 && s.charAt(i) != p.charAt(j)) {
				j = fail[j - 1];
			}
			if (s.charAt(i) == p.charAt(j)) {
				if (j == p.length() - 1) {
					ans = 1;
					break;
				} else {
					j++;
				}
			}
		}
	}



}
