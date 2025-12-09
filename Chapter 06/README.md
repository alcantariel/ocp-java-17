# Class Design

- Utilizing Java Object-Oriented Approach
  - Create classes and records
  - Define and use instance and static fields and methods, constructors, and instance and static initializers
  - Understand variable scopes, use local variable type inference, apply encapsulation, and make object immutable
  - Implement polymorphism and differentiate object type versus reference type. Perform type casting, identify object types using instanceof operator and pattern matching

## Understanding Inheritance

Inheritance is the process by which a subclass automatically includes certain members of the class, including primitives, objects, or methods, defined in the parent class.

We refer to any class that inherits from another class as a `subclass` or `child class`, as it is considered a descendant of that class. Alternatively, we refer to the class that the child inherits from as the `superclass` or `parent class`, as it is considered an ancestor of the class.

When working with other types, like interfaces, we tend to use the general term `subtype` and `supertype`.

### Declaring a Subclass

Example of a superclass, `Mammal`, and subclass `Rhinoceros`:

```java
public class Mammal {} // Superclass

public final class Rhinoceros extends Mammal {} // Subclass
```

1. public or package access
2. final keyword (optional)
3. class keyword
4. class name
5. Extends parent class

We indicate a class is a subclass by declaring it with the `extends` keyword. We don't need to declare anything in the superclass other than making sure it is not marked `final`.

One key aspect of inheritance is that it is transitive. Given three classes [`X`, `Y`, `Z`], if `X extends Y`, and `Y extends Z`, then `X is considered a subclass of Z`. Likewise, `Z is a superclass of X`. We sometimes use the term direct subclass to indicate the class directly extends the parent class, for example: X is a direct subclass only of class Y, not Z.

Related to the access levels: public, protected, package, and private. When one class inherits from a parent class, all public and protected members are automatically available as part of the child class. If the two classes are in the same package, then package members are available as part of the child class. Last but not least, private members are restricted to the class they are defined in, and are never available via inheritance. This does not mean the parent class can't have private members that can hold data or modify an object; it just means the subclass does not have direct access to them.

For example: [SubclassFirstExample.java](./SubclassFirstExample.java)

```java
public class BigCat {
  protected double size;
}

public class Jaguar extends BigCat {
  public Jaguar() {
    size = 10.2;
  }

  public void printDetails() {
    System.out.println(size);
  }
}

public class Spider {
  public void printDetails() {
    System.out.println(size); // DOES NOT COMPILE
  }
}
```

Jaguar is a subclass of BigCat, making BigCat a superclass of Jaguar. In the Jaguar class, size is accessible bacause it is marked as protected. Via inheritance, the Jaguar subclass can read or write size as if were its own member. Contrast this with the Spiper class, which has no access to size since it is not inherited.

### Class Modifiers

Like methods and variables, a class declaration can have various modifiers.

Modifier | Description
--- | ---
final | The class may not be extended
abstract | The class is abstract, may contain abstract methods, and requires a concrete subclass to instantiate
sealed | The class may only be extended by a specific list of classes
non-sealed | A subclass of a sealed class permits potentially unnarmed subclasses
static | Used for static nested classes defined within a class

The final modifier prevents a class from being extended any further. For example:

```java
public final class Rhinoceros extends Mammal {}

public class Clara extends Rhinoceros {} // DOES NOT COMPILE
```

### Single vs. Multiple Inheritance

Java supports single inheritance, by which a class may inherit from only one direct parent class. Also supports multiple levels of inheritance, by which one class may extend another class, which in turn extends another class.

#### Single Inheritance

```
Animal
├── Mammal
│   │
│   ├── Bat
│   └── Tiger
│
└── Bird
    │
    ├── Parrot
    └── Eagle
```

#### Multiple Inheritance

```
Pet <-------┐
Friendly <--┼──── Dog <─── Husky
Animal <----┘           └── Poodle
```

Part of what makes multiple inheritance complicated is determining which parent to inherit values from in case of a conflict. For example, have an object or method defined in all of the parents, which one does the child inherit? There is no natural ordering for parents in this example, which is why Java avoids these issues by `disallowing multiple inheritance altogether`.
