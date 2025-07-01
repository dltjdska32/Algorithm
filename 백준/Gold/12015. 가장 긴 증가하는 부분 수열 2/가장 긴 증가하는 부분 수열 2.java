
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {

    //10 30 25 26 40
    //  -> (1) 10 30 40 / (2) 10 25 26 40;
    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> ans = new ArrayList<>();

        String[] str = br.readLine().split(" ");

        for(int i = 0; i < n; i++){

            // 첫번째 값 넣어줌.
            if(i == 0 ){
                ans.add(Integer.parseInt(str[i]));
                continue;
            }

            int lastNum = ans.get(ans.size() - 1);
            int num = Integer.parseInt(str[i]);

            // ans의 리스트 마지막은 변경하지않는다.
            //마지막 값이 입력값보다 작다면 입력값 추가.
            if(lastNum < num) {
                ans.add(num);
                continue;
            }

            int high = ans.size() -1;
            int low = 0;
            int el = 0;
            while (low <= high){

                int mid = (high + low) / 2;

                //ans 의 가운데 위치값과 비교해서 num 보다 클경우
                // high를 mid - 1로 변경
                if(ans.get(mid) >= num){
                    el = mid;
                    high = mid - 1;
                } else{
                    low = mid  + 1;
                }
            }

            ans.set(el, num);
        }


        System.out.println(ans.size());
    }

}


