# Core APIs

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

In the `format()` and `formatted()` operations, the parameters are inserted and formatted via symbols in the order that they are provided in the `varargs`.

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

## Understanding Arrays

We have been referring to the String and StringBuilder classes as a `sequence of characters`. This is true because they are implemented using an `array of characters`.

An array is an area of memory on the heap with space for a designated number of elements and can be of any other Java type.

In other words, an array is an ordered list. It can contain duplicates.

### Creating an Array of Primitives

The most common way to create an array is shows as below. It specifies the type of the array `int` and the size `3`. The brackets `[]` tell that this is an array.

#### The basic structure of an array

```java
int[] numbers = new int[3];
```

1. Type of array
2. Array symbol (required)
3. Size of the array

Using this form to instantiate an array, all elements are set to the default value for that type. As we know, the default value of an int is 0, so the array is something like:

<table>
  <tr>
    <td>Index: </td>
    <td>0</td>
    <td>1</td>
    <td>2</td>
  </tr>
  <tr>
    <td>Element: </td>
    <td>0</td>
    <td>0</td>
    <td>0</td>
  </tr>
</table>

Another way to create an array is to specify all the elements it should start:

```java
int[] moreNumbers = new int[] { 42, 55, 99 };
```

We also create an int array of size 3, initializing with those values:

<table>
  <tr>
    <td>Index: </td>
    <td>0</td>
    <td>1</td>
    <td>2</td>
  </tr>
  <tr>
    <td>Element: </td>
    <td>42</td>
    <td>55</td>
    <td>99</td>
  </tr>
</table>

Java recognizes that this expression is redundant. Since we are specifying the type of the array on the left side and lets we write this:

```java
int[] moreNumbers = { 42, 55, 99 };
```

Finally, we can also type the `[]` before or after the name, the space is optional, for example:

```java
int[] numAnimals;
int [] numAnimals2;
int numAnimals3[];
int numAnimals4 [];
```

Most people use the first one.

### Using an array

```java
String[] mammals = { "monkey", "chimp", "donkey" };

System.out.println(mammals.length); // 3
System.out.println(mammals[0]); // monkey
System.out.println(mammals[1]); // chimp
System.out.println(mammals[2]); // donkey
```

1. Declares and initializes the array
2. How many elements the array can hold
3. The prints will print the array elements starting from index 0

### Sorting

Arrays have sort methods.

`Arrays` requires an import.

```java
import java.util.*; // import whole package including Arrays
import java.util.Arrays; // import just Arrays
```

Or we can write `java.util.Arrays` every time we use in the class instead of specifying it as an import.

#### Example sorting three numbers:

```java
int[] numbers = { 6, 9, 1 };
Arrays.sort(numbers);

System.out.println(numbers[0]); // 1
System.out.println(numbers[1]); // 6
System.out.println(numbers[2]); // 9
```

#### Example sorting three numbers as String:

```java
int[] strings = { "10", "9", "100" };
Arrays.sort(strings);

System.out.println(strings[0]); // 10
System.out.println(strings[1]); // 100
System.out.println(strings[2]); // 9
```

String sort in alphabetic order.

### Searching

Java also provides a way to search, `but only if the array is already sorted`.

#### Binary search rules

Scenario | Result
--- | ---
Target element found in sorted array | Index of match
Target element not found in sorted array | Negative value of the index that should be inserted, subtracting 1
Unsorted array | The result is undefined

Rules with examples:

```java
int[] numbers = { 2, 4, 6, 8 };

System.out.println(Arrays.binarySearch(numbers, 2)); // 0
System.out.println(Arrays.binarySearch(numbers, 4)); // 1
System.out.println(Arrays.binarySearch(numbers, 1)); // -1
System.out.println(Arrays.binarySearch(numbers, 3)); // -2
System.out.println(Arrays.binarySearch(numbers, 9)); // -5
```

1. Found at index 0
2. Found at index 1
3. Should be inserted at index 0, subtracting 1, resulting -1
4. Should be inserted at index 1, so the negative -1, subtracting 1, resulting -2
5. Should be inserted at index 4, so the negative -4, subtracting 1, resulting -5

### Comparing

Java also provides methods to compare two arrays to determine which is "smaller".

#### Using compare()

There are some rules before calling `compare()`:

- A `negative` number means the first array is smaller than the second
- A `zero` means the arrays are equal
- A `positive` number means the first array is larger than the second

For example:

