# Core APIs

OCP exam objectives covered in this chapter:

- Handling date, time, text, numeric and boolean values
  - Use primitives and wrapper classes including Math API, parentheses, type promotion and casting to evaluate arithmetic and boolean expressions
  - Manipulate text, including text blocks, using String and StringBuilder classes
  - Manipulate date, time, duration, period, instant and time-zone objects using Date-Time API
- Working with Arrays and Collections
  - Create Java arrays, List, Set, Map, Deque collections, and also, add, remove, update, retrieve and sort their elements

In the context of an application programming interface (API), an interface refers to a group of classes or Java interface definitions giving us access to functionality.

## Creating and Manipulating String

A string is basically a sequence of characters, for example:

```java
String name = "Fluffy";
```

```java
String name = new String("Fluffy");
```

In Java, these two snippets create a String.

Both gives us a reference variable named name pointing to the String object "Fluffy". They are subtly different but we will see later.

Further, text blocks are another way of creating a String, for example:

```java
String name = """
              Fluffy""";
```

Since a String is a sequence, it implements the interface CharSequence. This interface is a general way of representing several classes, including String and StringBuilder.

### Concatenating

Earlier we saw how to add numbers. `1 + 2 is 3`, but `"1" + "2" is "12"` because Java combines the two String objects, placing one String before the other String and combining them is called string concatenation.

Here are some rules:

- If both operands are numeric, + means numeric addition
- If either operand is a String, + means concatenation
- The expression is evaluated left to right

For example:

```java
System.out.println(1 + 2); // 3
System.out.println("a" + "b"); // ab
System.out.println("a" + "b" + 3); // ab3
System.out.println(1 + 2 + "c"); // 3c
System.out.println("c" + 1 + 2); // c12
System.out.println("c" + null); // cnull
```

1. Uses the first rule. Both operands are numbers so it will add.
2. Uses the seconds rule. Simple string concatenation.
3. Combines the second and third rules. Since start on the left, `"a" + "b"` evaluates to String, then Java looks at the remaining expression of `"ab" + 3` and uses concatenation since one operand is String.
4. Start with the third rule, considering both operand are numeric `1 + 2`, resulting in `3`. Then we have `3 + "c"` and uses concatenation since one operand is String.
5. Shows the importance of the third rule. First have `"c" + 1`, resulting in `"c1"`. Then `"c1" + 2`, resulting in `"c12"`.
6. Shows how null is represented as a string when concatenated or printed, resulting in `cnull`.

### Important String Methods

The String class has dozens of methods. For all these methods, we need to remember that a string is a sequence of characters and Java counts from 0 when indexed.

#### Indexing for a string

0 | 1 | 2 | 3 | 4 | 5 | 6
--- | --- | --- | --- | --- | --- | ---
a | n | i | m | a | l | s

A `String is immutable or unchangeable`. This means calling a method on a String will return a different String object rather than changing the value of the reference.

#### Determining the Length

The method `length()` returns the number of characters in the String.

The method signature is as follows:

```java
public int length();
```

The following code shows how to use `length()`:

```java
var name = "animals";

System.out.println(name.length()); // 7
```

It prints 7 because that `zero counting happens only if using indexes or positions within a list`.

When `determining the total size or length, Java uses normal counting`.

#### Getting a Single Character

The method `charAt()` lets us query the string to find out what character is at a specific index.

The method signature is as follows:

```java
public char charAt(int index);
```

The following code shows how to use `charAt()`:

```java
var name = "animals";

System.out.println(name.charAt(0)); // a
System.out.println(name.charAt(6)); // s
System.out.println(name.charAt(7)); // throws excpetion
```

Since indexes start counting with 0, `charAt(0)` returns the "first" character in the sequence, same with the `charAt(6)`.

`charAt(7)` is a problem because it asks for the `eighth character` in the sequence, but there are only seven characters present. When something goes wrong that Java doesn't know how to deal with, it throws an exception, as shown:

```
java.lang.StringIndexOutOfBOundsException: String index out of range: 7
```

#### Finding an Index

The method `indexOf()` looks at the characters in the string and finds the first index that matches the desired value.

It can work with an individual character or a whole String as input.

It also can start from a requested position.

The method signatures are as follows:

```java
public int indexOf(int ch);

public int indexOf(int ch, int fromIndex);

public int indexOf(String str);

public int indexOf(String str, int fromIndex);
```

The following code shows how to use `indexOf()`:

```java
var name = "animals";

System.out.println(name.indexOf('a')); // 0
System.out.println(name.indexOf("al")); // 4
System.out.println(name.indexOf('a', 4)); // 4
System.out.println(name.indexOf("al", 5)); // -1
```

