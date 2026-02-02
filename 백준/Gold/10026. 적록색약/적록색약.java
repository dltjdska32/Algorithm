import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    static String[][] area;
    static boolean[][] commonVisit;
    static boolean[][] sickVisit;
    static int[] moveX = {0, -1, 0, 1};
    static int[] moveY = {-1, 0, 1, 0};
    static int n;

    // 큐는 하나로 재사용해도 무방합니다.
    static Queue<Integer> qX = new LinkedList<>();
    static Queue<Integer> qY = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        area = new String[n + 1][n + 1];
        commonVisit = new boolean[n + 1][n + 1];
        sickVisit = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 1; j <= n; j++) {
                area[i][j] = s[j - 1];
            }
        }

        int commonAns = 0;
        int sickAns = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!commonVisit[i][j]) {
                    findCommonAns(j, i);
                    commonAns++;
                }
                if (!sickVisit[i][j]) {
                    findSickAns(j, i);
                    sickAns++;
                }
            }
        }
        System.out.println(commonAns + " " + sickAns);
    }

    private static void findCommonAns(int x, int y) {
        String curColor = area[y][x];
        commonVisit[y][x] = true; // 넣을 때 방문 처리
        qX.add(x);
        qY.add(y);

        while (!qX.isEmpty()) {
            int curX = qX.poll();
            int curY = qY.poll();

            for (int i = 0; i < 4; i++) {
                int nX = curX + moveX[i];
                int nY = curY + moveY[i];

                if (nX < 1 || nY < 1 || nX > n || nY > n || commonVisit[nY][nX]) continue;

                if (area[nY][nX].equals(curColor)) {
                    commonVisit[nY][nX] = true; // 넣을 때 방문 처리
                    qX.add(nX);
                    qY.add(nY);
                }
            }
        }
    }

    private static void findSickAns(int x, int y) {
        String curColor = area[y][x];
        sickVisit[y][x] = true; // 넣을 때 방문 처리
        qX.add(x);
        qY.add(y);

        while (!qX.isEmpty()) {
            int curX = qX.poll();
            int curY = qY.poll();

            for (int i = 0; i < 4; i++) {
                int nX = curX + moveX[i];
                int nY = curY + moveY[i];

                if (nX < 1 || nY < 1 || nX > n || nY > n || sickVisit[nY][nX]) continue;

                String nextColor = area[nY][nX];
                boolean isSameSection = false;

                // 적녹색약 로직: R과 G를 동일하게 취급
                if (curColor.equals("R") || curColor.equals("G")) {
                    if (nextColor.equals("R") || nextColor.equals("G")) isSameSection = true;
                } else {
                    if (nextColor.equals(curColor)) isSameSection = true;
                }

                if (isSameSection) {
                    sickVisit[nY][nX] = true; // 넣을 때 방문 처리
                    qX.add(nX);
                    qY.add(nY);
                }
            }
        }
    }
}