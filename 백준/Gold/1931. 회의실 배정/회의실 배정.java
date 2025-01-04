import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1 . 모두입력받음
        // 2. 리스트로 만들어서 endTime으로 sort
        // 3. endtime 과 가장 가까운 start타임을 찾고 해당 값의 end를 endTime으로 교체
        // 4. 리스트의 1회순회한 2 ~ 3 의 교체 갯수를 출력
        
        List<Time> times = new ArrayList<>();
       
   
        int n = Integer.parseInt(br.readLine());


   
        int endTime = 0;
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            Time time = new Time(start, end);
            times.add(time);
        }

       
    
        
        // 종료시간으로 오름차순 정렬 종료시간이 같다면 시작시간으로 오름차순 정룔
        // 2, 4 / 4, 4 와 같은 경우를 위해서
        times.sort((a, b) -> {
            if(a.end == b.end) return a.start - b.start;
            return a.end - b.end;
        });

        

        for(int i = 0; i < times.size(); i++){
            // 첫순서 무조건 시작
            if(i == 0) {
                endTime = times.get(i).end;
                cnt++;
                continue;
            }

            // 시작시간이 종료보다 크거나 같으면
            if(i > 0 && times.get(i).start >= endTime) {
                endTime = times.get(i).end;
                cnt++;
            }
        }

        System.out.println(cnt);
        
    }

    static class Time {
        int start;
        int end;


        public Time(int start, int end) {
            this.start = start;
            this.end = end;
 
        }
    }
    
}


