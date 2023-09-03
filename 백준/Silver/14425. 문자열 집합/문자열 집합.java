import java.io.*;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //문자열 집합문제(해쉬맵 사용)
        // 문자열 집합 n개를 만들고, 문자열 11개를입력한후, 문자열 n개중 문자열 집합과 일치하는 갯수를 찾는 문제


        // 문자열 집합의 수와 문자열 갯수를 입력
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        //문자열 집합의 원소 개수
        int n = Integer.parseInt(st.nextToken());
        // 비교할 문자열의 개수
        int m = Integer.parseInt(st.nextToken());

        //문자열 집합의 원소들을 키로 하는 해쉬맵을 만든다. 그와 매치되는 밸류는 0으로 한다.

        HashMap<String, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < n; i++){
            String s1 = br.readLine();
            if(i < n) {
                hashMap.put(s1, 0);
            }
        }

        //문자열을 담을 배열을 만들고 배열에 비교할 문자열을 저장
        String[] strings = new String[m];
        for(int i = 0; i < m; i++){
            String s1 = br.readLine();
            strings[i] = s1;
        }

        int cnt = 0;
        //해쉬맵의 키값과 일치하는 문자열의 값이있다면 cnt를 1씩 증가
        for(int i = 0; i < strings.length; i++){
            if(hashMap.containsKey(strings[i])){
                cnt++;
            }
        }

        bw.write(String.valueOf(cnt));






        bw.flush();
        bw.close();
    }



}