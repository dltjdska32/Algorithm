import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int[][] area;
    static List<int[][]> stickers = new ArrayList<>();
    static int n;
    static int m;
    static int k;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);

        area = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];
        for (int i = 0; i < k; i++) {

            s = br.readLine().split(" ");
            int y = Integer.parseInt(s[0]);
            int x = Integer.parseInt(s[1]);
            int[][] stk = new int[y + 1][x + 1];
            for (int j = 1; j <= y; j++) {
                s = br.readLine().split(" ");
                for (int j1 = 0; j1 < x; j1++) {

                    stk[j][j1 + 1] = Integer.parseInt(s[j1]);
                }
            }
            stickers.add(stk);
        }

        int stkCnt = 0;
        int curStkSize = 0;

        for(int i = 0; i < stickers.size(); i++) {
            int[][] stk = stickers.get(i);
            ///  회전 0 90 180 270
            for(int rt = 0; rt < 4; rt++) {

                boolean isAttached = false;

                ///  노트북 순회
                for(int j = 1; j <= n; j++){
                    for(int j1 = 1; j1 <= m; j1++) {

                        ///  붙힐수 있는지 확인 후 붙힘
                        if(checkAttach(stk, j1, j)) {

                            for(int k1 = 1; k1 <= stk.length - 1; k1++) {
                                for(int k2 = 1; k2 <= stk[k1].length - 1; k2++) {
                                    if(stk[k1][k2] == 1){
                                        area[j + k1 -1][j1 + k2 -1] = 1;
                                    }
                                }
                            }

                            isAttached = true;
                            break;
                        }
                    }
                    if(isAttached) {
                        break;
                    }

                    if(isAttached) {
                        break;
                    }
                }

                if(isAttached) {
                    break;
                }

                stk = rotateStk(stk);
            }
        }


        int ans = 0;
        for(int i =1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(area[i][j] == 1){
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

    ///  붙힐수있는지 확인.
    static boolean checkAttach(int[][] sticker, int x, int y){

        int row = sticker.length - 1;
        int col = sticker[0].length - 1;

        if(x + col - 1 > m || y + row - 1 > n){
            return false;
        }

        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                ///  겹칠경우 false
                if(sticker[i][j] == 1 && area[i + y - 1][j + x - 1] == 1){
                    return false;
                }
            }
        }

        return true;
    }

    ///  90도 회전함수
    static int[][] rotateStk(int[][] stk){
        int row = stk.length - 1;
        int col = stk[0].length - 1;
        int[][] rotatedStk = new int[col + 1][row + 1];

        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                rotatedStk[j][row - i + 1] = stk[i][j];
            }
        }


        return rotatedStk;
    }



}