```java
var arr1 = new int[] { 1 };
var arr2 = new int[] { 2 };

System.out.println(Arrays.compare(arr1, arr2));
```

The code prints a negative number since 1 is smaller than 2, making the first array smaller.

Now comparing arrays of different lengths:

- If both arrays has the same length and have the same values in the same index, return zero
- If all the elements are the same, but the second array has extra elements at the end, return a negative number
- If all the elements are the same, but the first array has extra elements at the end, return a positive number
- If the first element that differs is smaller in the first array, return a negative number
- If the first element that differs is larger in the first array, return a positive number

Smaller meaning:

- null is smaller than any other value
- For numbers, normal numeric order applies
- For strings, one is smaller if it is a prefix of another
- For strings/characters, numbers are smaller than letters
- For strings/characters, uppercase is smaller than lowercase

#### Arrays.compare() examples

First array | Second array | Result | Reason
--- | --- | --- | ---
`new int[] { 1 , 2 }` | `new int[] { 1 }` | Positive number | The first element is the same, but the first array is longer
`new int[] { 1 , 2 }` | `new int[] { 1 }` | Zero | Exact match
`new String[] { "a" }` | `new String[] { "aa" }` | Negative number | The first element is a substring of the second
`new String[] { "a" }` | `new String[] { "A" }` | Positive number | Uppercase is smaller than lowercase
`new String[] { "a" }` | `new String[] { null }` | Positive number | null is smaller than a letter

`Both arrays must be the same type, or it will cause a compilation error`.

### Using mismatch()

If the arrays are equal, `mismatch()` returns -1. Otherwise, it returns the first index where they differ.

```java
System.out.println(Arrays.mismatch(new int[] { 1 }, new int[] { 1 })); // -1
System.out.println(Arrays.mismatch(new String[] { "a" }, new String[] { "A" })); // 0
System.out.println(Arrays.mismatch(new int[] { 1, 2 }, new int[] { 1 })); // 1
```

#### Equality vs. comparison vs. mismatch

Method | When arrays contain the same data | When arrays are different
--- | --- | ---
`equals()` | true | false
`compare()` | 0 | Positive or negative number
`mismatch()` | -1 | Zero or positive index

### Using Methods with Varargs

```java
public static void main(String... args) {} // varargs
```
We can use a variable defined using varargs as if it were a normal array. For example, `args.length` and `args[0]` are legal.

### Creating a Multidimensional Array

Multiple array separators are all it takes to declare arrays with multiple dimensions, for example:

```java
int[][] vars1; // 2d array
int vars2[][]; // 2d array
int[] vars3[]; // 2d array
int[] vars4[], space[][]; // a 2d and a 3d array
```

1. Declaring a two-dimensional (2D) array
2. Declaring a two-dimensional (2D) array
3. Also declares a 2D array but, there's no good reason to use this style other than to confuse readers with your code
4. Declares two arrays on the same line, vars4 is a 2D array and space is a 3D array

We can also specify the size of our multidimensional array in the declaration, for example:

```java
String[][] rectangle = new String[3][2];
```

The result of this statement is an array rectangle with three elements, each element refers to an array of two elements.

Now suppose we set one of these values:

```java
rectangle[0][1] = "set";
```

#### Visualization of the rectangle

&emsp;&emsp;&emsp;0&emsp;&emsp;&emsp; | &emsp;&emsp;&emsp;1&emsp;&emsp;&emsp; | &emsp;&emsp;&emsp;2
--- | --- | ---
&ensp;&emsp;`0 \| 1` | &ensp;&emsp;`0 \| 1` | &ensp;&emsp;`0 \| 1`
`null \| "set"` |  `null \| null` | `null \| null`

### Using a Multidimensional Array

The most common operation on a multidimensional array is to loop through it.

We will need two loops. The first will uses the index `i` and goes through the first subarray. The second uses a different loop variable, `j`.

The `inner loop` looks at how many elements are in the second-level array, for example: [UsingMultidimensionalArray.java](./UsingMultidimensionalArray.java)

## Calculating with Math APIs

Java comes with a powerful Math class with many methods. We will cover a few common ones.

### Finding the Minimum and Maximum

The `min()` and `max()` methods compare two values and return one of them.

The method signatures are as follows:

```java
public static double min(double a, double b);
public static double max(double a, double b);

public static float min(float a, float b);
public static float max(float a, float b);

public static int min(int a, int b);
public static int max(int a, int b);

public static long min(long a, long b);
public static long max(long a, long b);
```

