import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_9658_돌게임4 {
	static int[] d;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int stone = n;
//		d = new int[8];
//		// 1:창영승
//		// 0:상근승
//		d[1] = 1;
//		d[2] = 0;
//		d[3] = 1;
//		d[4] = 0;
//		d[5] = 0;
//		d[6] = 0;
//		d[7] = 0;
		if(n%7==1||n%7==3)
			System.out.println("CY");
		else 
			System.out.println("SK");
	}
}
