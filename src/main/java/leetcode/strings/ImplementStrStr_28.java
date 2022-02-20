package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 07.02.2022
 **/
public class ImplementStrStr_28 {

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));

    }

    private static int strStr(final String haystack, final String needle) {
        if (!haystack.contains(needle)) {
            return -1;
        }
        if (haystack.equals(needle) || needle.equals(""))
            return 0;
        int index = 0;
        final char[] haystackChars = haystack.toCharArray();
        final char[] needleChars = needle.toCharArray();

        while (index != haystackChars.length) {
            if (haystackChars[index] == needleChars[0]) {
                int matchIndex = index;
                boolean flag = true;
                for (int i = 0; i < needleChars.length; i++, matchIndex++) {
                    if (haystackChars[matchIndex] != needleChars[i]) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    return index;
            }
            index++;
        }
        return -1;
    }

    public int strStrFast(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();
        if (nLen == 0) {
            return 0;
        }
        if (hLen < nLen) {
            return -1;
        }
        int i = 0;
        while (i < hLen) {
            int k = 0;
            boolean flag = true;
            int nextIndex = -1;
            if (i + nLen - 1 < hLen && haystack.charAt(i) == needle.charAt(0) && haystack.charAt(i + nLen - 1) == needle.charAt(nLen - 1)) {
                while (k < needle.length()
                        && i < hLen
                        && haystack.charAt(i) == needle.charAt(k)) {
                    if (flag && k != 0 && haystack.charAt(i) == needle.charAt(0)) {
                        nextIndex = i;
                        flag = false;
                    }
                    i++;
                    k++;
                }
                if (k >= needle.length()) {
                    return i - k;
                }
                if (nextIndex != -1) {
                    i = nextIndex;
                }
            } else {
                i++;
            }
        }
        return -1;
    }

}
