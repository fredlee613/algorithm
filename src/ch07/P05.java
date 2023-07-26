package ch07;

/**
 * 5. 이진트리 순회(깊이우선탐색)
 */

public class P05 {
    Node root;

    void DFS(Node root) {
        if (root == null) return;
        else {
//            System.out.print(root.data + " "); //전위 순회: 1 2 4 5 3 6 7
            DFS(root.lt);
//            System.out.print(root.data + " "); //중위 순회:  4 2 5 1 6 3 7
            DFS(root.rt);
//            System.out.print(root.data + " "); //후위 순회:  4 5 2 6 7 3 1
        }
    }

    public static void main(String[] args) {
        P05 tree = new P05();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.DFS(tree.root);
    }
}
