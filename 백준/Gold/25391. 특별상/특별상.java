import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");


        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);

        List<Info> infos = new ArrayList<>();

        for(int i = 0; i < n; i++){

            s = br.readLine().split(" ");

            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            Info info = new Info(a, b);
            infos.add(info);

        }


        infos.sort((a,b) -> {

            if(a.scoreTwo == b.scoreTwo) {
                return b.scoreOne - a.scoreOne;
            }

            return b.scoreTwo - a.scoreTwo;
        });



        Long ans = 0L;


        for(int i =0; i < k; i++){

            ans += infos.get(i).scoreOne;
        }

        infos = infos.subList(k, infos.size());

        infos.sort((a,b) -> {

            return b.scoreOne - a.scoreOne;
        });


        for(int i = 0; i < m; i++){
            ans+= infos.get(i).scoreOne;
        }

        System.out.println(ans);


    }



    public static class Info {
        int scoreOne; ///주최자
        int scoreTwo; /// 심팜

        public Info(int a, int b) {
            this.scoreOne = a;
            this.scoreTwo = b;
        }
    }
}