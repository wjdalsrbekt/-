import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class SWEA_7465_창용마을무리의개수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] parents;
    static int N, M;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        int[] result = new int[T];
        for (int i = 0; i < T; i++) {
            result[i] = getResult();
        }
 
        for (int i = 0; i < T; i++) {
            System.out.printf("#%d %d\n", i + 1, result[i]);
        }
    }
 
    static int getResult() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        makeSet();
        for (int i = 0; i < M; i++) {
            String[] line = br.readLine().split(" ");
            int personA = Integer.parseInt(line[0]);
            int personB = Integer.parseInt(line[1]);
            union(personA, personB);
        }
 
        int cnt = 0;
        for (int i = 1; i < N + 1; i++) {
            if (parents[i] == i) cnt++;
        }
 
        return cnt;
    }
 
    private static void union(int personA, int personB) {
        int rootA = find(personA);
        int rootB = find(personB);
        if (rootA == rootB) return;
        parents[rootA] = rootB;
    }
 
    private static int find(int person) {
        if (parents[person] == person) return person;
        return find(parents[person]);
    }
 
    private static void makeSet() {
        parents = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parents[i] = i;
        }
    }
}