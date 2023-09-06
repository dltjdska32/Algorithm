
import java.io.*;
import java.nio.IntBuffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 듣보잡 문제 (해쉬맵 사용)
        // 듣도 못한 사람 수 n, 보도 못한 사람 수 m 이 주어진다.
        // 듣도 못한 사람, 보도 못한 사람이 중복된 인원 수를 출력하고, 명단을 출력한다.
        // 해쉬맵을 하나 만들고, 듣도 못한 사람 이름을 키값으로 저장하고, 밸류로 각각 0 을 저장한다.
        // 동적 배열을 만들고 해쉬맵을 순회하면서 보도 못한 사람이름과 중복될경우 동적배열에 추가 한후, 해당배열을 사전순으로 정렬한다.

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //듣도 보도 못한 사람을 저장할 해쉬맵
        HashMap <String, Integer> hashMap = new HashMap<>();

        // 듣도 못한 사람 이름을 키값으로 하고 밸류를 0으로 한후 저장.
        for(int i = 0; i < n; i++){
            String name = br.readLine();
            hashMap.put(name, 0);
        }

        
        // 중복되는 값을 찾아 동적배열에 추가하고, 중복 인원슈을 구한다.
        int count = 0;
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i = 0; i < m; i++){
            String name = br.readLine();
            if(hashMap.containsKey(name)) {
                arrayList.add(name);
                count++;
            }
        }
        
        // 중복인원 수를 출력한다.
        bw.write(String.valueOf(count));
        bw.newLine();

        //사전순으로 정렬
        Collections.sort(arrayList);
        
        //중복인원 출력
        for(int i = 0; i < arrayList.size(); i++){
            bw.write(arrayList.get(i));
            bw.newLine();
        }





        bw.flush();
        bw.close();
    }



}
