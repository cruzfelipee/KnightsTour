# Knight's Tour

The Knight's Tour is a sequence of knight moves on a chess board which visits every square only once.
The tour is considered closed if the knight ends on the square they started, otherwise, it is considered open.

## The Solution

This algorithm uses a backtracking solution to find all geometrically distinct solutions.
Starting at the first square it then proceeds to explore all 8 possible knight moves nearby recursively.
If the solving function finds itself outside of the board, or on a square that was already visited, it backtracks.

## Executing the code

To run the code simply execute

```
javac App.java
java App
```

The code uses a constant variable called ``CLOSED_LAP`` to determine whether or not it considers open laps as valid solutions.
You can change it at line 4 of ``App.java`` to allow open laps (default true).

The code also uses a constant variable called ``SIZE`` to determine the size of the board that is being explored.
You can change it at line 5 of ``App.java`` to change the size of the board (default 5).

## Output

The code is expected to print the solutions it finds during the execution.
It should also print the number of geometrically distincts solutions and the time it took to find them at the end of the execution.