1. Returns the first 'a' that is at index 0.
2. Looks for a more specific string, so it matches later at index 4.
3. Says Java shouldn't look at the characters until it gets to index 4.
4. Doesn't find anything because it starts looking after the match occurred and returns -1 instead of throw an exception.

#### Getting a Substring

The method `substring()` also looks for characters in a string, and it returns parts of the string.

The method signatures are as follows:

```java
public String substring(int beginIndex);

public String substring(int beginIndex, int endIndex);
```

It helps to thing of indexes a bit differently for the substring methods. Pretend the indexes are right before the character they would point to.

This will help remember that endIndex is allowed to be one past the end of the index sequence.

<table>
  <tr>
    <td>&emsp;&emsp;&ensp;a</td>
    <td>&emsp;&emsp;&ensp;n</td>
    <td>&emsp;&emsp;&ensp;i</td>
    <td>&emsp;&emsp;&ensp;m</td>
    <td>&emsp;&emsp;&ensp;a</td>
    <td>&emsp;&emsp;&ensp;l</td>
    <td>&emsp;&emsp;&ensp;s</td>
    <td></td>
  </tr>
  <tr>
    <td>⬆ 0</td>
    <td>⬆ 1</td>
    <td>⬆ 2</td>
    <td>⬆ 3</td>
    <td>⬆ 4</td>
    <td>⬆ 5</td>
    <td>⬆ 6</td>
    <td>⬆ 7</td>
  </tr>
</table>

The following code shows how to use `substring()`:

```java
var name = "animals";

System.out.println(name.substring(3)); // mals
System.out.println(name.substring(name.indexOf('m'))); // mals
System.out.println(name.substring(3, 4)); // m
System.out.println(name.substring(3, 7)); // mals
System.out.println(name.substring(3, 3)); // empty string
System.out.println(name.substring(3, 2)); // throws excpetion
System.out.println(name.substring(3, 8)); // throws excpetion
```

1. Take the characters starting with index 3 through the end
2. Does the same as 1., but it calls `indexOf()` to get the index rather than hard-coding it
3. Take the characters starting with index 3 until, but not including, the character at index 4
4. Take the characters starting with index 3 until we get to index 8
5. Prints an empty string because the request is for the characters starting with index 3 until we get to index 3. Since it starts and end with the same index, there are no characters in between
6. Throws an exception because the indexes can't be backward
7. Throws an exception since there is no eighth position. Granted, there is no seventh either but at least there is the "end of string" invisible position.

#### Adjusting Case

These methods make it easy to convert data.

The method signatures are as follows:

```java
public String toLowerCase();

public String toUpperCase();
```

The following code shows how to use these methods:

```java
System.out.println("AnimAlS".toLowerCase()); // animals
System.out.println("AnimAlS".toUpperCase()); // ANIMALS
```

The `toLowerCase()` method converts any uppercase characters to lowercase in the `returned string`.

The `toUpperCase()` method converts any lowercase characters to uppercase in the `returned string`.

Remember that strings are immutable, so the original string stays the same.

#### Checking for Equality

The `equals()` method check whether two String objects contain exactly the same characters in the same order.

The `equalsIgnoreCase()` method checks whether two String objects contain the same characters, with the exception that it ignores the characters case.

The method signatures are as follows:

```java
public boolean equals(Object obj);

public boolean equalsIgnoreCase(String str);
```

The `equals()` method takes an Object rather than a String because the method is the same for all objects.

In Java, String values are case-sensitive, which means that "abc" and "ABC" are considered different values.

The following code shows how to use these methods:

```java
System.out.println("abc".equals("ABC")); // false
System.out.println("ABC".equals("ABC")); // true
System.out.println("abc".equalsIgnoreCase("ABC")); // true
```

1. The values aren't exactly the same
2. They are exactly the same
3. They differ only by case, but it is okay because the method ignores differences in case

#### Overriding toString(), equals(Object) and hashCode()

- `toString()`: this method is called when we try to print an object or concatenate the object with a String. It is commonly overridden with a version that prints a unique description of the instance using its instance fields
- `equals(Object)`: this method is used to compare objects, with the default implementation just using the == operator. We should override this method any time we want to compare elements for equality, `especially if this required checking numerous fields`
- `hashCode()`: any time we override `equals(Object)`, we must override `hashCode()` to be consistent. This means that for any two objects, if `a.equals(b)` is true, than `a.hashCode() == b.hashCode()` must also be true. `If they are not consistent, this could lead to invalid data and side effects in hash-based collections such as HashMap and HashSet`

All of these methods provide a default implementation in Object.

#### Searching for Substrings

Often we need to search a larger string to determine if a substring is contained within it.

The `startsWith()` and `endsWith()` methods look at whether the provided value matches part of the String.

The `contains()` method isn't as particular, it looks for matches anywhere in the String.

The method signatures are as follows:

