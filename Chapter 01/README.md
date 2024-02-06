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

### Compiling to Another Directory

By default, the javac command places the compiled classes in the same directory as the source code but also provides an option to place the class files into a different directory.

The `-d` option specifies this target directory.

Java options are case-sensitive. This means we cannot pass -D instead of -d.

So, the command with the -d option would would look like this:

```bash
javac -d classes packagea/ClassA.java packageb/ClassB.java
```

The new packages structure after compilation:

- packagea
  - ClassA.java
- packageb
  - ClassB.java
- classes
  - packagea
    - ClassA.class
  - packageb
    - ClassB.class

To run the program, we need to specify the classpath, so Java knows where to find the classes.

There are three options to do the same thing:

```bash
java -cp classes packageb.ClassB
java -classpath classes packageb.ClassB
java --class-path classes packageb.ClassB

# all the options should print "Got it"
```

Important javac options:

Option | Description
------ | -----------
-cp \<classpath> | Location of classes needed to compile the program
-classpath \<classpath>
--class-path \<classpath>
-d \<directory> | Directory in which to place generated class files

There are many other options available, and in the Modules chapter, we will learn these additional options.

### Compiling with JAR Files

This technique is useful when the class files are located elsewhere or in special JAR files. A Java Archive (JAR) file is like a ZIP file of mainly Java class files.

```bash
java -cp ".:/tmp/someOtherLocation:/tmp/myJar.jar" myPackage.MyClass
```

The period (.) indicates that we want to include the `current directory` in the classpath. The rest of the command says to look for loose class files or packages in `someOtherLocation` and within `myJar.jar`.

Just like when we're compiling, it's possible to use wildcards (*) to match all the JARs in a directory.

```bash
java -cp "/tmp/directoryWithJars/*" myPackage.MyClass
```

This command will add to the classpath all the JARs that are in the `directoryWithJars`. It won't include any JARs in the classpath that are in a subdirectory.

### Creating a JAR File

By using the jar command, the simplest commands create a jar containing the files in the current directory.

We can use the short or long form for each option.

```bash
jar -cvf myNewFile.jar .
jar --create --verbose --file myNewFile.jar .

# We can also specify a directory instead of using the current directory.
jar -cvf myNewFile.jar -C dir .

# There is no long form of the -C option
```

Option | Description
------ | -----------
-c | Create a new JAR file
--create
-v | Prints details when working with JAR files
--verbose
-f | JAR filename
--filename
-C \<directory> | Directory containing files to be used to create the JAR

### Ordering Elements in a Class

Correct order to type them into a file.

Comments can go anywhere in the code. Beyond that, we need to memorize the following rules:

Element | Example | Required? | Where does it go?
--------| ------- | --------- | -----------------
Package declaration | package abc; | No | First line in the file (excluding comments or blank lines)
Import statements | import java.util.* | No | Immediately after the package (if present)
Top-level type declaration | public class C | Yes | Immediately after the import (if any)
Field declarations | int value; | No | Any top-level element within a class
Method declarations | void method() | No | Any top-level element within a class

Example:

```java
package structure; // package must be first non-comment

import java.util.*; // import must come after package

public class Meerkat { // then comes the class
  double weight; // fields and methods can go in either order

  public double getWeight() {
    return weight;
  }
}
```

## Creating Objects

Remember that an object is an instance of a class.

In the following sections, we'll look at constructors, object fields, instance initializers, and the order in which values are initialized.

### Calling Constructors

To create an instance of a class, all we have to do is write `new` before the class name and add parentheses after it, for example:

```java
Park p = new Park();
```

First, we declare the type that we'll be creating, that is `Park`, and give the variable a name `p`. This gives Java a place to store a reference to the object. Then we write `new Park()` to create the object.

Park() looks like a method since it is followed by parentheses. It's called a `constructor` which is a special type of method that creates a new object.

Defining a constructor:

```java
public class Chick {
  public Chick() {
    System.out.println("in constructor");
  }
}
```

There are two key points to note:

- the name of the constructor matches the name of the class
- there's no return type

```java
public class Chick {
  public void Chick() {} // not a constructor
}
```

The purpose of a constructor is to initialize fields, although we can put any code in there.

Another way to initialize fields is to do so directly, for example, showing both approaches:

```java
public class Chick {
  int numEggs = 12;
  String name;

  public Chick() {
    name = "Duke";
  }
}
```

For most classes, we don't have to code a constructor, the compiler will supply a `"do nothing" default constructor` for us, but there are some scenarios that require us to define a constructor.

### Reading and Writing Member Fields

It's possible to read and write instance variables directly from the caller, for example:

```java
public class Swan {
  int numberEggs; // instance variable

  public static void main(String[] args) {
    Swan mother = new Swan();
    mother.numberEggs = 1; // set variable
    System.out.println(mother.numberEggs); // read variable
  }
}
```

We can even read values of already initialized fields, for example:

```java
public class Name {
  String first = "Theodore";
  String last = "Moose";
  Strinf full = first + last;
}
```

### Executing Instance Initializer Blocks

A code between braces (`{}`) is called a `code block`.

Sometimes code blocks are inside a method, and these are run when the method is called.

Other times, code blocks appear outside a method, and these are called `instance initializers`.

How many instance initializers are in this example?

```java
public class Bird { // class definition
  public static void main(String[] args) { // method instance
    { System.out.println("Feathers"); } // inner block
  }
  { System.out.println("Snowy"); } // instance initializer
}
```

