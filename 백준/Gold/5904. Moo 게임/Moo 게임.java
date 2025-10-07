import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n =  Integer.parseInt(br.readLine());

        int target = 0;
        int targetLen = 0;
        while (true) {

            if(target == 0){
                targetLen = 3;
                target++;
                continue;
            }

            if(targetLen < n){
                targetLen = targetLen * 2 + target + 3;
                target++;
                continue;
            }

            if(targetLen >= n){
                break;
            }

            target++;
        }

        /// 묙표인덱스
        target -= 1;

        while(true){
            int sideLen = (targetLen - (target + 3)) / 2;
            int midLen = target + 3;
            int tmp;
            if(n <= sideLen) {
                targetLen = sideLen;
                target--;
            } else if(n <= sideLen + midLen) {
                tmp = n - sideLen;
                if(tmp == 1){
                    System.out.println("m");
                    return;
                } else {
                    System.out.println("o");
                    return;
                }

            } else {
                target--;
                n = n - (sideLen + midLen);
                targetLen = sideLen;
            }
        }
    }


}
