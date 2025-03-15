import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            List<Inform> informs = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        //최적의 가격
        int optionalPrice = 0;

        // 답.
        int answerPrice = 0;
        
        //거리
        String[] lens = br.readLine().split(" ");

        // 가격
        String[] prices = br.readLine().split(" "); 

        // 거리 가격추가
        for(int i = 0; i < prices.length; i++){
            int len = 0;
            if(i == prices.length - 1) {
                len = 0;
            } else {
                len = Integer.parseInt(lens[i]);
            }
            
        
            
            Inform inform = new Inform(Integer.parseInt(prices[i]), len);
            informs.add(inform);
        }

        //계산
        
        for(int i = 0; i < informs.size(); i++){
            if(i == 0) {
                answerPrice = informs.get(i).price * informs.get(i).len;
                optionalPrice = informs.get(i).price;
            }

            // 0보다 클경우 최적의 가격과 비교 크다면 최적의값 변화 x
            // answerPrice 에 현재거리 x optionalPrice 더해줌
            if(i > 0 && informs.get(i).price > optionalPrice){
                answerPrice += informs.get(i).len * optionalPrice;
            } 

            // 0보다 클경우 최적의 가격과 비교 최적의 값보다 작다면 최적의값에 현재 가격넣어줌
            // answerPrice 에 현재거리 x optionalPrice 더해줌
            if(i > 0 && informs.get(i).price <= optionalPrice){
                optionalPrice = informs.get(i).price;
                answerPrice += informs.get(i).len * optionalPrice;
            } 

            
        }

        System.out.println(answerPrice);
    }

    public static class Inform{
        int price;
        int len;

        public Inform(int price, int len){
            this.price = price;
            this.len = len;
        }
    }
}