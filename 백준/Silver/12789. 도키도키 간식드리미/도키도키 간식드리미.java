import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       Stack<Integer> stackOne = new Stack<>();
       Stack<Integer> stackTwo = new Stack<>();
       int cnt = 1;

       int n = Integer.parseInt(br.readLine());

       String[] s = br.readLine().split(" ");


       for(int i = s.length - 1; i >= 0; i--) {
           stackOne.push(Integer.parseInt(s[i]));
       }

       while(!stackOne.isEmpty()) {

           int pop = stackOne.pop();
           if(pop == cnt) {
               cnt++;
           } else if(pop > cnt){
               stackTwo.push(pop);
           }

           if(!stackTwo.isEmpty()){
               int stackTwoSize = stackTwo.size();
               for(int i = 0; i < stackTwoSize; i++) {
                   if(stackTwo.peek() > cnt){
                       break;
                   }
                   if(stackTwo.peek() == cnt) {
                       stackTwo.pop();
                       cnt++;
                   }
               }
           }
       }
       if(stackTwo.isEmpty() && stackOne.isEmpty()) {
           System.out.println("Nice");
           return;
       }
        System.out.println("Sad");

    }
}