import java.io.*;
import java.nio.IntBuffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 백준 7785번 회사에있는 사람 문제 (해쉬맵 사용)
        // 회사에 출퇴근 기록이 남는다.
        // 출근하면 enter, 퇴근시 leave  현재 회사에 있는 사람을 출력한다. (이름 출력은 해당이름의 사전역순)

        int n = Integer.parseInt(br.readLine());

        HashMap <String, String> hashMap = new HashMap<>();

        for(int i = 0; i < n; i++){

            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);

            String name = st.nextToken();
            String commute = st.nextToken();

            hashMap.put(name, commute);

            //만약 이름의 값이 리브로 바뀌어져 있다면 해당 해쉬값을 제거.
            if(hashMap.get(name).equals("leave")){
                hashMap.remove(name);
            }

        }

        // 해쉬맵에 남아있는 키값은 퇴근기록이 없는 사람이다.
        //따라서 밸류값이 enter인 사람만 남아있따.

        // 어레이리스트를 만들어서 남아있는 사람 이름을 받아 하나씩 추가한다.
        ArrayList<String> strings = new ArrayList<>();
        for(HashMap.Entry<String, String> entry : hashMap.entrySet()){
            strings.add(entry.getKey());
        }

        //사전역순으로 출력하기위해 정렬을 하고 반전시켜서 출력한다.
        Collections.sort(strings);
        Collections.reverse(strings);
        for(int i = 0; i < strings.size(); i++){
            bw.write(strings.get(i));
            bw.newLine();
        }


        bw.flush();
        bw.close();
    }



}