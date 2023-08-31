import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        // 가장 큰 무게의 봉투 (big) = 5 , 가장 작은 무게의 봉투 (small) = 3
        int big = 5;
        int small = 3;

        //입력받은 무게
        int n = Integer.parseInt(br.readLine());

        //큰무게 봉투 갯수 (bigResult) , 작은 무게 봉투 (smallResult)
        int bigResult = 0;
        int smallResult = 0;

        // for문 조건을 충족시 이중 포문 탈출을 위한 boolean
        boolean b1 = false;

        //모든 조건을 충족하지 못할경우 -1 을 출력하기 위한 boolean
        boolean b2 = false;


        // 큰무게를 하나씩 감소시키고, 작은무게를 하나씩 증가시켜서 문제에 충족하는 봉투갯수를 구한다.
        //i = 큰 무게 봉투 갯수 ,  j = 작은 무게 봉투 갯수.
        for(int i = n / 5 + 1; i >= 0; i--){
            if(big * i > n){
                continue;
            }
            for(int j = 0; j <= n / 3 + 1; j++){

                // n 에 0을 입력시 아래의 if문을 통과하게 되어 곧바로 0을 출력하게 된다.
                //따라서 맨아래 if - else if 구문에 if(b2 || n == 0)를 조건으로 하였다.
                if(big * i + small * j == n){
                    bigResult = i;
                    smallResult = j;
                    b1 = true;
                    break;
                }

                if((i == 0 && j == n / 3 + 1) && big * i + small * j != n){
                    b2 = true;
                }
            }
            if(b1){
                break;
            }
        }

        if(b2 || n == 0){
            bw.write("-1");
        }else{
            bw.write(String.valueOf(bigResult + smallResult));
        }

        bw.flush();
        bw.close();
    }
}