```java
public boolean startsWith(String prefix);

public boolean endsWith(String suffix);

public boolean contains(CharSequence charSeq);
```

The following code shows how to use these methods:

```java
System.out.println("abc".startsWith("a")); // true
System.out.println("abc".startsWith("A")); // false

System.out.println("abc".endsWith("c")); // true
System.out.println("abc".endsWith("a")); // false

System.out.println("abc".contains("b")); // true
System.out.println("abc".contains("B")); // false
```

Java is doing a case-sensitive check on the values provided.

#### Replacing Values

The `replace()` methods does a simple search and replace on the string.

The method signatures are as follows:

```java
public String replace(char oldChar, char newChar);

public String replace(CharSequence target, CharSequence replacement);
```

The following code shows how to use these methods:

```java
System.out.println("abcabc".replace('a', 'A')); // AbcAbc
System.out.println("abcabc".replace("a", "A")); // AbcAbc
```

1. Uses the first method signature, passing in char parameters
2. Uses the second method signature, passing in String parameters

#### Removing Whitespace

The methods `strip()` and `trim()` remove blank space from the beginning and/or end of a String.

The `strip()` method does everything that `trim()` does, but it supports Unicode.

The `stripLeading()` method removes whitespace from the beginning of the String and leaves it at the end. The `stripTrailing()` method does the opposite.

The method signatures are as follows:

```java
public String strip();

public String stripLeading();

public String stripTrailing();

public String trim();
```

The following code shows how to use these methods:

```java
System.out.println("abc".strip()); // abc
System.out.println("\t a b c\n".strip()); // a b c

String text = " abc\t ";

System.out.println(text.trim().length()); // 3
System.out.println(text.strip().length()); // 3
System.out.println(text.stripLeading().length()); // 5
System.out.println(text.stripTrailing().length()); // 4
```

The `\t` represents a tab and is a `single` character.

1. Prints the original string because there are no whitespace at the beginning or end
2. Gets rid of the leading tab, subsequent spaces, and trailing newline. It leaves the spaces that are in the middle of the string
3. The remaining examples prints the number of characters remaining

#### Working with Indentation

The `indent()` method adds the same number of blank spaces to the beginning of each line if we pass a positive number.

If we pass a negative number, it tries to remove that number of whitespace characters from the beginning of the line.

If pass zero, the indentation will not change.

However, `indent()` also normalizes whitespace characters, this means that a line break is added to the end of the string if not already there. Also, any line breaks are converted to the `\n` format. Regardless of whether operating system uses `\r\n (Windows)` or `\n (Mac/Unix)`.

The `stripIndent()` method is useful when a String was built with concatenation rather than using a text block. It gets rid of all incidental whitespace.

Here are some rules:

Method | Indent change | Normalizes existing line breaks | Adds line break at end if missing
--- | --- | --- | ---
`indent(n) where n > 0` | Adds n spaces to beginning of each line | Yes | Yes
`indent(n) where n == 0` | No change | Yes | Yes
`indent(n) where n < 0` | Removes up to n spaces from each line where the same number of characters is removed from each non-blank line | Yes | Yes
`stripIndent()` | Removes all leading incidental whitespace | Yes | No

This example shows how to use these methods: [Indentation.java](./Indentation.java)

Both variables `block` and `concat` have `characters`, `line breaks` and `whitespace` at beginning, so each of these elements counts by 1, resulting in a longer length.

#### Translating Escapes

When we escape characters, we use a single backslash `\`.

For example, `\t` is a `tab`.

If we don't want this behavior, we add another backslash to escape the backslash, so `\\t` is the literal string `\t`.

The `translateEscapes()` method takes these literals and turns them into the equivalent escaped character.

The method signature is as follows:

```java
public String translateEscapes();
```

The following code shows how to use `translateEscapes()`:

```java
var str = "1\\t2";

System.out.println(str); // 1\t2
System.out.println(str.translateEscapes()); // 1    2
```

1. Prints the literal string \t because the backslash is escaped
2. Prints an actual tab since we translated the escape. This method can be used for escape sequences such as `\t (tab)`, `\n (new line)`, `\s (space)`, `\" (double quote)` and `\' (single quote)`

#### Checking for Empty or Blank Strings

Java provides convenience methods for whether a String has a length of zero or contains only whitespace characters.

The method signatures are as follows:

```java
public boolean isEmpty();

public boolean isBlank();
```

The following code shows how to use these methods:

```java
System.out.println(" ".isEmpty()); // false
System.out.println("".isEmpty()); // true
System.out.println(" ".isBlank()); // true
System.out.println("".isBlank()); // true
```

1. Prints false because the String is not empty, it has a blank space
2. Prints true because this time, there are no characters in the String
3. Prints true because there are no characters other than whitespace present
4. Same as 3

#### Formatting Values

There are methods to format String values using formatting flags.

