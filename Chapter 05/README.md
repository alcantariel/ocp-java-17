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

Modifier | Description | Chapter Covered
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

## Declaring Local and Instance Variables

```java
public class Lion {
  int hunger = 4;

  public int feedZooAnimals() {
    int snack = 10; // Local variable

    if (snack > 4) {
      long dinnerTime = snack++;
      hunger--;
    }

    return snack;
  }
}
```

In this class, snack and dinnerTime are local variables, only accessible within their respective code blocks, while hunger is an instance variable and created in every object of the Lion class.

The object or value returned by a method may be available outside the method, but the variable reference snack is gone.

### Local Variable Modifiers

There's only one modifier that can be applied to a local variable: `final`. The final modifier does not allow changing the variable reference, resulting in a compiler error, for example:

```java
public void zooAnimalCheckup(boolean isWeekend) {
  final int rest;

  if (isWeekend) {
    rest = 5;
  } else {
    rest = 20;
  }

  System.out.print(rest);

  final var giraffe = new Animal();
  final int[] friends = new int[5];

  rest = 10; // DOES NOT COMPILE
  giraffe = new Animal(); // DOES NOT COMPILE
  friends = null; // DOES NOT COMPILE
}
```

We don't need to assign a value when a final variable is declared, but it must be assigned a value before it can be used.

The final modifier does not mean that we can't modify the data, it refers to the variable reference, the content can be modified freely (assuming the object isn't immutable).

```java
public void zooAnimalCheckup() {
  final int rest = 5;
  final Animal giraffe = new Animal();
  final int[] friends = new int[5];

  giraffe.setName("George");
  friends[2] = 2;
}
```

The rest variable is a primitive, so it's just a value that can't be modified. On the other hand, contents of the giraffe and friends variables can be freely modified, provided the variables aren't reassigned.

Making a local variable final is a good practice, avoiding unexpected side effects.

### Instance Variable Modifiers

Like methods, instance variables can use access modifiers, such as private, package, protected and public. Instance variables can also use optional specifiers.

#### Optional specifiers for instance variables

Modifier | Description | Chapter Covered
--- | --- | ---
final | Specifies that the instance variable must be initialized with each instance of the class exactly once | Chapter 05
volatile | Instructs the JVM that the value in this variable may be modified by other threads | Chapter 13
transient | Used to indicate that an instance variable should not be serialized with the class | Chapter 14

## Working with Varargs

A method may use a varargs parameter (variable argument) as if it is an array. Creating a method with varargs is a bit more complicated. In fact, calling such a method may not use an array at all.

### Creating Methods with Varargs

There are some rules for creating a method with varargs:

1. A method can have at most one varargs parameter
2. If a method contains a varargs parameter, it must be the last parameter in the list

For example:

```java
public class VisitAttractions {
  public void walk1(int... steps) {}

  public void walk2(int start, int...steps) {}

  public void walk3(int... steps, int start) {} // DOES NOT COMPILE

  public void walk4(int... start, int... steps) {} // DOES NOT COMPILE
}
```

1. Valid declaration with one varargs
2. Valid declaration with varargs as last parameter
3. Have varargs in position that is not the last one
4. Have varargs in position that is not the last one

### Calling Methods with Varargs

When calling a method with varargs, we can pass an array, or we can list the elements of the array and let Java create.

[VarargsParameters.java](./VarargsParameters.java)

[VarargsWithOtherMethodParameters.java](./VarargsWithOtherMethodParameters.java)

```java
// Pass an array
walk1(new int[] { 1, 2, 3 });

// Pass a list of values
walk1(1, 2, 3);

// Omit values
walk1();
```

### Accessing Elements of a Varargs

Accessing a varargs parameter is like accessing an array. It uses array indexing, for example:

```java
public static void run(int... steps) {
  System.out.println(steps[1]);
}

public static void main(String[] args) {
  run(30, 77); // 77
}
```

## Applying Access Modifiers

Discussing access modifiers in order from most restrictive to least restrictive:

- private: only accessible within the same class
- package access: private plus other members of the same package. Sometimes referred to as package-private or default access
- protected: package access plus access within subclasses
- public: protected plus classes in the other packages

### Private Access

With the private access, only code in the same class can call private methods or access private fields.

#### Classes used to show private and package access

<table>
  <tr>
    <th>Package</th>
    <th>Classes</th>
  </tr>
  <tr>
    <td>pond.duck</td>
    <td>
      <ul>
        <li>FatherDuck</li>
        <li>MotherDuck</li>
        <li>BadDuckling</li>
        <li>GoodDuckling</li>
      </ul>
    </td>
  </tr>
  <tr>
    <td>pond.swan</td>
    <td>
      <ul>
        <li>BadCygnet</li>
      </ul>
    </td>
  </tr>
</table>

```java
package pond.duck;

public class FatherDuck {
  private String noise = "quack";

  private void quack() {
    System.out.println(noise);
  }
}
```

FatherDuck declares a private method `quack()` and uses a private instance variable `noise`.

```java
package pond.duck;

public class BadDuckling {

  public void makeNoise() {
    var duck = new FatherDuck();
    duck.quack(); // DOES NOT COMPILE
    System.out.println(duck.noise); // DOES NOT COMPILE
  }
}
```

