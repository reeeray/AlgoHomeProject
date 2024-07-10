package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 10.07.2024
 **/
public class CrawlerLogFolder_1598 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(1)
    public int minOperations(String[] logs) {
        int depthLevel = 0;
        for(String log : logs) {
            depthLevel += log.charAt(1) == '.' ? depthLevel == 0 ? 0 : -1 : log.charAt(0) == '.' ? 0 : 1;
        }
        return depthLevel;
    }
}
