package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 06.10.2024
 **/
public class SentenceSimilarity3_1813 {

    public static void main(String[] args) {
//        final String str1 = "You'll get what you worth";
//        final String str2 = "You'll get what you worth";
        final String str1 = "A B C D B B";
        final String str2 = "A B B";
        areSentencesSimilar(str1, str2);
    }

    public static boolean areSentencesSimilar(final String sentence1, final String sentence2) {
        if(sentence1.equals(sentence2)) {
            return true;
        }
        final String[] largest = sentence1.length() > sentence2.length() ? sentence1.split(" ") : sentence2.split(" ");
        final String[] smallest = sentence1.length() > sentence2.length() ? sentence2.split(" ") : sentence1.split(" ");
        int frontIndex = -1;
        for(int i=0; i<largest.length; i++) {
            if(frontIndex + 1 == smallest.length) {
                return true;
            }
            if(!largest[i].equals(smallest[frontIndex + 1])) {
                break;
            }
            frontIndex++;
        }
        int backIndex = smallest.length;
        for(int i=largest.length - 1; i >= 0; i--) {
            if(backIndex == 0 ) {
                return true;
            }
            if(!largest[i].equals(smallest[backIndex - 1])) {
                break;
            }
            backIndex--;
        }
        return backIndex - frontIndex <= 1;
    }

    public boolean areSentencesSimilarOpt(final String sent1, final String sent2) {
        String first = sent1;
        String sec = sent2;
        if(first.length()==sec.length()){
            return first.equals(sec);
        }
        if(sent2.length()<first.length()){
            first = sent2;
            sec = sent1;
        }
        int i = -1;
        while(i+1<first.length() && first.charAt(i+1)==sec.charAt(i+1)){
            i++;
        }
        int j = first.length();
        int last = sec.length();
        while(j-1>=0 && first.charAt(j-1)==sec.charAt(last-1)){
            j--;
            last--;
        }

        if(i==first.length()-1 && sec.charAt(i+1)==' '){
            return true;
        }
        if(j==0 && sec.charAt(last-1)==' '){
            return true;
        }
        if(i+1>=j && sec.charAt(i)==' ' && sec.charAt(last)==' '){
            return true;
        }

        return false;
    }
}
