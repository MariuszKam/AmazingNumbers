class BuzzNumber implements CanCalculate {

    @Override
    public boolean isCompatible(long number) {
        long lastDigit = number % 10;
        return lastDigit == 7 || number % 7 == 0;
    }

    @Override
    public String getCompatibility(long number) {
        if (isCompatible(number)) {
            return "buzz";
        }
        return null;
    }
}