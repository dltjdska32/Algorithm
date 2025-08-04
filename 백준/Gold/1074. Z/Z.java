import java.io.BufferedReader;
import java.io.InputStreamReader;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    static int n;
    static int targetRow;
    static int targetCol;
    static int ans = 0;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        targetRow = Integer.parseInt(s[1]);
        targetCol = Integer.parseInt(s[2]);

        int range = (int) Math.pow(2, n);

        divide(0, 0, range);

        System.out.println(ans);

    }

    static void divide(int startX, int startY, int range) {

        /// 만약 목표지점을 찾았다면 return;
        if(startX == targetRow && startY == targetCol) {
            return;
        }

        /// 새로운 범위 설정
        int newRange = range / 2;

        int size = newRange * newRange;

        ///  왼쪽 위에 있을경우
        if(conquer(startX, startY, newRange)) {
            divide(startX, startY, newRange);
        }
        ///  오른쪽 위에 있을경우
        else if(conquer(startX + newRange, startY, newRange)) {
            ans += size;
            divide(startX + newRange, startY, newRange);
        }
        ///  왼쪽아래에 있을경우
        else if(conquer(startX, startY + newRange, newRange)) {
            ans += 2 * size;
            divide(startX, startY + newRange, newRange);
        }
        ///  오른쪽 아래에 있을경우
        else if(conquer(startX + newRange, startY + newRange, newRange)) {
            ans += 3 * size;
            divide(startX + newRange, startY + newRange, newRange);
        }
    }


    ///  해당 영역에 있다면 return true;
    ///  없다면 returan False
    static boolean conquer(int startX, int startY, int range) {

        if((startX <= targetCol && targetCol < startX + range)
            && (startY <= targetRow && targetRow < startY + range)) {
            return true;
        }

        return false;
    }
}



