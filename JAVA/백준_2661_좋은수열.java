import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_2661_좋은수열 {
	static int n;
	static int complete;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		make_rot(1, "1");
	}

	static void make_rot(int cnt, String s) {
		if (complete == 1)
			return;
		if (cnt == n) {
			complete = 1;
			System.out.println(s.toString());
			return;
		}
		for (int i = 1; i <= 3; i++) {
			if (check(s + (char) (i + '0'))) {
				make_rot(cnt + 1, s + i);
			}
		}
	}

	static boolean check(String s) {
		int end = s.length();
		int start = s.length() - 1;
		int many = s.length() / 2;
		for (int i = 1; i <= many; i++) {
			if (s.substring(start - i, end - i).equals(s.substring(start, end))) {
				return false;
			}
			start -= 1;
		}
		return true;
	}
}
