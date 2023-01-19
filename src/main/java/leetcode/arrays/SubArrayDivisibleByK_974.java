package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 19.01.2023
 **/
public class SubArrayDivisibleByK_974 {

    public static void main(String[] args) {
        final int[] input = {4, 5, 0, -2, -3, 1};
        assert 7 == subarraysDivByK(input, 5);
        assert 7 ==subarraysDivByKEfficient(input, 5);
    }

    private static int subarraysDivByK(final int[] nums, final int k) {
        int sum = 0;
        int ans = 0;
        for(int i=0; i<nums.length; i++) {
            sum = 0;
            for(int j=i; j<nums.length; j++) {
                sum +=nums[j];
                if(sum % k == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * Efficient implementation via idea that subArray between pair i and j %k == 0 if prefixSum[i]%k == prefixSum[j]%k. And we just counting mods of k
     * @param nums
     * @param k
     * @return
     */
    private static int subarraysDivByKEfficient(final int[] nums, final int k) {
        final int[] modK = new int[k];
        modK[0] = 1;//to include if the whole array %k == 0
        int prefixSum = 0;
        int res = 0;
        for(final int num : nums) {
            prefixSum = (prefixSum + num%k + k)%k; // +k to handle negative cases
            res += modK[prefixSum];
            modK[prefixSum]++;
        }
        return res;
    }
}
