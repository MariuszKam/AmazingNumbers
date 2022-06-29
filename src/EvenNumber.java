class EvenNumber implements CanCalculate {

    @Override
    public boolean isCompatible(long number) {
        return number % 2 == 0;
    }

    @Override
    public String getCompatibility(long number) {
        if(isCompatible(number)) {
            return "even";
        }
        return null;
    }
}