import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static int n;
    static int l;
    static int r;

    static boolean[][] check;
    static int[][] area;

    static int[] moveToX = {0, 1, 0, -1};
    static int[] moveToY = {1, 0, -1, 0};

    static List<Point> unionList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        l = Integer.parseInt(s[1]);
        r = Integer.parseInt(s[2]);

        area = new int[n + 1][n + 1];
        check = new boolean[n + 1][n + 1];

        for(int i=1; i <=n; i++){
            s = br.readLine().split(" ");
            for(int j = 1; j <= n; j++){
                area[i][j] = Integer.parseInt(s[j - 1]);
            }
        }



        int ans = 0;

        while(true) {

            /// 방문기록 초기화 및 플래그 초기화
            boolean flag = false;
            check = new boolean[n + 1][n + 1];

            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){

                    ///  방문하지 않았다면
                    if(!check[i][j]){
                        unionList = new ArrayList<>();
                        int sum =  dfs(i, j, unionList);
                        ///  연합이 2개 이상일경우
                        if(unionList.size() > 1) {
                            flag = true;

                            int newPopulation = sum /  unionList.size();

                            /// 인구 재분배
                            for(int k = 0; k < unionList.size(); k++){
                                Point point = unionList.get(k);
                                area[point.y][point.x] = newPopulation;
                            }
                        }
                    }
                }
            }

            if(flag != true){
                break;
            }
            ans++;

        }

        System.out.println(ans);
    }



    static int dfs(int y, int x, List<Point> unionList){

        if(check[y][x] == true) return 0;
        check[y][x] = true;
        unionList.add(new Point(x, y));
        int comp = area[y][x];
        int sum = area[y][x];
        for(int i = 0; i < 4; i++){
            int movedX = moveToX[i] + x;
            int movedY = moveToY[i] + y;

            if(movedX < 1 || movedX > n || movedY < 1 || movedY > n){
                continue;
            }

            if(!check[movedY][movedX]) {
                int comp2 = area[movedY][movedX];
                int interval = Math.abs(comp - comp2);

                if (interval >= l && interval <= r) {

                    sum += dfs(movedY, movedX, unionList);
                }

            }
        }
        return sum;
    }

    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
