package leetcode.dfs;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 21.03.2025
 **/
public class FindAllPossibleRecipesFromGivenSupplies_2115 {

    public static void main(String[] args) {

    }

    //Time (n*m + s) and Space O(n + s) where n number of recipes, m number of ingridients and s number of supplies
    public List<String> findAllRecipes(final String[] recipes, final List<List<String>> ingredients, final String[] supplies) {
        // Track available ingredients and recipes
        final Set<String> available = new HashSet<>();
        for (String supply : supplies) {
            available.add(supply);
        }

        // Queue to process recipe indices
        final Queue<Integer> recipeQueue = new LinkedList<>();
        for (int idx = 0; idx < recipes.length; ++idx) {
            recipeQueue.offer(idx);
        }

        List<String> createdRecipes = new ArrayList<>();
        int lastSize = -1;

        // Continue while we keep finding new recipes
        while (available.size() > lastSize) {
            lastSize = available.size();
            int queueSize = recipeQueue.size();

            // Process all recipes in current queue
            while (queueSize-- > 0) {
                int recipeIdx = recipeQueue.poll();
                boolean canCreate = true;

                // Check if all ingredients are available
                for (String ingredient : ingredients.get(recipeIdx)) {
                    if (!available.contains(ingredient)) {
                        canCreate = false;
                        break;
                    }
                }

                if (!canCreate) {
                    recipeQueue.offer(recipeIdx);
                } else {
                    // Recipe can be created - add to available items
                    available.add(recipes[recipeIdx]);
                    createdRecipes.add(recipes[recipeIdx]);
                }
            }
        }

        return createdRecipes;
    }

    //Time O(n + m + s) and Space O(n + m)
    public List<String> findAllRecipesDFS(final String[] recipes, final List<List<String>> ingredients, final String[] supplies) {
        final List<String> possibleRecipes = new ArrayList<>();
        // Track if ingredient/recipe can be made
        final Map<String, Boolean> canMake = new HashMap<>();
        // Map recipe name to its index in ingredients list
        final Map<String, Integer> recipeToIndex = new HashMap<>();

        // Mark all initial supplies as available
        for (String supply : supplies) {
            canMake.put(supply, true);
        }

        // Create recipe to index mapping
        for (int idx = 0; idx < recipes.length; idx++) {
            recipeToIndex.put(recipes[idx], idx);
        }

        // Try to make each recipe using DFS
        for (String recipe : recipes) {
            checkRecipe(recipe, ingredients, new HashSet<String>(), canMake, recipeToIndex);
            if (canMake.get(recipe)) {
                possibleRecipes.add(recipe);
            }
        }

        return possibleRecipes;
    }

    private void checkRecipe(final String recipe, final List<List<String>> ingredients,
            final Set<String> visited, final Map<String, Boolean> canMake, final Map<String, Integer> recipeToIndex) {
        // Return if we already know if recipe can be made
        if (canMake.containsKey(recipe) && canMake.get(recipe)) {
            return;
        }

        // Not a valid recipe or cycle detected
        if (!recipeToIndex.containsKey(recipe) || visited.contains(recipe)) {
            canMake.put(recipe, false);
            return;
        }

        visited.add(recipe);

        // Check if we can make all required ingredients
        List<String> neededIngredients = ingredients.get(
                recipeToIndex.get(recipe)
        );
        for (String ingredient : neededIngredients) {
            checkRecipe(
                    ingredient,
                    ingredients,
                    visited,
                    canMake,
                    recipeToIndex
            );
            if (!canMake.get(ingredient)) {
                canMake.put(recipe, false);
                return;
            }
        }

        // All ingredients can be made
        canMake.put(recipe, true);
    }
}
