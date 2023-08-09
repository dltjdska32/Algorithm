
import java.io.*;

import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> integers = new ArrayList<>();




        for(int i = 0; i < 3; i++){
            int n = Integer.parseInt(br.readLine());
            integers.add(n);
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i : integers){
            if(hashMap.containsKey(i)){
                int cnt = hashMap.get(i);
                hashMap.put(i, cnt + 1);
            }
            else{
                hashMap.put(i, 1);
            }
        }

        int cnt = 0; // 키값이 60 (정삼각형)일 경우  +1 (Equilateral)
        int cnt1 = 0; // 키값 2개가 같은  경우 +1 ( Isosceles)
        int cnt2 =  0; // 키값이 모두 다를경우 하나씩 +1  도합 3을 담을경우 (Scalene)
        Collection<Integer> collection = hashMap.values();
        for(int i : collection){
            //각이 60인값이 3개일경우 cnt의값은 1
            if(i == 3){
                cnt++;
            }
            // 각이 2개가 같은경우 cnt1의 값은 1
            if(i == 2){
                cnt1++;
            }
            // 각이 모두 다를경우 cnt2의 값은 3
            if(i == 1){
                cnt2++;
            }
        }


        if(integers.get(0) + integers.get(1) + integers.get(2) != 180){
            bw.write("Error");
        }
        if(integers.get(0) + integers.get(1) + integers.get(2) == 180 && cnt == 1){
            bw.write("Equilateral");
        }
        if(integers.get(0) + integers.get(1) + integers.get(2) == 180 && cnt1 == 1){
            bw.write("Isosceles");
        }
        if(integers.get(0) + integers.get(1) + integers.get(2) == 180 && cnt2 == 3){
            bw.write("Scalene");
        }

        bw.flush();
        bw.close();
        }




}

