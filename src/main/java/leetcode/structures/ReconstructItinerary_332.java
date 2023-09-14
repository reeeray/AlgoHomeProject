package leetcode.structures;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 14.09.2023
 **/
public class ReconstructItinerary_332 {

    public static void main(String[] args) {
        final List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("MUC","LHR"));
        tickets.add(Arrays.asList("JFK","MUC"));
        tickets.add(Arrays.asList("SFO","SJC"));
        tickets.add(Arrays.asList("LHR","SFO"));
        finndItinerary(tickets);
    }

    public static List<String> finndItinerary(final List<List<String>> tickets) {
        final Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for(final List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), a -> new PriorityQueue<>()).add(ticket.get(1));
        }

        final LinkedList<String> stack = new LinkedList<>();
        stack.add("JFK");
        final LinkedList<String> itinerary = new LinkedList<>();
        while(!stack.isEmpty()) {
            while(graph.getOrDefault(stack.peekLast(), new PriorityQueue<>()).size() > 0) {
                stack.add(graph.get(stack.peekLast()).poll());
            }
            itinerary.addFirst(stack.pollLast());
        }
        return itinerary;
    }

    public List<String> finndItineraryDFS(final List<List<String>> tickets) {
        final Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for(final List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), a -> new PriorityQueue<>()).add(ticket.get(1));
        }

        final LinkedList<String> itinerary = new LinkedList<>();
        dfs("JFK", graph, itinerary);

        return itinerary;
    }

    private static void dfs(final String airport, final Map<String, PriorityQueue<String>> graph, final LinkedList<String> itinerary) {
        final PriorityQueue<String> flightsTo = graph.get(airport);
        while(flightsTo != null && flightsTo.size() > 0) {
            dfs(flightsTo.poll(), graph, itinerary);
        }
        itinerary.addFirst(airport);
    }
}
