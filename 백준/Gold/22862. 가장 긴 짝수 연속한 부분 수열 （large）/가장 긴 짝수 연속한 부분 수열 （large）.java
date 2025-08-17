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
        /// 입력 숫자값
        List<Integer> values = new ArrayList<>();

        ///  수열 길이 저장할 리스트
        List<Integer> lengths = new ArrayList<>();

        String[] str = br.readLine().split(" ");
        /// 숫자갯수
        int n =  Integer.parseInt(str[0]);
        /// 숫자를 제거할수있는 최고 갯수
        int k =  Integer.parseInt(str[1]);

        str = br.readLine().split(" ");

        /// 숫자 리스트 생성
        for(String s: str){
            values.add(Integer.parseInt(s));
        }

        ///  s, e 정의
        int s = 0 , e = 0;
        /// 삭제 횟수 정의
        int removeCnt = 0;

        while (e < n){
            ///  s 와 e 의 위치가 같고 홀수일경우 s 와 e 증가
            if(s == e && values.get(e) % 2 != 0){
                s++;
                e++;
                removeCnt = 0;
                continue;
            }

            /// s(시작지점)위치 변경.
            ///삭제횟수가 k보다 커진다면실행
            if(removeCnt > k){

                Integer i1 = values.get(s);

                /// 홀수일 경우 s++해주고 removeCnt--;
                if(i1 % 2 == 1){
                    removeCnt--;
                }
                s++;
                continue;
            }


            /// 위에서 걸리지 않는다면 길이계산 및 삭제횟수 계산
            /// e(종료지점) 이동.
            Integer i = values.get(e);

            if(i % 2 == 0){ /// e가 가르키는 숫자가 짝수일경우

                lengths.add(e - s - removeCnt + 1);
            } else{ /// e가 가르키는 숫자가 홀수일경우
                removeCnt++;
            }

            e++;
            if(e > n - 1) break;

        }

        /// 모두 홀수만 담긴경우.
        if(lengths.size() == 0){
            System.out.println(0);
            return;
        }
        ///  내림차순으로 정렬
        lengths.sort((a, b) -> b - a);
        ///  제일 큰 경우의수 출력
        System.out.println (lengths.get(0));
    }

}
