import java.io.BufferedReader;
import java.io.InputStreamReader;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {

    static String[][] stars;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ///  삼각형의 넓이
        int n = Integer.parseInt(br.readLine());

        ///  삼각형의 아랫변은 2 * N - 1
        stars = new String[n][2 * n - 1];

        ///  최상단 꼭지점 과 n을 파라미터로 넘겨줌.
        makePyramid(n - 1, 0, n);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < stars.length; i++) {
            for(int j = 0; j < stars[i].length; j++) {
                if(stars[i][j] == null) {
                    sb.append(" ");
                } else{
                    sb.append(stars[i][j]);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void makePyramid(int x, int y, int height) {
        ///  높이가 3이면 별찍기
        if(height == 3) {

            ///  첫번째줄
            stars[y][x] = "*";
            ///  두번째 줄
            stars[y + 1][x - 1] = stars[y + 1][x + 1] = "*";
            ///  세번째줄
            stars[y + 2][x - 2] = stars[y + 2][x - 1] = stars[y + 2][x]
                    = stars[y + 2][x +  1] = stars[y + 2][x + 2] = "*";
            return;
        }

        ///  높이 2등분
        int newHeight = height / 2;

        ///  최상단 재귀
        makePyramid(x, y, newHeight);



        ///  최상단 Y 좌표가 0 이기 때문에 Y에 N + NEWHEIGHT를 바로더해줌.
        ///  좌측하단
        makePyramid(x - newHeight , y + newHeight, newHeight);

        ///  우측 하단
        makePyramid(x + newHeight , y + newHeight, newHeight);
    }
}