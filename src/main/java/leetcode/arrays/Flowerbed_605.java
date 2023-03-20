package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 20.03.2023
 **/
public class Flowerbed_605 {

    public static void main(String[] args) {
    canPlaceFlowers(new int[]{0, 1, 0, 1, 0, 1, 0, 0}, 1);
    }

    public static boolean canPlaceFlowers(final int[] flowerbed, final int n) {
        int possible = 0;
        int i =0;
        while (i < flowerbed.length){
            if(flowerbed[i] == 1) {
                i+=2;
                continue;
            }
            if( (i == 0 || flowerbed[i-1] == 0) && (i == flowerbed.length -1 || flowerbed[i+1] == 0)) {
                flowerbed[i] = 1;
                possible++;
                i+=2;
                continue;
            }
            i++;
        }
        return n <= possible;
    }
}
