
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class TimeConventionTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}
	
	@Test
	public void testTransformStringToInt1() {	
		TimeConversion converter = new TimeConversion();
		converter.printTime24h("03:12:42AM");
	    assertEquals(2, converter.transformStringToInt("02"));
	}
	
	@Test
	public void testTransformStringToInt2() {	
		TimeConversion converter = new TimeConversion();
		converter.printTime24h("03:12:42AM");
	    assertEquals(12, converter.transformStringToInt("12"));
	}

	@Test
	public void testTransformIntToString1() {
		TimeConversion converter = new TimeConversion();
	    assertEquals("03", converter.transformIntToString(3));
	}
	
	@Test
	public void testTransformIntToString2() {
		TimeConversion converter = new TimeConversion();
	    assertEquals("13", converter.transformIntToString(13));
	}
	
	@Test
	public void testPrintTime24h(){
		TimeConversion converter = new TimeConversion();
		converter.printTime24h("03:12:42AM");
	    assertEquals("03:12:42", outContent.toString().trim());
	}
}
