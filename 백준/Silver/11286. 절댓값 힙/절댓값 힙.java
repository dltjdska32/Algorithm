import org.w3c.dom.Node;

import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /// 절댓값이 작은것 부터 차례로 출력하기 위해 우선순위 큐 사용
        ///  절댓값 작은순 -> 절댓값같다면 값이 작은순
        PriorityQueue<Info> pq = new PriorityQueue<>((a, b) -> {

            if(a.absValue == b.absValue) return a.value - b.value;
            
            return a.absValue - b.absValue;
        });

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            int absNum = Math.abs(num);

            if(num == 0 && pq.isEmpty()){
                System.out.println(0);
                continue;
            }

            if(num == 0 && !pq.isEmpty()){
                Info output = pq.poll();

                System.out.println(output.value);
                continue;
            }

            pq.offer(new Info(num, absNum));

        }


    } ///메인함수



    static class Info{
        int value;
        int absValue;
        public Info(int value, int absValue){
            this.value = value;
            this.absValue = absValue;
        }
    }

}

