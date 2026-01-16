package leetcode.arrays;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 16.01.2026
 **/
public class MaxSquareAreaByRemovingFencesFromAField_2975 {

    public static void main(String[] args) {

    }

    public static int maximizeSquareArea(final int m, final int n, final int[] hFences, final int[] vFences) {
        final Set<Integer> hEdges = getEdges(m, hFences);
        final Set<Integer> vEdges = getEdges(n, vFences);
        final int MOD = (int)1e9 + 7;

        long res = -1;
        for(final int hEdge : hEdges) {
            if(vEdges.contains(hEdge)) {
                res = Math.max(res, hEdge);
            }
        }
        return res == -1 ? -1 : (int)((res * res)%MOD);
    }

    private static Set<Integer> getEdges(final int limit, final int[] fences) {
        final Set<Integer> edges = new HashSet<>();
        final List<Integer> listOfFences = Arrays.stream(fences).boxed().collect(Collectors.toList());
        listOfFences.add(1);listOfFences.add(limit);
        Collections.sort(listOfFences);
        for(int i = 0; i < listOfFences.size(); i++) {
            for( int j = i + 1; j < listOfFences.size(); j++) {
                edges.add(listOfFences.get(j) - listOfFences.get(i));
            }
        }
        return edges;
    }
}
