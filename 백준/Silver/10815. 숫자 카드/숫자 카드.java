import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //숫자 카드 문제(해쉬맵 사용)
        // 상근이가 가지고 있는 숫자카드 N개 갯수입력
        // 숫자카드에 적혀있는 숫자 입력.
        // 숫자카드에 적혀있는지 찾을 숫자 M개 갯수 입력
        // M개의 임의의 수 입력
        // 상근이가 가지고 있는 숫자가 맞으면 1출력, 아니면 0 출력

        // 상근이가 가지고있는 숫자카드 n 개
        int n = Integer.parseInt(br.readLine());

        // 숫자카드에 적혀있는 숫자.
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        
        //n개 크기의 배열을 만들고 각 배열의  방에 상근이가 가지고 있는 숫자카드의 숫자를 저장
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        // 임의의 숫자 갯수 m개
        int m = Integer.parseInt(br.readLine());
        
        // 임의의 숫자
        s = br.readLine();
        st = new StringTokenizer(s);

        // 임의의 숫자개수 만큼 배열의 방을 만들고 임의의 수를 그 배열의 방에 저장
        // 임의의 숫자가 저장된 배열의 방을 만들면서 그 값을 키값으로 하는 해쉬맵을 만들고 그 키값의 밸류는 0으로 한다.
        int[] array1 = new int[m];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < m; i++){
            array1[i] = Integer.parseInt(st.nextToken());
            hashMap.put(array1[i], 0);
        }

        // 해쉬맵에 키값과 상근이가 가지고있는 카드값이 같다면 해당 키값과 매치되는 밸류값을 +1한다.
        for(int i = 0; i < n; i++){
            if(hashMap.containsKey(array[i])){
                int cnt = hashMap.get(array[i]);
                hashMap.put(array[i], cnt + 1);
            }
        }

        for(int i = 0; i < m; i++){
            bw.write(hashMap.get(array1[i]) + " ");
        }



        bw.flush();
        bw.close();
    }



}