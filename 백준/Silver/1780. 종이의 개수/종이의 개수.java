

import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int n;

    static int[][] area;

    static int[][] checkArea;

    static int zeroPaper = 0;
    static int plusPaper = 0;
    static int minusPaper = 0;

    static int zeroCnt = 0;
    static int plusCnt = 0;
    static int minusCnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        area = new int[n + 1][n + 1];
        checkArea = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {

            String[] s = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {

                area[i][j] = Integer.parseInt(s[j - 1]);
            }
        }

         divide(1, 1, n);
         System.out.println(minusPaper + "\n"  + zeroPaper + "\n" + plusPaper);

    }/// 메인함수




    /// 왼쪽상단(y, x) 부터 x + num , y + num 까지 영역을 탐색
    ///  만약 다른 숫자가 있다면 재귀호출
    ///  모든 숫자가있다면 zeroPaper , plusPaper, minusPaper 중 일치하는것을 + 1해준다. 그리고 boolean값을 true로 반환.
    static void divide(int startX, int startY, int moveRange) {

        /// 확인해야할 종이의 범위
        int paperSize = moveRange * moveRange;

        ///  해당 영역에 있는 숫자를 확인할 변수 선언
        zeroCnt = 0;
        plusCnt = 0;
        minusCnt = 0;

        for(int i = startY; i < startY + moveRange; i++) {

            for(int j = startX; j < startX + moveRange; j++) {

                ///  영역이 1일경우 plusCnt + 1 해준다.
                ///  -1일경우 minusCnt + 1해준다.
                ///  0 일경우 zeroCnt + 1 해준다.
                if(area[i][j] == 1) {
                    plusCnt++;
                }
                if(area[i][j] == 0) {
                    zeroCnt++;
                }
                if(area[i][j] == -1) {
                    minusCnt++;
                }
            }
        }


        ///  종이의 모든 값을 확인했을때
        ///  종이범위내의 값들이 모두 같은 값일경우 일치하는 종이를 + 1해준다.
        if(zeroCnt == paperSize) {
            zeroPaper++;
            return;
        }
        if(plusCnt == paperSize) {
            plusPaper++;
            return;
        }
        if(minusCnt == paperSize) {
            minusPaper++;
            return;
        }

        ///  확인할수있는 범위 3등분
        int newMoveRange = moveRange / 3;

        /// 재귀 호출 진행.
        ///  각각의 범위를 분할해서 호출한다 moveRange에서 3등분한 newMoveRange
        ///  를통해 시작위치와 newMoveRange를 넘겨준다.
        
        ///  첫번째 열 확인
        divide(startX, startY, newMoveRange);
        divide(startX + newMoveRange, startY, newMoveRange);
        divide(startX + 2 * newMoveRange, startY, newMoveRange);


        ///  두번째 열 확인
        divide(startX, startY + newMoveRange, newMoveRange);
        divide(startX + newMoveRange, startY + newMoveRange, newMoveRange);
        divide(startX + 2 * newMoveRange, startY + newMoveRange, newMoveRange);

        ///  세번째 열 확인
        divide(startX, startY + 2  * newMoveRange, newMoveRange);
        divide(startX + newMoveRange, startY + 2 * newMoveRange, newMoveRange);
        divide(startX + 2 * newMoveRange, startY + 2 * newMoveRange, newMoveRange);
    }

}

