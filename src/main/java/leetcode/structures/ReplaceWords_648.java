package leetcode.structures;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 07.06.2024
 **/
public class ReplaceWords_648 {

    public static void main(String[] args) {
        final List<String> dictionary = new ArrayList<>();
        dictionary.add("a");
        dictionary.add("aa");
        dictionary.add("aaa");
        dictionary.add("aaaa");
        //a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa
        //the cattle was rattled by the battery
        System.out.println(replaceWords(dictionary, "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"));
    }

    public static String replaceWords(final List<String> dictionary, final String sentence) {
        final Recursion head = new Recursion();
        for(final String s : dictionary) {
            Recursion curr = head;
            for(final char c : s.toCharArray()) {
                if(curr.rec == null) {
                    break;
                }
                if(curr.rec[c - 'a'] == null) {
                    curr.rec[c - 'a'] = new Recursion();
                }
                curr = curr.rec[c - 'a'];
            }
            curr.rec = null;
        }

        final String[] words = sentence.split(" ");
        final StringBuilder sb = new StringBuilder();
        for(final String word : words) {
            Recursion curr = head;
            final int count = sb.length();
            for(int i=0; i<word.length(); i++) {
                if(curr.rec != null && curr.rec[word.charAt(i) - 'a'] != null) {
                    curr = curr.rec[word.charAt(i) - 'a'];
                } else {
                    if(curr.rec == null) {
                        sb.append(word, 0, i);
                    }
                    break;
                }
            }
            if(count == sb.length()) {
                sb.append(word);
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    private static class Recursion {
        Recursion[] rec;

        public Recursion () {
            rec = new Recursion[26];
        }
    }

    static class Node {
        boolean isWord;
        Node[] children = new Node[26];
    }

    Node root = new Node();

    public String replaceWordsTheir(List<String> dictionary, String sentence) {
        for (String str: dictionary) {
            insert(str);
        }

        String[] arr = sentence.split(" ");
        StringBuilder builder = new StringBuilder("");
        for (int i=0; i<arr.length; i++) {
            String replace = search(arr[i]);
            if (replace == "") {
                builder.append(arr[i]);
            } else {
                builder.append(replace);
            }
            builder.append(" ");
        }
        return builder.toString().trim();
    }

    public void insert(String str) {
        Node node = this.root;
        for (char c: str.toCharArray()) {
            int n = c-'a';
            if (node.children[n] == null) {
                node.children[n] = new Node();
            }
            node = node.children[n];
        }
        node.isWord = true;
    }


    public String search(String str) {
        Node node = this.root;
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            int n = c-'a';
            if (node.children[n] == null) {
                return "";
            }
            node = node.children[n];
            if (node.isWord) return str.substring(0, i+1);
        }
        return "";
    }
}
