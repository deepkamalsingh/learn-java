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

