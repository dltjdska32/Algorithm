
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {


    static boolean[][] area;
    static int size = 0;
    static int[] moveX = {0, 0, -1, 1};
    static int[] moveY = {-1, 1, 0, 0};
    static int y;
    static int x;
    static List<Integer> pictures = new ArrayList<>();
    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s =br.readLine().split(" ");
        // 세로
        y = Integer.parseInt(s[0]);
        // 가로
        x = Integer.parseInt(s[1]);

        area = new boolean[y][x];

        // 그림 세팅
        for(int i = 0; i < y; i++){
            s = br.readLine().split(" ");
            for(int j = 0; j < x; j++){

                if((Integer.parseInt(s[j])) == 1) area[i][j] = true;
            }
        }

        // 탐색
        for(int i = 0; i < y; i++){

            for(int j = 0; j < x; j++){
                // 만약 영역이 그림이아닐경우 건너뜀.
                if(area[i][j] == false) continue;

                // 탐색시작.
                dfs(j, i);
                //그림사이즈 추가.
                pictures.add(size);
                //사이즈 초기화
                size = 0;
            }
        }

        // 그림이 없을경우
        if(pictures.size() == 0){
            System.out.println(0);
            System.out.println(0);
            return;
        }

        System.out.println(pictures.size());

        Collections.sort(pictures);
        System.out.println(pictures.get(pictures.size() - 1));
    }

    static void dfs(int tmpX, int tmpY){
        // 영역을 벗어나거나, 해당영역이 false일경우 종료.
        if(tmpX < 0 || tmpY < 0 || tmpX >= x || tmpY >= y || area[tmpY][tmpX] == false) return;

        //사이즈 +1
        size++;
        //area 의 true를 false로 변경
        area[tmpY][tmpX] = false;

        for(int i = 0; i < 4; i++){
            int changedX = tmpX + moveX[i];
            int changedY = tmpY + moveY[i];
            dfs(changedX, changedY);
        }
    }

}


