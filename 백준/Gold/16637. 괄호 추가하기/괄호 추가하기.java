import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static int n;

    static List<Long> nums = new ArrayList<>();
    static List<String> oper = new ArrayList<>();

    static String[] checkNumVal = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
    static Long ans = Long.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        String[] s = br.readLine().split("");



        for(int i = 0; i < s.length; i++){

            boolean check = true;

            /// 숫자리스트에 추가
            for(int j = 0; j < checkNumVal.length; j++){
                if(s[i].equals(checkNumVal[j])){
                    nums.add(Long.parseLong(s[i]));
                    check = false;
                    break;
                }
            }

            /// 연산자 리스트에 추가.
            if(check) {
                oper.add(s[i]);
            }

        }

        if(nums.size() == 1){
            System.out.println(nums.get(0));
            return;
        }

        Long value = nums.get(0);

        findAns(value, 0);

        System.out.println(ans);
    }

    ///  최종적으로 ans 갱신
    ///  파람 1 현재값 / 파람 2 연산자 위치
    ///  2칸씩 oper를 전진시키면 dfs 진행
    public static void findAns(Long curVal, int opLoc) {

        Long tempVal = curVal;

        /// ============================================== 리턴 로직 =============================================///
        if(opLoc > oper.size() - 1){
            ans = Math.max(ans, tempVal);
            return;
        }

        /// ==============================================계산 로직 =============================================///

        ///  괄호 없음.
        String curOp = oper.get(opLoc);
        if(curOp.equals("+")){
            tempVal += nums.get(opLoc + 1);
        }  else if (curOp.equals("-")) {
            tempVal -= nums.get(opLoc + 1);
        }  else if (curOp.equals("*")) {
            tempVal *= nums.get(opLoc + 1);
        }
        findAns(tempVal, opLoc + 1);
        tempVal = curVal; /// 백트래킹 curVal로 되돌림.



        ///  2칸뒤 연산자 계산 괄호 있음

        ///  뒤 연산자가 없을경우 종료
        if(opLoc + 1 > oper.size() - 1) return;

        String nextOp = oper.get(opLoc + 1);
        Long afVal = 0L;
        if(nextOp.equals("+")){
            afVal = nums.get(opLoc + 1) + nums.get(opLoc + 2);
        }  else if (nextOp.equals("-")) {
            afVal = nums.get(opLoc + 1) - nums.get(opLoc + 2);
        }   else if (nextOp.equals("*")) {
            afVal = nums.get(opLoc + 1) * nums.get(opLoc + 2);
        }

        if(curOp.equals("+")){
            tempVal += afVal;
        }  else if (curOp.equals("-")) {
            tempVal -= afVal;
        }  else if (curOp.equals("*")) {
            tempVal *= afVal;
        }

        findAns(tempVal, opLoc + 2);

    }

}
