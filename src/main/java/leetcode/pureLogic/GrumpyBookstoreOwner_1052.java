package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 21.06.2024
 **/
public class GrumpyBookstoreOwner_1052 {

    public static void main(String[] args) {
        maxSatisfied(new int[] {1,0,1,2,1,1,7,5}, new int[] {0,1,0,1,0,1,0,1}, 3);

    }

    public static int maxSatisfied(final int[] customers, final int[] grumpy, final int minutes) {
        int max = 0;
        int window = 0;
        int winIndex = -1;
        int totRes = 0;
        if(customers.length == minutes) {
            for(int c : customers) {
                totRes += c;
            }
            return totRes;
        }
        for(int i=0; i<customers.length; i++) {
            if(grumpy[i] == 0) {
                totRes += customers[i];
            } else {
                window += customers[i];
                if(winIndex == -1) {
                    winIndex = i;
                }
            }

            if(i - winIndex == minutes) {
                max = Math.max(max, window);
                window -= customers[winIndex];
                while(grumpy[++winIndex] == 0) {
                }

            }
        }
        return totRes + max;
    }

    public static int maxSatisfiedNotMine(final int[] customers, final int[] grumpy, final int minutes) {
        int unrealizedCustomers = 0;

        // Calculate initial number of unrealized customers in first 'minutes' window
        for (int i = 0; i < minutes; i++) {
            unrealizedCustomers += customers[i] * grumpy[i];
        }

        int maxUnrealizedCustomers = unrealizedCustomers;

        // Slide the 'minutes' window across the rest of the customers array
        for (int i = minutes; i < customers.length; i++) {
            // Add the current minute's unsatisfied customers if the owner is grumpy
            // and remove the customers that are out of the current window
            unrealizedCustomers += customers[i] * grumpy[i];
            unrealizedCustomers -= customers[i - minutes] * grumpy[i - minutes];

            // Update the maximum unrealized customers
            maxUnrealizedCustomers = Math.max(
                    maxUnrealizedCustomers,
                    unrealizedCustomers
            );
        }

        // Start with maximum possible satisfied customers due to secret technique
        int totalCustomers = maxUnrealizedCustomers;

        // Add the satisfied customers during non-grumpy minutes
        for (int i = 0; i < customers.length; i++) {
            totalCustomers += customers[i] * (1 - grumpy[i]);
        }

        // Return the maximum number of satisfied customers
        return totalCustomers;
    }
}
