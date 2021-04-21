import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class SWEA_5643_키순서 {
 
    static int N, M, adj[][];
    static int gtCnt, ltCnt;
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
 
            N = Integer.parseInt(br.readLine()); // 학생 수 : 정점 수
            M = Integer.parseInt(br.readLine()); // 관계 수 : 간선 수
            adj = new int[N + 1][N + 1];
            
            int i, j;
            for (int m = 1; m <= M; m++) {
                st = new StringTokenizer(br.readLine());
                
                i = Integer.parseInt(st.nextToken());
                j = Integer.parseInt(st.nextToken());
                adj[i][j] = 1;
            }
 
            int res = 0;
            for (int k = 1; k <= N; k++) {
                gtCnt = ltCnt = 0;
                gtBFS(k);
                ltBFS(k);
                if(gtCnt + ltCnt == N - 1) res++;
            }
            
            System.out.println("#" + tc + " " + res);
        }
 
    }
 
    private static void gtBFS(int start) {
 
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        q.add(start);
        visited[start] = true;
        
        while(!q.isEmpty()) {
            
            int k = q.poll();
            for (int i = 1; i <= N; i++) {
                if (adj[k][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    gtCnt++;
                }
            }
        }
 
    }
 
    private static void ltBFS(int start) { 
 
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        q.add(start);
        visited[start] = true;
        
        while(!q.isEmpty()) {
            
            int k = q.poll();
            for (int i = 1; i <= N; i++) {
                if (adj[i][k] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    ltCnt++;
                }
            }
        }
 
    }
}


