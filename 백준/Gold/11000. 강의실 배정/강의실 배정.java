import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> endTimeQ = new PriorityQueue<>((a, b) -> a - b);

        PriorityQueue<TimeInfo> pq = new PriorityQueue<>((a, b) ->
        {
            if(a.start == b.start) {
                return a.gap - b.gap;
            }
            return a.start - b.start;
        });

        for(int i = 0; i < n; i++){
            String[] s = br.readLine().split(" ");
            TimeInfo timeInfo = new TimeInfo(Integer.parseInt(s[0]), Integer.parseInt(s[1]));

            pq.add(timeInfo);
        }


        int firstStartTime = pq.peek().start;
        int ans = 0;
        for(int i = 0; i < n; i++){
            TimeInfo timeInfo = pq.poll();

            ///  첫번째 시간이랑 같을경우 강의실 추가 배정
            if(timeInfo.start == firstStartTime){
                ans++;
                endTimeQ.add(timeInfo.end);
            }

            ///  첫번째 시간이랑 다를경우
            /// endTimeQ의 첫번째시간이 timeInfo의 start시간 보다 클경우 강의실배정
            ///  >= 을경우 큐에서 빼고 timeInfo의 end시간을 넣어준다.
            if(firstStartTime != timeInfo.start){

                if(endTimeQ.peek() > timeInfo.start){
                    ans++;
                    endTimeQ.add(timeInfo.end);
                    continue;
                }

                if(endTimeQ.peek() <= timeInfo.start){
                    endTimeQ.poll();
                    endTimeQ.add(timeInfo.end);
                    continue;
                }
            }

        }

        System.out.println(ans);

    }

    static class TimeInfo{
        int start;
        int end;
        int gap;

        public TimeInfo(int start, int end){
            this.start = start;
            this.end = end;
            this.gap = end - start;
        }
    }
}



