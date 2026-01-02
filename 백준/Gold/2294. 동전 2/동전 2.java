import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static int MAX_VALUE = 100000000;
    public static void main(String[] args) throws Exception {



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ///  dp 맵
        ///  key = balance , value - 동전갯수
        Map<Integer, Integer> map = new HashMap<>();


        String[] s = br.readLine().split(" ");

        int n =  Integer.parseInt(s[0]);
        int k =   Integer.parseInt(s[1]);

        List<Integer> coins = new ArrayList<>();



        for(int i = 0 ; i < n; i++){
            int coin =  Integer.parseInt(br.readLine());
            coins.add(coin);

        }


        for(int i = 0; i <= k; i++){

            map.put(i, MAX_VALUE);
        }

        map.put(k, 0);

        ///  k 부터 0 까지 dp를 채워가면서 갱신 최종적으로 map.get(0) 하면 최소갯수 출력.
        for(int i = k; i >= 0; i--){

            Integer befCoinCount = map.get(i);

            int balance = i;

            for(int j = 0; j < coins.size(); j++){

                int coinV = coins.get(j);

                int newBalance = balance - coinV;

                /// 잔액이 0보다 작을경우 스킵
                if(newBalance < 0){
                    continue;
                }

                /// 해당 동전 갯수확인.
                int targetCoinCount = map.get(newBalance);

                ///  해당 동전갯수와 이전 동전 갯수 + 1 의 최솟값 비교
                ///  ex_ 동전 5  / 이전값 15 : 0 /  잔액 10 : 5     ->  잔액 10 : Math.min(0 + 1 ,  5);
                int newCoinCount = Math.min(befCoinCount + 1, targetCoinCount);

                map.put(newBalance, newCoinCount);
            }

        }



        ///  잔액 0 이 한번도 바뀌지 않않을경우  - 1출력
        if(map.get(0) == MAX_VALUE){
            System.out.println(-1);
            return;
        }
        System.out.println(map.get(0));
    }

}