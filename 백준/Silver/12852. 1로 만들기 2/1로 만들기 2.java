import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // 0 부터 n까지의 방을 만듦.
        int[] cnt = new int[n + 1];

        // 연산정보 저장
        List<List<Integer>> informs = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            List<Integer> inf = new ArrayList<>();
            /// 초기값 세팅
            // 0일경우 연산정보 없음.
            // cnt[0] = 0;
            if(i == 0){
                inf.add(0);
                informs.add(inf);
                continue;
            }
            //cnt[1] = 0;
            // 연상정보 1저장.
            if (i == 1){
                inf.add(1);
                cnt[i] = 0;
                informs.add(inf);
                continue;
            }
            //cnt[2] = 1
            // 연산정보 2 1저장
            if(i == 2){
                inf.add(2);
                inf.add(1);
                informs.add(inf);
                cnt[i] = 1;
                continue;
            }
            //cnt[3] = 1
            // 연산정보 3 1저장
            if(i == 3){
                inf.add(3);
                inf.add(1);
                informs.add(inf);
                cnt[i] = 1;
                continue;
            }

            /// 4부터는 연산회수 계산하여 연산정보 추가.
            /// 최소연산회수를 i - 1번째의 연상횟수로 저장.
            ///  연산 정보도 i - 1의 연산정보로 저장.
            int min = cnt[i - 1];
            inf.addAll(informs.get(i - 1));

            ///  2로나눌수 있고 min보다 작을경우 실행
            if(i % 2 == 0 && min > cnt[i / 2]) {
                inf.clear();
                min = cnt[i /2];
                inf.addAll(informs.get(i/2));
            }

            ///  3으로 나눌수 있고 min 보다 작을경우 실행.
            if(i % 3 == 0 && min > cnt[i / 3]) {
                inf.clear();
                min = cnt[i /3];
                inf.addAll(informs.get(i/3));
            }

            ///  이전 연산횟수에 1을 저장하여 현재 값의 최소연산횟수를 저장.
            cnt[i] = min + 1;
            ///  최소연산정보에 현재 값을 추가하고 연산정보리스트에 저장.
            inf.add(0, i);
            informs.add(inf);

        }


        StringBuilder sb= new StringBuilder().append(cnt[n]).append("\n");
        List<Integer> integers = informs.get(n);
        for(int i = 0; i < integers.size(); i++){
            if(i == 0){
                sb.append(integers.get(i));
                continue;
            }

            sb.append(" ").append(integers.get(i));
        }

        System.out.println(sb);
    }

}


