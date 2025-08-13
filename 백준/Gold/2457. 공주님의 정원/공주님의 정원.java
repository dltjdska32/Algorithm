import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<FlowerInfo> flowers = new ArrayList<>();

        /// mmdd형식으로 개화시기 저장.
        for(int i = 0; i < n; i++){
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]) * 100 +  Integer.parseInt(s[1]);
            int end = Integer.parseInt(s[2]) * 100 +  Integer.parseInt(s[3]);

            FlowerInfo f = new FlowerInfo(start, end);
            flowers.add(f);
        }

        /// 시작일을 우선정렬하여 시작일 기준으로 종료일 정렬
        flowers.sort((a, b) -> {
            if(a.start == b.start) return b.end - a.end;
            return a.start - b.start;
        });

        ///  시작일은 while문을 돌면서 갱신됨.
        int startDate = 301;
        /// 종료일은 최종적으로 꽃이 지는
        int endDate = 1201;
        int idx = 0;

        /// 임시적으로 제일긴 end를 저장하기 위한 변수
        int max = 0;
        /// 꽃 카운트
        int ans = 0;

        /// 갱신된 startDate가 endDate보다 작을경우까지만반복.
        while(startDate < endDate){
            /// 꽃갯수 카운트를위한 플래그
            boolean check = false;

            /// 인덱스번호부터 꽃 사이즈까지 반복
            for(int i = idx; i < flowers.size(); i++){

                ///  startDate보다 꽃의 개화시기가 크다면 종료
                ///  startDate이전에 개화된것중 end가 제일 긴것을 찾기위한 분기
                if(startDate < flowers.get(i).start){
                    break;
                }

                /// startDate이전의 값중 제일긴end를찾고 플래그를 true로변경후, 가지치기 진행
                if(flowers.get(i).end > max) {
                    ///  startDate이전의 최장길이 end저장
                    max = flowers.get(i).end;
                    /// 최장길이를 찾았단것을 확인하기위해 플래그 true로변경
                    check = true;
                    /// 가지치기
                    idx = i + 1;
                }

            }

            if(check) {
                /// 꼴카운트
                ans++;
                ///  startDate에 max를저장.
                startDate = max;
            } else {
                break;
            }
        }
        /// 최종적으로 max가 1201이전일경우 조건 만족못함 sout 0 출력후 종료
        if(max < endDate){
            System.out.println(0);
            return;
        }
        System.out.println(ans);
    }


    static class FlowerInfo{

        int start;
        int end;

        public FlowerInfo(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}

