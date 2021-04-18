import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_2437_저울 {
	static int N;
	static int[] weight;
	static int MIN;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		weight = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(weight);
		for (int i = 0; i < N; i++) {
			if (MIN + 2 <= weight[i])
				break;
			MIN += weight[i];
		}
		System.out.println(MIN+1);
	}

}