There are four code blocks; a class definition, a method instance, an inner block and an instance initializer.

When we're counting instance initializers, keep in mind that they cannot exist inside of a method.

### Following the Order of Initialization

When writing code that initializes fields in multiple places, we have to keep track of the order of initialization. This is simply the order in which different methods, constructors or blocks are called when an instance is created.

- Fields and instance initializers blocks are run in the order in which they appear in the file
- The constructor runs after all fields and instance initializer blocks have run

[Look at this example](./OrderOfInitialization.java)

Running this example prints this:

```bash
java OrderOfInitialization.java

# setting field
# setting constructor
# Abel
```

Let's check another order of initialization example, what will the code print out?

```java
public class AnotherOrderOfInitialization {
  public AnotherOrderOfInitialization() {
    number = 5;
  }

  public static void main(String[] args) {
    AnotherOrderOfInitialization another = new AnotherOrderOfInitialization();
    System.out.println(another.number);
  }

  private int number = 3;
  { number = 4; }
}
```

The correct answer is 5.

Fields and blocks are run first in the order, setting the number to 3 and then 4. Then the constructor runs, setting the number to 5.

## Understanding Data Types

Java applications contain two types of data: primitive types and reference types.

### Using Primitive Types

Java has eight built-in data types, referred to as the Java primitive types. These data types represent the building blocks for Java objects because all Java objects are just a complex collection of these primitive data types.

They aren't an object nor does it represent an object.

A primitive is just a single value in memory, such as a number or character.

#### The Primitive Types

Primitive types together with their size in bits and the range of values that each holds.

Keyword | Type | Min value | Max value | Default value | Example
--------|------|-----------|-----------|---------------|--------
boolean | true or false | n/a | n/a | false | true
byte | 8-bit integral value | -128 | 127 | 0 | 123
short | 16-bit integral value | -32,768 | 32,767 | 0 | 123
int | 32-bit integral value | -2,147,483,648 | 2,147,483,647 | 0 | 123
long | 64-bit integral value | -2<sup>63</sup> | 2<sup>63</sup> - 1 | 0L | 123L
float | 32-bit floating-point value | n/a | n/a | 0.0f | 123.45f
double | 64-bit floating-point value | n/a | n/a | 0.0 | 123.456
char | 16-bit Unicode value | 0 | 65,535 | \u0000 | 'a'

Some key points:

- The byte, short, int and long types are used for integer values without decimal points
- Each numeric type uses twice as many bits as the smaller similar type. For example, short uses twict as many bits as byte does
- All of the numeric types are signed and reserve one of their bits to cover a negative range. For example, instead of the byte covering 0 to 255, covers -128 to 127
- A float requires the letter f or F following the number so Java knows it is a float, without an f or F, Java interprets a decimal value as a double
- A long requires the letter l or L following the number so Java knows it is a long, without an l or L, Java interprets a number without a decimal point as an int

#### Signed and Unsigned: short and char

Short and char are closely related, as both are stored as integral types with the same 16-bit length.

The primary difference is that `short is signed`, which means it splits its range across the positive and negative integers.

Alternatively, `char is unsigned`, which means its range is strictly positive, including 0.

Often, short and char values can be cast one to another because the underlying data size is the same.

#### Writing Literals

When a number is present in the code, it's called a `literal`. By default, Java assumes you are defining an int value with a numeric literal.

In the following example, the number listed is bigger than what fits in an int.

```java
long max = 3123456789; // DOES NOT COMPILE
```

Java complains the number is out of range, and it is, for an int.

However, we don't have an int. The solution is to add the character L to the number:

```java
long max = 3123456789L;
```

Use the uppercase L, the lowercase l looks like the number 1.

Another way to specify numbers is to change the "base", and there are some number systems that Java allows us to specify:

- Decimal (digits 0-9): also called base 10 since there are 10 possible values for each digit
- Octal (digits 0-7): which uses the number 0 as a prefix, for example, 017
- Hexadecimal (digits 0-9 and letters A-F/a-f): which uses 0x or 0X as a prefix, for example, 0xFF, 0xff. Hexadecimal is case insensitive, so all of these examples mean the same value.
- Binary (0-1 digits): which uses the number 0 followed by b or B as a prefix, for example, 0b10, 0B10

#### Literals and the Underscore Character

We can have underscores in numbers to make them easier to read:

```java
int million1 = 1000000;
int million2 = 1_000_000;
```

It's possible to add underscores anywhere except at the beginning of a literal, the end of a literal, right before a decimal point, or right after a decimal point.

We can even place multiple underscore characters next to each other, although it's not recommended.

### Using Reference Types

A reference type refers to an object (an instance of a class).

Unlike primitive types that hold their values in the memory where the variable is allocated, references do not hold the value of the object they refer to.

Instead, a reference, "points" to an object by storing the memory address where the object is located, a concept referred to as a `pointer`.

Look at this example, that declares and initializes reference types. Suppose we declare a reference of type String:

```java
String greeting;
```

The greeting variable is a reference that can only point to a String object. A value is assigned to a reference in one of two ways:

- A reference can be assigned to another object of the same or compatible type
- A reference can be assigned to a new object using the new keyword

For example, the following statement assigns this reference to a new object:

```java
greeting = new String("How are you?");
```

The greeting reference points to a new String object, "How are you?".

The String object does not have a name and can be accessed only via a corresponding reference.
