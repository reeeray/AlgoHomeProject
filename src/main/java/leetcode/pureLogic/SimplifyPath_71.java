package leetcode.pureLogic;


import java.util.Arrays;
import java.util.Stack;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 12.04.2023
 **/
public class SimplifyPath_71 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString("/sdgsdf/..//sdfs/./".split("/")));
        System.out.println("---:" + "/sdgsdf/..//sdfs/./".split("/")[0]);
        System.out.println("---:" + "/sdgsdf/..//sdfs/./".split("/")[1]);
        System.out.println("---:" + "/sdgsdf/..//sdfs/./".split("/")[2]);
        System.out.println("---:" + "/sdgsdf/..//sdfs/./".split("/")[3]);
        System.out.println("---:" + "/sdgsdf/..//sdfs/./".split("/")[4]);
        simplifyPath("/a/./b/../../c/");
    }

    private static String simplifyPath(final String path) {
        final Stack<String> hierarchy = new Stack();
        for(final String reg : path.split("/")) {
            if(reg.isEmpty() || reg.equals(".")) continue;
            if(reg.equals("..")) {
                if(!hierarchy.isEmpty())
                    hierarchy.pop();
                continue;
            }
            hierarchy.add(reg);
        }
        String res = "/";
        for(final String str : hierarchy) {
            res += str + "/";
        }
        return res.length() == 1 ? res : res.substring(0, res.length()-1);
    }
}
