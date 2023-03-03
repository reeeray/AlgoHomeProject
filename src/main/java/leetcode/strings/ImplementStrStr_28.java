package leetcode.strings;

import patterns.creational.factory.Page;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 07.02.2022
 **/
public class ImplementStrStr_28 {

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStrRew("abc", "c"));

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

    public static int strStrFast(String haystack, String needle) {
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

    public static int strStrRew(final String hayStack, final String needle) {
        final int hayL = hayStack.length();
        final int needL = needle.length();

        if(needL == 0 || hayStack.equals(needle)) {
            return 0;
        }
        if(!hayStack.contains(needle)) {
            return -1;
        }

        int index = 0;
        while(index <= hayL-needL) {
            int internalIndex = 0;
            boolean flag = true;
            int nexIndex = -1;
            if(index + needL - 1 < hayL && hayStack.charAt(index) == needle.charAt(0) && hayStack.charAt(index + needL - 1) == needle.charAt(needL - 1)) {
                while(internalIndex < needL && index < hayL && hayStack.charAt(index) == needle.charAt(internalIndex)) {
                    if(flag && internalIndex != 0 && hayStack.charAt(index) == needle.charAt(0)) {
                        flag = false;
                        nexIndex = index;
                    }
                    index++;
                    internalIndex++;
                }
                if(internalIndex >= needL) {
                    return index - needL;
                }
                if(nexIndex != -1) {
                    index = nexIndex;
                }

            } else {
                index++;
            }
        }
        return -1;
    }

    public static int strStrEasyToUnderstand(final String haystack, final String needle) {
        if(needle.isEmpty()) {
            return 0;
        }
        final int h_length = haystack.length();
        final int n_length = needle.length();
        for(int i=0; i<=h_length - n_length; i++) {
            for(int j=0; j<n_length; j++) {
                if(haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
                if(j == n_length-1) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int strStrElegant(final String haystack, final String needle) {
        return haystack.indexOf(needle);
    }

    public static int strStrUsingHash(final String string, final String substring) {
        int n = string.length();
        int m = substring.length();
        if (m > n) {
            return -1;
        }
        int prime = 101;
        int power = 1;
        int substringHash = 0;
        int stringHash = 0;

        // Calculate hash value of substring and first substring of string
        for (int i = 0; i < m; i++) {
            substringHash += substring.charAt(i) * Math.pow(prime, i);
            stringHash += string.charAt(i) * Math.pow(prime, i);
        }

        // Compare hash values and actual substrings
        for (int i = 0; i < n - m + 1; i++) {
            if (substringHash == stringHash && string.substring(i, i + m).equals(substring)) {
                return i;
            }

            // Calculate hash value of next substring of string
            if (i < n - m) {
                stringHash = (stringHash - string.charAt(i)) / prime;
                stringHash += string.charAt(i + m) * Math.pow(prime, m - 1);
            }
        }

        return -1;
    }

}
