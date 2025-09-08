import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static int n;
    static int[][] area;
    static int[][] cpArea;
    static int m;
    static int minSec = 2000000000;
    static int[] moveX = {-1, 0, 1, 0};
    static int[] moveY = {0, -1, 0, 1};
    static int emptyCnt = 0;
    static Queue<Point> infect = new LinkedList<>();
    static List<Point> virusSpot = new ArrayList<>();
    static List<Point> virusList = new  ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        area = new int[n + 1][n + 1];
        cpArea = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {

            s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                if(s[j].equals("2")) {
                    virusSpot.add(new Point(j + 1, i, 0));
                }
                if(s[j].equals("0")) {
                    emptyCnt++;
                }

                area[i][j + 1] = Integer.parseInt(s[j]);
            }
        }

        emptyCnt += virusSpot.size() - m;

        if(emptyCnt == 0){
            System.out.println(0);
            return;
        }

        dfs(virusList, 0);

        if (minSec == 2000000000) {
            System.out.println(-1);
        } else {
            System.out.println(minSec);
        }
    }

    static void dfs(List<Point> virusList, int s) {

        if(virusList.size() == m) {
            infect.clear();
            bfs(virusList);
            return;
        }

        for(int i = s; i < virusSpot.size(); i++){
            virusList.add(virusSpot.get(i));
            dfs(virusList, i + 1);
            virusList.remove(virusList.size() - 1);
        }

    }

    static void bfs(List<Point> virusList) {

        boolean[][] visited = new boolean[n + 1][n + 1];

        for(int i = 0; i < virusList.size(); i++){
            infect.add(virusList.get(i));
            Point point = virusList.get(i);
            visited[point.y][point.x] = true;
        }

        int infectCnt = 0;
        int max = 0;
        while(!infect.isEmpty()){
            Point p = infect.poll();

            int movedX = 0;
            int movedY = 0;
            for(int j = 0; j < 4; j++){
                movedX = p.x + moveX[j];
                movedY = p.y + moveY[j];

                if(movedX > n || movedX < 1 || movedY > n || movedY < 1){
                    continue;
                }

                if(visited[movedY][movedX] != true && area[movedY][movedX] != 1){
                    visited[movedY][movedX] = true;
                    int time = p.time + 1;
                    infect.add(new Point(movedX, movedY, time));

                    if(area[movedY][movedX] != 1){
                        infectCnt++;
                        max = Math.max(max, time    );
                    }
                }
            }
        }
        if(infectCnt == emptyCnt){
            minSec = Math.min(minSec, max);
        }
    }




    static class Point {
        int x;
        int y;
        int time;
        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
