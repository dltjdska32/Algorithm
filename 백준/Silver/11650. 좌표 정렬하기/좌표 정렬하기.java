import java.io.*;
import java.util.*;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Position> positions = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String strPosition = br.readLine();
            String[] xAndY = strPosition.split(" ");
            int x = Integer.parseInt(xAndY[0]);
            int y = Integer.parseInt(xAndY[1]);
            positions.add(new Position(x, y));
        }

        positions.sort((a, b) -> {
            if (a.x != b.x) return a.x - b.x;
            return a.y - b.y;
        });


        for(Position position : positions) {
            System.out.println(position.x + " " + position.y);
        }
    }

    static class Position {
        int x;
        int y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}