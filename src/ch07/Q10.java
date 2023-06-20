package ch07;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 10. Tree 말단 노드까지의 가장 짧은 경로 (BFS)
 */

public class Q10 {
    Node root;

    int BFS(Node root) {
        int level = 0;
        Queue<Node> queue = new LinkedList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node currentNode = queue.poll();
                if (currentNode.lt == null && currentNode.rt == null) return level;
                if (currentNode.lt != null) queue.offer(currentNode.lt);
                if (currentNode.rt != null) queue.offer(currentNode.rt);
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Q10 tree = new Q10();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        System.out.print(tree.BFS(tree.root));
    }
}
