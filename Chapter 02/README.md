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