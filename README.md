# Cinema Room Manager

## Learning outcome
This project is a good opportunity to work with input and output in Kotlin. You will deal with multi-dimensional arrays and functions as well as loops and conditional statements. This project is a part of the following track: [Kotlin Developer](https://hyperskill.org/tracks/3).

## Objectives
- You need to read two positive integer numbers from the input: the `number of rows` and the `number of seats` in each row. The `ticket price` is determined by the following rules:
  - If the total number of seats in the screen room is not more than 60, then the price of each ticket is 10 dollars.
  - In a larger room, the tickets are 10 dollars for the front half of the rows and 8 dollars for the back half. Please note that the number of rows can be odd, for example, 9 rows. In this case, the first half is the first 4 rows, and the second half is the rest 5 rows.
- Then, read two integer numbers from the input: a `row number` and a `seat number` in that row. These numbers represent the coordinates of the seat according to which the program should print the ticket price. After that, the program should print out all the seats in the screen room and mark the chosen seat by the 'B' symbol.
- Then it should print a menu with the following three items (read the integer numbers as options):
  - [1]. Show the seats
  - [2]. Buy a ticket
  - [3]. Statistics
  - [0]. Exit
- When the item **Statistics** is chosen, your program should print the following information:
  - The number of purchased tickets;
  - The number of purchased tickets represented as a percentage. Percentages should be rounded to 2 decimal places;
  - Current income;
  - The total income that shows how much money the theatre will get if all the tickets are sold.
- If a user chooses an already taken seat, print *That ticket has already been purchased!*
- You shouldn't allow coordinates that are out of bounds. If this happens, print *Wrong input!*
