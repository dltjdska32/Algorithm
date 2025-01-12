import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        List<Integer> nums = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        int index = 0;
        int cnt = 1;

        for(int i = 1; i <= n; i++){
            nums.add(i);
        }

        while(q.size() < n ) {

            if(index > nums.size() - 1){
                index = 0;
            }

            // cnt 가 k의 배수이면 nums의 인덱스에서 추출해서 q에추가후
            // nums 에서 제거
            // nums에서 remove할경우 인덱스는 변화x cnt만증가ㅌ
            if(cnt % k == 0) {

                q.offer(nums.get(index));
                nums.remove(index);

                cnt++;
                continue;
            }

            cnt++;
            index++;


        }

        // 출력ㅊ
        StringBuilder sb = new StringBuilder();
        int qSize =  q.size();
        sb.append("<");


        for(int i = 0; i < qSize; i++) {

            sb.append(q.poll());
            if(i == qSize -1) {
                break;
            }
            sb.append(", ");
        }
        sb.append(">");

        System.out.println(sb);
        br.close();
    }
}