BadDuckling is trying to access an instance variable and a method it has no business touching.

It tries to access a private instance variable and a private method, and both generate compiler errors.

Trying to access private members of other classes is not allowed, we have to use a different type of access.

### Package Access

MotherDuck is more accommodating about what her ducklings can do. She allows classes in the same package to access her members. When there's no access modifier, Java assumes package access.

```java
package pond.duck;

public class MotherDuck {
  String noise = "quack";

  void quack() {
    System.out.println(noise);
  }
}
```

```java
package pond.duck;

public class GoodDuckling {
  public void makeNoise() {
    var duck = new MotherDuck();
    duck.quack(); // quack
    System.out.println(duck.noise); // quack
  }
}
```

In the same pond, we have a baby swan and is called a cygnet and decides to learn from MotherDuck as well.

```java
package pond.swan; // another package

public class BadCygnet {
  public void makeNoise() {
    var duck = new MotherDuck();
    duck.quack(); // DOES NOT COMPILE
    System.out.println(duck.noise); // DOES NOT COMPILE
  }
}
```

MotherDuck only allows lessons to other ducks by restricting access to the `pond.duck` package.

### Protected Access

Protected access allows everything that package access does and more. It adds the ability to access members of a parent class. The following example, the "child" ClownFish class is a subclass of the "parent" Fish class.

```java
public class Fish {}

public class ClownFish extends Fish {}
```

By extending a class, the subclass gains access to all protected and public members of the parent class, as if they were declared in the subclass. If the two classes are in the same package, then the subclass also gains access to all package members.

#### Classes used to show protected access

<table>
  <tr>
    <th>Package</th>
    <th>Classes</th>
  </tr>
  <tr>
    <td>pond.shore</td>
    <td>
      <ul>
        <li>Bird</li>
        <li>BirdWatcher</li>
      </ul>
    </td>
  </tr>
  <tr>
    <td>pond.goose</td>
    <td>
      <ul>
        <li>Gosling (extends Bird)</li>
      </ul>
    </td>
  </tr>
  <tr>
    <td>pond.inland</td>
    <td>
      <ul>
        <li>BirdWatcherFromAfar</li>
      </ul>
    </td>
  </tr>
</table>

First, the "parent" class, `Bird`.

```java
package pond.shore;

public class Bird {
  protected String text = "floating";

  protected void floatInWater() {
    System.out.println(text);
  }
}
```

Subclasses:

```java
package pond.goose; // different package than Bird

import pond.shore.Bird;

public class Gosling extends Bird { // Gosling is a subclass of Bird
  public void swim() {
    floatInWater(); // floating
    System.out.println(text); // floating
  }
}
```

This is a simple subclass. It `extends` the Bird class. Extending means creating a subclass that has access to any protected or public members of the parent class.

Protected also gives us access to everything that package access does. This means a class in the same package as Bird can access its protected members.

```java
package pond.shore; // same package as Bird

public class BirdWatcher {
  public void watchBird() {
    Bird bird = new Bird();
    bird.floatInWater(); // floating
    System.out.println(bird.text); // floating
  }
}
```

Since Bird and BirdWatcher are in the same package, BirdWatcher can access package members of the bird variable.

The definition of protected allows access to subclasses and classes in the same package.

Now the same thing from a different package:

```java
package pond.inland; // different package than Bird

import pond.shore.Bird;

public class BirdWatcherFromAfar { // not a subclass of Bird
  public void watchBird() {
    Bird bird = new Bird();
    bird.floatInWater(); // DOES NOT COMPILE
    System.out.println(bird.text); // DOES NOT COMPILE
  }
}
```

BirdWatcherFromAfar is not in the same package as Bird, and it doesn't inherit from Bird, this means it is not allowed to access protected members of Bird.

### Public Access

The public access, means anyone can access the member from anywhere.

```java
package pond.duck;

public class DuckTeacher {
  public String name = "helpful";

  public void swim() {
    System.out.println(name);
  }
}
```

DuckTeacher allows access to any class that wants it.

```java
package pond.goose;

import pond.duck.DuckTeacher;

public class LostDuckling {
  public void swim() {
    var teacher = new DuckTeacher();
    teacher.swim(); // helpful
    System.out.println("Thanks " + teacher.name); // helpful
  }
}
```

LostDuckling is able to refer to `swim()` and `name` on DuckTeacher because they are public.

### Reviewing Access Modifiers

<table>
  <tr>
    <th></th>
    <th>private</th>
    <th>package</th>
    <th>protected</th>
    <th>public</th>
  </tr>
  <tr>
    <th>the same class</th>
    <td>Yes</td>
    <td>Yes</td>
    <td>Yes</td>
    <td>Yes</td>
  </tr>
  <tr>
    <th>another class in the same package</th>
    <td>No</td>
    <td>Yes</td>
    <td>Yes</td>
    <td>Yes</td>
  </tr>
  <tr>
    <th>a subclass in a different package</th>
    <td>No</td>
    <td>No</td>
    <td>Yes</td>
    <td>Yes</td>
  </tr>
  <tr>
    <th>an unrelated class in a different package</th>
    <td>No</td>
    <td>No</td>
    <td>No</td>
    <td>Yes</td>
  </tr>
