class BuzzNumber extends EvenOddNumber {


    public BuzzNumber(long number) {
        super(number);
    }

    protected void isBuzzNumber() {
        if (isBuzz()) {
            System.out.println("buzz: true");
        } else {
            System.out.println("buzz: false");
        }
    }

    private long getLastDigit() {
        return number % 10;
    }

    private boolean isEndsBy7() {
        return getLastDigit() == 7;
    }

    private boolean isDividedBy7(){
        return number % 7 == 0;

    }

    private boolean isBuzz() {
        return isEndsBy7() || isDividedBy7();
    }

}
