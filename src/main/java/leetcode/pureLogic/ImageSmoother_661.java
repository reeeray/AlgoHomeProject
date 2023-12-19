package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 19.12.2023
 **/
public class ImageSmoother_661 {

    public static void main(String[] args) {

    }

    //Space complexity O(m*n) and Time complexity O(m*n)
    public int[][] imageSmoother(final int[][] img) {
        final int m = img.length;
        final int n = img[0].length;
        final int[] dir = new int[] {-1, 0, 1};
        final int[][] smoother = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j =0; j<n; j++) {
                int sum = 0;
                int count = 0;
                for(int k = 0; k<3; k++) {
                    final int newm = i + dir[k];
                    if(newm < 0 || newm >= m) {
                        continue;
                    }
                    for(int l =0; l<3; l++) {
                        final int newn = j + dir[l];
                        if(newn < 0 || newn >= n) {
                            continue;
                        }
                        sum += img[newm][newn];
                        count++;
                    }
                }
                smoother[i][j] = sum / count;
            }
        }



        return smoother;
    }

    public int[][] imageSmootherConstSpace(int[][] img) {
        // Save the dimensions of the image.
        int m = img.length;
        int n = img[0].length;

        // Iterate over the cells of the image.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Initialize the sum and count
                int sum = 0;
                int count = 0;

                // Iterate over all plausible nine indices.
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        // If the indices form valid neighbor
                        if (0 <= x && x < m && 0 <= y && y < n) {
                            // Extract the original value of img[x][y].
                            sum += img[x][y] % 256;
                            count += 1;
                        }
                    }
                }

                // Encode the smoothed value in img[i][j].
                img[i][j] += (sum / count) * 256;
            }
        }

        // Extract the smoothed value from encoded img[i][j].
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                img[i][j] /= 256;
            }
        }

        // Return the smooth image.
        return img;
    }
}
