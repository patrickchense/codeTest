package fieldvalidator;

public class LengthRule implements Rule<Length>{
    @Override
    public void check(Length checkLength, String fieldName, Object target) {
        int length = length(target);
        if (length < checkLength.min() || length > checkLength.max()) {
            throw new IllegalStateException("Invalid string: "
                    + fieldName + ", " + target
                    + " Min length: " + checkLength.min()
                    + " Max length: " + checkLength.max()
                    + " Actual: " + length
            );
        }
    }

    @Override
    public Class<Length> getAnnotationClass() {
        return Length.class;
    }

    private int length(Object target) {
        return target == null ? 0 : target.toString().length();
    }
}
