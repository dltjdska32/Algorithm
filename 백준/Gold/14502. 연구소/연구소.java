import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static int[][] area;
    static int[][] cpArea;
    static int n;
    static int m;
    static List<Point> zeroPoints = new ArrayList<>();
    static List<Point> twoPoints = new ArrayList<>();
    static int maxZeroCnt = 0;
    static int[] moveX = {-1, 0, 1, 0};
    static int[] moveY = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        area = new int[n + 1][m + 1];
        int oneCnt = 0;
        for(int i = 1; i <= n; i++) {
            s = br.readLine().split(" ");

            for(int j = 0; j < s.length; j++) {
                if(s[j].equals("0")) {
                    Point p = new Point(j + 1, i);
                    zeroPoints.add(p);
                }
                if(s[j].equals("1")) {
                    oneCnt++;
                }
                if(s[j].equals("2")) {
                    Point p = new Point(j + 1, i);
                    twoPoints.add(p);
                }
                area[i][j + 1] = Integer.parseInt(s[j]);
            }
        }

        ///  브루트 포스
        ///  1로 바꿀 3곳을 찾는다.
        for(int i = 0; i < zeroPoints.size(); i++) {

            Point p1 = zeroPoints.get(i);
            for(int j = i + 1; j < zeroPoints.size(); j++) {

                Point p2 = zeroPoints.get(j);
                for(int k = j + 1; k < zeroPoints.size(); k++) {

                    Point p3 = zeroPoints.get(k);

                    cpArea = new int[n + 1][m + 1];
                    for(int l = 1; l <= n; l++){
                        for(int l2 = 1; l2 <= m; l2++){
                            if(l == p1.y && l2 == p1.x) {
                                cpArea[l][l2] = 1;
                                continue;
                            }
                            if(l == p2.y && l2 == p2.x) {
                                cpArea[l][l2] = 1;
                                continue;
                            }
                            if(l == p3.y && l2 == p3.x) {
                                cpArea[l][l2] = 1;
                                continue;
                            }

                            cpArea[l][l2] = area[l][l2];
                        }
                    }

                    for(int l3 = 0; l3 < twoPoints.size(); l3++) {
                        dfs(twoPoints.get(l3).x, twoPoints.get(l3).y);
                    }
                    int cnt = 0;

                    for(int l4 = 1; l4 <= n; l4++) {
                        for(int l5 = 1; l5 <= m; l5++) {
                            if(cpArea[l4][l5] == 0) {
                                cnt++;
                            }
                        }
                    }

                    maxZeroCnt = Math.max(maxZeroCnt, cnt);
                }

            }
        }
        System.out.println(maxZeroCnt);
    }

    static void dfs(int x, int y){


        for(int i = 0; i < 4; i++){
            int movedX = moveX[i] + x;
            int movedY = moveY[i] + y;

            if(movedX < 1 || movedX > m || movedY < 1 || movedY > n){
                continue;
            }
            if(cpArea[movedY][movedX] == 2 || cpArea[movedY][movedX] == 1){
                continue;
            }

            cpArea[movedY][movedX] = 2;
            dfs(movedX, movedY);
        }
    }

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
