import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_9661_돌게임7 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		if(n%5==0||n%5==2) {
			System.out.println("CY");
		}else {
			System.out.println("SK");
		}
	}
}
