# Minesweeper Game

A console-based Java implementation of the classic Minesweeper game.

## Demo & Snippets

Live demo: Not applicable – runs in local terminal

Screenshots:
(Optional – you could include a screenshot of the console while running the game.)

## Requirements / Purpose

This project is a terminal-based version of the classic Minesweeper game. It challenges users to uncover all the non-mine tiles in a grid by selecting coordinates, while avoiding hidden mines. The grid is updated in real-time in the console, and numbers are color-coded based on the count of surrounding mines.

### MVP

- Console-based Minesweeper experience
- Prompt user for tile coordinates
- Redraw grid with updated state after each move
- Numbered tiles showing how many adjacent mines
- Game ends when mine is hit or all safe tiles are revealed

### Stack Used & Why
- **Language:** Java
- **Why:** Java provides a strong foundation for building logic-heavy, object-oriented games like Minesweeper. A console application removes UI complexity and keeps the focus on game mechanics.

#Build Steps
```bash 
# Clone the repo
git clone https://github.com/AmeliaJarrad/Minesweeper.git
cd Minesweeper

# Compile the code
javac Minesweeper.java

# Run the game
java Minesweeper


If your entry point class has a different name (e.g. Main.java), adjust accordingly.
``` 
## Design Goals / Approach

- Keep it simple: all interactions happen in the terminal
- Redraw the grid after each user move
- Provide clear visual feedback with color-coded numbers
- Avoid overly complex game logic — no difficulty settings or flagging (yet)
- Lay the groundwork for future enhancements like difficulty, GUI, or flagging

## Features

✅ Console input for row/column coordinates

✅ Grid redraw after each move

✅ Color-coded numbers based on surrounding mines

✅ Game over on hitting a mine

✅ Win condition when all safe tiles are revealed

## Automated Test (check if I have)

## Known Issues

⚠ No support for difficulty levels (e.g. board size or number of mines)

⚠ No flagging mechanic for suspected mines

⚠ User input is not validated for out-of-bounds or invalid formats - not sure this is true !!!

⚠ No persistent game state / save functionality

## Future Goals

Add difficulty levels (easy/medium/hard with different grid sizes)

Implement flagging system for suspected mines

Add input validation and better error handling

Build a GUI version with JavaFX or Swing

Add unit tests for game logic

## Change Logs

2025‑09‑18

Initial version of the game completed

Grid redraw working with coordinate input

Added color-coding for numbers

## What did you struggle with?

Designing a clear way to redraw the grid in console while showing current state

Mapping user input to correct grid coordinates

Managing game state and detecting win/loss conditions cleanly

## Licensing Details

This project is licensed under the MIT License. See the LICENSE
 file for more details.

## Further Details & Related Projects

This is a self-contained Java application

Potential to reimplement this as a web version in React or JavaScript, or create a GUI version in JavaFX
