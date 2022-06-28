class BuzzNumber {

    protected static boolean isBuzzNumber(long number) {
        long lastDigit = number % 10;
        return lastDigit == 7 || number % 7 == 0;
    }

    protected static String getBuzzNumber(long number) {
        if (isBuzzNumber(number)) {
            return "buzz";
        }
        return null;
    }

}