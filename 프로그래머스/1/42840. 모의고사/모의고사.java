import java.util.*;
import java.math.*;
class Solution {
    public int[] solution(int[] answers) {
    
        
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int oneLoc = 0;
        int twoLoc = 0;
        int threeLoc = 0;
        
        int[] val = new int[3];
        
        Mapping oneM = new Mapping(1, 0);
        Mapping twoM = new Mapping(2, 0);
        
        Mapping threeM = new Mapping(3, 0);
        
        for(int i = 0;  i< answers.length; i++){
            
            if(oneLoc > one.length - 1) {
                oneLoc = 0;
            }
            if(twoLoc > two.length - 1) {
                twoLoc = 0;
            }
            if(threeLoc > three.length - 1) {
                threeLoc = 0;
            }
            
            int ans = answers[i];
            
            if(one[oneLoc] == ans) {
                oneM.addVal();
            }
            
            
             if(two[twoLoc] == ans) {
                twoM.addVal();
            }
            
            if(three[threeLoc] == ans) {
                threeM.addVal();
            } 
            
            oneLoc++;
            twoLoc++;
            threeLoc++;
            
        }
        
        
        List<Mapping> lst = new ArrayList<>();
        
        lst.add(oneM);
        lst.add(twoM);
        lst.add(threeM);
        
        
         int max = 0;
        
//         for(int i = 0; i < lst.size(); i++){
//             Math.max(max, lst.get(i).val);
            
//             System.out.println(lst.get(i).key + " " + lst.get(i).val);
//         }
        
        lst.sort((a, b) -> {
            
            if(a.val == b.val) {
                return a.key - b.key;
            }
            
            return b.val - a.val;
        });
        
        for(int i = 0; i < lst.size(); i++){
           max =  Math.max(max, lst.get(i).val);
            
            System.out.println(lst.get(i).key + " " + lst.get(i).val);
        }
       
        
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 0;  i < lst.size(); i++){
            
            if(max == lst.get(i).val){
                answer.add(lst.get(i).key);
            }
        }
        
        System.out.print(answer);
        
        
        int[] retVal = new int[answer.size()];
        
        for(int i = 0; i < answer.size(); i++){
            
            retVal[i] = answer.get(i);
        }
    
        
        return  retVal;
    }
    
}

class Mapping{
    
    public int key;
    public int val;
    
    public Mapping(int key, int val){
        this.key = key;
        this.val = val;
    }
    
    public void addVal() {
        this.val++;
    }
}