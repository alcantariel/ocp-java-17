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
- the first operation is to decrement cookies, resulting in 3
- then the multiplication 3 * 2, resulting in 6
- then the addition 6 + 3, resulting in 9
- finally the result is automatically promoted from 9 to 9.0 and assigned to the reward

The final values of reward and cookies are 9.0 and 3, respectively, with the following printed:

`Zoo animal receives 9.0 reward points`

### Operator Precedence

In mathematics, certain operators can override other operators and be evaluated first.

Determining which operators are evaluated in what order is referred to as `operator precedence`.

Consider the following expression with some optional parentheses to demonstrate how the compiler evaluates this statement:

```java
var perimeter = ((2 * height) + (2 * length));
```

- the multiplication operator (*) has a higher precedence than the addition operator (+)
- the `height` and `length` are both multiplied by 2 before being added together
- the assignment operator (=) has the lowest order of precedence, so is performed last

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

`Logical Complement Operator (!)` flips the value of a boolean expression. [LogicalComplementOperatorExample.java](./LogicalComplementOperator.java)

`Bitwise Complement Operator (~)` which flips all the 0s and 1s in a number. It can only be applied to integer numeric types such as byte, short, char, int and long. [BitwiseComplementOperatorExample.java](./BitwiseComplementOperator.java)

`Negation Operator (-)` reverses the sign of a numeric expression. [NegationOperatorExample.java](./NegationOperatorExample.java)

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
