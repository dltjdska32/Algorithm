import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static List<Integer>[] likeFriends;
    static int[][] classRoom;
    static int n;
    static int[] moveToX = {0, 1, 0, -1};
    static int[] moveToY = {1, 0, -1, 0};

    static class SeatInfo{
        int x;
        int y;
        int likeFriendCnt;
        int emptySeat;

        public SeatInfo(int x, int y, int likeFriendCnt, int emptySeat) {
            this.x = x;
            this.y = y;
            this.likeFriendCnt = likeFriendCnt;
            this.emptySeat = emptySeat;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        classRoom = new int[n + 1][n + 1];
        likeFriends = new ArrayList[n * n + 1];

        for (int i = 0; i < likeFriends.length; i++) {
            likeFriends[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n * n; i++) {

            String[] s = br.readLine().split(" ");

            int studentNum = Integer.parseInt(s[0]);

            ///  좋아하는 친구번호 저장.
            for (int j = 1; j <= s.length - 1; j++) {
                likeFriends[studentNum].add(Integer.parseInt(s[j]));
            }

            List<Integer> likeFriend = likeFriends[studentNum];
            //앉을수 있는 자리 리스트
            List<SeatInfo> seatInfos = new ArrayList<>();

            ///  앉을수 있는 자리 리스트 탐색
            for (int y = 1; y <= n; y++) {
                for (int x = 1; x <= n; x++) {
                    int friend = 0;
                    int empty = 0;
                    /// 사방탐색
                    for (int move = 0; move < 4; move++) {
                        int movedX = x + moveToX[move];
                        int movedY = y + moveToY[move];
                        /// 범위 벗어날경우 continue
                        if (movedX < 1 || movedY < 1 || movedX > n || movedY > n) continue;
                        ///  움직인 범위에 좋아하는 친구있는지 확인
                        for (int j = 0; j < 4; j++) {
                            if (classRoom[movedY][movedX] == likeFriend.get(j)) {
                                friend++;
                            }
                        }
                        /// 자리가 비어있는지 확인.
                        if (classRoom[movedY][movedX] == 0) {
                            empty++;
                        }
                    }
                    seatInfos.add(new SeatInfo(x, y, friend, empty));
                }

            }

            /// 우선순위순으로 sort
            ///  1. 좋아하는 학생 많은순
            ///  2. 비어있는 칸 많은순
            ///  3. 행번호 가장 작은순
            ///  4. 열번호 가장 작은순
            seatInfos.sort((a, b) -> {
                if(a.likeFriendCnt != b.likeFriendCnt) return b.likeFriendCnt - a.likeFriendCnt;
                if(a.emptySeat != b.emptySeat) return b.emptySeat - a.emptySeat;
                if(a.y != b.y) return a.y - b.y;
                return a.x - b.x;
            });

            for (int j = 0; j < seatInfos.size(); j++) {

                SeatInfo seatInfo = seatInfos.get(j);

                if (classRoom[seatInfo.y][seatInfo.x] > 0) {
                    continue;
                }

                /// 위에서 걸리지 않을경우 빈 자리
                ///  자리배치후 종료
                classRoom[seatInfo.y][seatInfo.x] = studentNum;
                break;
            }

        }

        int ans = 0;

        ///  점수 확인
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= n; x++) {

                int cnt = 0;
                int num = classRoom[y][x];
                List<Integer> likeFriend = likeFriends[num];

                for (int move = 0; move < 4; move++) {
                    int movedX = moveToX[move] + x;
                    int movedY = moveToY[move] + y;

                    if (movedX < 1 || movedY < 1 || movedX > n || movedY > n) continue;

                    for (int i = 0; i < 4; i++) {
                        Integer likeFriendNum = likeFriend.get(i);
                        if (likeFriendNum == classRoom[movedY][movedX]) {
                            cnt++;
                        }
                    }
                }

                if (cnt == 1) {
                    ans += 1;
                    continue;
                }
                if (cnt == 2) {
                    ans += 10;
                    continue;
                }
                if (cnt == 3) {
                    ans += 100;
                    continue;
                }
                if (cnt == 4) {
                    ans += 1000;
                    continue;
                }
            }
        }

        System.out.println(ans);
    }
}
