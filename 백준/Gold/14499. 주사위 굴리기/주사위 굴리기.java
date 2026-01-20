import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/// 주사위 굴리기     14499
///
/// 주사위 초기값 0
/// 주사위를 이동하면서 주사위 바닥면이 0일경우 지도의 숫자 흡수     지도숫자 변경 x
/// 주사위를 이동하면서 주사위 바닥면이 0이 아닐경우 지도 숫자 흡수  지도숫자 0으로 초기화
class Main{

    public static int[] horizontal = {0,0,0,0};  ///가로          위 앞 아래 뒤
    public static int[] vertical = {0,0,0,0};    /// 세로         위 오른 아래 왼

    public static int[][] area;
    static int y;
    static int x;

    static int curY;   /// 세로축
    static int curX;   /// 가로축

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");


        for(int i = 0; i < s.length; i++){

            if(i == 0){
                y = Integer.parseInt(s[i]) + 1;
            }
            if(i == 1){
                x = Integer.parseInt(s[i]) + 1;
            }
            if(i == 2){
                curY = Integer.parseInt(s[i]) + 1;
            }
            if(i == 3){
                curX = Integer.parseInt(s[i]) + 1;
            }
        }

        /// 지도생성.
        area = new int [y][x];

        for(int i = 1; i < y; i++){

            s = br.readLine().split(" ");

            for(int j = 0; j < s.length; j++){

                int num =  Integer.parseInt(s[j]);

                area[i][j + 1] = num;
            }
        }

        s = br.readLine().split(" ");

        for(int i = 0; i < s.length; i++){

            int q =  Integer.parseInt(s[i]);

            moveAndChangeDice(q);
        }

    }




    public static void moveAndChangeDice(int q) {



        ///  1 동 2 서
        /// 3 북 4 남
        if(q == 1){
            curX++;

            if(curX >= x) {
                curX--;
                return;
            }

            moveHorizontal(q);
        } else if(q == 2){

            curX--;

            if(curX < 1) {
                curX++;
                return;
            }


            moveHorizontal(q);
        } else if(q == 3){

            curY--;

            if(curY < 1) {
                curY++;
                return;
            }

            moveVertical(q);
        } else {

            curY++;

            if(curY >= y) {
                curY--;
                return;
            }

            moveVertical(q);
        }

    }


    /// 가로          위 앞 아래 뒤
    /// 세로         위 오른 아래 왼

    /// 세로
    static void moveVertical(int q) {




        if(q == 3){   /// 북   -  vertical 을 한칸씩 위로 이동
                     ///          로직수행


            rotateN();

            if(area[curY][curX] == 0){ /// 칸이 0 일경우

                int tmp = vertical[2];
                area[curY][curX] = tmp;

            }else {               ///  칸이 0 이아닐경우

                int tmp = area[curY][curX];
                area[curY][curX] = 0;
                vertical[2] = tmp;
            }

        } else {      /// 남   -  vertical 을 한칸씩 아래로 이동
                      ///          로직수행

            rotateS();

            if(area[curY][curX] ==  0){

                int tmp = vertical[2];
                area[curY][curX] = tmp;

            }else {

                int tmp = area[curY][curX];
                area[curY][curX] = 0;
                vertical[2] = tmp;
            }

        }

        ///          horizontal 윗면 변경
        horizontal[0] = vertical[0];
        ///         horizontal 아랫면 변경
        horizontal[2] = vertical[2];

        System.out.println(vertical[0]);

    }


    /// 가로
    static void moveHorizontal(int q) {



        if(q == 1){  /// 동

            rotateE();


            if(area[curY][curX] == 0){ /// 지도 0 일경우

                int tmp = horizontal[2];
                area[curY][curX] = tmp;

            }else {               ///  아랫면 1이상일경우

                int tmp = area[curY][curX];
                area[curY][curX] = 0;
                horizontal[2] = tmp;
            }


        } else {     ///  서

            rotateW();

            if(area[curY][curX] == 0){ /// 아랫면 0 일경우

                int tmp = horizontal[2];
                area[curY][curX] = tmp;

            }else {               ///  아랫면 1이상일경우

                int tmp = area[curY][curX];
                area[curY][curX] = 0;
                horizontal[2] = tmp;
            }
        }


        vertical[0] = horizontal[0];
        vertical[2] = horizontal[2];

        System.out.println(horizontal[0]);
    }



    static void rotateN() {

        int tmp1 = vertical[0];
        int tmp2 = vertical[1];
        int tmp3 = vertical[2];
        int tmp4 = vertical[3];

        vertical[0] = tmp2;
        vertical[1] = tmp3;
        vertical[2] = tmp4;
        vertical[3] = tmp1;
    }


    static void rotateS() {
        int tmp1 = vertical[0];
        int tmp2 = vertical[1];
        int tmp3 = vertical[2];
        int tmp4 = vertical[3];


        vertical[0] = tmp4;
        vertical[1] = tmp1;
        vertical[2] = tmp2;
        vertical[3] = tmp3;
    }

    static void rotateE() {

        int tmp1 = horizontal[0];
        int tmp2 = horizontal[1];
        int tmp3 = horizontal[2];
        int tmp4 = horizontal[3];

        horizontal[0] = tmp4;
        horizontal[1] = tmp1;
        horizontal[2] = tmp2;
        horizontal[3] = tmp3;
    }

    static void rotateW() {

        int tmp1 = horizontal[0];
        int tmp2 = horizontal[1];
        int tmp3 = horizontal[2];
        int tmp4 = horizontal[3];

        horizontal[0] = tmp2;
        horizontal[1] = tmp3;
        horizontal[2] = tmp4;
        horizontal[3] = tmp1;
    }
}