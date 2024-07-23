package leetcode.arrays;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 23.07.2024
 **/
public class SortArrayByIncreasingFrequency_1636 {

    public static void main(String[] args) {

    }

    public static int[] frequencySort(final int[] nums) {
        final Map<Integer, Integer> count = new HashMap<>();
        for(int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        final TreeMap<Integer, List<Integer>> sorted = new TreeMap<>();
        for(final Map.Entry<Integer, Integer> entry : count.entrySet()) {
            sorted.computeIfAbsent(entry.getValue(), b -> new ArrayList<>());
            sorted.get(entry.getValue()).add(entry.getKey());
        }

        int index = 0;
        for(final Map.Entry<Integer, List<Integer>> entry : sorted.entrySet()) {
            final List<Integer> desc = entry.getValue();
            Collections.sort(desc, Collections.reverseOrder());
            for(final int val : desc) {
                for(int i=0; i<entry.getKey(); i++) {
                    nums[index++] = val;
                }
            }
        }
        return nums;
    }

    //Time O(nlogn) and Time O(n)
    public int[] frequencySortCustomizedSort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Java's Arrays.sort method doesn't directly support
        // sorting primitive arrays (int[]) with a lambda comparator.
        // We can convert the primitive int into Integer objects
        // to get around this limitation.
        final Integer[] numsObj = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsObj[i] = nums[i];
        }
        Arrays.sort(numsObj, (a, b) -> {
            if (freq.get(a).equals(freq.get(b))) {
                return Integer.compare(b, a);
            }
            return Integer.compare(freq.get(a), freq.get(b));
        });

        // Convert numsObj back to a primitive array to match
        // return type.
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numsObj[i];
        }

        return nums;
    }

    public int[] frequencySortOpt(int[] nums) {
        final int[] f = new int[201];
        int maxFreq = 0;
        for (int num : nums) {
            maxFreq = Math.max(++f[num + 100], maxFreq);
        }

        final List<Integer>[] buckets = new List[maxFreq + 1];

        for (int i = 1; i <= maxFreq; i++)
            buckets[i] = new ArrayList<>();

        for (int i = 200; i >= 0; i--) {
            if (f[i] > 0)
                buckets[f[i]].add(i - 100);
        }

        int[] result = new int[nums.length];

        for (int i = 1, idx = 0, n = buckets.length; i < n; i++) {
            for (int x : buckets[i]) {
                for (int j = 0; j < i; j++) {
                    result[idx++] = x;
                }
            }
        }

        return result;
    }

    public int[] frequencySortQuickSort(int[] nums) {
        int[] count=new int[202];
        for(int i=0;i<nums.length;i++){
            count[nums[i]+100]++;
        }
        quickSort(nums,count,0,nums.length-1);
        return nums;
    }
    void quickSort(int[] nums,int freq[],int low,int high){
        if(low<high){
            int pivot=partition(nums,freq,low,high);
            quickSort(nums,freq,low,pivot-1);
            quickSort(nums,freq,pivot+1,high);
        }
    }
    int partition(int[] nums,int freq[],int low,int high){
        int pivot=freq[nums[high]+100];
        int i=low-1;
        for(int j=low;j<high;j++){
            if(pivot > freq[nums[j]+100]){
                i++;
                int temp=nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
            }else if(freq[nums[j]+100]==pivot){
                if(nums[high]<=nums[j]){
                    i++;
                    int temp=nums[j];
                    nums[j]=nums[i];
                    nums[i]=temp;
                }
            }
        }
        int temp=nums[i+1];
        nums[i+1]=nums[high];
        nums[high]=temp;
        return i+1;
    }
}
