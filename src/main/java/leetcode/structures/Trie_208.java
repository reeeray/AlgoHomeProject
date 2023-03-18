package leetcode.structures;

import java.util.ArrayList;
import java.util.List;

/**
 * Prefix tree
 * User : Shein G.A.{@reeeray}
 * Date : 17.03.2023
 **/
public class Trie_208 {

    private List<int[]> words = new ArrayList<>();

    public Trie_208() {
        words.add(new int[26]);
    }

    public void insert(final String word) {
        for(int i=0; i<word.length(); i++) {
            int[] chars;
            if(words.size()-1 >= i) {
                chars = words.get(i);
            } else {
                chars = new int[26];
                words.add(chars);
            }
            final int n = word.charAt(i) - 'a';
            if(chars[n] == 0) {
                if(i == word.length()-1) {
                    chars[n] = -1;
                } else {
                    chars[n] = 1;
                }
            } else if(i == word.length()-1) {
                chars[n] = 2;
            }
        }
    }

    public boolean search(final String word) {
        for(int i=0; i<word.length(); i++) {
            if(words.size()-1 >= i) {
                int[] chars = words.get(i);
                final int n = word.charAt(i) - 'a';
                if(chars[n] == 0) {
                    return false;
                } else {
                    if (i == word.length()-1) {
                        if (chars[n] == -1 || chars[n] == 2) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean startsWith(final String prefix) {
        for(int i=0; i<prefix.length(); i++) {
            if(words.size()-1 >= i) {
                int[] chars = words.get(i);
                final int n = prefix.charAt(i) - 'a';
                if(chars[n] == 0) {
                    return false;
                } else {
                    if (i == prefix.length()-1) {
                        if (chars[n] != 0) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            } else {
                return false;
            }
        }
        return false;
    }



    public static class Demo {
        public static void main(String[] args) {
            final Trie_208 trie = new Trie_208();
            trie.insert("a");
            trie.search("a");
            trie.startsWith("a");
        }
    }
}
