package leetcode.dfs;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 07.05.2026
 **/
public class JumpGameIX_3660 {

    public static void main(String[] args) {
        maxValue(new int[] {2, 1, 3});
    }

    //Divide and Conqure approach : Time O(n) and Space O(n)
    public int[] maxValueOpt(int[] nums) {
        final int n = nums.length;
        final int[] res = new int[n];
        final Item[] prevMax = new Item[n];

        Item prev = new Item(Integer.MIN_VALUE, -1);
        for (int i = 0; i < n; i++) {
            if (nums[i] > prev.value()) {
                prev = new Item(nums[i], i);
            }
            prevMax[i] = prev;
        }

        process(n - 1, Integer.MAX_VALUE, 0, prevMax, res, nums);
        return res;
    }

    private void process(final int rightMaxIndex,final int rightMin, final int rightMaxValue, final Item[] prevMax,
            final int[] res, final int[] nums) {
        final int prevMaxVal = prevMax[rightMaxIndex].value();
        final int pivotIndex = prevMax[rightMaxIndex].index();
        final int currMax = prevMaxVal <= rightMin ? prevMaxVal : rightMaxValue;
        int nextRightMin = Math.min(prevMaxVal, rightMin);

        for (int i = pivotIndex; i <= rightMaxIndex; i++) {
            res[i] = currMax;
            nextRightMin = Math.min(nextRightMin, nums[i]);
        }

        if (pivotIndex == 0) {
            return;
        }

        process(pivotIndex - 1, nextRightMin, currMax, prevMax, res, nums);
    }

    private static class Item {
        private final int value;
        private final int index;
        public Item(final int value, final int index) {
            this.value = value;
            this.index = index;
        }

        public int value() {return this.value;}
        public int index(){return this.index;}
    }

    public static int[] maxValue(final int[] nums) {
        final boolean[] visited = new boolean[nums.length];
        final int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                dfs(nums, visited, res, i, -1);
            }
        }
        return res;
    }

    private static int dfs(final int[] nums, final boolean[] visited, final int[] res, final int index, final int maxVal) {
        if(visited[index]) return res[index];

        visited[index] = true;
        final int currMax = Math.max(maxVal, nums[index]);
        int rightMax = - 1;
        for(int i = index + 1; i < nums.length; i++) {
            if(nums[i] < nums[index])
                rightMax = Math.max(rightMax, dfs(nums, visited, res, i, currMax));
        }
        int leftMax = - 1;
        for(int i = 0; i < index; i++) {
            if(nums[i] > nums[index])
                leftMax = Math.max(leftMax, dfs(nums, visited, res, i, currMax));
        }
        final int max = Math.max(leftMax, rightMax);
        res[index] = Math.max(currMax, max);
        return res[index];
    }
}
