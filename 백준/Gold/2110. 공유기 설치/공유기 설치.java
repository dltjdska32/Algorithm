
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        long c = Long.parseLong(str[1]);

        List<Long> locations = new ArrayList<>();

        for(int i = 0; i < n; i++){
            locations.add(Long.parseLong(br.readLine()));
        }

        Collections.sort(locations);

        long low = 1; //최초 최소거리
        long high = locations.get(n - 1) - locations.get(0); // 최대거리
        long distance = 0;

        while (low <= high) {

            long mid = (low + high) / 2; // 최소거리

            long installCnt = 1; // 첫번째 집에 설치 따라서 cnt 1
            long installLoc = locations.get(0);

            //mid를 기준으로 공유기를 설치
            for(int i = 1; i < n; i++) {
                // 현재 위치 - 이전설치위치 가 
                // mid 보다 크거나 같을경우 설치
                if(locations.get(i) - installLoc >= mid) {
                    installCnt++;
                    installLoc = locations.get(i);
                }
            }

            /// 설치한 공유기 개수가 c개보다 크거나 같을경우
            /// distance를 mid로 설정하고 low를 이동시켜서 최대거리를 찾아봄
            if (installCnt >= c) {
                distance = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(distance);
    }
}
