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

#### Reassign Pattern Variables

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

#### Pattern Variables and Expressions

Pattern matching includes expressions that can be used to filter data out, such as in the following example:

```java
void printIntegerGreaterThan5(Number number) {
  if (number instanceof Integer data && data.compareTo(5) > 0) {
    System.out.println(data);
  }
}
```

Notice that we're using the pattern variable in an expression in the same line in which it is declared.

#### Subtypes

The type of the pattern variable must be a subtype of the variable on the left side of the expression.

It also cannot be the same type.

This rule does not exist for traditional instanceof operator expressions.

```java
Integer value = 123;

if (value instanceof Integer) {}

if (value instanceof Integer data) {} // DOES NOT COMPILE
```

`The pattern variable should be a strict subtype of Integer.`

#### Flow Scoping

The compiler applies flow scoping when working with pattern matching.

Flow scoping means the variable is only in scope when the compiler can definitively determine its type.

Flow scoping is unlike any other type of scoping in that it is not strictly hierarchical like instance, class or local scoping.

```java
void printIntegerTwice(Number number) {
  if (number instanceof Integer data) {
    System.out.println(data.intValue());
  }

  System.out.println(data.intValue()); // DOES NOT COMPILE
}
```

## Applying switch Statements

What if we have a lot of possible branches or paths for a single value?

For example, print a different message based on the day of the week.

We could combine seven if or else statements, but that tends to create code that is long, difficult to read and hard to maintain.

### The switch Statement

A switch statement is a complex decision-making structure in which a single value is evaluated and flow is redirected to the first matching branch, knows as a `case` statement.

If no such case statement is found that matches the value, an optional `default` statement will be called if provided.

If no such default option is available, the entire switch will be skipped.

#### The structure of a switch statement

```java
switch (variableToTest) {
  case constantExpresion:
    // branch for case
    break;
  case constantExpression2, constantExpression3:
    // branch for case2 and case3
    break;
  default:
    // branch for default
}
```

1. switch keyword
2. Parentheses (required)
3. case scenarios
4. Optional break
5. Optional default as fallback

Going back to our example and using switch to print the days of week.

```java
void printDayOfWeek(int day) {
  switch (day) {
    case 0:
      System.out.println("Sunday");
      break;
    case 1:
      System.out.println("Monday");
      break;
    case 2:
      System.out.println("Tuesday");
      break;
    case 3:
      System.out.println("Wednesday");
      break;
    case 4:
      System.out.println("Thursday");
      break;
    case 5:
      System.out.println("Friday");
      break;
    case 6:
      System.out.println("Saturday");
      break;
    default:
      System.out.println("Invalid value");
  }
}
```

#### Exiting with break Statements

A break statement terminates the switch statement and returns flow control to the enclosing process.

`It ends the switch statement immediately.`

The break statements are optional, but without them the code will execute every branch following a matching case statement, including any default statement it finds.

#### Selecting switch Data Types

The following is a list of all data types supported by switch statements:

- int and Integer
- byte and Byte
- short and Short
- char and Character
- String
- enum values
- var (if the type resolves to one of the preceding types)

The types `boolean`, `long`, `float` and `double` are excluded as are their associated `Boolean`, `Long`, `Float` and `Double` classes.

The reasons are varied, such as `boolean having too small range of values` and `floating-point numbers having quite a wide range of values`.

#### Determining Acceptable Case Values

Not just any variable or value can be used in a case statement.

First, the values in each case statement must be compile-time constant values of the same data type as the switch value. This means you can use only literals, enum constants or final constant variables of the same data type.

We can't have a case statement value that requires executing a method at runtime, for example:

```java
int getCookie() {
  return 4;
}

void feedAnimals() {
  final int bananas = 1;
  int apples = 2;
  int numberOfAnimals = 3;
  final int cookies = getCookies();

  switch (numberOfAnimals) {
    case bananas:
    case apples: // DOES NOT COMPILE
    case getCookie(): // DOES NOT COMPILE
    case cookies: // DOES NOT COMPILE
    case 3 * 5:
  }
}
```

1. The bananas variable is marked final and its value is knows at compile-time, so it is valid
2. The apples variable is not marked final, even though its value is knows, so it is not permitted
3. The values getCookies() and cookies do not compile because methods are not evaluated until runtime, so they cannot be used as the value of a case statement
4. The value 3 * 5 does compile as expressions are allowed as case values, provided the value can be resolved at compile-time