The method parameters are used to construct a formatted String in a single method call rather than a lot of concatenations.

The method signatures are as follows:

```java
public static String format(String format, Object args...);

public static String format(Locale loc, String format, Object args...);

public String formatted(Object args...);
```

The following code shows how to use these methods:

[StringFormat.java](./StringFormat.java)

```java
var name = "Kate";
var orderId = 5;

// All print: Hello Kate, order 5 is ready
System.out.println("Hello " + name + ", order " + orderId + " is ready");
System.out.println(String.format("Hello %s, order %d is ready", name, orderId));
System.out.println("Hello %s, order %d is ready".formatted(name, orderId));
```

In the `format()` and `formatted()` operations, the parameters are inserted and formatted via symbols in the order that they are provided in the `vararg`.

#### Common formatting symbols

Symbol | Description
--- | ---
%s | Applies to any type, commonly String values
%d | Applies to integer values like int and long
%f | Applies to floating-point values like float and double
%n | Inserts a line break using the system-dependent line separator

#### Method Chaining

It is common to call multiple methods as shown:

```java
var start = "AniMaL   ";
var trimmed = start.trim(); // "AniMaL"
var lowercase = trimmed.toLowerCase(); // animal
var result = lowercase.replace('a', 'A');

System.out.println(result); // AnimAl
```

This is a series of String methods. Each time one is called, the returned value is put in a new variable. There are four String values along the way and `AnimAl` is output.

This technique called method chaining cram as much code as possible into a small space, for example:

```java
String result = "AniMaL   ".trim().toLowerCase().replace('a', 'A');

System.out.println(result); // AnimAl
```

Both snippets are equivalent. It also creates four String objects and outputs the same result.

To read code that uses method chaining, start at left and evaluated the first method. Then call the next method on the returned value, and so on.

## Using the StringBuilder Class

A small program can create a lot of String objects very quickly. For example:

```java
String alpha = "";

for (char current = 'a'; current <= 'z'; current++) {
  alpha += current;
}

System.out.println(alpha);
```

The following code creates a total of 27 objects are instantiated, since each concatenation creates a new String.

1. The empty String `alpha` is created
2. Then in the loop, appends an `"a"`, and the `""` object becomes eligible for garbage collection
3. The next time through the loop, alpha is assigned a new String object `"ab"`, and the `"a"` object becomes eligible for garbage collection, and so on

This is very inefficient, and Java has a solution. The StringBuilder class creates a String without storing all those values, but unlike the String class, the StringBuilder is not immutable.

```java
StringBuilder alpha = new StringBuilder();

for (char current = 'a'; current <= 'z'; current++) {
  alpha.append(current);
}

System.out.println(alpha);
```

1. The StringBuilder object is instantiated
2. The call to `append()` adds a character to the StringBuilder object each time through the for loop, without creating a new String object in every iteration

#### Creating a StringBuilder

There are three ways to construct a StringBuilder:

```java
StringBuilder sb1 = new StringBuilder();
StringBuilder sb2 = new StringBuilder("animal");
StringBuilder sb3 = new StringBuilder(10);
```

1. Create a StringBuilder containing an empty sequence of characters
2. Create a StringBuilder containing a specific value
3. Tells Java that we have some idea of how big the eventual value will be and would like the StringBuilder to reserve a certain capacity or number of slots for characters

#### The String Pool

Since strings are everywhere in Java, they use up a lot of memory.

If Java realizes that many strings repeat in the program, he solves this issue by reusing common ones.

The string pool, also knows as the intern pool, is a location in the Java Virtual Machine (JVM) that collects all these strings.

The string pool contains literal values and constants that appear in our program.

For example, `"name"` is a literal and therefore goes into the string pool. The `myObject.toString()` method returns a string but not a literal, so it does not go into the string pool.

Some scenarios:

```java
var x = "Hello World";
var y = "Hello World";

System.out.println(x == y); // true
```

Remember that a String is immutable and literals are pooled. The JVM created only one literal in memory. The x and y variables both point to the same location in memory. Therefore, the statement outputs true.

```java
var x = "Hello World";
var y = " Hello World".trim();

System.out.println(x == z); // false
```

We don't have two of the same String literal. Although x and y happen to evaluate to the same string, `one is computed at runtime. Since it isn't the same at compile-time, a new String object is created`.

```java
var singleString = "hello world";
var concat = "hello "
concat += "world";

System.out.println(singleString == concat); // false
```

Calling `+=` just like calling a method and results in a new String.

We can also tell Java to use the string pool. The `intern()` method will use an object in the string pool if one is present.

```java
public String intern();
```

If the literal is not yet in the pool, Java will add it at this time.

```java
var name = "Hello World";
var name2 = new String("Hello World").intern();

System.out.println(name == name2); // true
```
