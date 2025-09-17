package leetcode.structures;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 17.09.2025
 **/
public class DesignAFoodRatingSystem_2353 {

    public static void main(String[] args) {
//        final FoodRatings testee = new FoodRatings(new String[] {"kimchi","miso","sushi","moussaka","ramen","bulgogi"},
//                new String[] {"korean","japanese","japanese","greek","japanese","korean"}, new int[] {9,12,8,15,14,7});
//        testee.highestRated("korean");
//        testee.highestRated("japanese");
//        testee.changeRating("sushi", 16);
//        testee.highestRated("japanese");
//        testee.changeRating("ramen", 16);
//        testee.highestRated("japanese");

        final FoodRatings testee2 = new FoodRatings(new String[] {"czopaaeyl","lxoozsbh","kbaxapl"},
                new String[] {"dmnuqeatj","dmnuqeatj","dmnuqeatj"}, new int[] {11,2,15});
        testee2.changeRating("czopaaeyl",12);
        testee2.highestRated("dmnuqeatj");
        testee2.changeRating("kbaxapl",8);
        testee2.highestRated("dmnuqeatj");
        testee2.changeRating("lxoozsbh",5);
        testee2.highestRated("dmnuqeatj");

    }

    private static class FoodRatings {

        private final String[] foods;
        private final String[] cuisines;
        private final int[] ratings;
        private final Map<String, Integer> cuisinesIndex;
        private final Map<String, Integer> foodIndex;

        public FoodRatings(final String[] foods, final String[] cuisines, final int[] ratings) {
            this.foods = foods;
            this.cuisines = cuisines;
            this.ratings = ratings;
            cuisinesIndex = new HashMap<>();
            foodIndex = new HashMap<>();
            for(int i = 0; i < foods.length; i++) {
                foodIndex.put(foods[i], i);
                final int currIndex = cuisinesIndex.getOrDefault(cuisines[i], -1);
                final int currRating = currIndex == -1 ? -1 : ratings[currIndex];
                if(ratings[i] > currRating) {
                    cuisinesIndex.put(cuisines[i], i);
                } else if (ratings[i] == currRating) {
                    if(foods[i].compareTo(foods[cuisinesIndex.get(cuisines[i])]) < 0) {
                        cuisinesIndex.put(cuisines[i], i);
                    }
                }
            }
        }

        public void changeRating(final String food, final int newRating) {
            final int index = foodIndex.get(food);
            final int oldRating = ratings[index];
            ratings[index] = newRating;
            final String cuisine = cuisines[index];
            if(cuisinesIndex.get(cuisine) == index && newRating >= oldRating) {
                return;
            }
            if(ratings[cuisinesIndex.get(cuisine)] > newRating) {
                return;
            }
            if(cuisinesIndex.get(cuisine) != index && ratings[cuisinesIndex.get(cuisine)] == newRating) {
                if(food.compareTo(foods[cuisinesIndex.get(cuisines[index])]) < 0) {
                    cuisinesIndex.put(cuisines[index], index);
                }
                return;
            }
            if(newRating > ratings[cuisinesIndex.get(cuisine)]) {
                cuisinesIndex.put(cuisines[index], index);
                return;
            }
            for(int i = 0; i < cuisines.length; i++) {
             if(cuisine.equals(cuisines[i])) {
                 if(ratings[i] > ratings[cuisinesIndex.get(cuisines[i])]) {
                     cuisinesIndex.put(cuisines[i], i);
                 } else if(ratings[i] == cuisinesIndex.get(cuisines[i])) {
                     if(foods[i].compareTo(foods[cuisinesIndex.get(cuisines[i])]) < 0) {
                         cuisinesIndex.put(cuisines[i], i);
                     }
                 }
             }
            }
        }

        public String highestRated(final String cuisine) {
            return foods[cuisinesIndex.get(cuisine)];
        }
    }

    private static class FoodRatingsTreeSetImpl{
        // Map food with its rating.
        private Map<String, Integer> foodRatingMap = new HashMap<>();
        // Map food with cuisine it belongs to.
        private Map<String, String> foodCuisineMap = new HashMap<>();

        // Store all food of cuisine in set (to sort them on ratings/name)
        // Set element -> Pair: (-1 * foodRating, foodName)
        private Map<String, TreeSet<Pair<Integer, String>>> cuisineFoodMap = new HashMap<>();

        public FoodRatingsTreeSetImpl(String[] foods, String[] cuisines, int[] ratings) {
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

        public void changeRating(String food, int newRating) {
            // Fetch cuisine name for food.
            String cuisineName = foodCuisineMap.get(food);

            // Find and delete the element from the respective cuisine's set.
            TreeSet<Pair<Integer, String>> cuisineSet = cuisineFoodMap.get(cuisineName);
            Pair<Integer, String> oldElement = new Pair<>(-foodRatingMap.get(food), food);
            cuisineSet.remove(oldElement);

            // Update food's rating in 'foodRating' map.
            foodRatingMap.put(food, newRating);
            // Insert the '(-1 * new rating, name)' element in the respective cuisine's set.
            cuisineSet.add(new Pair<>(-newRating, food));
        }

        public String highestRated(String cuisine) {
            Pair<Integer, String> highestRated = cuisineFoodMap.get(cuisine).first();
            // Return name of the highest rated 'food' of 'cuisine'.
            return highestRated.getRight();
        }
    }


}
