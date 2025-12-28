# Basics

## Java file structure
- public class name == file name
    - You can have 0 or 1 public class per `.java` file.
    - This is required because java is designed to be stricty organized and makes it easier for tools/compilers to find things.
    - Their are 4 access levels to java from most restrictive to least restrictive.
        | access level  | same class | same package | sub class | world |
        | ------------- |:-------------:|:-------------:|:-------------:|:-------------:|
        | private      |    Y | N | N     | N   |
        | default / no modifier (package-private)      |   Y  | Y | N     | N  |
        | protected      | Y    | Y | Y     | N   |
        | public     |  Y    | Y |  Y   | Y   |  
    - what defines package in java ?
        - package is like a namespace, you define it at the top of the file with the `package` keyword. 

## How java compiles
- commands to compile java:
    - `javac filename.java` will compile the java file and create a class file with the same name as the class name.
    - `java filename` will run the java file.
    - java collections is similar to c++ STL.
    
    
## Java Collections
- Lists
    - ArrayList
    - LinkedList  
- Sets 
    - HashSet 
        - HashMap in disguise.
        - Ordering is unpredictable.
    - LinkedHashSet
        - HashMap + A Doubly Linked List.
    - TreeSet 
        - does not use hashing instead uses balanced binary search tree.
- Queues & Deques
    - PriorityQueue
    - ArrayDeque 
- Maps 
    - HashMap 
        - Syntax: 
        ```
        HashMap<KeyType, ValueType> myMap = new HashMap<>();
        myMap.put("key", "value");
        System.out.println(myMap.get("key"));
        ```
        - Internally, each key is hashed to an index in the array. 
        If multiple keys hash to the same index, a linked list is used to store the values. 
        in newer versions of java, linked list is replaced with a Red-Black Tree.

        - As we add more and more keys, the hashmap will resize the array and rehash the keys, their is a load factor  
        - The load factor is 0.75 by default, which means that the hashmap will resize the array when 75% of the array is full.
    - LinkedHashMap
    - TreeMap 

## Memory storage
- Stack and heap
    - Stack Memory (The "Work Desk"):
        - immediate, temporary tasks.
        - Java handles method execution here, java creates a stack frame and place it on top of stack. Follows LIFO.
        - stack stores Local Primitives: int, double, boolean, etc and Object References.
        - No Garbage Collector is needed here.
        - Each thread in Java has its own private stack. Thread A cannot see variables in Thread B's stack.
        - StackOverflowError (Recursion)
    - Heap (The "Warehouse"):
        - long-term, large-scale storage.
        - The Heap is a giant pool of memory used for dynamic allocation, all objects in Java live here..
        - It stores:
            - All Objects: Any time you use the new keyword (e.g., `new HashMap()`), it goes here.
            - Instance Variables: If a class has a field like int age, and that class is instantiated as an object, that age lives in the heap inside the object.  
        - Garbage Collector (GC) periodically scans the heap to find objects that no longer have a "reference" pointing to them and deletes them.
        - The heap is shared by all threads. If Thread A and Thread B both have a reference to the same object, they can both modify it (this is why we need "thread-safety").
        - OutOfMemoryError (Heap full)

- Primitives vs. Objects
    - Primitives are lightweight e.x int, stored directly where they are defined or on stack. 
    - Objects are heavyweight (Header + Data + Padding + Reference) e.x. Integer, stored on heap.
    - primitives (`int`) should be your default choice.
    - when to use objects (`Integer`)
        - Collections e.x. `Map<Integer, Integer>`.
        - representing null value.

- Why `ArrayList<Integer>` instead of `ArrayList<int>` ?
    - Type Erasure:
        - It enforces type safety at compile time, but strictly removes (erases) all type information at runtime.
        - Since `ArrayList` excepts an `Object` we need to use `Integer` instead of `int`.
    - Autoboxing:
        - `list.add(5);` // Looks like a primitive
        - `list.add(Integer.valueOf(5));` // Converts primitive 5 into an Object on the Heap
    - Boxed Overhead:
    - Real-world impact: If you are processing a list of 10 million numbers:
        - int[] uses ~40 MB of RAM.
        - `ArrayList<Integer>` uses ~200 MB+ of RAM and causes millions of tiny object allocations.
    - C++ can store integers directly in a map because the compiler writes a custom version of that map just for integers.
        - Java: Type Erasure: One class to rule them all.
        - C++: Monomorphization: Generate a class for every type.
    - For java we don't have this hence we have **The "One Size Fits All" Problem** so we need define objects instead of generics.
    - Trove, fastutil, or Eclipse Collections provoide collections like IntIntMap.
    - Project Valhalla

- Typing in Java:
    - Strongly and Statically Typed
    - Type Safety:
        - 
        ```py
        x = 5
        x = "Hello" # Fine in Python
        ```
        ```java
        int x = 5;
        x = "Hello"; // Compiler Error: Incompatible types
        ```
    - Reflection and type casting:
        ```
        List<String> names = new ArrayList<>();
        List rawList = names; // Dropping the generic type
        rawList.add(100);     // The JVM allows this!
        ```
        But if you try `String s = names.get(0);` it raises error.