# Chapter 02 - Operators

OCP Exam objectives covered in this chapter:

- Handling date, time, text, numeric and boolean values
  - Use primitives and wrapper classes including Math API, parentheses, type promotion, and casting to evaluate arithmetic and boolean expressions

This chapter introduces operators and shows how we can use them to combine existing variables and create new values.

## Understanding Java Operators

Java `operator` is a special symbol that can be applied to a set of variables, values or literals (referred to as `operands`) and that returns a result.

```java
var c = a + b;

// c -> Result
// a and b -> Operands
// + -> Operator
```

### Types of Operators

Java supports three types of operators: `unary`, `binary` and `ternary`. These types of `operators` can be applied to one, two or three `operands`, respectively.

Operators are not necessarily evaluated from left-to-right order, for example:

```java
int cookies = 4;
double reward = 3 + 2 * --cookies;
System.out.print("Zoo animal receives: " + reward + " reward points")
```

Step by step given this example:
1. The first operation is to decrement cookies, resulting in 3
2. Then the multiplication 3 * 2, resulting in 6
3. Then the addition 6 + 3, resulting in 9
4. Finally the result is automatically promoted from 9 to 9.0 and assigned to the reward

The final values of reward and cookies are 9.0 and 3, respectively, with the following printed:

`Zoo animal receives 9.0 reward points`

### Operator Precedence

In mathematics, certain operators can override other operators and be evaluated first.

Determining which operators are evaluated in what order is referred to as `operator precedence`.

Consider the following expression with some optional parentheses to demonstrate how the compiler evaluates this statement:

```java
var perimeter = ((2 * height) + (2 * length));
```

- The multiplication operator (*) has a higher precedence than the addition operator (+)
- The `height` and `length` are both multiplied by 2 before being added together
- The assignment operator (=) has the lowest order of precedence, so is performed last

### Order of Operator Precedence

Operator | Symbols and examples | Evaluation
--- | --- | ---
Post-unary operators | expression++, expression-- | Left-to-right
Pre-unary operators | ++expression, --expression | Left-to-right
Other unary operators | -, !, ~, + (type) | Right-to-left
Cast | (Type) reference | Right-to-left
Multiplication, division, modulus | *, /, % | Left-to-right
Addition, subtraction | +, - | Left-to-right
Shift operators | <<, >>, >>> | Left-to-right
Relational operators | <, >, <=, >=, instanceof | Left-to-right
Equal to, not equal to | ==, != | Left-to-right
Logical AND | & | Left-to-right
Logical exclusive OR | ^ | Left-to-right
Logical inclusive OR | \| | Left-to-right
Conditional AND | && | Left-to-right
Conditional OR | \|\| | Left-to-right
Ternary operators | boolean expression ? expression1 : expression2 | Right-to-left
Assignment operators | =, +=, -=, /=, %=, &=, ^=, \|=, <<=, >>=, >>>= | Right-to-left
Arrow operator | -> | Right-to-left

## Applying Unary Operators

A unary operator is one that requires exactly one operand or variable.

They often perform simple tasks, such as increasing a numeric variable by one or negating a boolean value.

### Unary Operators

Operator | Examples | Description
--- | --- | ---
Logical complement | !a | Inverts a boolean logical value
Bitwise complement | ~b | Inverts all 0s and 1s in a number
Plus | +c | Indicates a number is positive
Negation or minus | -d | Indicates a literal number is negative or negates an expression
Increment | ++e, f++ | Increments a value by 1
Decrement | --g, h-- | Decrements a value by 1
Cast | (String) i | Casts a value to a specific type

## Complement and Negation Operators

`Logical Complement Operator (!)` flips the value of a boolean expression. [LogicalComplementOperator.java](./LogicalComplementOperator.java)

`Bitwise Complement Operator (~)` which flips all the 0s and 1s in a number. It can only be applied to integer numeric types such as byte, short, char, int and long. [BitwiseComplementOperator.java](./BitwiseComplementOperator.java)

`Negation Operator (-)` reverses the sign of a numeric expression. [NegationOperator.java](./NegationOperator.java)

## Increment and Decrement Operators

Increment and decrement operators, ++ and -- can be applied to numeric variables and have a high order of precedence compared to binary operators.

In other words, they are often applied first in an expression.

The order in which they are attached to their associated variable makes difference in how an expression is processed.

### Increment and Decrement Operators
Operator | Example | Description
--- | --- | ---
Pre-increment | ++w | Increases the value by 1 and returns the new value
Pre-decrement | --x | Decreases the value by 1 and returns the new value
Post-increment | y++ | Increases the value by 1 and returns the original value
Post-decrement | z-- | Decreases the value by 1 and returns the original value

