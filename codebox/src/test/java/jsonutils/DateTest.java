package jsonutils;

import org.junit.Test;

import java.time.LocalDate;
import java.time.OffsetDateTime;

public class DateTest {

	@Test
	public void testMillisAtMidnight() {
		long ts = LocalDate.now().atStartOfDay().toInstant(OffsetDateTime.now().getOffset()).toEpochMilli();
		System.out.println(ts);
	}
}
