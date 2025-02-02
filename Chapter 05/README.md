# Methods

- Utilizing Java Object-Oriented Approach
  - Create classes and records, define and use instance and static fields and methods, constructors, instance and static initializers
  - Implement overloading, including varargs methods

In this chapter we will explore methods in depth, including modifiers, arguments, varargs, overloading and auto-boxing. Many of these fundamentals, such as access and static modified, are applicable to classes and other types.

## Designing Methods

We have basically only seen the `main()` method throughout the chapters, but we can write other methods as well.

#### Method declaration

```java
public final void nap(int minutes) throws InterruptedException {
  // take a nap
}
```

1. public access modified
2. final optional specifier
3. void return type
4. nap method name
5. Parentheses (required) with a list of parameters
6. throws exception (optional)
7. method body

This is called method declaration, which specifies all the information needed to call the method.

The `method name` and `parameter list` are called `method signature`.

The method signature provides instructions for `how` callers can reference this method.

#### Parts of a method declaration

Element | Value in `nap()` example | Required
--- | --- | ---
Access modifier | public | No
Optional specifier | final | No
Return type | void | Yes
Method name | nap | Yes
Parameter list | (int minutes) | Yes, but can be empty parentheses
Method signature | nap(int minutes) | Yes
Exception list | throws InterruptedException | No
Method body | { // take a nap } | Yes, except for abstract methods

To call this method, just use the method signature and provide an int value in parentheses: `nap(10)`.

### Access Modifiers

An access modifier determines what classes a method can be accessed from. Think of it like a security guard.

Access modifiers help to enforce when components are allowed to talk to each other.

There are four choices of access modifier:

- `private`: means the method can be called only from within the same class
- `Package Access`: the method can be called only from a class in the same package. Simply omit the access modifier. Package access is sometimes referred to as package-private or default
- `protected`: means the method can be called only from a class in the same package or a subclass
- `public`: means the method can be called from anywhere

```java
public class ParkTrip {
  public void skip1() {}

  default void skip2() {} // DOES NOT COMPILE

  void public skip3() {} // DOES NOT COMPILE

  void skip4() {}
}
```

1. Is a valid declaration with public access
2. The default is not a valid access modifier, there is a default keyword, which is used in switch statements and interfaces
3. The access modifier should be specified before the return type
4. Is a valid declaration with package access

### Optional Specifiers

Unlike access modifiers, we can have multiple specifiers in the same method (although not all combinations are legal). We can specify them in any order. And since these specifiers are optional, we can have zero or more specifiers in a method declaration.

#### Optional specifier for methods

Modifier | Description | Chapter covered
--- | --- | ---
static | Indicates the method is a member of the shared class object | Chapter 05
abstract | Used in an abstract class or interface when the method body is excluded | Chapter 06
final | Specifies that the method may not be overridden in a subclass | Chapter 06
default | Used in an interface to provide a default implementation of a method for classes that implement the interface | Chapter 07
synchronized | Used with multithreaded code | Chapter 13
native | Used when interacting with code written in another language | Out of scope
strictfp | Used for making floating-point calculations portable | Out of scope

```java
public class Exercise {
  public void bike1() {}

  public final void bike2() {}

  public static final void bike3() {}

  public final static void bike4() {}

  public modifier void bike5() {} // DOES NOT COMPILE

  public void final bike6() {} // DOES NOT COMPILE

  final public void bike7() {}
}
```

While access modifiers and optional specifiers can appear in any order, `they must all appear before the return type`.

It is not possible to declare a method or class both final and abstract.

### Return Type

It must appear after any access modifiers or optional specifiers, and before the method name.

The return type might be an actual Java type such as String or int. If there is no return type, the void keyword is used. This return type means without contents.

Methods with a return type other than void are required to have a return statement inside the method body.

Methods that have a return type of void are permitted to have a return statement with no value returned or omit the return statement, for example:

```java
public void swim(int distance) {
  if (distance <= 0) {
    // exit early, nothing to do
    return;
  }

  System.out.println("Fish is swimming " + distance + " meters");
}
```

More examples:

```java
public class Hike {
  public void hike1() {}

  public void hike2() {
    return;
  }

  public String hike3() {
    return "";
  }

  public String hike4() {} // DOES NOT COMPILE

  public hike5() {} // DOES NOT COMPILE

  public String int hike6() {} // DOES NOT COMPILE

  String hike7() { // DOES NOT COMPILE
    if (1 < 2) {
      return "orange";
    }
  }
}
```

1. The return is optional
2. Shows the optional return statement that doesn't return anything
3. The return type is String, and it returns a String
4. Doesn't compile because return statement is missing
5. Doesn't compile because the return type is missing
6. Doesn't compile because it attempts to use two return types
7. There is a return statement, but it doesn't always get run. Even though 1 is always less than 2, the compiler won't evaluate the if statement and requires a return statement if this condition is false

```java
// return with if

String hike8() {
  if (1 < 2) {
    return "orange";
  }

  return "apple";
}
```

This code compiles, although the compiler will produce a warning about unreachable code since the if statement is always true.

### Method name

Method names follow the same rules as variable names.

```java
public class BeachTrip {
  public void jog1() {}

  public void 2jog() {} // DOES NOT COMPILE

  public jog3 void() {} // DOES NOT COMPILE

  public void Jog_$() {}

  public _() {} // DOES NOT COMPILE

  public void() {} // DOES NOT COMPILE
}
```

1. Is a valid declaration with a traditional name
2. Does not compile because is not allowed to begin with numbers
3. Does not compile because the method name is before the return type
4. Is a valid declaration despite being a bad practice
5. Is not allowed since it consists of a single underscore
6. Method name missing

### Parameter List

Although the parameter list is required, it does not have to contain any parameters. This means we can have an empty pair of parentheses after the method name, for example:

```java
public class Sleep {
  void nap() {}
}
```

With multiple parameters, we separate them with a comma, for example:

```java
public class PhysicalEducation {
  public void run1() {}

  public void run2(int a) {}

  public void run3(int a, int b) {}
}
```

There are a couple of rules for the parameter list that we'll see when varargs was covered.

### Method Signature

A method signature, composed of the method name and parameter list, is what Java uses to uniquely determine exactly which method we are attempting to call, then determines if the call is allowed.

It's important to note that the names of the parameters in the method signature are not used as part of a method signature. The parameter list is about the types of parameters and their order, for example:

```java
public class Trip {
  public void visitZoo(String name, int waitTime) {}

  public void visitZoo(String attraction, int rainFall) {} // DOES NOT COMPILE
}
```

Despite having different parameter names, these two methods have the exact same signature and cannot be declared within the same class. Changing the order of parameter types does allow the method to compile, though:

```java
public class Trip {
  public void visitZoo(String name, int waitTime) {}

  public void visitZoo(int rainFall, String attraction) {}
}
```

These rules will be covered in more detail when we get to method overloading.

### Exception List

We can also indicate that something went wrong by throwing an exception, and we can list as many types of exceptions as we want in this clause, separated by commas, for example:

```java
public class ZooMonorail {
  public void zeroExceptions() {}

  public void oneException() throws IllegalArgumentException {}

  public void twoExceptions() throws IllegalArgumentException, InterruptedException {}
}
```

While the list of exceptions is optional, it may be required by the compiler, depending on what appear inside the method body.

### Method Body

A method body is a code block. It has braces that contain zero or more Java statements, for example:

```java
public class Bird {
  public void fly(int a) {
    // method body
    int name = 5;
  }
}
```
