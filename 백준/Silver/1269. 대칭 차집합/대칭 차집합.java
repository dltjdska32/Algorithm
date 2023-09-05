import java.io.*;
import java.nio.IntBuffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //대칭 차집합 문제(해쉬맵사용)
        // a의 원소개수와 b의 원소개수를 입력받는다.
        // a에서 a와b의 교집합을 빼고
        // b에서 a와b의 교집합을 뺀 후, 그값을 합쳐서 출력한다.

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        //a와 b의 원소 개수를 입력받는다.
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        //a와 b의 원소들을 저장할 배열을 각각 만든다.
        int[] aElement = new int[a];
        int[] bElement = new int[b];

        //교집합의 갯수를 찾기위한 해쉬맵 생성
        HashMap <Integer, Integer> aHashMap = new HashMap<>();
        HashMap <Integer, Integer> bHashMap = new HashMap<>();

        //a의 원소를 입력받는다.
        String element = br.readLine();
        st = new StringTokenizer(element);

        //입력받은 원소를 a원소 배열에 저장하고 aHashmap의 키값에 저장한다.
        for(int i = 0; i < a; i++){


            int num = Integer.parseInt(st.nextToken());

            aElement[i] = num;
            aHashMap.put(num, 0);
        }

        
        //b의 원소를 입력받는다.
        element = br.readLine();
        st = new StringTokenizer(element);
        
        //입력받은 원소를 b원소 배열에 저장하고 bHashmap의 키값에 저장한다.
        for(int i = 0; i < b; i++){

            int num = Integer.parseInt(st.nextToken());

            bElement[i] = num;
            bHashMap.put(num, 0);
        }

        //교집합의 수 cnt를 0으로 초기화한후, aHashMap의 키값에 b배열원소값이 있다면 cnt를 1씩 증가한다.
        int cnt = 0;
        for(int i = 0; i < b; i++){
            if(aHashMap.containsKey(bElement[i])){
                cnt++;
            }
        }

        // a의 원소수에서 교집합의 수 를 뺀다.
        int aCount = a - cnt;

        //교집합의 수 cnt를 0으로 초기화한후, bHashMap의 키값에 a배열 원소값이 있다면 cnt를 1씩증가
        cnt = 0;
        for(int i = 0; i < a; i++){
            if(bHashMap.containsKey(aElement[i])){
                cnt++;
            }
        }

        //b의 원소수에서 교집합 수를 뺀다.
        int bCount = b - cnt;
        // a차집합과 b차집합의 수를 더한다.
        bw.write(String.valueOf(aCount + bCount));
        bw.flush();
        bw.close();
    }



}
