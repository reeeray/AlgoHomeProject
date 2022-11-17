package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 17.11.2022
 **/
public class RectangleArea_223 {


    public static void main(String[] args) {
        assert 16 == computeArea(-2, -2, 2, 2, 3, 3, 4, 4);
    }

    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        final int s1 = Math.abs(ay2 - ay1) * Math.abs(ax2 - ax1);
        final int s2 = Math.abs(by2 - by1) * Math.abs(bx2 - bx1);
        int intersectionA = 0;
        int intersectionB = 0;
        for(int i=ax1; i<=ax2; i++) {
            if(i>= bx1 && i <= bx2)
                intersectionA++;
        }

        for(int j=ay1; j<=ay2; j++) {
            if(j>= by1 && j <= by2)
                intersectionB++;
        }
        final int intersected = intersectionA != 0 && intersectionB != 0 ? (intersectionA-1)*(intersectionB-1) : 0;

        return s1 + s2 - intersected;
    }

    public static int computeAreaImproved(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int areaOfA = (ay2 - ay1) * (ax2 - ax1);
        int areaOfB = (by2 - by1) * (bx2 - bx1);

        // calculate x overlap
        int left = Math.max(ax1, bx1);
        int right = Math.min(ax2, bx2);
        int xOverlap = right - left;

        // calculate y overlap
        int top = Math.min(ay2, by2);
        int bottom = Math.max(ay1, by1);
        int yOverlap = top - bottom;

        int areaOfOverlap = 0;
        // if the rectangles overlap each other, then calculate
        // the area of the overlap
        if (xOverlap > 0 && yOverlap > 0) {
            areaOfOverlap = xOverlap * yOverlap;
        }

        // areaOfOverlap is counted twice when in the summation of
        // areaOfA and areaOfB, so we need to subtract it from the
        // total, to get the toal area covered by both the rectangles
        int totalArea = areaOfA + areaOfB - areaOfOverlap;

        return totalArea;
    }
}
