package leetcode.structures;

import java.util.TreeMap;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 22.07.2024
 **/
public class SortThePeople_2418 {

    public static void main(String[] args) {
        final String[] inputStr = new String[] {"IEO","Sgizfdfrims","QTASHKQ","Vk","RPJOFYZUBFSIYp","EPCFFt","VOYGWWNCf","WSpmqvb"};
        sortPeople(inputStr, new int[] {17233,32521,14087,42738,46669,65662,43204,8224});
    }

    public static String[] sortPeople(final String[] names, final int[] heights) {
        int index;
        int max;
        for(int i=0; i<heights.length-1; i++) {
            max = heights[i];
            index = i;
            for(int j = i+1; j<heights.length; j++) {
                if(max < heights[j]) {
                    index = j;
                    max = heights[index];
                }
            }
            final String toSwap = names[i];
            names[i] = names[index];
            names[index] = toSwap;
            heights[index] = heights[i];
        }
        return names;
    }

    //O(nlogn) and Space O(n)
    public String[] sortPeopleMap(String[] names, int[] heights) {
        final int numberOfPeople = names.length;

        // Create a TreeMap to store height-name pairs (automatically sorted by height)
        final TreeMap<Integer, String> heightToNameMap = new TreeMap<>();

        // Populate the map with height as key and name as value
        for (int i = 0; i < numberOfPeople; i++) {
            heightToNameMap.put(heights[i], names[i]);
        }

        final String[] sortedNames = new String[numberOfPeople];

        // Index for filling sortedNames array from end to start
        int currentIndex = numberOfPeople - 1;

        // Iterate through the map (sorted by height in ascending order)
        // and fill the sortedNames array from end to start
        for (int height : heightToNameMap.keySet()) {
            sortedNames[currentIndex] = heightToNameMap.get(height);
            currentIndex--;
        }

        return sortedNames;
    }

    //Time O(n^2) and Space O(n)
    public String[] sortPeopleQuickSort(String[] names, int[] heights) {
        quickSort(heights, names, 0, heights.length - 1);
        return names;
    }

    private void swap(int[] heights, String[] names, int index1, int index2) {
        // Swap heights
        int tempHeight = heights[index1];
        heights[index1] = heights[index2];
        heights[index2] = tempHeight;

        // Swap corresponding names
        String tempName = names[index1];
        names[index1] = names[index2];
        names[index2] = tempName;
    }

    private int partition(int[] heights, String[] names, int start, int end) {
        int pivot = heights[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            // If current element is greater than or equal to pivot
            if (heights[j] >= pivot) {
                i++;
                swap(heights, names, i, j);
            }
        }
        // Place the pivot in its correct position
        swap(heights, names, i + 1, end);
        return i + 1;
    }

    private void quickSort(int[] heights, String[] names, int start, int end) {
        if (start < end) {
            // Find the partition index
            int partitionIndex = partition(heights, names, start, end);

            // Recursively sort the left and right sub-arrays
            quickSort(heights, names, start, partitionIndex - 1);
            quickSort(heights, names, partitionIndex + 1, end);
        }
    }

    //Time O(nlogn) and Space O(n)
    public String[] sortPeopleMergeSort(String[] names, int[] heights) {
        mergeSort(names, heights, 0, heights.length - 1);
        return names;
    }

    private void mergeSort(String[] names, int[] heights, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(names, heights, start, mid);
            mergeSort(names, heights, mid + 1, end);
            merge(names, heights, start, mid, end);
        }
    }

    private void merge(
            String[] names,
            int[] heights,
            int start,
            int mid,
            int end
    ) {
        int leftSize = mid - start + 1;
        int rightSize = end - mid;

        // Create temporary arrays
        int[] leftHeights = new int[leftSize];
        int[] rightHeights = new int[rightSize];
        String[] leftNames = new String[leftSize];
        String[] rightNames = new String[rightSize];

        // Copy data to temporary arrays
        for (int i = 0; i < leftSize; i++) {
            leftHeights[i] = heights[start + i];
            leftNames[i] = names[start + i];
        }
        for (int j = 0; j < rightSize; j++) {
            rightHeights[j] = heights[mid + 1 + j];
            rightNames[j] = names[mid + 1 + j];
        }

        // Merge the temporary arrays
        int leftIndex = 0, rightIndex = 0;
        int mergeIndex = start;
        while (leftIndex < leftSize && rightIndex < rightSize) {
            if (leftHeights[leftIndex] >= rightHeights[rightIndex]) { // Descending order
                heights[mergeIndex] = leftHeights[leftIndex];
                names[mergeIndex] = leftNames[leftIndex];
                leftIndex++;
            } else {
                heights[mergeIndex] = rightHeights[rightIndex];
                names[mergeIndex] = rightNames[rightIndex];
                rightIndex++;
            }
            mergeIndex++;
        }

        // Copy remaining elements of leftHeights[], if any
        while (leftIndex < leftSize) {
            heights[mergeIndex] = leftHeights[leftIndex];
            names[mergeIndex] = leftNames[leftIndex];
            leftIndex++;
            mergeIndex++;
        }

        // Copy remaining elements of rightHeights[], if any
        while (rightIndex < rightSize) {
            heights[mergeIndex] = rightHeights[rightIndex];
            names[mergeIndex] = rightNames[rightIndex];
            rightIndex++;
            mergeIndex++;
        }
    }
}
