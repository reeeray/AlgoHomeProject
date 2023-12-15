package leetcode.strings;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 15.12.2023
 **/
public class DestinationCity_1436 {

    public static void main(String[] args) {

    }

    //Time complexity(2n) and Space complexity O(n-1)
    public String destCity(final List<List<String>> paths) {
        final Set<String> from = new HashSet<>();
        for(final List<String> path : paths) {
            from.add(path.get(0));
        }
        for(final List<String> path : paths) {
            if(!from.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return "";
    }
}
