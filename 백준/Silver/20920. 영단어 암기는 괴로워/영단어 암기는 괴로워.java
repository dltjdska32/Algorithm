import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        
        Map<String, Integer> map = new HashMap<>();
        List<Inform> informs = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
          String str = br.readLine();
          
          if(str.length() < m) continue;
          
          if(map.containsKey(str)) {
            int value = map.get(str);
            map.put(str, value + 1);
          } else {
            map.put(str, 1);
          } 
        
        }
        
        
        Set<String> keys = map.keySet();
        
        for (String key : keys) {
        
          Inform inform = new Inform(key, map.get(key), key.length());
          informs.add(inform);
          
        }
        
        informs.sort((a, b) -> {
          if(a.getValue() != b.getValue()) return b.getValue() - a.getValue();
          if(a.getLength() != b.getLength()) return b.getLength() - a.getLength();
          return a.getKey().compareTo(b.getKey());
        });
        

        StringBuilder sb = new StringBuilder();
        
        
        for(Inform inform : informs) {
            sb.append(inform.getKey());
            sb.append("\n");      
        }

        System.out.println(sb);
    }
    
    static class Inform {
          String key;
          int value;
          int keyLength;
          
          public Inform(String key, int value, int keyLength) {
            this.key = key;
            this.value = value;
            this.keyLength = keyLength;
          }
          
          public int getValue() {
            return this.value;
          }
          
          public int getLength() {
            return this.keyLength;
          }
          
          public String getKey() {
            return this.key;
          }
        }
}