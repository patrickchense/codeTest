package fieldvalidator;

import org.junit.Test;

import java.util.Arrays;

public class TestLengthAnnotation {

    @Test(expected = IllegalStateException.class)
    public void testLengthAnnotationBlock() {
        AnnotationValidator validator = new AnnotationValidator(Arrays.asList(new LengthRule()));

        StringLengthEntity str = new StringLengthEntity();
        str.setFirstString("aaa");

        validator.validate(str);
    }
}
