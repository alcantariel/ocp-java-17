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
