class DuckNumbers implements CanCalculate {

    @Override
    public boolean isCompatible(long number) {
        String numberString = Long.toString(number).substring(1);
        return numberString.contains("0");
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
        return "duck";
    }
}
