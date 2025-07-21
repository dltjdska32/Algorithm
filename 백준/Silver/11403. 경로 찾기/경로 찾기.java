/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main{

    // 노드
    static int n;
    // 간선
    static int m;
    //간선 리스트
    static List<Integer>[] links;
    static int[] cnt;

    static boolean[] visited;
    static int visitCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        cnt = new int[n + 1];
        cnt[0] = 0;

        // 배열방 = 부모노드 번호
        links = new ArrayList[n + 1];
        //links초기화
        for(int i = 0; i <= n; i++){
            links[i] = new ArrayList<>();
        }


        // 간선생성
        // b = 부모노드 , a = 자식노드
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            links[b].add(a); // b에서 a로 해킹 가능
        }

        for(int i = 0; i < links.length; i++){
            visited = new boolean[n + 1];
            visitCnt = 0;
            dfs(i);
            cnt[i] = visitCnt;
        }

        int max = 0;
        for(int i = 0; i < cnt.length; i++){
            if (max < cnt[i]){
                max = cnt[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < cnt.length; i++){
            if(cnt[i] == max) {
                sb.append(i + " ");
            }
        }
        System.out.println(sb);
    }

    static void dfs(int node) {
        visited[node] = true;

        for(int i : links[node]){

            if(visited[i]) continue;
            visitCnt++;
            dfs(i);
        }
    }
}*/
import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int[][] graph;
    static int[][] ansGraph;
    static int n;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        graph = new int[n + 1][n + 1];
        ansGraph = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++){
            String[] s = br.readLine().split(" ");

            for(int j = 0; j < s.length; j++){
                graph[i][j + 1] = Integer.parseInt(s[j]);
                ansGraph[i][j + 1] = Integer.parseInt(s[j]);
            }
        }

        floydWarshall();

        for(int i = 1; i <= n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 1; j <= n; j++){
                sb.append(ansGraph[i][j] + " ");
            }
            System.out.println(sb);
        }

    }

    public static void floydWarshall(){
        for(int k = 1; k <= n; k++){   /// 중간노드
            for(int i = 1; i <= n; i++){/// 시작노드
                for(int j = 1; j <= n; j++){/// 종료노드
                    if((ansGraph[i][k] == 1 && ansGraph[k][j] == 1)){
                        ansGraph[i][j] = 1;
                    }
                }
            }
        }
    }
}