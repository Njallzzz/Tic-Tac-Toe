# Javadoc and coding styles:

All functions and variable are declared in *camel-casing* (ex. `baseFunction`)

All classes start in *pascal-casing* (ex. `BaseClass`)

All comments should be constructed with JavaDoc annotations:

```
/*
*
* All comments should be here
*
* Short description of functions purpose / logic
* @param <parameter name> Short description of parameter
* @return type of the return and short description of the object
*/
```

All if/else calls should be encapsulated by brackets {}


Brackets should start at first line of declaration and end in a new line with the same indentation and declaration

```java
if(< conditions >){     
  	< code >
}
else{
	Return 0; 	
}
```

All class specific variables should be private, if they are needed outside of the class, try to use getters/ setters.
