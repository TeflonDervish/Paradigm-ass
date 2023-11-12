import java.util.Scanner;

public class StringManipulation {


    public static String SortString(String inputString) {
        int starIndex = inputString.indexOf('*');
        int hashtagIndex = inputString.indexOf('#');

        int startIndex = Math.min(starIndex, hashtagIndex);
        int endIndex = Math.max(starIndex, hashtagIndex);

        String substringBetween = inputString.substring(startIndex + 1, endIndex);
        String sortedSubstring = inputString.substring(0, starIndex) + "*" +
                                sortAlphabetically(substringBetween) + "#" +
                                inputString.substring(endIndex + 1, inputString.length() - 1);

        return sortedSubstring;
    }

    private static String sortAlphabetically(String substring) {
        char[] charArray = substring.toCharArray();
        java.util.Arrays.sort(charArray);
        return new String(charArray);
    }
}