```java
int parkAttendance = 0;

System.out.println(parkAttendance); // 0

System.out.println(++parkAttendance); // 1
System.out.println(parkAttendance); // 1

System.out.println(parkAttendance--); // 1
System.out.println(parkAttendance); // 0
```

## Working with Binary Arithmetic Operators

Binary Operators are the most common operators in the Java language. They can be used to perform mathematical operations on variables, create logical expressions and perform basic variable assignments.

### Arithmetic Operators

Arithmetic operators are those that operate on numeric values.

Operator | Example | Description
--- | --- | ---
Addition | a + b | Adds two numeric values
Subtraction | c - d | Subtracts two numeric values
Multiplication | e * f | Multiplies two numeric values
Division | g / h | Divides one numeric value by another
Modulus | i % j | Returns the remainder after division of one numeric value by another

`Multiplicative operators (*, / and %)` have a `higher` order of precedence than the `additive operators (+ and -)`.

```java
int price = 2 * 5 + 3 * 4 - 8;

// first we evaluate 2 * 5 and 3 * 4, reducing the expression to
int price = 10 + 12 - 8;

// then we evaluate the remaining terms in left-to-right order

// resulting in a value of price of 14
```

### Adding Parentheses

We can change the order of operation explicitly by wrapping parentheses around the sections we want to evaluate first.

Changing the order of operation from the previous example:

```java
int price = 2 * ((5 + 3) * 4 - 8);

// first we evaluate 5 + 3, reducing the expression to
int price = 2 * (8 * 4 - 8);

// and then we multiply 8 * 4, reducing the expression even more
int price = 2 * (32 - 8);

// next we subtract the values within the parentheses before applying the terms outside
int price = 2 * 24;

// finally we multiply 2 * 24

// resulting in a value of 48 for price
```

### Division and Modulus Operators

The modulus operator, sometimes called the `remainder operator`, is the remainder when two numbers are divided.

For example, `9 divided by 3 divides evenly and has no remainder` so, `9 % 3 is 0`.

On the other hand, `11 divided by 3 does not divide evenly` so, `11 % 3 is 2`.

#### Division vs. Modulus:

```java
System.out.println(9 / 3); // 3
System.out.println(9 % 3); // 0

System.out.println(10 / 3); // 3
System.out.println(10 % 3); // 1

System.out.println(11 / 3); // 3
System.out.println(11 % 3); // 2

System.out.println(12 / 3); // 4
System.out.println(12 % 3); // 0
```

For integer values, division results in the floor value of the nearest integer that fulfills the operation, whereas the modulus is the remainder value.

`Floor value` means the value without anything after the decimal point.

For example, the value 4 is the floor value for 4.0, 4.5 and 4.9999.

### Numeric Promotion

