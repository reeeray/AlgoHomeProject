package leetcode.bruteforce;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 29.07.2024
 **/
public class CountNumberOfTeams_1395 {

    public static void main(String[] args) {
        numTeams(new int[] {2, 5, 3, 4, 1});
    }

    public static int numTeams(final int[] rating) {
        int count = 0;

        for(int i=0; i<rating.length-2; i++) {
            for(int j=i+1; j<rating.length-1; j++) {
                for(int k=j+1; k<rating.length; k++) {
                    if(rating[i] < rating[j] && rating[j] < rating[k]) {
                        count++;
                    } else if(rating[i] > rating[j] && rating[j] > rating[k]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    //Time O(n^2) and Space O(1)
    public static int numTeamsOpt(final int[] rating) {
        int count = 0;
        for(int mid=1; mid<rating.length-1; mid++) {
            int leftSmaller = 0;
            int rightGreater = 0;

            for(int l=0; l<mid; l++) {
                if(rating[l] < rating[mid]) {
                    leftSmaller++;
                }
            }
            for(int r=mid+1; r<rating.length; r++) {
                if(rating[mid] < rating[r]) {
                    rightGreater++;
                }
            }
            count += leftSmaller*rightGreater;
            count += (mid - leftSmaller) * (rating.length - rightGreater - mid + 1);
        }
        return count;
    }
}
