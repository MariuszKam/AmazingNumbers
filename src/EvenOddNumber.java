class EvenOddNumber {

    protected static boolean isEvenNumber(long number) {
        return number % 2 == 0;
    }

    protected static boolean isOddNumber(long number) {
        return !(number % 2 == 0);
    }

    protected static String getEvenOdd(long number) {
        if (isEvenNumber(number)) {
            return "even";
        } else {
            return "odd";
        }
    }
}