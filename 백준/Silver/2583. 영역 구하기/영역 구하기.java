

import java.io.*;
import java.util.*;

public class Main {

    static boolean[][] area;
    static int ext;
    static List<Integer> areas = new ArrayList<>();
    static int[] moveX = {0 ,0 ,-1 ,1};
    static int[] moveY = {1, -1, 0, 0};
    static int m;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        //세로축
        m = Integer.parseInt(s[0]);
        //가로
        n = Integer.parseInt(s[1]);
        //사각형갯수.
        int k = Integer.parseInt(s[2]);

        area = new boolean[m][n];

        //k 개의 사각형 영역설정.
        for(int i = 0; i < k; i++){
             s = br.readLine().split(" ");
            int x1 = Integer.parseInt(s[0]);
            int y1 = Integer.parseInt(s[1]);
            int x2 = Integer.parseInt(s[2]);
            int y2 = Integer.parseInt(s[3]);

            for(int y = y1; y < y2; y++) {
                
                for(int x = x1; x < x2; x++){
                     area[y][x] = true;
                }
            }
        }

        for(int x = 0; x < n; x++){

            for(int y = 0; y < m; y++){
                // true일경우 해당 좌표 건너뜀.
                if(area[y][x]) continue;

                //만약 좌표가 false이면 dfs로 영역 탐색시작.
                dfs(x, y);
                // dfs이후에 ext(넓이)가 구해짐.
                // 너비 추가
                areas.add(ext);
                //너비 초기화
                ext = 0;
            }

        }

        

        System.out.println(areas.size());

        Collections.sort(areas);
        for(Integer i : areas){
            System.out.print(i + " ");
        }

    }

    static void dfs(int x, int y){

        /// 영역이 true이거나 좌표를 벗어날경우 종료
        //  조건을 좌표확인먼저 하지않아서 if(area[y][x] || x < 0 || y < 0 || y >= m || x >= n) 이경우 오류남. 
        if( x < 0 || y < 0 || y >= m || x >= n || area[y][x]) return;

        // 탐색한 영역 true로 변경
        area[y][x] = true;
        //넓이 +1
        ext++;

        // 상하좌우 탐색
        // 재귀호출로 탐색시작.
        for(int i = 0; i < 4; i++){
            int changedX = x + moveX[i];
            int changedY = y + moveY[i];
            dfs(changedX, changedY);
        }
    }

}