As shown in [Chapter 01 - Understanding Data Types](../Chapter%2001/README.md#understanding-data-types), each primitive numeric type has a bit-length.

We don't need to know the exact size but keep in mind which one are bigger than the others.

Java will follow these rules when applying operators to data types:

#### Numeric Promotion Rules

1. If two values have different data types, Java will automatically promote one of the values to the larger of the two data types
2. If one of the values is integral and the other is floating-point, Java will automatically promote the integral value to the floating-point value's data type
3. Smaller data types, such as `byte`, `short` and `char`, are first promoted to int any time they're used with a Java binary arithmetic operator, even if neither of the operands is int
4. After all promotion has occurred and the operands have the same data type, the resulting value will have the same data type as its promoted operands

Examples:

- What is the data type of `x * y`?

  ```java
  int x = 1;
  long y = 33;
  var z = x * y;
  ```

  In this case will follow the first rule. Since one of the values is int and the other is long. Long is larger than int, then the int value x is first promoted to a long. The result z is then a long value.

- What is the data type of `x * y`?

  ```java
  short x = 10;
  short y = 3;
  var z = x * y;
  ```

  In this case will follow the third rule. Both will be promoted to int before the multiplication, resulting in an output of type int.

- What is the data type of `w * x / y`?

  ```java
  short w = 14;
  float x = 13;
  double y = 30;
  var z = w * x / y;
  ```

  In this case the short w will be promoted to int. The promoted w will then be promoted to a float, so it can be multiplied with x. Then will be promoted to a double so that it can be divided by y, resulting in a double value.

## Assigning Values

Compilation errors from assignment operators are often overlooked. To be successful with the assignment operators, we should understand how the compiler handles numeric promotion and when casting is required.

### Assignment Operator

An assignment operator is a binary operator that modifies, or assigns the variable on the left side of the operator with the result on the right side of the equation.

The assignment operator is evaluated from right to left.

The simplest assignment operator is the `=` assignment.

`int herd = 1;`

This statement assigns to the herd variable the value of 1.

#### Simple Assignment Operator

Operator | Example | Description
--- | --- | ---
Assignment | int a = 50; | Assigns the value on the right to the variable on the left

### Casting Values

Casting is a unary operation where one data type is explicitly interpreted as another data type.

Casting is optional and `unnecessary` when converting to a `larger` data type, but is `required` when converting to a `smaller` data type.

Without casting, the compiler will generate an error when trying to put a larger data type inside a smaller one.

For example:

```java
int fur = (int) 5;
int hair = (short) 2;
String type = (String) "Bird";
short tail = (short) (4 + 10);
long feathers = 10 (long); // DOES NOT COMPILE
```

- Spaces between the cast and the value are optional
- Since casting is a unary operation, it would only be applied to the 4 if we didn't enclose 4 + 10 in parentheses
- The last example does not compile because the type is on the wrong side of the value

Examples putting a larger value into a smaller data type:

```java
float egg = 2.0 / 9; // DOES NOT COMPILE
int tadpole = (int) 5 * 2L; // DOES NOT COMPILE
short frog = 3 - 2.0; // DOES NOT COMPILE
```

### Applying Casting

See these examples trying to assign invalid values to the variables:

```java
int fish = 1.0; // DOES NOT COMPILE
short bird = 1921222; // DOES NOT COMPILE
int mammal = 9f; // DOES NOT COMPILE
long reptile = 192_301_398_193_810_323; // DOES NOT COMPILE
```

- The first statement does not compile because we are trying to assign a double 1.0 to an integer variable
- The second statement does not compile because the literal value 1921222 is outside the range of short
- The third statement does not compile because the f added to the end of the number instructs the compiler to treat the number as floating-point value
- The last statement does not compile because Java interprets the literal as an int and notices that the value is larger than int allows and would need a postfix L or l to be considered a long.

It is possible to fix three of these previous examples by casting the results to a smaller data type.

```java
int fish = (int) 1.0;
short bird = (short) 1921222; // stored as 20678
int mammal = (int) 9f;
```

The last example does not work with casting because it is promoted to int and is out of range.

So the following code fixes it without requiring casting:

```java
long reptile = 192_301_398_193_810_323L;
```

### Overflow and Underflow

The second value of the previous example `1,921,222` is too large to be stored as a short, so numeric overflow occurs, and it becomes `20,678`.

`Overflow` is when a number is so large to fit in the data type, so the system "wraps around" the lowest negative value and counts up from there. [Overflow.java](./Overflow.java)

`Underflow` is when the number is too low to fit in the data type, so the system "wraps around" the highest positive value and counts up from there. [Underflow.java](./Underflow.java)

### Compound Assignment Operators```

Besides the simple assignment operator (=), Java supports numerous compound assignment operators.

#### Compound Assignment Operators

Operator | Example | Description
--- | --- | ---
Addition assignment | a += 5 | Adds the value on the right to the variable on the left and assigns the sum to the variable
Subtraction assignment | b -= 0.2 | Subtracts the value on the right from the variable on the left and assigns the difference to the variable
Multiplication assignment | c *= 100 | Multiplies the value on the right with the variable on the left and assigns the product to the variable
Division assignment | d /= 4 | Divides the variable on the left by the value on the right and assigns the quotient to the variable

#### Simple vs. Compound

```java
int camel = 2;
int giraffe = 3;

camel = camel * giraffe; // simple assignment operator
camel *= giraffe; // compound assignment operator
```

Compound operators can also implicitly cast a value.

For example:

```java
long goat = 10;
int sheep = 5;

sheep = sheep * goat; // DOES NOT COMPILE
```

This does not compile because we are trying to assign a long value to an int variable.

```java
long goat = 10;
int sheep = 5;

sheep *= goat; // WORKS
```

But using the compound operator works because it will first cast sheep to a long, apply the multiplication and then cast the result to an int.

### Return Value of Assignment Operators

The result of an assignment is an expression in and of itself equal to the value of the assignment.

For example:

```java
long wolf = 5;
long coyote = (wolf = 3);

System.out.println(wolf); // 3
System.out.println(coyote); // 3
```

The (wolf = 3) expression does two things.

1. It sets the value of the variable wolf to be 3
2. It returns the value of the assignment, which is also 3
