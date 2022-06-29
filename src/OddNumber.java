public class OddNumber implements CanCalculate {

    @Override
    public boolean isCompatible(long number) {
        return number % 2 == 1;
    }

    @Override
    public String getCompatibility(long number) {
        if (isCompatible(number)) {
            return "odd";
        }
        return null;
    }
}
