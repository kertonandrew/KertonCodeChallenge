#Robot Movement

##Ideas

### Robot and Table class
This approach makes more sense from a software perspective. 

- It is more scalable and makes querying the table for positions of robots for reporting easier.
- Robots can query the table for positions of other robots ot avoid collisions.
- "storing" the robots on(in) the table makes more sense.

### Autonomous Robot
This approach makes more sense conceptually - a Robot should be self sufficient

- Less complexcity
- Construct robot with table parameters - table can change size if required.