There are four overloaded methods, but they all work the same way.

The following code shows how to use these methods:

```java
int first = Math.min(7, -9); // -9
int second = Math.max(3, 7); // 7
```

1. Returns the -9 because it is the smaller
2. Returns the 7 because it is the larger

### Rounding Numbers

The `round()` method gets rid of the decimal portion of the value, choosing the next higher number if appropriate. `If the fractional is .5 or higher, round up`.

The method signatures are as follows:

```java
public static long round(double num);

public static int round(float num);
```

The following code shows how to use `round()`:

```java
long low = Math.round(123.45); // 123
long high = Math.round(123.50); // 124
int fromFloat = Math.round(123.45f); // 123
```

1. Returns 123 because .45 is smaller than a half
2. Returns 124 because the fractional part is a half
3. The same as 1 but returning int

### Determining the Ceiling and Floor

The `ceil()` method takes a double value. If it has any fractional value, it rounds up to the next whole number.

The `floor()` method discards any values after the decimal.

The method signatures are as follows:

```java
public static double ceil(double num);

public static double floor(double num);
```

The following code shows how to use these methods:

```java
double c = Math.ceil(3.14); // 4.0
double f = Math.floor(3.14); // 3.0
```

1. Returns 4 because is the closest largest integer
2. Returns 3 because it is the closest smallest integer

### Calculating Exponents

The `pow()` method handles exponents, for example, 3<sup>2</sup> means three squared. This is 3 * 3 or 9.

The method signature is as follows:

```java
public static double poow(double number, double exponent);
```

The following code shows how to use this method:

```java
double squared = Math.pow(5, 2); // 25.0
```

1. Returns 25.0 since it is a double. 5<sup>2</sup> is 5 * 5 or 25

### Generating Random Numbers

The `random()` method returns a value greater than or equal to 0 and less than 1.

The method signature is as follows:

```java
public static double random();
```

The following code shows how to use this method:

```java
double num = Math.random();
```

Since it is a random number, we can't know the result but, it can't be negative or 1.

## Working with Dates and Times

Java provides a number of APIs for working with dates and times. There's also an old `java.util.Date` class.

We will need to use an import statement to work with the modern date and time classes:

```java
import java.time.*;
```

### Time Zone

`Greenwich Mean Time (GMT)` is a time zone in Europe that is used as time zone zero when discussing offsets.

We also have the `Coodtinated Universal Time (UTC)` which is a time zone standard.

### Creating Dates and Times

When working with dates and times, the first thing is to decide how much information we need.

- `LocalDate`: contains just a date, without time and time zone
- `LocalTime`: contains just a time, without date and time zone
- `LocalDateTime`: contains date and time but no time zone
- `ZonedDateTime`: contains a date, time and time zone

It is possible to obtain date and time instances using a static method, each of the four classes has a static method called `now()`, which gives the current date and time:

[Now.java](./Now.java)

```java
System.out.println(LocalDate.now()); // 2025-01-22
System.out.println(LocalTime.now()); // 18:46:49.480071100
System.out.println(LocalDateTime.now()); // 2025-01-22T18:46:49.480071100
System.out.println(ZonedDateTime.now()); // 2025-01-22T18:46:49.480570700-03:00[America/Sao_Paulo]
```

All these classes have the static method `of()` that creates dates and times.

The method signatures are as follows:

```java
// LocalDate
public static LocalDate of(int year, int month, int dayOfMonth);
public static LocalDate of(int year, Month month, int dayOfMonth);

// LocalTime
public static LocalTime of(int hour, int minute);
public static LocalTime of(int hour, int minute, int second);
public static LocalTime of(int hour, int minute, int second, int nanos);

// LocalDateTime
public static LocalDateTime of(int year, int month, int dayOfMonth, int hour, int minute);
public static LocalDateTime of(int year, int month, int dayOfMonth, int hour, int minute, int second);
public static LocalDateTime of(int year, int month, int dayOfMonth, int hour, int minute, int second, int nanos);

// LocalDateTime - Month reference
public static LocalDateTime of(int year, Month month, int dayOfMonth, int hour, int minute);
public static LocalDateTime of(int year, Month month, int dayOfMonth, int hour, int minute, int second);
public static LocalDateTime of(int year, Month month, int dayOfMonth, int hour, int minute, int second, int nanos);

// LocalDateTime - LocalDate and LocalTime
public static LocalDateTime of(LocalDate date, LocalTime time);

// ZonedDateTime
public static ZonedDateTime(int year, int month, int nanos, ZoneId zone);
public static ZonedDateTime(LocalDate date, LocalTime time, ZoneId zone);
public static ZonedDateTime(LocalDateTime dateTime, ZoneId zone);
```

