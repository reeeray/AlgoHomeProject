package leetcode.arrays;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 07.03.2025
 **/
public class ClosestPrimeNumbersInRange_2523 {

    public static void main(String[] args) {

    }

    //Eratosfen sieve. Space O(R) and Time O(log(log(R)) + R - L) where R is right limit and L is left limit
    public static int[] closestPrimes(final int left, final int right) {
        // Step 1: Get all prime numbers up to 'right' using sieve
        int[] sieveArray = sieveEratosfen(right);

        final List<Integer> primeNumbers = new ArrayList<>(); // Store all primes in the range [left, right]
        for (int num = left; num <= right; num++) {
            // If number is prime add to the primeNumbers list
            if (sieveArray[num] == 1) {
                primeNumbers.add(num);
            }
        }

        // Step 2: Find the closest prime pair
        if (primeNumbers.size() < 2) return new int[] { -1, -1 }; // Less than two primes available

        int minDifference = Integer.MAX_VALUE;
        final int[] closestPair = new int[]{-1, -1};

        for (int index = 1; index < primeNumbers.size(); index++) {
            final int difference = primeNumbers.get(index) - primeNumbers.get(index - 1);
            if (difference < minDifference) {
                minDifference = difference;
                closestPair[0] = primeNumbers.get(index - 1);
                closestPair[1] = primeNumbers.get(index);
            }
        }

        return closestPair;
    }

    private static int[] sieveEratosfen(final int limit) {
        final int[] primeNumbers = new int[limit + 1];
        Arrays.fill(primeNumbers, 1);
        primeNumbers[0] = 0;
        primeNumbers[1] = 0;
        for (int n = 2; n*n <= limit; n++) {
            if(primeNumbers[n] == 1) {
                for(int factor = n*n; factor <= limit; factor+=n) {
                    primeNumbers[factor] = 0;
                }
            }
        }
        return primeNumbers;
    }

    //Analayze distance between two closes prime numbers. Time O(min(1452, R-L)*sqrt(R)) and space O(1)
    public int[] closestPrimesOpt(int left, int right) {
        int prevPrime = -1, closestA = -1, closestB = -1;
        int minDifference = (int) 1e6;
        // Find all prime numbers in the given range
        for (int candidate = left; candidate <= right; candidate++) {
            if (isPrime(candidate)) {
                if (prevPrime != -1) {
                    final int difference = candidate - prevPrime;
                    if (difference < minDifference) {
                        minDifference = difference;
                        closestA = prevPrime;
                        closestB = candidate;
                    }
                    // Twin prime optimization
                    if (difference == 2 || difference == 1) return new int[] {
                            prevPrime,
                            candidate,
                    };
                }
                prevPrime = candidate;
            }
        }

        return (closestA == -1)
                ? new int[] { -1, -1 }
                : new int[] { closestA, closestB };
    }

    private boolean isPrime(int number) {
        if (number < 2) return false;
        if (number == 2 || number == 3) return true;
        if (number % 2 == 0) return false;
        for (int divisor = 3; divisor * divisor <= number; divisor += 2) {
            if (number % divisor == 0) return false;
        }
        return true;
    }
}
