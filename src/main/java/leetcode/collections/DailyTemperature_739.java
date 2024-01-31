package leetcode.collections;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 31.01.2024
 **/
public class DailyTemperature_739 {

    public static void main(String[] args) {
        final int[] input = new int[] {73,74,75,71,69,72,76,73};
        dailyTemperatures(input);
    }

    public static int[] dailyTemperatures(final int[] temperatures) {
        final int[] answ = new int[temperatures.length];
        for(int i=temperatures.length-1; i>=0; i--) {
            int k = i + 1;
             while (k < temperatures.length){
                if (temperatures[i] < temperatures[k]) {
                    answ[i] = k - i;
                    break;
                } else if (answ[k] != 0){
                    k = k + answ[k];
                } else {
                    break;
                }
            }
        }
        return answ;
    }
}
