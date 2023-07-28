package ch07;

/**
 * 9. Tree 말단 노드까지의 가장 짧은 경로 (DFS)
 */

public class P09 {
    Node root;

    int DFS(int level, Node root) {
        if (root.lt == null && root.rt == null) return level;
        else return Math.min(DFS(level + 1, root.lt), DFS(level + 1, root.rt));
    }

    public static void main(String[] args) {
        P09 tree = new P09();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        System.out.print(tree.DFS(0, tree.root));
    }
}
