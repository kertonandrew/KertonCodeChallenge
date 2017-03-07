#Robot Movement

##Setup and run

1.	Ensure the your java environment is setup (you have access to javac). If you don't have the JDK installed, head to the [installation page](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html) and follow the instructions.
2.	Navigate to the root of the project and run ```javac *.java``` to compile the java source.
3.	Run ```java RobotMovement``` to run the program. You will be prompted for input.
4.	Have fun :)

##Testing
**It is assumed the test file ends with "q" or "quit" to close the program.**

-	After compilation of the program (Refer to "Setup and run"), simply run the program with the file path of the test data file.
-	The file "test" has been provided so run ```java RobotMovement test``` to execute the tests in the file.

##Ideas

### Robot and Table class
This approach makes more sense from a software perspective. 

- It is more scalable and makes querying the table for positions of robots for reporting easier.
- Robots can query the table for positions of other robots ot avoid collisions.
- "storing" the robots on(in) the table makes more sense.

### Autonomous Robot - Winner!
This approach makes more sense conceptually - a Robot should be self sufficient

- Less complexcity
- Construct robot with table parameters - table can change size if required.

