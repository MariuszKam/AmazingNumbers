class PalindromicNumber extends DuckNumbers {

    public PalindromicNumber(long number) {
        super(number);
    }
    protected void isPalindromicNumber() {
        if(isPali()) {
            System.out.println("palindromic: true");
        } else {
            System.out.println("palindromic: false");
        }
    }
    protected boolean isPali() {
        String numberString = Long.toString(number);
        for (int i = 0; i < (numberString.length() / 2) + 1; i++) {

            if (numberString.charAt(i) != numberString.charAt(numberString.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
