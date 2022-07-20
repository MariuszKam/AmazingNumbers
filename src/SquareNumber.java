public class SquareNumber implements CanCalculate{
    @Override
    public boolean isCompatible(long number) {
        return Math.sqrt(number) % 1 == 0;
    }

    @Override
    public String getCompatibility(long number) {
        if (isCompatible(number)) {
            return getName();
        }
        return null;
    }

    @Override
    public String getName() {
        return "square";
    }
}
