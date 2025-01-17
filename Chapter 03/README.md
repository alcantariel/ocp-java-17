# Chapter 03 - Making Decisions

OCP Exam objectives covered in this chapter:

- Controlling Program Flow
  - Create program flow control constructs including if/else, switch statement and expressions, loops, and break and continue statements
- Utilizing Java Object-Oriented Approach
  - Implement polymorphism and differentiate object type versus reference type. Perform type casting, identify object types using instanceof operator and pattern matching

## Creating Decision-Making Statements

Java operators allow us to create a lot of complex expressions, but they're limited in the manner in which they can control program flow.

In this section, we discuss decision-making statements including if/else, along with the new pattern matching feature.

### Statements and Blocks

A Java statement is a complete unit of execution, terminated with a semicolon `;`.

Control flow statements break up the flow of execution by using decision-making, looping and branching, allowing the application to selectively execute particular segments of code.

A `block of code` in Java is a group of zero or more statements between braces `{}`.

For example:

#### Single statement

```java
patrons++;
```

#### Statement inside a block

```java
{
  patrons++;
}
```

A statement or block often serves as the target of a decision-making statement.

#### if statement to these two examples (Single statement)

```java
if (ticketsTaken > 1)
  patrons++;
```

#### if statement to these two examples (Statement inside a block)

```java
if (ticketsTaken > 1) {
  patrons++;
}
```

Both of these snippets are equivalent.

`Using blocks is often preferred, even if the block has only one statement.`

### The if Statement

The if statement allow us to execute a block if and only if a boolean expression evaluates to true at runtime.

#### The structure of an if statement

```java
if (booleanExpression) {

}
```

1. if keyword
2. Parentheses (required)
3. Curly braces required for block of multiple statements, optional for single statement

Imagine had a function that used the hour of day, an integer value from 0 to 23 to display a message to the user:

```java
if (hourOfDay < 11) {
  System.out.println("Good morning");
}
```

If the hour of the day is less than 11, then the message will be displayed.

### The else Statement

What if we want to display a different message if it is 11 a.m. or later?

```java
if (hourOfDay < 11) {
  System.out.println("Good morning");
}

if (hourOfDay >= 11) {
  System.out.println("Good afternoon");
}
```

This seems a bit redundant, though since we're performing an evaluation on hourOfDay twice.

In this case we can use the else statement.

#### The structure of an else statement

```java
if (booleanExpression) {
  // branch if true
} else {
  // branch if false
}
```

1. if keyword
2. Parentheses (required)
3. Optional else statement

And returning to the previous example:

```java
if (hourOfDay < 11) {
  System.out.println("Good morning");
} else {
  System.out.println("Good afternoon");
}
```

Now the code is branching between one of the two possible options with the boolean evaluation happening only once.

The else operator also takes a statement or block of statements, in the same manner as the if statement, for example:

```java
if (hourOfDay < 11) {
  System.out.println("Good morning");
} else if (hourOfDay < 15) {
  System.out.println("Good afternoon");
} else {
  System.out.println("Good evening");
}
```

In this example, Java process will continue execution until it encounters an if statement that evaluates to true, if neither of the first two expressions is true, it will execute the final code of the else block.

### Shortening Code with Pattern Matching

Java 16 introduced pattern matching with if statements and the instanceof operator.

Pattern matching is a technique of controlling program flow that only executes a section of code that meets certain criteria.

It is used in conjunction with if statements for greater program control.

Pattern matching is a new tool at your disposal to reduce boilerplate in our code.

To understand why this tool was added, consider the following code:

```java
void compareIntegers(Number number) {
  if (number instanceof Integer) {
    Integer data = (Integer) number;
    System.out.println(data.compareTo(5));
  }
}
```

The cast is needed since the `compareTo()` method is defined on Integer but not on Number.

Code that first checks if a variable is of a particular type and then immediately casts it to that type is extremely common. So the authors of Java decided to implement a shorter syntax for it:

```java
void compareIntegers(Number number) {
  if (number instanceof Integer data) {
    System.out.println(data.compareTo(5));
  }
}
```

The variable `data` in this example is referred to as the `pattern variable`.

Notice that this code also avoids any potential ClassCastException.

### Reassign Pattern Variables

While possible, it is a bad practice to reassign a pattern variable since doing so can lead to ambiguity about what is and is not in scope.

```java
if (number instanceof Integer data) {
  data = 10;
}
```

The reassignment can be prevented with a final modifier.

```java
if (number instanceof final Integer data) {
  data = 10; // DOES NOT COMPILE
}
```

### Pattern Variables and Expressions

Pattern matching includes expressions that can be used to filter data out, such as in the following example:

```java
void printIntegerGreaterThan5(Number number) {
  if (number instanceof Integer data && data.compareTo(5) > 0) {
    System.out.println(data);
  }
}
```

Notice that we're using the pattern variable in an expression in the same line in which it is declared.