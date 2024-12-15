package leetcode.structures;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 15.12.2024
 **/
public class MaxAveragePassRatio_1792 {

    public static void main(String[] args) {

    }

    //Time O(nlogn) due to PQ and Space O(n)
    public static double maxAverageRatio(final int[][] classes, int extraStudents) {
        final PriorityQueue<int[]> formulaBasedPrio = new PriorityQueue<>(Comparator.comparingDouble(a -> -((a[0] + 1.0)/(a[1] + 1) - (a[0]*1.0/a[1]))));
        formulaBasedPrio.addAll(Arrays.asList(classes));
        while (extraStudents-- > 0) {
            final int[] klass = formulaBasedPrio.poll();
            klass[0]++;
            klass[1]++;
            formulaBasedPrio.add(klass);
        }
        double ans = 0;
        while (!formulaBasedPrio.isEmpty()) {
            final int[] klass = formulaBasedPrio.poll();
            ans += klass[0]*1.0 / klass[1];
        }
        return ans / classes.length;
    }

    public double maxAverageRatioAlternative(int[][] classes, int extraStudents) {
        // Lambda to calculate the gain of adding an extra student
        final PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) ->
                Double.compare(b[0], a[0])
        );

        for (final int[] singleClass : classes) {
            int passes = singleClass[0];
            int totalStudents = singleClass[1];
            double gain = calculateGain(passes, totalStudents);
            maxHeap.offer(new double[] { gain, passes, totalStudents });
        }

        // Distribute extra students
        while (extraStudents-- > 0) {
            double[] current = maxHeap.poll();
            double currentGain = current[0];
            int passes = (int) current[1];
            int totalStudents = (int) current[2];
            maxHeap.offer(
                    new double[] {
                            calculateGain(passes + 1, totalStudents + 1),
                            passes + 1,
                            totalStudents + 1,
                    }
            );
        }

        // Calculate the final average pass ratio
        double totalPassRatio = 0;
        while (!maxHeap.isEmpty()) {
            double[] current = maxHeap.poll();
            int passes = (int) current[1];
            int totalStudents = (int) current[2];
            totalPassRatio += (double) passes / totalStudents;
        }

        return totalPassRatio / classes.length;
    }

    private double calculateGain(int passes, int totalStudents) {
        return (
                (double) (passes + 1) / (totalStudents + 1) -
                        (double) passes / totalStudents
        );
    }
}
