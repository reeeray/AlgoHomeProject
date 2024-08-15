package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 15.08.2024
 **/
public class LemondeChange_860 {

    public static void main(String[] args) {
        final int[] input = new int[] {5, 5, 5, 5, 20, 20, 5, 5, 20, 5};
        lemonadeChange(input);
        assert Boolean.FALSE == lemonadeChange(input);
    }

    //Space O(1) and Time O(n)
    public static boolean lemonadeChange(final int[] bills) {
        int fiveBill = 0;
        int tenBill = 0;
        for(final int bill : bills) {
            if(bill == 5) {
                fiveBill++;
            } else if(bill == 10) {
                if(fiveBill < 1) {
                    return false;
                }
                tenBill++;
                fiveBill--;
            } else {
                if(fiveBill > 0 && tenBill > 1) {
                    fiveBill--;
                    tenBill--;
                } else if (fiveBill >= 3) {
                    fiveBill -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
