package leetcode.arrays.binarySearch;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 27.04.2023
 **/
public class BulbSwitcher_319 {

    public static void main(String[] args) {
        assert 2 == bulbSwitch(6);
    }

    private static int bulbSwitch(final int n) {
        long low=0;
        long high=n;
        while(low<=high){
            long mid=low+(high-low)/2;
            if((mid*mid)==n)
                return (int)mid;
            else if((mid*mid)<n)
                low=mid+1;
            else
                high=mid-1;
        }
        return (int)low-1;
    }

    private static int bulbSwitchEff(final int n) {
        return (int)Math.sqrt(n);
    }
}
