import java.util.*;
import java.lang.*;
import java.io.*;


class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> d = new ArrayDeque<>();
        
        for(int i = 0; i < n; i++){
            String[] s = br.readLine().split(" ");

            if(s[0].equals("1")){
                d.offerFirst(Integer.parseInt(s[1]));
                continue;
            }
            if(s[0].equals("2")){
                d.offerLast(Integer.parseInt(s[1]));
                continue;
            }
            if(s[0].equals("3")){
                if(d.size() == 0){
                    System.out.println("-1");
                    continue;
                }
                System.out.println(d.pollFirst());
                continue;
            }
            if(s[0].equals("4")){
                if(d.size() == 0){
                    System.out.println("-1");
                    continue;
                }
                System.out.println(d.pollLast());
                continue;
            }
            if(s[0].equals("5")){
                System.out.println(d.size());
                continue;
            }
            if(s[0].equals("6")){
                if(d.isEmpty()){
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
                continue;
            }
            if(s[0].equals("7")){
                if(!d.isEmpty()){
                    System.out.println(d.peekFirst());
                } else {
                    System.out.println("-1");
                }
                continue;
            }
            if(s[0].equals("8")){
                if(!d.isEmpty()){
                    System.out.println(d.peekLast());
                } else {
                    System.out.println("-1");
                }
                continue;
            }
        }
    }    
}