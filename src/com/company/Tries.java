package com.company.company;

public class Tries {
    public static class Node {
        Node [] children = new Node[26];
        boolean eow = false;
        public Node () {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }
    public static Node root = new Node();

    public static void insert (String word) {
        Node curr = root;
        for (int level = 0;  level<word.length() ; level++) {
            int idx = word.charAt(level)-'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static boolean search (String key) {
        Node curr = root;
        for (int level = 0;  level<key.length() ; level++) {
            int idx = key.charAt(level)-'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow;
    }
    public static boolean wordBreak (String key) {
        if (key.isEmpty()) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            if (search(key.substring(0, i)) && wordBreak(key.substring(i))) {
                return true;
            }
        }
        return false;
    }
    public static boolean startsWith (String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i)-'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    public static int countNodes (Node root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }
        return count+1;
    }

    public static String ans = "";
    public static void longestWord (Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].eow) {
                char ch = (char) (i+'a');
                temp.append(ch);
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
    public static void main(String[] args) {
//        String [] words = {"the", "a", "there", "their", "any", "thee"};
//        for (String word : words) {
//            insert(word);
//        }
//        System.out.println(search("thee"));
//        System.out.println(search("thor"));

//        String [] arr = {"i", "like", "sam", "samsung", "mobile", "ice"};
//        for (String s : arr) {
//            insert(s);
//        }
//        String key = "ilikesamsung";
//        System.out.println(wordBreak(key));

//        String [] words = {"apple", "app", "mango", "man", "woman"};
//        for (String word : words) {
//            insert(word);
//        }
//        System.out.println(startsWith("app"));
//        System.out.println(startsWith("moon"));

//        String str = "ababa";
//        // suffix -> insert in trie
//        for (int i = 0; i < str.length(); i++) {
//            String suffix = str.substring(i);
//            insert(suffix);
//        }
//        System.out.println(countNodes(root));

        String[] words = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        for (String word : words) {
            insert(word);
        }
        longestWord(root, new StringBuilder());
        System.out.println(ans);
    }
}