The following code shows how to use these methods: [DatesAndTimes.java](./DatesAndTimes.java)

The compiler will throw a `DateTimeException` if we pass invalid numbers to `of()`.

### Manipulating Dates and Times

The date and time classes are immutable. Assign the results of these methods to a reference variable.

```java
var date = LocalDate.of(2025, 1, 22);
System.out.println(date); // 2025-01-22

date = date.plusDays(2);
System.out.println(date); // 2025-01-24

date = date.plusWeeks(1);
System.out.println(date); // 2025-01-31

date = date.plusMonths(1);
System.out.println(date); // 2025-02-28
```

This code does what it looks like.

There are also methods in time:

```java
  var date = LocalDate.of(2025, 1, 22);
  var time = LocalTime.of(7, 25);
  var dateTime = LocalDateTime.of(date, time);

  System.out.println(dateTime); // 2025-01-22T07:25

  dateTime = dateTime.minusHours(10);
  System.out.println(dateTime); // 2025-01-21T21:25

  dateTime = dateTime.minusSeconds(30);
  System.out.println(dateTime); // 2025-01-21T21:24:30
```

#### Methods in LocalDate, LocalTime, LocalDateTime and ZonedDateTime

<table>
  <tr>
    <td></td>
    <td>Can call on <b>LocalDate</b>?</td>
    <td>Can call on <b>LocalTime</b>?</td>
    <td>Can call on <b>LocalDateTime</b> or <b>ZonedDateTime</b>?</td>
  </tr>
  <tr>
    <td><b>plusYears() / minusYears()</b></td>
    <td>Yes</td>
    <td>No</td>
    <td>Yes</td>
  </tr>
  <tr>
    <td><b>plusMonths() / minusMonths()</b></td>
    <td>Yes</td>
    <td>No</td>
    <td>Yes</td>
  </tr>
  <tr>
    <td><b>plusWeeks() / minusWeeks()</b></td>
    <td>Yes</td>
    <td>No</td>
    <td>Yes</td>
  </tr>
    <tr>
    <td><b>plusDays() / minusDays()</b></td>
    <td>Yes</td>
    <td>No</td>
    <td>Yes</td>
  </tr>
    <tr>
    <td><b>plusHours() / minusHours()</b></td>
    <td>No</td>
    <td>Yes</td>
    <td>Yes</td>
  </tr>
  <tr>
    <td><b>plusMinutes() / minusMinutes()</b></td>
    <td>No</td>
    <td>Yes</td>
    <td>Yes</td>
  </tr>
  <tr>
    <td><b>plusSeconds() / minusSeconds()</b></td>
    <td>No</td>
    <td>Yes</td>
    <td>Yes</td>
  </tr>
  <tr>
    <td><b>plusNanos() / minusNanos()</b></td>
    <td>No</td>
    <td>Yes</td>
    <td>Yes</td>
  </tr>
</table>

### Working with Periods

A zoo performs animal enrichment activities to give the animals something enjoyable to do. The head zookeeper has decided to switch the toys every month. This system will continue for three months to see how it works out.

[Zoo.java](./Zoo.java)

This code works fine. It adds a month to the date until it hits the end date. The problem is that this method can't be reused. The zookeeper want to try different schedules.

For this, Java has a Period class. This code does the same thing as the previous example but with flexibility.

[ZooWithPeriod.java](./ZooWithPeriod.java)

This will allow to reuse the same method for different periods of time as the zookeeper changes their mind.

There are five ways to create a Period class:

```java
var annually = Period.ofYears(1);
var quarterly = Period.ofMonths(3);
var everyThreeWeeks = Period.ofWeeks(3);
var everyOtherDay = Period.ofDays(2);
var everyYearAndAWeek = Period.of(1, 0, 7);
```

It is not possible to chain methods when creating a Period.

#### Period format

```java
System.out.println(Period.of(1, 2, 3)); // P1Y2M3D
```

P | 1Y | 2M | 3D
--- | --- | --- | ---
Period (mandatory) | Years | Months | Days

