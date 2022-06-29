class PalindromicNumber implements CanCalculate {

    @Override
    public boolean isCompatible(long number) {
        String numberString = Long.toString(number);
        for (int i = 0; i < (numberString.length() / 2) + 1; i++) {

            if (numberString.charAt(i) != numberString.charAt(numberString.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getCompatibility(long number) {
        if (isCompatible(number)) {
            return "palindromic";
        }
        return null;
    }
}
