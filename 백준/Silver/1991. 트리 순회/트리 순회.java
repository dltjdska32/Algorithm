import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {

    static List<Tree> trees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        trees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            trees.add(new Tree(s[0], s[1], s[2]));
        }


        // 전위 순회
        preorderTraversal("A");
        System.out.println();
        // 중위 순회
        inorderTraversal("A");
        System.out.println();
        // 후위 순회
        postorderTraversal("A");
        System.out.println();
    }

    //전위 순회.
    // 재귀호출
    // 왼쪽 노드가 없을때 까지 출력하면서 반복한다
    // 왼쪽 자식노드가 없을경우 return 하고 오른쪽 자식노드를 출력하면서
    public static void preorderTraversal (String parent){
        // 자식노드가 없을경우 종료
        if(parent.equals(".")){
            return;
        }

        //노드출력
        System.out.print(parent);

        for(int i = 0; i < trees.size(); i++){
            Tree tree = trees.get(i);
            if(tree.parentNode.equals(parent)){
                // 왼쪽 탐색
                preorderTraversal(tree.leftNode);
                // 오른쪽 탐색
                preorderTraversal(tree.rightNode);
            }
        }
    }

    //중위순회
    // 왼쪽 -> 출력 -> 오른쪽순으로 재귀호출진행
    // 왼쪽노드가 .이 아닐경우 왼쪽노드 계속 재귀호출
    // 만약 왼쪽노드가 .일경우 해당 노드 출력후
    // 오른쪽 노드 재귀호출 진행
    public static void inorderTraversal(String parent){

        for(int i = 0; i < trees.size(); i++){
            Tree tree = trees.get(i);

            // 왼쪽노드부터 재귀호출
            // 자식노드가 . 아닐경우 재귀호출진행
            if(tree.parentNode.equals(parent)){

                if(!tree.leftNode.equals(".")) inorderTraversal(tree.leftNode);
                System.out.print(parent);
                if(!tree.rightNode.equals(".")) inorderTraversal(tree.rightNode);
            }
        }
    }

    // 후위 순회
    // 파라미터로 넘어온 부모노드와 일치하는 tree를 찾고
    // 왼쪽 노드가 . 이아닐때 까지 계속 재귀호출진행
    // 왼쪽 노드가 . 일경우
    // 오른쪽 노드가 .이 아닐때 까지 계속 재귀호출 진행
    // 출력후 return;
    public static void postorderTraversal(String parent){

        for(int i = 0; i < trees.size(); i++){
            Tree tree = trees.get(i);

            if(tree.parentNode.equals(parent)){
                if(!tree.leftNode.equals(".")) postorderTraversal(tree.leftNode);
                if(!tree.rightNode.equals(".")) postorderTraversal(tree.rightNode);
                System.out.print(parent);
            }
        }
    }
}

class Tree {
    String parentNode;
    String leftNode;
    String rightNode;

    public Tree(String parentNode, String leftNode, String rightNode) {
        this.parentNode = parentNode;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
}