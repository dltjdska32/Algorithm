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
                ///  2일경우 바이러스 위치 저장.
                if(s[j].equals("2")) {
                    virusSpot.add(new Point(j + 1, i, 0));
                }
                /// 0일경우 비어있는 공간 카운트
                if(s[j].equals("0")) {
                    emptyCnt++;
                }

                area[i][j + 1] = Integer.parseInt(s[j]);
            }
        }


        ///  처음입력받을때 비어있는공간이없다면 0출력후 종료
        if(emptyCnt == 0){
            System.out.println(0);
            return;
        }

        /// dfs로 활성바이러스선택
        dfs(virusList, 0);


        if (minSec == 2000000000) {
            System.out.println(-1);
        } else {
            System.out.println(minSec);
        }
    }

    static void dfs(List<Point> virusList, int s) {

        /// 바이러스 리스트사이즈가 m 이될경우
        /// 활성바이러스 조건에 맞을경우 dfs시작.
        if(virusList.size() == m) {
            infect.clear();
            bfs(virusList);
            return;
        }

        /// dfs를 해가면서 활성바이러스 추가.
        for(int i = s; i < virusSpot.size(); i++){
            virusList.add(virusSpot.get(i));
            dfs(virusList, i + 1);
            virusList.remove(virusList.size() - 1);
        }

    }

    /// 바이러스 퍼트림.
    static void bfs(List<Point> virusList) {

        boolean[][] visited = new boolean[n + 1][n + 1];


        /// 감염 큐에 바이러스를 추가하고 방문표시
        for(int i = 0; i < virusList.size(); i++){
            infect.add(virusList.get(i));
            Point point = virusList.get(i);
            visited[point.y][point.x] = true;
        }

       ///  감염 갯수
        int infectCnt = 0;
        ///  최대 시간.
        int max = 0;
        /// bfsㅎ시작.
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

                /// 벽이거나 방문했던 곳이아닐경우 실행.
                if(visited[movedY][movedX] != true && area[movedY][movedX] != 1){
                    /// 방문표시
                    visited[movedY][movedX] = true;
                    /// 시간 추가후, 새로운 point생성해서 infect큐에 넣어줌.
                    int time = p.time + 1;
                    infect.add(new Point(movedX, movedY, time));

                    ///  최대시간계산, 감염갯수증가.
                    if(area[movedY][movedX] == 0){
                        infectCnt++;
                        max = Math.max(max, time);
                    }
                }
            }
        }
        /// 감염갯수와 빈공간의 갯수가 같다면 최솟값을 구함.
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
