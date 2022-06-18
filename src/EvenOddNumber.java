class EvenOddNumber  {
    long number;

    public EvenOddNumber(long number) {
        this.number = number;
    }
    protected void isEvenOddNumber() {
        if (isEven()){
            System.out.println("even: true\nodd: false");
        } else {
            System.out.println("even: false\nodd: true");
        }

    }

    private boolean isEven() {
        return number % 2 == 0;
    }
}
