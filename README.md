# League Statistics

## Story

### Football League Statistics
A newspaper from your hometown needs someone to create an archive of statistics
from your local backyard soccer league. Since you are very close to the players and fans,
you decided to create a program that provides these statistics at every moment
of the season and in all subsequent seasons.

As the whole history database is being built in parallel by someone else
and you don't want to wait, you got the idea to create a simulation of the season
that generates data that you don't yet have, for testing your program.

## What are you going to learn?

- Use Java 8 Stream API.
- Understand method references.
- Use lambda expressions.
- Understand the practical usage of the Model-View-Controller design pattern.

## Tasks

1. Implement the 'Season' class, where all matches are be played on a peer-to-peer basis using the 'League' team collection.
    - The `playMatch()` method provides the result of a match played between two teams. It increments the `Wins`, `Losts`, or `Draws` value of the teams.
    - The `scoredGoals()` method returns the number of goals scored by a team in one match. The method contains the logic of the scoring chance of each player. The method increments the `Goals` stats of players.
    - The `playAllGames()` method contains the logic of all matches played in one round. Every team has to play a match against every team exactly once.

2. Implement the methods in League Statistics class using Streams.
    - All methods in League Statistics class are public static methods.
    - No loops (while, do-while, for, foreach) are used in League Statistics class.
    - All methods in League Statistics class are single-line return methods, and consist of streams, lambda expressions, and method references. The methods have no braces.

3. Implement the `Display` class with all necessary methods for creating a console view for the league statistics.
    - Methods are implemented for displaying the following.
- A table with name, points, goals, wins, draws, losses columns.
- Single match results.

4. [OPTIONAL] Turn the Player into an abstract class. Create subclasses of Player and new modifier attributes to make match simulation more realistic.
    - Subclasses of `Player`, such as `Attacker`, `Midfielder`, `Defender`, `Goalkeeper` are implemented. New skill rates are created accordingly.
    - More complex logic is used for match results, such as the sum of the chances of Attackers and Midfielders against Defenders and Goalkeepers. Instead of checking score chance for each player, the game is split into attacking and defending rounds. The skill rates of various players are aggregated, depending on their roles. Individual scoring chances are considered. The more realistic simulation – the more fun it is when implemented.

5. [OPTIONAL] Create a new class responsible for keeping all necessary data for single game results. Use the class as a parameter that decides league position instead of goal numbers. Save the results with all season statistics in a .txt file
    - The result class keeps information on the season, teams in the game, goals scored, and goalscorers.
    - Display methods are created for all statistics requested in the `LeagueStatistics` class.
    - A method is implemented for archiving the results and all season statistics in a .txt file.

6. [OPTIONAL] Instead of a simple implementation of `playAllGames()`, implement logic to schedule turns. In each turn, all teams are set up in pairs to play a match. In every turn, the set of pairs is different until the season is fully played.
    - The `playAllGames()` method is overloaded or a new method is created to play all games in the season, using the robin-round algorithm.

## General requirements

None

## Hints

- Start by implementing the `Season` class where the league is simulated.
  `League Statistics` process its properties.
- Manage all randomization through the pre-created static `getRandomValue()` method in `Utils`.
- Start the implementation of the `LeagueStatistics` class with the `getAllTeamsSorted()` method to display the full table after a played season.
- Use the `getTeamWithTheLongestName()` method from `LeagueStatistics` in the `Display` class to set the table border width.


## Background materials

- [Model View Controller](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller)
- [Java Streams Introduction](https://www.baeldung.com/java-8-streams-introduction)
- [Java 8 Stream API documentation](https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html)
- [Streams with examples](https://stackify.com/streams-guide-java-8/)
- [Lambda Expressions](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)
- [Method References](https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html)
- [Random Vs ThreadLocalRandom](https://stackoverflow.com/questions/23396033/random-over-threadlocalrandom)

