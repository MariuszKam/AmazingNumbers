public class GapfulNumber  {

    protected static int getDivider(long number) {
        char first = Long.toString(number).charAt(0);
        char last = Long.toString(number).charAt(Long.toString(number).length() - 1);
        String divider = "" + first + last;
        return Integer.parseInt(divider);

    }

    protected static boolean isGapful(long number) {
        if (String.valueOf(number).length() < 3) {
            return false;
        } else return number % getDivider(number) == 0;
    }

    protected static String getGapful(long number) {
        if (isGapful(number)) {
            return "gapful";
        }
        return null;
    }

}
