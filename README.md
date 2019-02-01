# Software Engineer Challenge

**Note:** If you make a public fork of this repo please don't push the solution into the fork

## Question 1

### Challenge A

Write code to set 100K records in redis as fast as possible (generating a Redis protocol file is not accepted).
 - This operation should repeat every 1 minute
 - Your code will be benchmarked against a redis instance in a different continent than where your application will run
 - A nonoptimal solution is provided in [this file](src/main/java/com/uken/platform/interview/problem1/RedisService.java)

### Challenge B

Write code that maximizes the throughput of writing key value pairs to Redis.

 - A nonoptimal solution is provided in [this file](src/main/java/com/uken/platform/interview/problem2/RedisController.java). This solution will hit a max throughput (e.g.: 2K requests per second) that is not optimal. If the communication between the application and redis is understood and bottlenecks are identified a different solution could be devised that would increase throughput on the same hardware.
 - Throughput can be measured by using a command such as `wrk -c 20 -d 5 -t 2 http://host:8080/pair/key/value`. You will probably need to tweak these values
 - Your code will be benchmarked against a redis instance in a different continent than where your application will run

#### Notes ####
- Challenge A and Challenge B are sharing the same repo for convenience but they are independent Challenges.
- Write a short explanation of why your solution improves on the provided sample solutions.
- You can use different frameworks to solve the problems, but scripted solutions (e.g.: Bash script that generates redis protocol file for mass insertion) will not be accepted.
- We are not looking for infrastructure related solutions (e.g.: Adding more hardware, changing redis server location and etc).

#### Bonus ####
- Make a docker image with your solution

## Question 2

What is the maximum number of players to ever be in a bingo hall at the same time?

The interactions between the players and the bingo hall are captured in a text log file. Each line of the file contains one of 2 types of event names(JOIN or LEAVE) followed by a timestamp which represent seconds since Unix epoch time.
If a JOIN and a LEAVE events have the same timestamp it is considered that the JOIN event happened first.

Here is an example of input for a player who was in the Bingo hall for 1 minute (60 seconds). In this example the correct value sent to Standard Output should be 1.

```
JOIN 100
LEAVE 160
```

Note that the above is a minimalistic example that doesn't cover all the possible scenarios, your code will be tested against larger log files.

**Your program should take a text file as input via arguments or via standard input in the format described above and the output should be a single number which is the answer for the given input.**

## Question 3

Imagine a massively multiplayer RPG.  The most popular feature is a battle arena.  When a user enters the arena, a list of 10 other users are presented based on certain conditions.  Most importantly, the list must have users within a similar hero level (level), and they also must be alive (health>0).  Note: the health value changes frequently.

How would you store this information to ensure less than 10 ms (single digit) response times even with 100 million user in the database and 100,000 players online at any given time?
