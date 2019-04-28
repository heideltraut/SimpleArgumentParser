package de.simple.args;

import java.util.ListIterator;

public interface ArgumentValue {
	public void set(ListIterator<String> iterator);
	public Object get();
	public String getAsString();
	public int 	  getAsInt();
	public Double getAsDouble();
}
