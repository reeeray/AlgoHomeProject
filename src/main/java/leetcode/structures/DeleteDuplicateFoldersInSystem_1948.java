package leetcode.structures;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 20.07.2025
 **/
public class DeleteDuplicateFoldersInSystem_1948 {

    public static void main(String[] args) {

    }

    private static List<List<String>> deleteDuplicateFolder(final List<List<String>> paths) {
        final Trie root = new Trie();
        for(final List<String> nodes : paths) {
            Trie curr = root;
            for(final String node : nodes) {
                curr.successors.putIfAbsent(node, new Trie());
                curr = curr.successors.get(node);
            }
        }

        final Map<String, Integer> freq = new HashMap<>();
        countFreq(root, freq);
        final List<List<String>> res = new ArrayList<>();
        final List<String> path = new ArrayList<>();
        processTrie(root, freq, path, res);
        return res;
    }

    private static void countFreq(final Trie node, final Map<String, Integer> freq) {
        if(node.successors.isEmpty()) return;
        final List<String> temp = new ArrayList<>();
        for(Map.Entry<String, Trie> entry : node.successors.entrySet()) {
            countFreq(entry.getValue(), freq);
            temp.add(entry.getKey() + "(" + entry.getValue().id + ")");
        }
        Collections.sort(temp);
        final StringBuilder sb = new StringBuilder();
        for(final String repr : temp) {
            sb.append(repr);
        }
        node.id = sb.toString();
        freq.put(node.id, freq.getOrDefault(node.id, 0) + 1);
    }

    private static void processTrie(final Trie node, final Map<String, Integer> freq, final List<String> path, final List<List<String>> res) {
        if(freq.getOrDefault(node.id, 0) > 1) return;
        if(!path.isEmpty()) {
            res.add(new ArrayList<>(path));
        }
        for(final Map.Entry<String, Trie> entry : node.successors.entrySet()) {
            path.add(entry.getKey());
            processTrie(entry.getValue(), freq, path, res);
            path.remove(path.size() - 1);
        }
    }

    private static class Trie {
        String id;
        Map<String, Trie> successors = new HashMap<>();
    }
}
