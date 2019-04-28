package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.simple.args.ArgsParser;

public class TestCases {

	@Test
	public void testHasArgument() throws Exception {
		String[] fakeArgs = {"-f", "-g"};
		ArgsParser parser = new ArgsParser();
		parser.addArguments("-f");
		parser.addArguments("g");
		
		assertFalse(parser.hasArgument("f"));
		assertFalse(parser.hasArgument("-g"));
		parser.parse(fakeArgs);
		assertTrue(parser.hasArgument("f"));
		assertTrue(parser.hasArgument("-g"));
		assertFalse(parser.hasArgument("x"));
	}
	
	@Test
	public void testHasMultiCharArgument() throws Exception {
		String[] fakeArgs = {"-file", "-debug"};
		ArgsParser parser = new ArgsParser();
		parser.addArguments("-file");
		parser.addArguments("debug");
		
		assertFalse(parser.hasArgument("file"));
		assertFalse(parser.hasArgument("-debug"));
		parser.parse(fakeArgs);
		assertTrue(parser.hasArgument("file"));
		assertTrue(parser.hasArgument("-debug"));
		assertFalse(parser.hasArgument("help"));
	}
	
	@Test
	public void testEmptyValue() throws Exception {
		String[] fakeArgs = {"-a", "some value", "-b"};
		ArgsParser parser = new ArgsParser();
		parser.addArguments("-a");
		parser.addArguments("b");
		parser.parse(fakeArgs);
		
		Object rawValue = parser.getValue("b").get();
		assertEquals(rawValue, "");
	}
	
	@Test
	public void testStringValue() throws Exception {
		String[] fakeArgs = {"-a", "some value", "-b"};
		ArgsParser parser = new ArgsParser();
		parser.addArguments("-a");
		parser.addArguments("b");
		parser.parse(fakeArgs);
		
		String stringValue = parser.getValue("a").getAsString();
		Object rawValue = parser.getValue("a").get();
		assertTrue(stringValue instanceof java.lang.String);
		assertEquals("some value", stringValue);
		assertEquals("some value", rawValue);
	}
	
	@Test
	public void testStringValueWithSpecialCharacters() throws Exception {
		String[] fakeArgs = {"-a", "C:\\someDir\\some folder\\example.exe", "-b"};
		ArgsParser parser = new ArgsParser();
		parser.addArguments("-a");
		parser.parse(fakeArgs);
		
		String stringValue = parser.getValue("a").getAsString();
		assertTrue(stringValue instanceof java.lang.String);
		assertEquals("C:\\someDir\\some folder\\example.exe", stringValue);
	}
	
	@Test
	public void testIntValue() throws Exception {
		String[] fakeArgs = {"-number", "1234"};
		ArgsParser parser = new ArgsParser();
		parser.addArguments("-number");
		parser.parse(fakeArgs);
		
		int intValue = parser.getValue("number").getAsInt();
		assertEquals(1234, intValue);
	}
	
	@Test
	public void testDoubleValue() throws Exception {
		String[] fakeArgs = {"-number", "1234.4321"};
		ArgsParser parser = new ArgsParser();
		parser.addArguments("-number");
		parser.parse(fakeArgs);
		
		Double doubleValue = parser.getValue("number").getAsDouble();
		Double originalValue = 1234.4321;
		assertEquals(originalValue, doubleValue);
	}
	
	
	
	
}
