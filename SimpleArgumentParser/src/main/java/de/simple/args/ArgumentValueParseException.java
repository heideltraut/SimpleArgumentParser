package de.simple.args;

public class ArgumentValueParseException extends RuntimeException {

	public ArgumentValueParseException(Object value, String destFormat) {
		super("Failed to parse value '" + value + "' to " + destFormat + ".");
	}
	
}
