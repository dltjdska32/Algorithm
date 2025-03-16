import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Inform> dq = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        
        
        String[] s = br.readLine().split(" ");

        for(int i = 0; i < s.length; i++){
            Inform inform = new Inform(i + 1, Integer.parseInt(s[i]));
            dq.add(inform);
        }

        int cnt = 0;
        int move = 0;
        while(!dq.isEmpty()){
            if(cnt == 0) {
                Inform inform = dq.poll();
                if (inform == null) break; // Null 체크
                move = inform.move;
                answer.add(inform.loc);
                if (dq.isEmpty()) break; // 마지막 풍선이면 종료
            }

            if(cnt > 0) {

                //무브가 양수일경우
                if(move > 0) {
                    // 정보 뒤로 이동
                    for(int i = 1; i < move; i++){
                        dq.addLast(dq.pollFirst());
                    }
                    //맨앞에 정보 꺼냄
                    Inform inform = dq.poll();
                    if (inform == null) break; // Null 체크
                    move = inform.move;
                    answer.add(inform.loc);
                    if (dq.isEmpty()) break; // 마지막 풍선이면 종료
                }
                
                // 무브가 음수일경우
                if(move < 0) {
                    for(int i = 1; i < -move + 1; i++) {
                        dq.addFirst(dq.pollLast());
                    }
                    Inform inform = dq.pollFirst();
                    if (inform == null) break; // Null 체크
                    move = inform.move;
                    answer.add(inform.loc);
                }
            }


            cnt++;
        }
        
        for(Integer i : answer) {
            System.out.print(i + " ");
        }
        
        
    }

    public static class Inform{
        int loc;
        int move;

        public Inform(int loc, int move) {
            this.loc = loc;
            this.move = move;
        }
    }
    
}