</table>

## Accessing static Data

When the `static` keyword is applied to a variable, method or class, it belongs to the class rather than a specific instance of the class. Can also be applied to import statements.

### Designing static Methods and Variables

Methods and variables declared static don't require an instance of the class. They are shared among all users of the class.

```java
public class Penguin {
  String name;
  static String nameOfTallestPenguin;
}
```

In this class, every Penguin instance has its own name like, Willy or Lilly, but only one Penguin among all the instances is the tallest.

Think static variable as being member of the single class object. It exists independently of any instances of that class, for example:

```java
public static void main(String[] args) {
  var p1 = new Penguin();
  p1.name = "Lilly";
  p1.nameOfTallestPenguin = "Lilly";

  var p2 = new Penguin();
  p2.name = "Willy";
  p2.nameOfTallestPenguin = "Willy";

  System.out.println(p1.name); // Lilly
  System.out.println(p1.nameOfTallestPenguin); // Willy
  System.out.println(p2.name); // Willy
  System.out.println(p2.nameOfTallestPenguin); // Willy
}
```

Each penguin has its own unique name updated, but the static field is shared between both instances.

We can also define static methods, such as `main()` method. We can call the `main()` method directly from the class.

```java
public class Application {
  public static int count = 0;

  public static void main(String[] args) {
    System.out.println(count);
  }
}
```

The JVM calls `Application.main()` to get the program started.

Static methods have two main purposes:

- For utility or helper methods that don't require any object state. Since there is no need to access instance variables, having static methods eliminates the need for the called to instantiate an object just to call the method
- For state that is shared by all instances of a class, like a counter. All instances must share the same state. Methods that merely use that state should be static as well.

### Class vs. Instance Membership

A static member cannot call an instance member without referencing an instance of the class, since static doesn't require any instances of the class to even exist, for example: [InvalidClassVsInstanceMembership.java](./InvalidClassVsInstanceMembership.java)

```java
public class InvalidClassVsInstanceMembership {
  private String name = "Sammy";

  public static void first() {}

  public void second() {
    System.out.println(name);
  }

  public static void main(String[] args) {
    first();
    second(); // DOES NOT COMPILE
  }
}
```

The compiler will give an error about making a static reference to an instance method.

And fix this by adding static to `second()`, we create a new problem because the variable `name` is an instance variable.

There are two ways we could fix this:

1. Add static to the name variable and method: [FirstExampleClassVsInstanceMembership](./FirstExampleClassVsInstanceMembership.java)
2. Call `second()` as an instance method and not use static for the method or the variable, for example: [SecondExampleClassVsInstanceMembership](./SecondExampleClassVsInstanceMembership.java)

Now suppose we have a Giraffe class:

```java
public class Giraffe {
  public void eat(Giraffe g) {}

  public void drink() {}

  public static void allGiraffeGoHome(Giraffe g) {}

  public static void allGiraffeComeOut() {}
}
```

#### Static vs. Instance calls

Method | Calling | Legal?
--- | --- | ---
`allGiraffeGoHome()` | `allGiraffeComeOut()` | Yes
`allGiraffeGoHome()` | `drink()` | No
`allGiraffeGoHome()` | `g.eat()` | Yes
`eat()` | `allGiraffeComeOut()` | Yes
`eat()` | `drink()` | Yes
`eat()` | `g.eat()` | Yes

### static Variable Modifiers

Static variables can be declared with the same modifiers as instance variables, such as final, transient and volatile.

While some static variables are meant to change as the program runs, like our count example.

Others static variables are meant to never change, this type of static variable is knows as a `constant`. It uses the final modifiers to ensure the variable never changes.

`Constants` use the modifiers `static final` and a different `naming convention` than other variables. They use `all uppercase letters with underscores between "words"`, for example:

```java
public class ZooPen {
  private static final int NUM_BUCKETS = 45;

  public static void main(String[] args) {
    NUM_BUCKETS = 5; // DOES NOT COMPILE
  }
}
```

### static initializers

static initializers look like unnamed methods, we add the static keyword to specify that they should be run when the class is first loaded, for example:

```java
private static final int NUM_SECONDS_PER_MINUTE;
private static final int NUM_MINUTES_PER_HOUR;
private static final int NUM_SECONDS_PER_HOUR;

static {
  NUM_SECONDS_PER_MINUTE = 60;
  NUM_MINUTES_PER_HOUR = 60;
}

static {
  NUM_SECONDS_PER_HOUR = NUM_SECONDS_PER_MINUTE * NUM_MINUTES_PER_HOUR;
}
```

All static initializers run when the class is first used, in the order they are defined.

We just got through saying that final variables aren't allowed to be reassigned. The key here is that the static initializer is the first assignment, and since it occurs up front, it is okay.

#### Try to Avoid static and Instance Initializers

Using static and instance initializers can make our code much harder to read.

But a common case to use a static initializer is when we need to initialize a static field and the code to do so requires more than one line.
