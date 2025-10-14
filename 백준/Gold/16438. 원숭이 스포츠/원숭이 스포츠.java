
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /// 행이 팀배치 열이 원숭이
    /// 7일동안 모든원숭이 한번씩은 적으로 만나야함 AB
    /// 열을 이진법으로 보고 2^1 부터 2 ^7의 결과가 달라진다면 모두 한번씩 만나게됨.
    ///  2 ^ 7 은 128개의 패턴을 만들수 있다 원숭이 숫자가 최대 99이므로 겹치지 않고 만들수있음.
    static int n;
    static char[][] mk ;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        mk = new char[n][7];

        for(int i = n - 1; i >= 0; i--){

            recur(i, i, 0);
        }

        for(int i = 0; i < 7; i++){
            int aCount = 0;
            boolean checkTeam = true;
            for(int j = 0; j < n; j++){
                if(j == n -1 && aCount == n - 1 ||j == n -1 && aCount == 0 ) {

                    if(aCount == n - 1){
                        System.out.print("B");
                    } else {
                        System.out.println("A");
                    }
                    break;
                }

                System.out.print(mk[j][i]);
                if(mk[j][i] == 'A'){
                    aCount++;
                }

            }
            System.out.println();
        }
    }

    ///  몽키번호를 /2해주면서 재귀호출을 함으로서 2진법형태로 만듦.
    static void recur(int monkeyNum, int changeNum, int day){

        if(day > 6) return;

        recur(monkeyNum, changeNum / 2, day + 1);


        if(changeNum % 2 == 0) {
            mk[monkeyNum][day] = 'A';
        } else {
            mk[monkeyNum][day] = 'B';
        }

    }


}
