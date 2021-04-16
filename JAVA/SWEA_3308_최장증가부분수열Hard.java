import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3308_최장증가부분수열Hard {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		for (int k = 1; k <= tc; k++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int[] arr2 = new int[n];
			int size = 0;
			for (int i = 0; i < n; i++) {
				int temp = Arrays.binarySearch(arr2, 0, size, arr[i]);
				temp = Math.abs(temp) - 1;
				arr2[temp] = arr[i];
				if (temp == size)
					size += 1;
			}
			System.out.println("#"+k+" "+size);
		}
	}
}