#### The switch Expression

Out implementation of `printDayOfWeek` is quite long. That there was a lot of boilerplate code with numerous break statements.

There is a new switch expression added to Java 14 that is more compact.

The switch expression supports two types of branches, expression and a block.

#### The structure of a switch expression

```java
int result = switch (variableToTest) {
  case constantExpression -> 5;
  case constantExpression2, constantExpression3 -> {
    yield 10;
  }
  default -> 20;
}
```

1. The assignment to the variable result is optional
2. switch keyword
3. Parentheses (required)
4. case expressions followed by the arrow operator (required)
5. yield required for case block if switch returns a value
6. default branch is required if all possible case statement values are not handled

Rewriting the previous `printDayOfWeek`:

```java
void printDayOfWeek(int day) {
  var result = switch (day) {
    case 0 -> "Sunday";
    case 1 -> "Monday";
    case 2 -> "Tuesday";
    case 3 -> "Wednesday";
    case 4 -> "Thursday";
    case 5 -> "Friday";
    case 6 -> "Saturday";
    default -> "Invalid value";
  };

  System.out.println(result);
}
```

There are some new rules:

1. All the branches of a switch expression that do not throw an exception must return a consistent data type (if the switch expression returns a value)
2. If the switch expression return a value, then every branch that is not an expression must yield a value
3. A default branch is required unless all cases are covered or no value is returned

### Examples covering these rules

#### Returning Consistent Data Types

You can't return incompatible or random data types. [ReturningConsistentDataTypes.java](./ReturningConsistentDataTypes.java)

#### Applying a case Block

A switch expression supports both an expression and a block. It also includes a yield statement if the switch expression returns a value. [ApplyingCaseBlock.java](./ApplyingCaseBlock.java)

#### Covering All Possible Values

A switch expression that returns a value must handle all possible input values.

```java
int canis = 4;
String type = switch (canis) { // DOES NOT COMPILE
  case 1 -> "dog";
  case 2 -> "wolf";
  case 3 -> "coyote";
};
```

There's no case branch to cover 4, 5, etc...

But there are two ways to address this:

- Add a default branch
- If the switch expression takes an enum value, add a case branch for every possible enum value

For example: [CoveringAllPossibleValues.java](./CoveringAllPossibleValues.java)

Since all possible permutations of Season are covered, a default branch is not required.

## Writing while Loops

A common practice when writing software is doing the same task some number of times.

A loop is a repetitive control structure that can execute a statement of code multiple times in succession.

The following loop executes exactly 10 times:

```java
int counter = 0;

while (counter < 10) {
  double price = counter * 10;
  System.out.println(price);
  counter++;
}
```

### The while Statement

The simplest repetitive control structure in java is the while statement.

Like all repetition control structures, it has a termination condition, implemented as a boolean expression, that will continue as long the expression evaluates to true.

#### The structure of a while statement

```java
while (booleanExpression) {
  // body
}
```

1. while keyword
2. Parentheses (required)

A while loop is similar to an if statement in that it is composed of a boolean expression and a block of statements.

During execution, the boolean expression is evaluated before each iteration of the loop and exits if the evaluation return false.

```java
int roomInBelly = 5;

void eatCheese(int bitesOfCheese) {
  while (bitesOfCheese > 0 && roomInBelly > 0) {
    bitesOfCheese--;
    roomInBelly--;
  }

  System.out.println(bitesOfCheese + " pieces of cheese left");
}
```

This method takes an amount of cheese and continues until has no room in belly.

### The do/while Statement

Another form to do loops is called do/while loop.

#### The structure of a do/while

```java
do {
  // body
} while (booleanExpression);
```

1. do keyword
2. while keyword followed by a boolean expression
3. Parentheses (required)
4. Semicolon (required)

Unlike a while loop, a `do/while loop guarantees that the block will be executed at least once`.

```java
int lizard = 0;

do {
  lizard++;
} while (false);

System.out.println(lizard); // 1
```

The block will be executed and then check the loop condition.

### Infinite Loops

The most important thing when using any repetition control structure is to `make sure they always terminate`.

`Failure to terminate a loop can lead to numerous problems, including overflow exception, memory leaks, slow performance and even bad data.`

For example:

```java
int pen = 2;
int pigs = 5;

while (pen < 10) {
  pigs++;
}
```

