import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {


    /// 1 최댓값 제거
    /// -1 최솟값 재거
    public static void main(String[] args) throws Exception {


        PriorityQueue<Long> minPq = new PriorityQueue<>();
        PriorityQueue<Long> maxPq = new PriorityQueue<>();



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s ;

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            TreeMap<Long, Long> map = new TreeMap<>();
            int m =  Integer.parseInt(br.readLine());
            for(int j = 0; j < m; j++){
               s = br.readLine().split(" ");
               String inp = s[0];
               Long num = Long.valueOf(s[1]);

                if (inp.equals("D")){
                    if(map.size() == 0) {
                        continue;
                    }
                    if(num.equals(1L)){
                        Long last = map.lastKey();
                        if(map.get(last).equals(1L)){
                            map.remove(last);
                        } else {
                            map.put(last, map.get(last) - 1L);
                        }

                    } else {
                        Long first = map.firstKey();
                        if(map.get(first).equals(1L)){
                            map.remove(first);
                        } else {
                            map.put(first, map.get(first) - 1L);
                        }
                   
                    }

                } else {
                    if(map.containsKey(num)){
                        Long l = map.get(num);
                        map.put(num,l+1);
                    } else {
                        map.put(num , 1L);
                    }
                }
            }

            if(map.isEmpty()){
                System.out.println("EMPTY");
            } else {
                Long min = map.firstKey();
                Long max = map.lastKey();

                System.out.println(max + " " + min);
            }
        }



    }
}