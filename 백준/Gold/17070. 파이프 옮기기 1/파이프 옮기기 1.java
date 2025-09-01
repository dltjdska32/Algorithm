import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static int n;
    static int[][] area;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        area = new int[n + 1][n + 1];
        Location lc = new Location(1, 1, 2, 1);

        /// area설정
        for(int i = 1; i <= n; i++) {
            String[] s = br.readLine().split(" ");
            for(int j = 0; j < s.length; j++) {
                area[i][j+1] = Integer.parseInt(s[j]);
            }
        }

        dfs(lc);

        System.out.println(count);
    }

    static class Location{
        int sX, sY, eX, eY;
        Location(int sX, int sY, int eX, int eY){
            this.sX = sX;
            this.sY = sY;
            this.eX = eX;
            this.eY = eY;
        }
    }

    static void dfs (Location lc){

        if(lc.eX == n && lc.eY == n){
            count++;
            return;
        }

        if(lc.eX > n || lc.eY > n){
            return;
        }

        /// 이동하는 위치에 1이 있는지 확인
        /// 가로
        if(lc.sX + 1 == lc.eX && lc.sY == lc.eY){

            /// 가로로 한칸이동 후 dfs
            if(lc.eX + 1 <= n && area[lc.eY][lc.eX + 1] == 0){
                lc.sX += 1;
                lc.eX += 1;
                dfs(lc);
                lc.sX -= 1;
                lc.eX -= 1;
            }
            /// 대각선 한칸 이동후 dfs
            if(lc.eX + 1 <= n
                    && lc.eY + 1 <= n
                    && area[lc.eY + 1][lc.eX + 1] == 0
                    && area[lc.eY + 1][lc.eX] == 0
                    && area[lc.eY][lc.eX + 1] == 0){
                lc.eX += 1;
                lc.eY += 1;
                lc.sX += 1;
                dfs(lc);
                lc.eX -= 1;
                lc.eY -= 1;
                lc.sX -= 1;
            }
        }

        /// 세로
        if(lc.sX == lc.eX && lc.sY + 1 == lc.eY){
            ///  세로로 한칸 이동후 dfs
            if(lc.eY + 1 <= n && area[lc.eY + 1][lc.eX] == 0){
                lc.sY += 1;
                lc.eY += 1;
                dfs(lc);
                lc.sY -= 1;
                lc.eY -= 1;
            }
            ///  대각선 한칸이동후 dfs
            if(lc.eY + 1 <= n
                    && lc.eX + 1 <= n
                    && area[lc.eY + 1][lc.eX + 1] == 0
                    && area[lc.eY + 1][lc.eX] == 0
                    && area[lc.eY][lc.eX + 1] == 0){
                lc.eX += 1;
                lc.eY += 1;
                lc.sY += 1;
                dfs(lc);
                lc.eX -= 1;
                lc.eY -= 1;
                lc.sY -= 1;
            }
        }


        /// 대각선
        if(lc.sX + 1 == lc.eX && lc.sY  + 1== lc.eY){
            /// 가로로 이동후 dfs
            if(lc.eX + 1 <= n && area[lc.eY][lc.eX + 1]== 0){
                lc.sX += 1;
                lc.sY += 1;
                lc.eX += 1;
                dfs(lc);
                lc.sX -= 1;
                lc.eX -= 1;
                lc.sY -= 1;
            }
            /// 세로로 이동후 dfs
            if(lc.eY + 1 <= n && area[lc.eY + 1][lc.eX] == 0){
                lc.sX += 1;
                lc.sY += 1;
                lc.eY += 1;
                dfs(lc);
                lc.sX -= 1;
                lc.sY -= 1;
                lc.eY -= 1;
            }

            /// 대각선으로 이동후dfs
            if(lc.eY + 1 <= n
                    && lc.eX + 1 <= n
                    && area[lc.eY + 1][lc.eX + 1] == 0
                    && area[lc.eY + 1][lc.eX] == 0
                    && area[lc.eY][lc.eX + 1] == 0){
                lc.eX += 1;
                lc.eY += 1;
                lc.sX += 1;
                lc.sY += 1;
                dfs(lc);
                lc.eX -= 1;
                lc.eY -= 1;
                lc.sY -= 1;
                lc.sX -= 1;
            }

        }
    }
}
