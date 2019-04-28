# SimpleArgumentParser
Parses your arguments from commandline in a simple way. Parse it and get it, no complex configuration, properties or setup before use.


# How to use it
## Initial
Create an instance of the parser simple by calling the constructor;
```
ArgsParser parser = new ArgsParser();
```

## Add arguments
Adding arguments by calling the *addArguments(String argument)* method and passing the argument name. 
It is possible to create an argument with 1 or more characters. The parser is currently supporting only the "-" symbol as a prefix.
```
parser.addArguments("f");
parser.addArguments("-f");
parser.addArguments("-file");
```

## Parsing arguments
Parse your arguments by passing the String-array to the *parse(String[] args)* method.
```
parser.parse( arguments );
```

## Check for arguments
```
parser.hasArgument("f");
parser.hasArgument("-f");
parser.hasArgument("-file");
```
Notice: You dont need to pass the prefix to find your argument. Its optional.

## Getting values
The *getValue(String argument)* method will return the *ArgumentValue* interface, which provides several methods to get
your value out of it.
```
ArgumentValue value = parser.getValue("f");
value.get()         //return value as Object
value.getAsString() //return value as String
value.getAsInt()    //return value as int
(...)
```
