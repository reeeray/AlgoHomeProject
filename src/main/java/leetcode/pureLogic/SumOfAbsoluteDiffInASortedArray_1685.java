package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 25.11.2023
 **/
public class SumOfAbsoluteDiffInASortedArray_1685 {

    public static void main(String[] args) {

    }

    public int[] getSumAbsoleteDifference(final int[] nums) {
        final int[] answer = new int[nums.length];
        answer[0] = nums[0];
        for(int i=1; i<nums.length; i++) {
            answer[i] = answer[i-1] + nums[i];
        }

        //calculation :
//        int leftSum = prefix[i] - nums[i];
//        int rightSum = prefix[n - 1] - prefix[i];
//
//        int leftCount = i;
//        int rightCount = n - 1 - i;
//
//        int leftTotal = leftCount * nums[i] - leftSum;
//        int rightTotal = rightSum - rightCount * nums[i];
//
//        ans[i] = leftTotal + rightTotal;
        for(int i=0; i<nums.length; i++) {
            answer[i] = Math.abs(answer[i] - (i + 1)*nums[i]) + Math.abs(answer[nums.length - 1] - answer[i] - (nums.length - i - 1)*nums[i]);
        }
        return answer;
    }

    public int[] getSumAbsoluteDifferencesPreficSumOnTheFly(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - nums[i];

            int leftCount = i;
            int rightCount = n - 1 - i;

            int leftTotal = leftCount * nums[i] - leftSum;
            int rightTotal = rightSum - rightCount * nums[i];

            ans[i] = leftTotal + rightTotal;
            leftSum += nums[i];
        }

        return ans;
    }
}
