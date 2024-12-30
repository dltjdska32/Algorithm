import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Position> positions = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n; i++){
                String strPosition = br.readLine();
            String[] token = strPosition.split(" ");
            int x = Integer.parseInt(token[0]);
            int y = Integer.parseInt(token[1]);
            positions.add(new Position(x, y));
        }

        positions.sort((a,b) -> {
            if(a.y != b.y) return a.y - b.y;
            return a.x - b.x;
        });


            for(Position p : positions) {
                System.out.println(p.x + " " + p.y);
            }
    }

    static class Position {
        int x;
        int y;
        public Position (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}