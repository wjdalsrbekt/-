import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 백준_10819_차이를최대로 {
	static int n;
	static int[] arr;
	static int[] arr2;
	static boolean[] arr3;
	static int max = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		arr2 = new int[n];
		arr3 = new boolean[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		find_max(0);
		System.out.println(max);
	}

	static void find_max(int cnt) {
		if (cnt == n) {
			int tmp = 0;
			for (int i = 0; i < n-1; i++) {
				tmp += Math.abs(arr2[i] - arr2[i + 1]);
			}
			max = max > tmp ? max : tmp;
			return;
		}
		for (int i = 0; i < n; i++) {
			if (arr3[i] != true) {
				arr2[cnt] = arr[i];
				arr3[i] = true;
				find_max(cnt + 1);
				arr3[i] = false;
			}
		}
	}
}
