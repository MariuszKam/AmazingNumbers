class DuckNumbers {

    protected static boolean isDuck(long number) {
        String numberString = Long.toString(number).substring(1);
        return numberString.contains("0");
    }

    protected static String getDuck(long number) {
        if (isDuck(number)) {
            return "duck";
        }
        return null;
    }


}
