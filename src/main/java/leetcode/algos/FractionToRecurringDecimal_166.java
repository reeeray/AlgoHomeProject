package leetcode.algos;

import java.util.HashMap;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 24.09.2025
 **/
public class FractionToRecurringDecimal_166 {

    public static void main(String[] args) {

    }

    public static String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) {
            return "0";
        }
        final StringBuilder sb = new StringBuilder();
        if(numerator < 0 ^ denominator <  0) {
            sb.append("-");
        }
        long numeratorAbs = Math.abs(Long.valueOf(numerator));
        long denominatorAbs = Math.abs(Long.valueOf(denominator));
        sb.append(numeratorAbs / denominatorAbs);
        if(numeratorAbs % denominatorAbs == 0) {
            return sb.toString();
        }
        sb.append(".");
        long reminder = numeratorAbs % denominatorAbs;
        final Map<Long, Integer> repetitions = new HashMap<>();
        while (reminder != 0) {
            if(repetitions.containsKey(reminder)) {
                sb.insert(repetitions.get(reminder), "(");
                sb.append(")");
                break;
            }
            repetitions.put(reminder, sb.length());
            reminder *= 10;
            sb.append(reminder / denominatorAbs);
            reminder %=  denominatorAbs;
        }
        return sb.toString();
    }
}
