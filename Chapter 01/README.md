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

Is similar to a multiline comment, except it starts with /**. Javadoc comments have a specific structure that the tool knows how to read.

```java
/**
 * @Javadoc multiple-line comment
 * @author Gabriel
 */
```

## Classes and Source Files

Most of the time, each Java class is defined in its .java file.

In this chapter, the only top-level type is a class.

A top-level type is a data structure that can be defined independently within a source file and it is often public.

It is possible to put two types in the same file but at most one of the top-level types in the file is allowed to be public, and the public should match the filename. [Example](./Person.java).

## Writing a main() Method

A Java program begins execution with its main() method, it is the starting point that the JVM looks for when it begins running a new program.

### Creating a main() Method

The main() method lets the JVM call our code.

[This code](./Main.java) prints "Hello, world!".

To compile and execute:

```bash
javac Main.java
java Main

# Hello, world!
```

To compile Java code with the javac command, the file must have the extension .java.

The result is a file bytecode with the same name but with a .class filename extension. That bytecode consists of instructions that the JVM knows how to execute.

### Passing Parameters to a Java Program

The new main class [MainWithArgs.java](./MainWithArgs.java) is printing the first two arguments passed in.

To run passing parameters, execute:

```bash
javac MainWithArgs.java
java MainWithArgs "Hello guys" Hi

# Hello guys
# Hi
```

### Single-File Source-Code

There is a shortcut instead of running the `javac and java` commands, it is possible to run:

```bash
java MainWithArgs.java "Hello guys" Hi
```

There is a key difference, the .java extension. This feature is called launching single-file source-code programs and is designed for when our program is one file.

## Understanding Package Declarations and Imports

Java comes with thousands of built-in classes, and Java needs a way to organize them.

We can't just use some classes and try to compile, like:

[NumberPicker without Import](./NumberPicker.java)

Java compiler will throw an error saying that we are probably missing a required import statement for the Random class.

A statement is an instruction, and import statements tell Java which packages to look in for classes.

Trying this again with the import allows the code to compile:

[NumberPicker with Import](./NumberPickerWithImport.java)

### Packages

The import statement tells the compiler which package to look in to find a class.

If it begins with java, this means it came with the JDK.

If it starts with something else, it likely shows where it came from using the website name in reverse. For example, `com.wiley.javabook` tells us the code is associated with `wiley.com`.

We'll see package names that don't follow this convention too.

### Wildcards

Classes in the same package are often imported together. We can use a shortcut to import all the classes in a package.

[WildcardClass.java](./WildcardClass.java)

In this example, we imported `java.util.Random` and a pile of other classes.

The `*` is a wildcard that matches all classes in the package. The import statement doesn't bring in child packages, fields, or methods; it imports only classes directly under the package.


```java
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
```

Only the last import allows the class to be recognized because child packages are not included with the first two.

Including many classes doesn't slow down our program execution. The compiler figures out what's needed.

### Redundant Imports

We've been using `System` without import, and that's because there's one special package in Java called `java.lang` which is automatically imported.

So import anything of `java.lang` inside our program is redundant. For example:

```java
import java.lang.System;
import java.lang.*;
```

Or:

```java
import java.util.Random;
import java.util.*;
```

### Naming Conflicts

One of the reasons for using packages is so that class names don't have to be unique across all of Java. This means we'll sometimes want to import a class that can be found in multiple places, such as the Date class.

Java provides implementations of `java.util.Date` and `java.sql.Date`.

When the class name is found in multiple packages and we try to import all with wildcards, Java gives us a compiler error.

```java
import java.util.*;
import java.sql.*; // causes Date declaration to not compile
```

So we need to import the more specific class we want.

```java
import java.util.Date;
import java.sql.*;
```

If we explicitly import a class name, it takes precedence over any wildcards present.

What does Java do with "ties" for precedence?

```java
import java.util.Date;
import java.sql.Date;
```

The compiler will tell us the imports are ambiguous.

If we need to use two classes with the same name, we also can do something like:

```java
public class Conflicts {
  java.util.Date date;
  java.sql.Date sqlDate;
}
```

### Creating a New Package

All the code written in this chapter has been in the default package.

This is a special unnamed package that we should use only for throwaway codes.

The directory structure on our computer is related to the package name.

Such as [packagea class](./packagea/ClassA.java) and [packageb class](./packageb/ClassB.java)

When we run a Java program, Java knows where to look for those package names. In this case, running from /root works because both packagea and packageb are underneath it.

### Compiling and Running Code with Packages

```bash
# Compiling file by file
javac packagea/ClassA.java packageb/ClassB.java

# Compiling using Wildcards
javac packagea/*.java packageb/*.java

# Running
java packageb.ClassB
```

If it works, will print "Got it".

Packages structure after compilation:

- packagea
  - ClassA.java
  - ClassA.class
- packageb
  - ClassB.java
  - ClassB.class
