import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int n;
    static int m;
    static int max = 0;
    static int[][] area;
    static boolean[][] visit;
    static int[] mvX = {-1, 0, 1, 0};
    static int[] mvY = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        area = new int[n + 1][m + 1];
        visit = new boolean[n + 1][m + 1];

        for(int i = 1; i <=n; i++){
            s = br.readLine().split(" ");
            for(int j = 0; j < s.length; j++){
                area[i][j + 1] = Integer.parseInt(s[j]);
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                visit[i][j] = true;
                /// ㅗ ㅏ ㅜ ㅓ 제외 모든 테트리스 탐색.
                dfs(j, i, area[i][j], 1);
                visit[i][j] = false;
                /// ㅗ ㅏ ㅜ ㅓ 탐색
                findMax(j, i);


            }
        }

        System.out.println(max);
    }


    static void dfs(int x, int y, int cnt, int depth) {
        /// 맥스갱신
        if(depth == 4){
            max = Math.max(max, cnt);
            return;
        }


        for(int i = 0; i < 4; i++){

            int movedX = x +  mvX[i];
            int movedY = y +  mvY[i];

            if(movedX < 1 || movedX > m ||  movedY < 1 || movedY > n){
                continue;
            }
            /// dfs재귀호출.
            if(!visit[movedY][movedX]){
                visit[movedY][movedX] = true;
                dfs(movedX, movedY, cnt + area[movedY][movedX], depth + 1);
                visit[movedY][movedX] = false;
            }

        }

    }

    static void findMax (int x, int y){

        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        int cnt4 = 0;

        ///  ㅗ
        if(x - 1 >= 1 && x + 1 <= m && y - 1 >= 1 && y  <= n){

            int top = area[y - 1][x];
            int bottom = area[y][x];
            int left = area[y][x - 1];
            int right = area[y][x + 1];
            cnt1 = top + bottom + left + right;
        }

        ///  ㅏ
        if(x  >= 1 && x + 1 <= m && y + 1 <= n && y - 1 >= 1){
            int top = area[y - 1][x];
            int center = area[y][x];
            int bottom = area[y + 1][x];
            int right = area[y][x + 1];
            cnt2 = top + center + bottom + right;
        }

        ///  ㅜ
        if(x - 1 >= 1 && x + 1 <= m && y  >= 1 && y + 1 <= n){
            int center = area[y][x];
            int bottom = area[y + 1][x];
            int left = area[y][x - 1];
            int right = area[y][x + 1];
            cnt3 = center + bottom + left + right;
        }

        ///  ㅓ
        if(x - 1 >= 1 && x  <= m && y - 1 >= 1 && y + 1 <= n){
            int center = area[y][x];
            int left = area[y][x - 1];
            int top =  area[y - 1][x];
            int bottom = area[y + 1][x];
            cnt4 = top + center + bottom + left;
        }


        int maxcnt = Math.max(cnt1, Math.max(cnt2, Math.max(cnt3, cnt4)));
        max = Math.max(max, maxcnt);
    }
}
