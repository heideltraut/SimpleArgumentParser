package de.simple.args;

import java.util.ListIterator;
import static de.simple.args.ArgsParserProperties.ARGUMENT_PREFIX;

class Value implements ArgumentValue {

	private Object value;
	
	@Override
	public void set(ListIterator<String> iterator) {
		if(iterator.hasNext() && iterator.next().startsWith(ARGUMENT_PREFIX) == false) {
			value = iterator.previous();
		} else {
			value = "";
		}
	}

	@Override
	public Object get() {
		return value;
	}

	@Override
	public String getAsString() {
		return String.valueOf(value);
	}

	@Override
	public int getAsInt() {
		try {
			return Integer.parseInt( getAsString() );
		} catch(NumberFormatException e) {
			throw new ArgumentValueParseException(value, Integer.class.toString());
		}
	}

	@Override
	public Double getAsDouble() {
		try {
			return Double.parseDouble( getAsString() );
		} catch(NumberFormatException e) {
			throw new ArgumentValueParseException(value, Double.class.toString());
		}
	}

}
