package kata5;

import java.util.Arrays;
import java.util.regex.Pattern;
import org.springframework.util.StringUtils;

/**
 * Date: 2017-11-28
 * Author: Patryk Kozak @pakz
 */
public class SpringCalculator {

  public int add(String nums) {

    if (nums.isEmpty()) {
      return 0;
    }

    String[] ns = nums.split(",|\n");
    int sum = 0;

    if (ns[0].startsWith("//")) {
      ns = splitByDelimiter(ns);
    }

    return addAllNumbers(ns);
  }

  private int addAllNumbers(String[] ns) {
    StringBuilder sbException = new StringBuilder();
    int sum = 0;

    for (String n : ns) {
      int nNumber = Integer.parseInt(n);

      if (nNumber < 0) {
        sbException.append(nNumber);
        sbException.append(" ");
      }

      if (nNumber >= 1000) {
        continue;
      }
      sum += Integer.parseInt(n);
    }

    String exceptionStrings = sbException.toString();

    if (exceptionStrings.length() != 0) {
      throw new NegativesAreNotAllowedException("negatives are not allowed: " + exceptionStrings);
    }

    return sum;
  }

  private String[] splitByDelimiter(String[] data) {
    String delimeter = data[0].substring(2);

    if (StringUtils.countOccurrencesOf(delimeter, "[") > 1) {
      StringBuilder delimsSb = new StringBuilder();
      for (int i = 0; i < delimeter.length(); i++) {
        char charString = delimeter.charAt(i);
        delimsSb.append("\\");
        delimsSb.append(charString);
        if (charString == ']') {
          delimsSb.append("|");
        }
      }
      delimeter = delimsSb.toString().substring(0, delimsSb.toString().length() - 1);
    } else {
      delimeter = Pattern.quote(delimeter);
    }

    String onlyNums = Arrays.toString(Arrays.copyOfRange(data, 1, data.length));
    return onlyNums.substring(1, onlyNums.length() - 1).split(delimeter);
  }

}