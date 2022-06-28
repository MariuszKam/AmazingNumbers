class PalindromicNumber {

    protected static boolean isPalindromicNumber(long number) {
        String numberString = Long.toString(number);
        for (int i = 0; i < (numberString.length() / 2) + 1; i++) {

            if (numberString.charAt(i) != numberString.charAt(numberString.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    protected static String getPalindromicNumber(long number) {
        if (isPalindromicNumber(number)) {
            return "palindromic";
        }
        return null;
    }
}
