package com.company;

import java.util.*;
import java.util.LinkedList;

public class HeightOfBT {
    public static class Node {
        int data;
        Node left;
        Node right;
        Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static int height (Node root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh)+1;
    }
    public static int countNodes (Node root) {
        if (root == null) {
            return 0;
        }
        int lCount = countNodes(root.left);
        int rCount = countNodes(root.right);
        return  lCount+rCount+1;
    }
    public static int sum (Node root) {
        if (root == null) {
            return 0;
        }
        int lSum = sum(root.left);
        int rSum = sum(root.right);
        return lSum+rSum+root.data;
    }
    public static class Info {
        int diam;
        int ht;
        public Info (int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }
    public static Info diameter (Node root) {
        if (root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht+rightInfo.ht+1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht)+1;

        return new Info(diam, ht);
    }

    public static boolean isIdentical (Node node, Node subRoot) {
        if (node == null && subRoot == null) {
            return true;
        } else if (node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }
        if (!isIdentical(node.left, subRoot.left)) {
            return false;
        }
        if (!isIdentical(node.right, subRoot.right)) {
            return false;
        }
        return true;
    }
    public static boolean isSubTree (Node root, Node subRoot) {
        if (root == null) {
            return false;
        }
        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        return  isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }

    public static class Info1 {
        Node node;
        int hd;
        public Info1 (Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    public static void topView (Node root) {
        // Level order traversal
        Queue<Info1> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;
        q.add(new Info1(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            Info1 curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            }
            else {
                if (!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }
                if (curr.node.left != null) {
                    q.add(new Info1(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }
                if (curr.node.right != null) {
                    q.add(new Info1(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();
    }

    public static void KLevel (Node root, int level, int k) {
        if (root == null) {
            return;
        }
        if (level == k) {
            System.out.print(root.data+" ");
            return;
        }
        KLevel(root.left, level+1, k);
        KLevel(root.right, level+1, k);
    }

    public static boolean getPath (Node root, int n, ArrayList<Node> path) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root.data == n) {
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if (foundLeft || foundRight) {
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }

    public static Node lca1(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        // Last Common Ancestor
        int i = 0;
        for (; i<path1.size() && i<path2.size(); i++) {
            if (!Objects.equals(path1.get(i), path2.get(i))) {
                break;
            }
        }

        // last equal node
        return path1.get(i-1);
    }

    public static Node lca2 (Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLCA = lca2(root.left, n1, n2);
        Node rightLCA = lca2(root.right, n1, n2);

        if (rightLCA == null) {
            return leftLCA;
        }
        if (leftLCA == null) {
            return rightLCA;
        }
        return root;
    }

    public static int lcaDist (Node root, int n) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }

        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        } else if (leftDist == -1) {
            return rightDist+1;
        } else {
            return leftDist+1;
        }
    }
    public static int minDist (Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2);
        int dist1 = lcaDist (lca, n1);
        int dist2 = lcaDist (lca, n2);
        return dist1+dist2;
    }

    public static int kthAncestor (Node root, int n, int k) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }

        int leftDist = kthAncestor(root.left, n, k);
        int rightDist = kthAncestor(root.right, n, k);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }

        int max = Math.max(leftDist, rightDist);
        if (max+1 == k) {
            System.out.println(root.data);
        }
        return max+1;
    }

    public static int transform (Node root) {
        if (root == null) {
            return 0;
        }
        int leftChild = transform(root.left);
        int rightChild = transform(root.right);

        int data = root.data;

        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0: root.right.data;

        root.data = newLeft + leftChild + newRight + rightChild;
        return data;
    }
    public static void levelOrder (Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data+" ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(height(root));
        System.out.println(countNodes(root));
        System.out.println(sum(root));
        System.out.println(diameter(root).diam);
        System.out.println(diameter(root).ht);

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println(isSubTree(root, subRoot));

        topView(root);

        KLevel(root, 1, 2);
        System.out.println();
        KLevel(root, 1, 3);

        System.out.println();

        System.out.println(lca1(root, 4, 5).data);
        System.out.println(lca1(root, 4, 6).data);

        System.out.println(lca2(root, 4, 5).data);
        System.out.println(lca2(root, 4, 6).data);

        System.out.println(minDist(root, 4, 5));
        System.out.println(minDist(root, 4, 6));

        kthAncestor(root, 5, 2);

        transform(root);
        levelOrder(root);
    }
}
