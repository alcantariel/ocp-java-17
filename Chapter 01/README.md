# Chapter 01 - Building Blocks

OCP exam objectives covered in this chapter:

- Handling date, time, text, numeric and boolean values
  - Use primitives and wrapper classes including Math API, parentheses, type promotion, and casting to evaluate arithmetic and boolean expressions
- Utilizing Java Object-Oriented Approach
  - Declare and instantiate Java objects including nested class objects, and explain the object life-cycle including creation, reassigning references, and garbage collection
  - Understand variable scopes, use local variable type inference, apply encapsulation, and make objects immutable

## Major Components of Java

The Java Development Kit (JDK) contains de minimum software needed to do Java development.

Some key commands:

```bash
# Converts .java source files into .class bytecode
javac 

# Executes the program
java

# Packages files together
jar

# Generates documentation
javadoc
```

The javac command generates this special format called bytecode that the java command can run. Then java launches the Java Virtual Machine (JVM) before running the code. The JVM knows how to run bytecode on the actual machine it is on.

Think JVM as a special magic box on your machine that knows how to run our .class files within your particular operating system and hardware.

Checking Java Version:

```bash
# Both of these command should print installed java version

javac -version
java -version
```

## Understanding the Class Structure

Classes are the basic building blocks. When defining a class, we describe all the parts and characteristics of one of those building blocks. There are other building blocks such as interfaces, records, and enums.

To use most classes, we need to create objects. An object is a runtime instance of a class in memory.

An object is often referred to as an instance since it represents a single representation of the class.

A reference is a variable that points to an object.

All these objects which are instances of classes, together compose our program state.

## Fields and Methods

Java classes have two primary elements:

- Methods: often called functions or procedures in other languages
- Fields: more generally known as variables, properties or attributes

Together these are called the members of a class.

Variables hold the state of the program and methods operate on that state.

### Understanding what is happening in this [Java class](./Animal.java)

- The public keyword allows other classes to use it
- The class keyword indicates we are defining a class
- Animal is the name of the class
- On line 2, is defined a variable called name, where the type is String
- On lines 4 and 8, we are defining methods
  - The public means that may be called from other classes, next comes the return type
  - The return type means that the method returns a String, or void that equals to returns nothing
  - When calling setName, this method requires information, this information is called "parameter"
- The method name and parameter types are called the method signature
  - String getName();
  - setName(String);

## Comments

Comments are not executable code and can be placed in many places.

There are three types of comments in Java.

### Single-line comment

Begins with two slashes and the compiler will ignore anything typed after that on the same line.

```java
// comment until end of line
```

### Multi-line comment

Includes anything starting from the symbol /* until the symbol */.

```java
/* Multiple
 * line
 * comment
 */
```

### Javadoc comment

Is similar to a multiline comment, except it starts with /**. This special syntax tells the Javadoc tool to pay attention to the comment. Javadoc comments have a specific structure that the tool knows how to read.

```java
/**
 * @Javadoc multiple-line comment
 * @author Gabriel
 */
```

## Classes and Source files
