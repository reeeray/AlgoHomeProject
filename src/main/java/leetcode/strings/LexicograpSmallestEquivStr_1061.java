package leetcode.strings;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 14.01.2023
 **/
public class LexicograpSmallestEquivStr_1061 {

    public static void main(String[] args) {
        final String str1 = "opecenadojbodihfgmpijpfocomhcncicefpohkibjckijghii";
        final String str2 = "ndlbhpaeppgekfhnjnmmplmdoifdhbglmedpjgleofgnahglbe";
        final String minLex = "ttusuhhrabgsswpaapxoxdanchyccmpjitwwmfioedtbiggfru";

        System.out.println(smallestEquivalentString(str1, str2, minLex));
        System.out.println("ttusuaaraaasswaaaaxaxaaaaayaaaaaatwwaaaaaataaaaaru".equals("ttusuaaraaasswaaaaxaxaaaaayaaaaaatwwaaaaaataaaaaru"));
    }

    private static String smallestEquivalentString(final String s1, final String s2, final String baseStr) {
        final Map<Character, Set<Character>> uniques = new HashMap<>();
        for(int i=0; i<s1.length(); i++) {
            final char c1 = s1.charAt(i);
            final char c2 = s2.charAt(i);
//            uniques.computeIfAbsent(c1, v -> new HashSet<>()).add(c2);
//            uniques.computeIfAbsent(c2, v -> new HashSet<>()).add(c1);
//            uniques.get(c1).addAll(uniques.get(c2));
//            uniques.get(c2).addAll(uniques.get(c1));

            if(uniques.get(c1) == null && uniques.get(c2) == null) {
                final Set<Character> equiv = new HashSet<>();
                equiv.add(c1);
                equiv.add(c2);
                uniques.put(c1, equiv);
                uniques.put(c2, equiv);
            } else {
                if(uniques.get(c1) == null) {
                    uniques.get(c2).add(c1);
                    uniques.put(c1, uniques.get(c2));
                } else if (uniques.get(c2) == null){
                    uniques.get(c1).add(c2);
                    uniques.put(c2, uniques.get(c1));
                } else {
                    uniques.get(c1).addAll(uniques.get(c2));
                    uniques.get(c2).addAll(uniques.get(c1));
                }
            }
        }

        final StringBuilder sb = new StringBuilder();
        for(char c : baseStr.toCharArray()) {
            final Optional<Map.Entry<Character, Set<Character>>> possibleChar = uniques.entrySet().stream().sorted(Map.Entry.comparingByKey()).filter(e -> e.getValue().contains(c)).findFirst();
            final char ans = possibleChar.isPresent() ? possibleChar.get().getKey() : c;
            sb.append(ans);
//            if(uniques.get(c) != null) {
//                final List<Character> equiv = new ArrayList<>(uniques.get(c));
//                Collections.sort(equiv);
//
//                sb.append(equiv.get(0));
//            } else {
//                sb.append(c);
//            }
        }
        return sb.toString();
    }


    private static final int minRepr[] = new int[26];

    public String smallestEquivalentStringSolution2(String s1, String s2, String baseStr) {
        for(int i=0; i<26; i++) {
            minRepr[i] = i;
        }

        for(int i=0; i<s1.length(); i++) {
            merge(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        String res ="";
        for(char c : baseStr.toCharArray()) {
            res +=(char)('a' + findMinRepresentative(c-'a'));
        }
        return res;
    }

    private static int findMinRepresentative(final int val) {
        if(minRepr[val] == val) {
            return val;
        }
        return minRepr[val] = findMinRepresentative(minRepr[val]);
    }

    private static void merge(final int c1, final int c2) {
        final int minC1 = findMinRepresentative(c1);
        final int minC2 = findMinRepresentative(c2);

        if(minC1 == minC2) {
            return;
        } else if(minC1 < minC2) {
            minRepr[minC2] = minC1;
        } else {
            minRepr[minC1] = minC2;
        }
    }


    private static class UF {
        private Map<Character, Character> parent;
        public UF() {
            parent = new HashMap<>();
        }

        public void add(char c) {
            if(parent.containsKey(c)) return;
            parent.put(c, c);
        }

        public void union(char a, char b) {
            char rootA = findRoot(a);
            char rootB = findRoot(b);
            if(rootA == rootB) return;
            if(rootA < rootB) {
                parent.put(rootB, rootA);
            } else {
                parent.put(rootA, rootB);
            }
        }

        private char findRoot(char a) {
            if(parent.get(a) != a) {
                parent.put(a, findRoot(parent.get(a)));
            }
            return parent.get(a);
        }

        public char getSmall(char a) {
            return findRoot(a);
        }

    }
    public String smallestEquivalentStringSolution3(String s1, String s2, String baseStr) {
        UF uf = new UF();
        int n = s1.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            uf.add(c1);
            uf.add(c2);
            uf.union(c1, c2);
        }
        for(char c : baseStr.toCharArray()) {
            uf.add(c);
            sb.append(uf.getSmall(c));
        }
        return sb.toString();
    }


}
