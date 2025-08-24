import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static int n;
    static int m;
    static int[][] area;
    static List<Point> housePoints = new ArrayList<>();
    static List<Point> chickenPoints = new ArrayList<>();
    static int ans;
    static boolean[] check;
    public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] s = br.readLine().split(" ");
            n = Integer.parseInt(s[0]);
            m = Integer.parseInt(s[1]);

            area = new int[n + 1][n + 1];

            /// 치킨집 , 집, 지역 설정.
            for(int i = 1; i <= n; i++) {
                s = br.readLine().split(" ");
                for(int j = 0; j < n; j++) {

                    area[i][j + 1] = Integer.parseInt(s[j]);

                    if(s[j].equals("1")){
                        housePoints.add(new Point(i, j + 1));
                        continue;
                    }
                    if(s[j].equals("2")){
                        chickenPoints.add(new Point(i, j + 1));
                    }

                }
            }
            ans  = 2000000000;
            check = new boolean[chickenPoints.size()];
            dfs(0, 0);
            System.out.println(ans);
    }

    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    ///  bfs
    static void dfs(int cnt, int s){

        ///  cnt가 m과 같다면 확인후 종료
        if(cnt == m){

            int sum = 0;

            for(int i = 0; i < housePoints.size(); i++){
                int temp = 2000000000;

                for(int j = 0; j < chickenPoints.size(); j++){
                    if(check[j]) {
                        Point p1 = housePoints.get(i);
                        Point p2 = chickenPoints.get(j);
                        int dist = findDist(p1.x, p1.y, p2.x, p2.y);

                        if(temp > dist) {
                            temp = dist;
                        }
                    }
                }

                sum += temp;
            }

            if(ans > sum){
                ans = sum;
            }
            return;
        }


        for(int i = s; i < chickenPoints.size(); i++){
            check[i] = true;
            dfs(cnt + 1, i + 1);
            check[i] = false;
        }
    }


    ///  거리구하는 로직.
    static int findDist(int x, int y, int x1, int y1){

        return Math.abs(x1 - x) + Math.abs(y1 - y);
    }


}
