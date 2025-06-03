import java.util.*;
import java.lang.*;
import java.io.*;
// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Integer> nList = new ArrayList<>();
        List<Integer> mList = new ArrayList<>();
        
        int n = Integer.parseInt(br.readLine());
        String[] strN = br.readLine().split(" ");
     
        for(int i = 0; i < strN.length; i++){
            nList.add(Integer.parseInt(strN[i]));
        }

        int m = Integer.parseInt(br.readLine());
        String[] strM = br.readLine().split(" ");
        
        for(int i = 0; i < strM.length; i++){
            mList.add(Integer.parseInt(strM[i]));
        }

        Collections.sort(nList);

        for(int i = 0; i < m; i++){
            sb.append(checkValue(nList, mList.get(i)) + "\n");
        }

    
        System.out.print(sb);
    }


   public static int checkValue(List<Integer> nList, int target) { // 변수명 m을 target으로 변경하여 명확성 증가
    int low = 0;
    int high = nList.size() - 1;

    while (low <= high) {
        int mid = (high + low) / 2; // 올바른 mid 계산 (오버플로우 방지)

        if (nList.get(mid) == target) {
            return 1; // 찾았을 경우
        } else if (nList.get(mid) < target) { // 중간값이 타겟보다 작으면, 오른쪽 부분 탐색
            low = mid + 1;
        } else { // nList.get(mid) > target, 중간값이 타겟보다 크면, 왼쪽 부분 탐색
            high = mid - 1;
        }
    }
    return 0; // 찾지 못했을 경우
}
}