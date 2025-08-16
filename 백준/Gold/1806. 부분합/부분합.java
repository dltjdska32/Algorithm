import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split( " ");

        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        List<Integer> integers = new ArrayList<>();

        ///  최소  길이를 저장할 우선순위 큐
        PriorityQueue<Integer> cnts = new PriorityQueue<>();

        str= br.readLine().split(" ");

        for(int i = 0; i < n; i++) {
            integers.add(Integer.parseInt(str[i]));
        }

        /// startPoint
        int s = 0;

        /// endPoint
        int e = 0;

        ///  Start와 end 사이의 숫자들 합.
        int tempSum = 0;

        ///  start ~ end 사이의 숫자 갯수
        int tempCnt = 0;



        ///  endPoint를 1칸씩 전진시킨다.
        ///  이때 tempSum 과 tempCnt를 갱신한다.
        ///  만약 start ~ end 까지 숫자의 합이 m 을 넘을경우 start를 전진시킨다.
        ///  이경우에도 tempSUm과 tempCnt를 갱신한다.
        while(s <= e) {
            ///  e 포인트가 리스트의 끝인데 m보다 tempSUm이 작을경우
            ///  0출력후 종료
            if((e == n && s == 0) && tempSum < m) break;

            /// tempSUm이 m보다 크거나 같을경우 start증가
            /// 길이를 저장하는 cnts큐에 tempCnt를 저장한다.
            if(tempSum >= m){
                cnts.add(tempCnt);
                ///  tempSum 에서 s포인트의 값을 빼준다.
                tempSum -= integers.get(s);
                ///  s 포인트를 증가시킨다.
                s++;
                /// tempCnt를 감소시킨다.
                tempCnt--;
                continue;
            }

            ///  tempSum 이 m보다 작을경우 end 증가
            if(tempSum < m){
                if(e == n) break;
                /// tempSum에 integers리스트의 e번째 값을 더해준다.
                tempSum += integers.get(e);
                /// endPoint를 1증가시킨다.
                e++;
                /// tempCnt를 1증가시킨다.
                tempCnt++;

            }


        }
        if(cnts.size() == 0) {
            System.out.println(0);
            return;
        }
        System.out.print(cnts.poll());
    }

}
