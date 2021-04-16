import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class SWEA_1953_탈주범검거 {
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {0,0,-1,1};//상하좌우
    static int[] dy = {-1,1,0,0};
    static int tunnel[][] = {{},{0,1,2,3},{0,1},{2,3},{0,3},{1,3},{1,2},{0,2}};
    static int N, M, R, C, L;
    static int[][] map;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
             
            map = new int[N][M];
             
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<M;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append("#"+(t+1)+" "+solves()+"\n");
        }
        System.out.println(sb);
    }
    public static int solves() {
        Queue<Pair> q = new LinkedList<>();
        boolean[][] checkMap = new boolean[N][M];
        q.add(new Pair(C,R));
        checkMap[R][C] = true;
        int result = 1;
        int count = 0;
        while(!q.isEmpty()) {
            int length = q.size();
            count++;
            if(count == L)break; //L초가 되면 종료
            for(int i=0;i<length;i++) {
                Pair temp = q.poll();
                int num = map[temp.y][temp.x];
                for(int j=0;j<tunnel[num].length;j++) { //터널이 뚤린 방향만큼 반복
                    Pair next = new Pair(temp.x+dx[tunnel[num][j]],temp.y+dy[tunnel[num][j]]);
                    if(next.x>=0&&next.y>=0&&next.x<M&&next.y<N&&checkHole(tunnel[num][j],tunnel[map[next.y][next.x]])&&!checkMap[next.y][next.x]) {//현재위치에서 나가려는 방향과 도착하려는 위치의 모든 방향을 check함
                        checkMap[next.y][next.x] = true;
                        q.add(next);
                        result++;
                    }
                }
            }
        }
        return result;
    }
    public static boolean checkHole(int first, int[] second) {//구멍이 연결되어있으면 true리턴
        //first에서 나가려는 방향에 반대 방향이 second에 있으면 true리턴
        int find = 0;//반대방향 번호
        switch(first) {
        case 0:
            find = 1;
            break;
        case 1:
            find = 0;
            break;
        case 2:
            find = 3;
            break;
        case 3:
            find = 2;
            break;
        }
        boolean check = false;
        for(int i=0;i<second.length;i++) {
            if(second[i] == find) {
                check = true;
                break;
            }
        }
        return check;
    }
}