import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;

import com.justsystems.springboot.sample.validator.constraints.ZipCode;


public class ZipCodeTest {

	public static class TestTarget {
		public TestTarget(String zipCode) {
			this.zipCode = zipCode;
		}

		@ZipCode
		public String zipCode;
	}

	@Test
	public void testZipCodeValidator() {
		TestTarget testTarget = new TestTarget("001-1111");
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<TestTarget>> validate = validator.validate(testTarget);

		assertEquals(0, validate.size());
		testTarget = new TestTarget("00z-1111");
		validate = validator.validate(testTarget);
		assertEquals(1, validate.size());

		for (ConstraintViolation<TestTarget> constraintViolation : validate) {
			assertEquals("The format of the zipcode is invalid.", constraintViolation.getMessage());
		}
	}

}
