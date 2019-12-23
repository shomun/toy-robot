# Toy Robot

# Solution
* A Robot class is implemented with minimum feature(turn left/right). If a robot is not placed on a board, none of the functionality work on Robot.
* A Board can be created with row/col configuration.   
* Each Instruction is implemented as a command .

* The application can support 2 mode of execution,
  * Console 
  * File
 
But current implementation,  executes only in  console mode, but new Executor can be implemented to provide both option to the user and user can select any particular option.


**Following are few important components:**  
**Game Class** - Initializes and manage the application.

**GameContext Class** - Holds the current context.

**AbstractTurtle Class** - Is the base class for turtle, it contains basic functionality.

# Enhancement
* New types of Robot can be created with additional functionality such as  move 2 step forward, rotate 180 degree and so on.


# How to run
Gradle is required to build the solution. It is assumed gradle is available. Run the following gradle command
```
gradlew clean buildJar
```
it will build an executable jar at /build/libs folder. Run the jar as follows,
```
java -jartoy-robot-1.0-SNAPSHOT.jar 
```
