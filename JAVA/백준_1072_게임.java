import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1072_게임 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		double x = Integer.parseInt(st.nextToken());
		double y = Integer.parseInt(st.nextToken());
		double z = (y*100) / (x);
		
		z = (int) z;
		double cal = (int) z;
		double cnt = 0;
		while (cal == z) {
			if (cal >= 99)
				break;
			y += 1;
			x += 1;
			cnt += 1;
			cal = (int)((y * 100) / (x));
		}
		if (cnt == 0)
			System.out.println(-1);
		else
			System.out.print((int) cnt);
	}
}
