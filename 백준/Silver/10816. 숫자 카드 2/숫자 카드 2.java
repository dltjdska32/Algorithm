import java.io.*;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //숫자카드2(해쉬맵 사용)
        // 상근이가 가지고 있는 숫자카드 n개, 각각의 숫자카드에는 숫자가 적혀있다.
        // 임의의 숫자카드 m개, 각각의 카드에는 숫자가 적혀있다.
        // 임의의 카드 1개당 상근이가 가지고 있는 숫자들의 갯수들의 합을 구한다.

        //상근이가 가지고 잇는 숫자카드 갯수와 각각의 숫자를 입력받고 배열을 만든다.
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        //임의의 숫자카드 갯수 m개를 입력받고 임의의 숫자를 입력받아 배열과 해쉬맵을 만든다.

        int m = Integer.parseInt(br.readLine());
        s = br.readLine();
        st = new StringTokenizer(s);

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] array1 = new int[m];
        for(int i = 0; i < m; i++){
            array1[i] = Integer.parseInt(st.nextToken());
            hashMap.put(array1[i], 0);

        }

        //해쉬맵을 순회하며 상근이가 가지고 있는 숫자카드와 일치하는 해쉬맵의 키값을 찾을경우
        //해당 키값을 +1한다.
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
