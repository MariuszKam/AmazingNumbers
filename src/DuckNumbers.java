class DuckNumbers extends BuzzNumber    {

    public DuckNumbers(long number) {
        super(number);
    }

    protected void isDuck() {
        String numberString = Long.toString(number).substring(1);
        if (numberString.contains("0")) {
            System.out.println("duck: true");
        } else {
            System.out.println("duck: false");
        }


    }


}
