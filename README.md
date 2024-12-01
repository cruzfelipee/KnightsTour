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
You can change it at line 3 of ``App.java`` to only allow open laps (default false).
Note that this greatly reduces the amount of possible boards, making it impractical to solve for a board bigger than 6x6.

The code also uses a constant variable called ``SIZE`` to determine the size of the board that is being explored.
You can change it at line 4 of ``App.java`` to change the size of the board (default 8).

## Output

The code is expected to print the solutions it finds during the execution.
It should also print the number of geometrically distincts solutions and the time it took to find them at the end of the execution.

The following solution starts with the knight at position [0 0], then moving to position [1 2], [4 4] and so on.

```
1  8  21 12 35 10
14 29 36 9  20 23
7  2  13 22 11 34
28 15 30 3  24 19
31 6  17 26 33 4
16 27 32 5  18 25
```
