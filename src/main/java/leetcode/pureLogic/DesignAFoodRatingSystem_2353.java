package leetcode.pureLogic;

import leetcode.structures.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 18.12.2023
 **/
public class DesignAFoodRatingSystem_2353 {

    public static void main(String[] args) {

    }

    // Map food with its rating.
    private Map<String, Integer> foodRatingMap = new HashMap<>();
    // Map food with cuisine it belongs to.
    private Map<String, String> foodCuisineMap = new HashMap<>();

    // Store all food of a cuisine in set (to sort them on ratings/name)
    // Set element -> Pair: (-1 * foodRating, foodName)
    private Map<String, TreeSet<Pair<Integer, String>>> cuisineFoodMap = new HashMap<>();

    public DesignAFoodRatingSystem_2353(final String[] foods, final String[] cuisines, final int[] ratings) {
        for (int i = 0; i < foods.length; ++i) {
            // Store 'rating' and 'cuisine' of current 'food' in 'foodRatingMap' and 'foodCuisineMap' maps.
            foodRatingMap.put(foods[i], ratings[i]);
            foodCuisineMap.put(foods[i], cuisines[i]);

            // Insert the '(-1 * rating, name)' element in the current cuisine's set.
            cuisineFoodMap
                    .computeIfAbsent(cuisines[i], k -> new TreeSet<>((a, b) -> {
                        int compareByRating = Integer.compare(a.getLeft(), b.getLeft());
                        if (compareByRating == 0) {
                            // If ratings are equal, compare by food name (in ascending order).
                            return a.getRight().compareTo(b.getRight());
                        }
                        return compareByRating;
                    }))
                    .add(new Pair(-ratings[i], foods[i]));
        }
    }

    public void changeRating(final String food, final int newRating) {
        // Fetch cuisine name for food.
        final String cuisineName = foodCuisineMap.get(food);

        // Find and delete the element from the respective cuisine's set.
        final TreeSet<Pair<Integer, String>> cuisineSet = cuisineFoodMap.get(cuisineName);
        final Pair<Integer, String> oldElement = new Pair<>(-foodRatingMap.get(food), food);
        cuisineSet.remove(oldElement);

        // Update food's rating in 'foodRating' map.
        foodRatingMap.put(food, newRating);
        // Insert the '(-1 * new rating, name)' element in the respective cuisine's set.
        cuisineSet.add(new Pair<>(-newRating, food));
    }

    public String highestRated(final String cuisine) {
        final Pair<Integer, String> highestRated = cuisineFoodMap.get(cuisine).first();
        // Return name of the highest rated 'food' of 'cuisine'.
        return highestRated.getRight();
    }
}