### Working with Durations

There is also Duration, which is for smaller units of time. We can specify the number of days, hours, minutes, seconds or nanoseconds.

We could pass 365 days to make a year, but we shouldn't, that's what Period is for.

Duration is used with objects that have time. Duration's output beginning with PT that means period of time.

A duration is stored in hours, minutes and seconds. The number of has fractional seconds.

The following code shows how to use with different granularities:

```java
var daily = Duration.ofDays(1); // PT24H
var hourly = Duration.ofHours(1); // PT1H
var everyMinute = Duration.ofMinutes(1); // PT1M
var everyTenSeconds = Duration.ofSeconds(10); // PT10S
var everyMilli = Duration.ofMillis(1); // PT0.001S
var everyNano = Duration.ofNanos(1); // PT0.000000001S
```

Duration includes another more generic factory method, it takes a number and a TemporalUnit.

The previous example could be written like this:

```java
var daily = Duration.ofDays(1, ChronoUnit.DAYS);
var hourly = Duration.ofHours(1, ChronoUnit.HOURS);
var everyMinute = Duration.ofMinutes(1, ChronoUnit.MINUTES);
var everyTenSeconds = Duration.ofSeconds(10, ChronoUnit.SECONDS);
var everyMilli = Duration.ofMillis(1, ChronoUnit.MILLIS);
var everyNano = Duration.ofNanos(1, ChronoUnit.NANOS);
```

ChronoUnit also includes `ChronoUnit.HALF_DAYS` to represent 12 hours.

### ChronoUnit for Differences

ChronoUnit is a great way to determine how far apart two Temporal values are.

Temporal includes LocalDate, LocalTime, and so on. ChronoUnit is in the `java.time.temporal` package.

```java
var one = LocalTime.of(5, 15);
var two = LocalTime.of(6, 30);

System.out.println(ChronoUnit.HOURS.between(one, two)); // 1
System.out.println(ChronoUnit.MINUTES.between(one, two)); // 75
```

We can also truncate any object with a time element, for example:

```java
LocalTime time = LocalTime.of(6, 3, 45);
System.out.println(time); // 06:03:45

LocalTime truncated = time.truncatedTo(ChronoUnit.MINUTES);
System.out.println(truncated); // 06:03
```

The example zeroes out any fields smaller than minutes. In this case, gets rid of the seconds.

### Period vs. Duration

Period and Duration are not equivalent.

```java
var date = LocalDate.of(2025, 1, 23);
var period = Period.ofDays(1);
var duration = Duration.ofDays(1);

System.out.println(date.plus(period)); // 2025-01-24
System.out.println(date.plus(duration)); // Unsupported unit: Seconds
```

Since we are working with a LocalDate, it is required to use Period.

Period has time units in it, even if we don't see them, they are meant only for objects with time.

#### Where to use Duration and Period

<table>
  <tr>
    <td></td>
    <td>Can use with <b>Period</b>?</td>
    <td>Can use with <b>Duration</b>?</td>
  </tr>
  <tr>
    <td><b>LocalDate</b></td>
    <td>Yes</td>
    <td>No</td>
  </tr>
  <tr>
    <td><b>LocalDateTime</b></td>
    <td>Yes</td>
    <td>Yes</td>
  </tr>
  <tr>
    <td><b>LocalTime</b></td>
    <td>No</td>
    <td>Yes</td>
  </tr>
  <tr>
    <td><b>ZonedDateTime</b></td>
    <td>Yes</td>
    <td>Yes</td>
  </tr>
</table>

### Working with Instants

The Instant class represents a specific moment in time in the GMT time zone.

```java
var now = Instant.now();

// do something time consuming over a second

var later = Instant.now();

var duration = Duration.between(now, later);
System.out.println(duration); // returns number milliseconds
```
We can turn a ZonedDateTime into an Instant:

```java
var date = LocalDate.of(2025, 1, 23);
var time = LocalTime.of(6, 15);
var zone = ZoneId.of("America/Sao_Paulo");
var zonedDateTime = ZonedDateTime.of(date, time, zone);
var instant = ZonedDateTime.toInstant();

System.out.println(zonedDateTime); // 2025-01-23T06:15-03:00[America/Sao_Paulo]
System.out.println(instant); // 2025-01-23T09:15:00Z
```

The ZonedDateTime includes a time zone.

The Instant gets rid of the time zone and turns it into an Instant of time in GMT.
