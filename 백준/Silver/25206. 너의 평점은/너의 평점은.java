import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Inf> infs = new ArrayList<>();
        float answer = 0;
        for(int i = 0; i < 20; i++){
            String string = br.readLine();
            StringTokenizer st = new StringTokenizer(string);

            String s = st.nextToken();
            float score = Float.parseFloat(st.nextToken());
            String str = st.nextToken();
            Inf inf = new Inf(s,score,str);
            infs.add(inf);
        }

        float totalScore = 0;
        //학점총합
        for(int i = 0; i < infs.size(); i++){
            if(infs.get(i).str().equals("P")){
                continue;
            }
            totalScore += infs.get(i).f();
        }


        String obS = "";
        float obScore = 0;
        float score = 0;
        for(int i = 0; i < infs.size(); i++){
            if(infs.get(i).str().equals("A+")){
                obScore = (float)4.5;
                score += infs.get(i).f() * obScore;
            }else if(infs.get(i).str().equals("A0")){
                obScore = (float)4.0;
                score += infs.get(i).f() * obScore;
            }else if(infs.get(i).str().equals("B+")){
                obScore = (float)3.5;
                score += infs.get(i).f() * obScore;
            }else if(infs.get(i).str().equals("B0")){
                obScore = (float)3.0;
                score += infs.get(i).f() * obScore;
            }else if(infs.get(i).str().equals("C+")){
                obScore = (float)2.5;
                score += infs.get(i).f() * obScore;
            }else if(infs.get(i).str().equals("C0")){
                obScore = (float)2.0;
                score += infs.get(i).f() * obScore;
            }else if(infs.get(i).str().equals("D+")){
                obScore = (float)1.5;
                score += infs.get(i).f() * obScore;
            }else if(infs.get(i).str().equals("D0")){
                obScore = (float)1.0;
                score += infs.get(i).f() * obScore;
            }else if(infs.get(i).str().equals("F")){
                obScore = (float)0.0;
                score += infs.get(i).f() * obScore;
            }else if(infs.get(i).str().equals("P")){
                continue;
            }


        }

        answer = score / totalScore;

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
    }
}

class Inf{
    private String s;
    private float f;
    private String str;


    public String s() {
        return s;
    }

    public Inf setS(String s) {
        this.s = s;
        return this;
    }

    public float f() {
        return f;
    }

    public Inf setF(float f) {
        this.f = f;
        return this;
    }

    public String str() {
        return str;
    }

    public Inf setStr(String str) {
        this.str = str;
        return this;
    }

    public Inf(String s, float f, String str){
        this.s = s;
        this.f = f;
        this.str = str;
    }

}
