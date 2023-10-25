package leetcode.pureLogic;

import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 25.10.2023
 **/
public class KthSymbolInGrammar_779 {

    public static void main(String[] args) {
        kthGrammar(3, 1);
    }

    //My own algo : O(2n) and Space O(nmax)
    public static int kthGrammar(final int n, final int k) {
        final int[] levels = new int[n+1];
        levels[n] = k;
        for(int i=n-1; i>0; i--) {
            final int prevK = levels[i+1];
            levels[i] = prevK/2 + prevK%2;
        }
        int ans = 0;

        for(int i=2; i<=n; i++) {
            int left, right;
            if(ans == 0) {
                left = 0;
                right = 1;
            } else {
                left = 1;
                right = 0;
            }
            ans = levels[i] % 2 == 0 ? right : left;
        }
        return ans;
    }

    //Binary Tree representation O(1) and O(1)
    private static int dfs(final int n, final int k, final int root) {
        if(n == 1) {
            return root;
        }
        final int total = ((int)Math.pow(2, n-1))/2;
        //right subTree
        if( k > total) {
            final int nextRoot = root == 0 ? 1 : 0;
            return dfs(n-1, k - total, nextRoot);
        } else {
            final int nextRoot = root == 0 ? 0 : 1;
            return dfs(n-1, k, nextRoot);
        }
    }

    //via recursion O(n) and O(n)
    public int kthGrammarRecursion(int n, int k) {
        if(n == 1 && k == 1) return 0;
        int mid = (int)Math.pow(2, n-1) /2;
        if(k <= mid) return kthGrammar(n-1, k);
        else {
            int res = kthGrammar(n-1, k-mid);
            if(res == 0) return 1;
            return 0;
        }
    }
}
