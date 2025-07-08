
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    static int[] moveX = {0, 0, -1, 1};
    static int[] moveY = {-1, 1, 0, 0};

    static int cnt = 0;
    static int[][] box;
    static int m;
    static int n;
    static Queue<Point> q = new LinkedList<>();
    static Queue<Point> tempQ = new LinkedList<>();

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split( " ");
        // 세로
        n = Integer.parseInt(s[1]);
        // 가로
        m = Integer.parseInt(s[0]);

        box = new int[n][m];



        int zeroCnt = 0;
        int oneCnt = 0;
        // 토마토 세팅
        for(int i = 0; i < n; i++){

            s = br.readLine().split(" ");
            for(int j = 0; j < m; j++){

                box[i][j] = Integer.parseInt(s[j]);
                // 초기 1 좌표 q에 저장.
                if(box[i][j] == 1){
                    q.add(new Point(j,i));
                    oneCnt++;
                }
                if(box[i][j] == 0){
                    zeroCnt++;
                }
            }
        }

        // 저장될때부터 모든 토마토익어있을경우 -> 0출력
        if(zeroCnt == 0 && oneCnt > 0){
            System.out.println(0);
            return;
        }

        //q사이즈가 0일경우 
        //처음 입력받은 값중 익은 토마토가 없는경우 -> -1출력
        if(q.size() == 0){
            System.out.println(-1);
            return;
        }
        
        
        int qSize = q.size();
        
        // q사이즈만큼 반복
        for(int i = 0; i < qSize; i++){
            Point p = q.poll();
            
            // bfs메서드를 통해 영역 탐색
            for(int j = 0; j < 4; j++){
                int changedX = p.x + moveX[j];
                int changedY = p.y + moveY[j];
                bfs(new Point(changedX, changedY));
            }

            // tempQ의 값들을 Q로 옮기고 i를 0으로 초기화후 다시 포문 을돌린다.
            if(i == qSize - 1){

                i = -1;
                // tempQ의 값들을 Q로 옮긴다.
                q.addAll(tempQ);
                qSize = q.size();

                // tempQ초기화.
                tempQ.clear();
                // cnt + 1;
                cnt++;
            }
        }

        zeroCnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(box[i][j] == 0) zeroCnt++;
            }
        }

        // 0이 하나라도 있으면 익지않은 토마토있음  -> -1 출력
        if(zeroCnt > 0){
            System.out.println(-1);
            return;
        }


        System.out.println(cnt - 1);

    }
    
    // 큐에 넣을 좌표 정보를 담을 객체
    static class Point{
        int x;
        int y;
        public Point (int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    // tempQ에 추가
    static void bfs(Point point){
        int x = point.x;
        int y = point.y;

        // 영역 초기화
        if(x < 0 || x >= m || y < 0 || y >= n || box[y][x] != 0) return;

        // x, y 좌표의 토마토 1로변경후 tempQ에 추가.
        box[y][x] = 1;
        tempQ.add(new Point(x, y));
    }
}


