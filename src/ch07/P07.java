package ch07;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 7. 이진트리 순회(넓이우선탐색 : 레벨탐색)
 */

public class P07 {
    Node root;

    void DFS(Node root) {
        String answer = "";
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node currentQueue = queue.poll();
                answer += currentQueue.data + " ";
                if (currentQueue.lt != null) queue.offer(currentQueue.lt);
                if (currentQueue.rt != null) queue.offer(currentQueue.rt);
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {
        P07 tree = new P07();
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
