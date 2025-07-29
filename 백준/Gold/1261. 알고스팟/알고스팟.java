import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int x;
    static int y;
    static int[][] arr;

    ///  1,1 부터 x,y 까지 가는 최소한의 벽 파괴횟수를 저장하기 위한 배열
    static int[][] checkArr;

    static int[] moveX = {0 ,0 , -1, 1};
    static int[] moveY = {1, -1, 0, 0};

    ///  checkArr을 초기화할 무한대값(최단경로를 모르기 때문에)
    ///  다익스트라 수행을 위해 checkArr의 1,1 을 제외한 모든 배열방을 INF로 초기화 후, 최솟값으로 갱신해나감.
    static final int INF = 2000000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        x =  Integer.parseInt(s[0]);
        y = Integer.parseInt(s[1]);

        arr = new int[y + 1][x + 1];
        checkArr = new int[y + 1][x + 1];

        for(int i = 1; i <= y; i++){

            s = br.readLine().split("");
            for(int j = 1; j <= x; j++){
                arr[i][j] = Integer.parseInt(s[j - 1]);

                ///  1,1(시작지점)은 0으로 넣어준다
                if(i == 1 && j == 1) {
                    checkArr[i][j] = 0;
                    continue;
                }

                ///  1,1(시작지점)이 아닐경우 무한대로 설정한다.
                checkArr[i][j] = INF;
            }
        }

        ///  다익스트라 메서드 호출. -> 1,1부터 다익스트라 시작함.
        dijkstra(1, 1);

        ///  다익스트라가 실행되고 난후  y, x 의 값은 최솟값으로 세팅되어있다.
        System.out.println(checkArr[y][x]);

    } ///메인함수


    /// 다익스트라 로직.
    static void dijkstra(int startX, int startY){

        /// nodeInfo의 wallCnt를 통해 오름차순으로 정렬하면서 큐에 넣어준다.
        /// 우선순위 큐를 활용해 제일 wallCnt가 적은값부터 차례로 값을 찾아나간다.
        PriorityQueue<NodeInfo> pq = new PriorityQueue<>((a, b) -> a.wallCnt - b.wallCnt);

        /// 시작 지점을 우선순위 큐에 넣어준다. 부순 벽은 0으로 세팅.
        pq.add(new NodeInfo(startX, startY, 0));

        /// 큐에 값이 없어질때 까지 반복.
        while(!pq.isEmpty()){

            /// 우선순위 큐에서 벽을 제일 적게 부순 노드를 가져온다.
            NodeInfo nodeInfo = pq.poll();

            int curX = nodeInfo.x;
            int curY = nodeInfo.y;
            int curWallCnt = nodeInfo.wallCnt;

            ///  curWallCnt가 checkArr[curY][curX] 보다 클경우 스킵
            if(curWallCnt > checkArr[curY][curX]){
                continue;
            }

            ///  4개의 방향으로 이동하면서 확인.
            for(int i = 0; i < 4; i++){
                int movedX = curX + moveX[i];
                int movedY = curY + moveY[i];

                ///범위를 벗어날경우 스킵
                if(movedX < 1 || movedX > x || movedY < 1 || movedY > y) continue;

                /// 현재 벽을 부슨 갯수에서 이동할 위치의 벽갯수를 더해준다.
                int newWallCnt = curWallCnt + arr[movedY][movedX];

                /// 만약 현재 cnt 가 checkArr의 값보다 작다면 큐에넣어주고 checkArr갱신
                if(newWallCnt < checkArr[movedY][movedX]) {

                    /// 값이작다면 우선순위 큐에 넣어준다.
                    pq.add(new NodeInfo(movedX, movedY, newWallCnt));
                    ///  checkArr을 newWallCnt로 갱신해준다.
                    checkArr[movedY][movedX] = newWallCnt;
                }
            }
        }

    } /// 다익스트라


    static class NodeInfo{
        int x;
        int y;
        int wallCnt;

        public NodeInfo(int x, int y, int wallCnt){
            this.x = x;
            this.y = y;
            this.wallCnt = wallCnt;
        }
    }
}