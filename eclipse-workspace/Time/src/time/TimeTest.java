package time;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {
	 
	
	
	@Test
	void testGetTotalMillisecondsGood() {
		int miliseconds = 
		Time.getTotalMilliSeconds("05:05:05:005");
		assertTrue("The mili-seconds were not calculated properly" , miliseconds==18305005);
	}
	@Disabled
	@Test
	void testGetTotalSecondsGood() {
		int seconds = 
		Time.getTotalSeconds("05:05:05");
		assertTrue("The seconds were not calculated properly" , seconds==18305);
	}
	@Disabled
	@Test
	public void testGetTotalSecondsBad()
	{
		assertThrows(
		StringIndexOutOfBoundsException.class, ()-> {Time.getTotalSeconds("10:00");});
	}
	 
	@Disabled
	@Test
	public void testGetTotalSecondsBoundry()
	{
		int seconds = Time.getTotalSeconds("05:59:59");
		assertTrue ("The boundry was not calculated properly", seconds==21599);
	}

	@Disabled
	@Test
	void testGetTotalMinutesGood() {
		int minutes = 
		Time.getTotalMinutes("05:05:00");
		assertTrue("The seconds were not calculated properly" , minutes==5);
	}
	
	@Disabled
	@Test
	public void testGetTotalMinutesBad()
	{
		assertThrows(
		StringIndexOutOfBoundsException.class, ()-> {Time.getTotalMinutes("58");});
	}
	@Disabled
	@Test
	public void testGetTotalMinutesBoundry()
	{
		int minutes = Time.getTotalMinutes("05:59:00");
		assertTrue ("The boundary was not calculated properly", minutes==59);
	}


	@Disabled
	@ParameterizedTest
	@ValueSource (strings = {"05:00:00", "05:15:15", "05:59:59"})
	void testGetTotalHours(String candidate) {
		int hours = Time.getTotalHours(candidate);
		assertTrue ("The hours were not proper", hours==5);
	}

}
