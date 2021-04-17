import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class 백준_1541_잃어버린괄호 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int sum = Integer.MAX_VALUE;
		String[] minus_sent = br.readLine().split("-");
		for (int i = 0; i < minus_sent.length; i++) {
			int temp = 0;
			String[] plus_sent = minus_sent[i].split("\\+");
			for (int j = 0; j < plus_sent.length; j++) {
				temp += Integer.parseInt(plus_sent[j]);
			}

			if (sum == Integer.MAX_VALUE) {
				sum = temp;
			} else {
				sum -= temp;
			}
		}
		System.out.println(sum);
	}

}