The problem with this while statement is that it will never end since the variable pen is never modified and will always evaluate to true.

`This is referred to as infinite loop because the termination condition is never reached.`

So make sure that the loop condition, or the variables the condition is dependent, are changing between executions. Then ensure that the termination condition will be eventually reached in all circumstances.

A loop can also exit under other conditions, such as a break statement.

## Constructing for Loops

There are two types of for loops, although both use the same for keyword.

The first is referred to as the `basic` for loop, and the second is often called the `enhanced` for loop.

### The for Loop

A basic for loop ha the same conditional boolean expression and block of statements, as the while loops.

#### The structure of a basic for loop

```java
for (initialization; booleanExpression; updateStatement) {
  // body
}
```

1. Initialization statement executes
2. If booleanExpression is true, continue, else exit loop
3. Body executes
4. Execute updateStatement
5. Return to Step 2

The organization of the components and flow allow us to create extremely powerful statements in a single line that otherwise would take multiple lines with a while loop.

Each of the three sections is separated by a semicolon `;`.

Variables declared in the initialization block of a for loop have limited scope and are accessible only within the for loop.

```java
for (int i = 0; i < 10; i++) {
  System.out.println("Value is " + i);
}

System.out.println(i); // DOES NOT COMPILE
```

Alternatively, variables declared before the for loop and assigned a value in the initialization block or in the body may be used outside the for loop.

```java
int i;

for (i = 0; i < 10; i++) {
  System.out.println("Value is " + i);
}

System.out.println(i); // 10
```

#### Printing Elements in Reverse

```java
for (var counter = 4; counter >= 0; counter--) {
  System.out.println(counter);
}
```

### Working with for Loops

#### Creating an Infinite Loop:

```java
for (;;) {
  System.out.println("Hello World");
}
```

Although this for loop may look like it does not compile, it will in fact compile and run without issue. It is actually an infinite loop.

Note that the semicolons separating the three sections are required.

#### Adding Multiple Terms to the for Statement

```java
int x = 0;

for (long y = 0, z = 4; x < 5 && y < 10; x++, y++) {
  System.out.println(y);
}

System.out.println(x);
```

This code demonstrates three variations of the for loop.

1. It is possible to declare a variable, such as x, before the loop begins
2. The initialization block, boolean expression and update statements can include extra variables that may or may not reference each other, such as z, that is defined in the initialization block and is never used
3. The update statement can modify multiple variables

#### Redeclaring a Variable in the Initialization Block

```java
int x = 0;

for (int x = 4; x < 5; x++) { // DOES NOT COMPILE
  System.out.println(x);
}
```

This example looks similar to the previous, but it does not compile because of the initialization block.

The difference is that x is repeated in the initialization block after already being declared before the loop.

#### Using Incompatible Data Type in the Initialization Block

```java
int x = 0;

for (long y = 0; int z = 4; x < 5; x++) { // DOES NOT COMPILE
  System.out.println(y);
}
```

This code will not compile. The variables in the initialization block must all be of the same type.

#### Modifying Loop Variables

```java
for (int i = 0; i < 10; i++) {
  i++;
}
```

As a general rule is considered a bad practice to modify loop variables due to the unpredictability of the result.

It also tends to make code difficult for other people to follow.

### The for-each Loop

The for-each loop is a specialized structure design to iterate over arrays and various Collections Framework classes.

#### The structure of an enhanced for-each loop

```java
for (datatype instance : collection) {
  // body
}
```

1. for keyword
2. instance is the object to be iterated
3. collection is the array that will be traversed

The `right side` of the for-each loop must be:

- A built-in Java array
- An object whose type implements `java.lang.Iterable`. In other words, the right side must be an array or collection of items, such as a List or a Set.

The `left side` of the for-each loop must include a declaration for an instance of a variable whose type is compatible with the type of the array or collection on the right side. On each iteration of the loop, the named variable on the left side is assigned a new value from the array or collection.

#### for vs. for-each

```java
// for

public void printNames(String[] names) {
  for (int counter = 0; counter < names.length; counter++) {
    System.out.println(names[counter]);
  }
}
```

```java
// for-each

public void printNames(String[] names) {
  for (var name : names) {
    System.out.println(name);
  }
}
```

The for-each loop is a lot shorter.

We no longer have a counter loop variable that we need to create, increment and monitor.

## Controlling Flow with Branching