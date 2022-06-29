public class SpyNumber implements CanCalculate{
    @Override
    public boolean isCompatible(long number) {
        long sum = 0;
        long product = 1;
        long remainingNumber = number;
        for (int i = 0; i < String.valueOf(number).length(); i++) {
            long lastDigit = remainingNumber % 10;
            sum += lastDigit;
            product *= lastDigit;
            remainingNumber = remainingNumber / 10;
        }
        return sum == product;
    }

    @Override
    public String getCompatibility(long number) {
        if(isCompatible(number)) {
            return getName();
        }
        return null;
    }

    @Override
    public String getName() {
        return "spy";
    }
}
