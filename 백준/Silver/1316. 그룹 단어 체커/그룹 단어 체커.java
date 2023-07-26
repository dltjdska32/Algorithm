import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String s = ""; // 다른 단어를 저장할 저장소
        int n = Integer.parseInt(br.readLine());
        int cnt = n; // 총 문자열의 숫자에서 그룹단어가 아닐경우 하나씩 차감
                     
        boolean b = false;


        for(int i = 0; i < n; i++){
            String str = br.readLine();
            String[] s1 = str.split(""); // 한단어씩 쪼개서 s1배열에 저장

            if(s1.length <= 2){
                // s1 배열의 길이가 2보다 작거나 같으면 무조건 그룹단어
                continue;
            }

            if(s1.length > 2){
                    // s1배열의 길이가 2보다 클경우 그룹단어 체크를 위해 이프문 실행
                for(int j = 0; j < s1.length; j++){

                    if( j + 1 < s1.length) {
                        // j + 1 의 값이 s1의 길이보다 작아야함 왜냐하면 j의 값이 s1의 길이
                        //보다 1작을경우 j+1의 값이 배열을 벗어나기 때문
                        //ex) s1.length == 7; -> 이경우 s1의 크기는 6 j가 6일경우 j+1 == 7
                        //배열의 크기를 벗어난다.


                        if (s1[j].equals(s1[j + 1])) {
                            //s1배열의 시작배열과 다음배열을 차근차근 찾아가면서 같을경우
                            //계속해서 진행
                            continue;
                        }

                        if (!s1[j].equals(s1[j + 1])) {
                            //문자열을 하나씩하나씩 찾아가면서 문자가 달라지는구간을 반견할경우실행

                            if (find(s1, j + 1, s1[j]) == true) {
                                //find함수에서 true(찾음)을 반환할경우 그룹단어가 아님
                                // 따라서 cnt를 --

                                cnt--;


                                b = true;
                                // 그룹단어가 아닐경우 총문자열에서 하나를 차감하고 추가적으로
                                // 차감하지 않기위해서 다시 문자열입력받기위해 b를 트루로 바꾸고
                                // 밖으로 나가서 break실행
                            }
                        }

                    }
                    if(b){
                        b = false;
                        break;
                    }
                }
            }
        }
        bw.write(String.valueOf(cnt));

        bw.flush();
        bw.close();

        }

    public static boolean find(String[] s, int n, String  ss) {
        // 문자가 다른 구간을 찾을경우 달라지는 구간부터 배열의 끝까지 달라지기 전 문자를 찾는 함수
        // ex) aaabbb 이경우 문자가 달라지는구간은 s[2]~ s[3] s[3]위치부터 ++해가면서 s[2]를 찾는 함수
        for(int i = n; i < s.length; i++){
            if(s[i].equals(ss)){
                return true;
            }
        }
        return false;
    }

}


