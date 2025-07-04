import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int n = 0;
    static int m = 0;
    static int ans = 0;
    static int[][] graph;
    static int[] visited;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new int[n + 1][n + 1];
        visited =   new int [n + 1];
        
        for(int i = 0; i < m; i++){
            String[] s = br.readLine().split(" ");
            int nod1 = Integer.parseInt(s[0]);
            int nod2 = Integer.parseInt(s[1]);

            graph[nod1][nod2] = graph[nod2][nod1] = 1;
        }
        dfs(1);
        System.out.println(ans);
    }

    static void dfs(int index){
        if(index != 1) ans++;

        for(int i = 1; i <= n; i++){
            if(visited[i] != 1 && graph[index][i] == 1){
                visited[i] = 1;
                dfs(i);
            }
        }

    }
}
