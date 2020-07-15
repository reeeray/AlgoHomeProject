package leetcode.strings;

import java.util.*;

/**
 * 332 Reconstruct Itinerary.
 * User : Shein G.A.{@reeeray}
 * Date : 28.06.2020
 **/
public class ReconstructItinerary_332 {

    public static List<String> findItinerary(List<List<String>> tickets) {
        final Map<String, List<String>> map = new HashMap<>();
        final List<String> res = new ArrayList<>();
        for (List<String> ticket : tickets) {
            map.putIfAbsent(ticket.get(0), new ArrayList<>());
            if (map.get(ticket.get(0)).isEmpty())
                map.get(ticket.get(0)).add(ticket.get(1));
            else {
                final List<String> list = map.get(ticket.get(0));
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).compareTo(ticket.get(1)) > 1) {
                        System.out.println(ticket.get(0) + "---" + ticket.get(1));
                        list.add(i, ticket.get(1));
                        break;
                    }
                    if (i == list.size() - 1) {
                        list.add(ticket.get(1));
                        break;
                    }
                }
            }
        }

        String cur = "JFK";
        res.add(cur);
        System.out.println(map.get(cur).get(0));
        while (cur != null) {
            List<String> list = map.get(cur);
            if (list == null || list.isEmpty())
                break;
            cur = list.remove(0);
            res.add(cur);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(
                findItinerary(Arrays.asList(Arrays.asList("JFK", "SFO"), Arrays.asList("JFK", "ATL"), Arrays.asList("SFO", "ATL"),
                        Arrays.asList("ATL", "JFK"), Arrays.asList("ATL", "SFO")))
        );
    }

    public List<String> findItineraryDFS(List<List<String>> tickets) {
        final Map<String, PriorityQueue<String>> adj = new HashMap();
        for (List<String> t : tickets) {
            adj.putIfAbsent(t.get(0), new PriorityQueue<>());
            adj.get(t.get(0)).add(t.get(1));
        }

        final LinkedList<String> result = new LinkedList();
        dfs(adj, result, "JFK");
        return result;
    }

    private void dfs(Map<String, PriorityQueue<String>> adj, LinkedList<String> result, String s) {
        PriorityQueue<String> pq = adj.get(s);
        while (pq != null && !pq.isEmpty()) {
            String v = pq.poll();
            dfs(adj, result, v);
        }
        result.addFirst(s);
    }
}
