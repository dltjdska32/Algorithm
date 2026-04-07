import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main{

    static int n;

    static int[][] base;

    static int[][] check;


    public static int[] moveX = {1, 0, - 1, 0};
    public static int[] moveY = {0, -1, 0, +1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        base = new int [n + 1][n+1];
        check = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){

            String[] s = br.readLine().split("");

            for(int j = 1; j <= n; j++){
                int num  = Integer.parseInt(s[j-1]);
                base[i][j] = num;
                check[i][j] = 100000000;
            }
        }

        findAns(1, 1);

        System.out.println(check[n][n]);
    }



    public static void findAns(int x, int y) {

        Queue<Info> q = new LinkedList<>();

        q.add(new Info(x, y));

        /// 시작지점 0으로초기화
        check[y][x] = 0;

        while(!q.isEmpty()){

            Info poll = q.poll();

            int curX = poll.x;
            int curY = poll.y;

            for(int i = 0; i < 4; i++){

                int movedX = moveX[i] + curX;
                int movedY = moveY[i] + curY;

                int checkVal = check[curY][curX];


                ///  범위 초과 스킵
                if(movedY > n || movedX > n || movedX < 1 || movedY < 1){
                    continue;
                }

                int addVal = 0;

                if(base[movedY][movedX] == 0){
                    addVal = 1;
                }


                if(check[movedY][movedX] > check[curY][curX] + addVal){
                    check[movedY][movedX] = check[curY][curX] + addVal;
                    q.add(new Info(movedX, movedY));
                }


            }

        }


    }


    public static class Info{
        int x;
        int y;

        public Info(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}