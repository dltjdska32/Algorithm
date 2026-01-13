import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split("");

        List<Info> infos = new ArrayList<>();

        String cff = "";
        int xCnt = 0;

        Info info = new Info();

        for(int i = 0; i < s.length; i++){

            if(s[i].equals("+")){
                infos.add(info);
                info = new Info();
                continue;
            }else if(i != 0 && s[i].equals("-")){
                infos.add(info);

                info = new Info();

                info.addCff("-");
                continue;
            }

            if(s[i].equals("x")){ ///  x일경우 지수 카운트
                info.addXCnt();
                continue;
            }

            if(!s[i].equals("x")){ ///  x가아닐경우 계수 추가.
                info.addCff(s[i]);
            }
        }

        infos.add(info);


        if(infos.size() == 1 && infos.get(0).cff.equals("0")){
            System.out.println("W");
            return;
        }

        StringBuilder sb = new StringBuilder();

        ///  적분
        for(int i = 0; i < infos.size(); i++){

            info = infos.get(i);

            ///  coff / cnt   * x^cnt  + .....+W
            int cnt = info.xCnt + 1;
            String coff = info.cff;
            if(coff.equals("")){ /// coff 가 빈값일경우 1로 변경
                coff = "1";
            } else if (coff.equals("-")){/// coff 가 -일경우 -1로 변경
                coff = "-1";
            }

            String xStr = "";
            for(int j = 0; j < cnt; j++){
                xStr += "x";
            }


            int v = Integer.parseInt(coff) / cnt;


            if(i == 0){

                if(v == 1){
                    sb.append(xStr);
                } else if(v == -1){
                    sb.append("-" + xStr);
                } else {
                    sb.append(v).append(xStr);
                }

            } else if(coff.contains("-")){ ///  i=1이상이면서 - 포함

                if(coff.equals("-0")){
                    continue;
                } else if(coff.equals("-1")){
                    sb.append("-").append(xStr);
                } else {
                    sb.append(v).append(xStr);
                }

            } else if(!coff.contains("-")){ ///  - 포함아닐경우 > 문자열에 + 추가

                if(coff.equals("0")){
                    continue;
                } else if(coff.equals("1")){
                    sb.append("+").append(xStr);
                } else {
                    sb.append("+").append(v).append(xStr);
                }

            }

        }


        String out = sb.toString();





        System.out.println(out + "+W");
    }


    static class Info {
        String cff;
        int xCnt;

        public Info() {
            this.cff = "";
            this.xCnt = 0;
        }

        void addXCnt(){
            this.xCnt += 1;
        }
        void addCff(String s){
            this.cff += s;
        }
    }
}