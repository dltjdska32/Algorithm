import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n;
    static int[] board;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        // n 크기의 보드 생성
        // 인덱스 번호는 행
        // 인덱스 안의 값은 열.
        board = new int[n];
        // 0, 0 부터 시작
        bt(0);

        System.out.println(cnt);
    }


    static void bt(int row){

        // row 가 n 까지 왔다면 cnt++후 리턴
        // n번째 행까지 왔다는건 행을 초과했기때문에 마지막 까지 두었다는것.
        if(row == n) {
            cnt++;


            return;
        }


        // 재귀호출의경우 행을 증가
        // for문은 열을 증가.
        // loc 부터 차례로 퀸을 보드에 둔다.
        // 열 이나 대각선에 퀸이있으면 종료 있으면 리턴 하고 다음 으로 넘어간다.
        for(int i = 0; i < n; i++){
            // row에 i를 임시로 넣고 가능한 위치인지 확인한다.
            board[row] = i;

            boolean check = true;
            // 가능한위치인지 확인
            if(row > 0) {

                for(int j = 0; j < row; j++){

                    // 동일 열에 있을경우
                    if (board[row] == board[j]) {
                        check = false;
                        break;
                    }
                    // 동일한 대각선상에 있을경우
                    if(Math.abs(row - j) == Math.abs(board[row] - board[j])){
                        check = false;
                        break;
                    }
                }
            }

            //만약 걸리는게없으면 다음행으로 이동
            if(check) {
                bt(row + 1);
            }
        }

    }





}
