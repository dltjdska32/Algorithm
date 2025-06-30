import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {

    //10 30 25 26 40
    //  -> (1) 10 30 40 / (2) 10 25 26 40;
    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] str = br.readLine().split(" ");

        // 0 ~ n 까지의 최장수열길이를 저장할 값.
        int[] size = new int[n + 1];


        // 수열정보 저장할 리스트
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            List<Integer> lst = new ArrayList<>();

            ///  초기값 세팅
            ///  0 일경우  리스트에는 null size 0번방에는 0d넣어줌.
            if(i == 0) {
                lst.add(null);
                list.add(lst);
                size[i] = 0;
                continue;
            }

            // 1번방부터 사이즈 저장
            if(i == 1) {
                size[i] = 1;
                lst.add(Integer.parseInt(str[i - 1]));
                list.add(lst);
                continue;
            }

            ///  2번방 부터는 비교하면서 저장.
            ///  현재방과 이전방들을 비교해서
            ///  현재값보다 str[j - 1]이 작은값중에.
            ///  횟수가 가장 큰 방을 찾는다.
            ///  해당 방의 횟수 + 1`은 현재방의 최장 연산횟수
            ///  해당방의 리스트 + 현재값은 최장연산
            int maxCnt = 0;
          
            ///  이전 연산횟수와 비교 
            for(int j = i - 1; j > 0; j--){
                
                ///  현재입력받은 숫자가 이전 숫자보다 클경우.
                if(Integer.parseInt(str[i - 1]) > Integer.parseInt(str[j - 1])){
                    ///  최장연산 및 연산횟수 갱신.
                    if(maxCnt < size[j]) {
                        maxCnt = size[j];
                        lst.clear();
                        lst.addAll(list.get(j));
                    }
                }
            }
            
            /// 이전최장연산횟수 + 1 은 현재 최장연산횟수 
            size[i] = maxCnt + 1;
            ///  이전 최장연산리스트에 현재 입력값 추가.
            lst.add(Integer.parseInt(str[i - 1]));
            list.add(lst);

        }

        /// 최장 연산 위치 찾기
        int loc = 0;
        int max = 0;

        for(int i = 1; i <= n; i++){
            if(size[i] > max) {
                max = size[i];
                loc = i;
            }
        }


        StringBuilder sb = new StringBuilder().append(size[loc]).append("\n");
        for(int i = 0; i < list.get(loc).size(); i++){
            if(i == 0){
                sb.append(list.get(loc).get(i));
                continue;
            }
            sb.append(" ").append(list.get(loc).get(i));
        }
        System.out.println(sb);

    }

}


