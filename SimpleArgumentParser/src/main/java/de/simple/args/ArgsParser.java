package de.simple.args;

import static de.simple.args.ArgsParserProperties.ARGUMENT_PREFIX;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class ArgsParser {

	private List<String> argsList;
	private Set<String> exceptedArguments;
	private Map<String, ArgumentValue> parsedArguments;
	
	public ArgsParser() {
		argsList = new ArrayList<>();
		exceptedArguments = new HashSet<>();
		parsedArguments = new HashMap<>();
	}
	
	public void addArguments(String argument) {
		argument = checkArgumentFormat(argument);
		exceptedArguments.add(argument);
	}
	
	private String checkArgumentFormat(String argument) {
		if(argument.startsWith(ARGUMENT_PREFIX))
			return argument;
		else
			return ARGUMENT_PREFIX + argument;
	}

	public void parse(String[] args) {
		argsList = Arrays.asList(args);
		parseArguments();
	}
	
	private void parseArguments() {
		for(String exceptedArg : exceptedArguments) {
			if(exceptedArg.startsWith(ARGUMENT_PREFIX) == false || argsList.contains(exceptedArg) == false)
				continue;
			
			String parsedArgument = exceptedArg;
			ArgumentValue parsedValue = parseValue( parsedArgument );
			parsedArguments.put(parsedArgument, parsedValue);
		}
	}
	
	private ArgumentValue parseValue(String argument) {
		ListIterator<String> iterator = argsList.listIterator( argsList.indexOf(argument) + 1 );
		ArgumentValue value = new Value();
		value.set(iterator);
		return value;
	}
	
	public boolean hasArgument(String argument) {
		argument = checkArgumentFormat(argument);
		return parsedArguments.containsKey(argument);
	}
	
	public ArgumentValue getValue(String argument) {
		argument = checkArgumentFormat(argument);
		ArgumentValue value = parsedArguments.get(argument);
		return value;
	}
}


























