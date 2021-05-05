import java.util.*;
class Solution {
    static char[][] map;
    static StringBuilder sb;
    static String[] memory;
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};
        answer=new String[n];
        map=new char[n][n];
        memory=new String[n];
        change(arr1,n);
        change(arr2,n);
        for(int i=0;i<n;i++){
            sb=new StringBuilder();
            for(int j=n-1;j>=0;j--){
                sb.append(map[i][j]);
            }
            answer[i]=sb.toString();
        }
        return answer;
    }
    static void change(int[] arr,int n){
        for(int i=0;i<n;i++){
            sb=new StringBuilder();
            int tmp=arr[i];
            int rest;
            while(tmp>=2){
                rest=tmp%2;
                tmp=tmp/2;
                sb.append(rest); //거꾸로
            }
            sb.append(tmp);
            while(sb.length()<n){
                sb.append(0);
            }
            memory[i]=sb.toString();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(memory[i].charAt(j)=='1'||map[i][j]=='#'){
                    map[i][j]='#';
                }else{
                    map[i][j]=' ';
                }
            }
        }
    }
} 

///*
// *2진법으로 바꾼다. 이때 마지막 남은 몫도 스트링빌더에 추가시켜놓는다.
// *2진법이 작을경우 2진수로 변경시, 남은 수들은 0으로 넣어논다.
// *해당 진법의 수가 1이거나 기존의 표시구간에 이미 #이 있을경우 # 을 놓고 나머지는 ' ' 빈칸을 넣는다.
// *이 빈칸은 꼭넣어야한다. 안넣으니 이때 \\u로 인식되더라.. 조심!
// *16번째줄 진법 변경시에 임시인 memory는 문제가 원하는 출력과 좌우대칭으로 나오니 answer에 옮길때 거꾸로 옮겨야한다.
// * */
 