import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int val;
        Node left, right;
        Node(int val) {
            this.val = val;
        }
    }

    // Insert node into BST
    static Node insert(Node root, int val) {
        if (root == null) return new Node(val);
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();

        String tToken = sc.next();
        if (tToken == null) return;
        int t = Integer.parseInt(tToken);

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            Node root = null;
            for (int i = 0; i < n; i++) {
                int val = sc.nextInt();
                root = insert(root, val);
            }

            if (root == null) continue;

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            // Level 1 (odd) is Right-to-Left, so start with leftToRight = false
            boolean leftToRight = false;

            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> currentLevel = new ArrayList<>();

                for (int i = 0; i < size; i++) {
                    Node curr = queue.poll();
                    currentLevel.add(curr.val);

                    if (curr.left != null) queue.add(curr.left);
                    if (curr.right != null) queue.add(curr.right);
                }

                if (!leftToRight) {
                    Collections.reverse(currentLevel);
                }

                for (int val : currentLevel) {
                    sb.append(val).append(" ");
                }

                leftToRight = !leftToRight;
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    // Fast I/O Helper
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    return null;
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            String s = next();
            return s != null ? Integer.parseInt(s) : 0;
        }
    }
}
