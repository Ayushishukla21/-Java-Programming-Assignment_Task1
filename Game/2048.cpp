// @Filename-2048.cpp
// @Description-This C++ program implements a simplified console-based version of the popular puzzle game “2048".
// @Author-Ayushi Shukla
#include <iostream>
#include <cstdlib>
#include <ctime>
#include <iomanip>
#include <conio.h>

using namespace std;

const int GRID_SIZE = 4;        // 4x4 grid for the 2048 game
int grid[GRID_SIZE][GRID_SIZE]; // game board

// Function Prototypes

void initializeGrid();
void addRandomTile();
void printGrid();
bool slideLeft();
void rotateGrid();
bool moveTiles(int keyCode);
bool isGameOver();

// Function Implementations

/**
 * Initializes the game grid by setting all cells to 0 (empty).
 */
void initializeGrid()
{
    for (int i = 0; i < GRID_SIZE; ++i)
        for (int j = 0; j < GRID_SIZE; ++j)
            grid[i][j] = 0;
}

/**
 * Adds a random tile (2 or 4) to a random empty cell in the grid.
 */
void addRandomTile()
{
    int emptyCells[GRID_SIZE * GRID_SIZE][2];
    int emptyCount = 0;

    // Collect all empty cell positions
    for (int i = 0; i < GRID_SIZE; ++i)
    {
        for (int j = 0; j < GRID_SIZE; ++j)
        {
            if (grid[i][j] == 0)
            {
                emptyCells[emptyCount][0] = i;
                emptyCells[emptyCount][1] = j;
                ++emptyCount;
            }
        }
    }

    // If there are empty cells, place a new tile randomly
    if (emptyCount > 0)
    {
        int randomIndex = rand() % emptyCount;
        int x = emptyCells[randomIndex][0];
        int y = emptyCells[randomIndex][1];
        grid[x][y] = (rand() % 2 + 1) * 2; // generates 2 or 4
    }
}

/**
 * Prints the current grid to the console.
 * Empty cells are shown as dots for clarity.
 */
void printGrid()
{
    cout << "\n";
    for (int i = 0; i < GRID_SIZE; ++i)
    {
        for (int j = 0; j < GRID_SIZE; ++j)
        {
            if (grid[i][j] == 0)
                cout << setw(5) << ".";
            else
                cout << setw(5) << grid[i][j];
        }
        cout << "\n\n";
    }
}

/**
 * Slides all tiles to the left, merging equal adjacent tiles.
 * Returns true if any tile moved or merged, false otherwise.
 */
bool slideLeft()
{
    bool moved = false;

    for (int i = 0; i < GRID_SIZE; ++i)
    {
        int mergedRow[GRID_SIZE] = {0};
        int targetIndex = 0;

        for (int j = 0; j < GRID_SIZE; ++j)
        {
            if (grid[i][j] != 0)
            {
                if (mergedRow[targetIndex] == 0)
                {
                    // Move tile to empty spot
                    mergedRow[targetIndex] = grid[i][j];
                }
                else if (mergedRow[targetIndex] == grid[i][j])
                {
                    // Merge same-value tiles
                    mergedRow[targetIndex++] *= 2;
                    moved = true;
                }
                else
                {
                    // Move tile to next position
                    mergedRow[++targetIndex] = grid[i][j];
                }
                if (j != targetIndex)
                    moved = true;
            }
        }

        // Update the original row
        for (int j = 0; j < GRID_SIZE; ++j)
            grid[i][j] = mergedRow[j];
    }

    return moved;
}

/**
 * Rotates the grid 90 degrees clockwise.
 * Used to handle moves in directions other than left.
 */
void rotateGrid()
{
    int temp[GRID_SIZE][GRID_SIZE];
    for (int i = 0; i < GRID_SIZE; ++i)
        for (int j = 0; j < GRID_SIZE; ++j)
            temp[j][GRID_SIZE - 1 - i] = grid[i][j];

    for (int i = 0; i < GRID_SIZE; ++i)
        for (int j = 0; j < GRID_SIZE; ++j)
            grid[i][j] = temp[i][j];
}

/**
 * Handles movement based on the pressed arrow key.
 * Rotates the grid appropriately so all moves can reuse slideLeft().
 */
bool moveTiles(int keyCode)
{
    bool moved = false;

    switch (keyCode)
    {
    case 72: // Up Arrow
        rotateGrid();
        rotateGrid();
        rotateGrid(); // Rotate 270°
        moved = slideLeft();
        rotateGrid(); // Rotate back
        break;
    case 80:          // Down Arrow
        rotateGrid(); // Rotate 90°
        moved = slideLeft();
        rotateGrid();
        rotateGrid();
        rotateGrid(); // Rotate back 270°
        break;
    case 75: // Left Arrow
        moved = slideLeft();
        break;
    case 77: // Right Arrow
        rotateGrid();
        rotateGrid(); // Rotate 180°
        moved = slideLeft();
        rotateGrid();
        rotateGrid(); // Rotate back 180°
        break;
    }

    return moved;
}

/**
 * Checks if there are no possible moves left (game over).
 * Returns true if the game is over, false otherwise.
 */
bool isGameOver()
{
    // If any empty cell exists → game continues
    for (int i = 0; i < GRID_SIZE; ++i)
        for (int j = 0; j < GRID_SIZE; ++j)
            if (grid[i][j] == 0)
                return false;

    // Check horizontal adjacent equal tiles
    for (int i = 0; i < GRID_SIZE; ++i)
        for (int j = 0; j < GRID_SIZE - 1; ++j)
            if (grid[i][j] == grid[i][j + 1])
                return false;

    // Check vertical adjacent equal tiles
    for (int j = 0; j < GRID_SIZE; ++j)
        for (int i = 0; i < GRID_SIZE - 1; ++i)
            if (grid[i][j] == grid[i + 1][j])
                return false;

    return true; // No moves left
}

/**
 * Entry point: initializes game, handles user input, and runs the game loop.
 */
int main()
{
    srand(static_cast<unsigned int>(time(nullptr)));

    initializeGrid();
    addRandomTile();
    addRandomTile();
    printGrid();

    cout << "Welcome to 2048!\nUse arrow keys to move tiles.\n\n";

    // Main Game Loop
    while (true)
    {
        int ch = _getch(); // Wait for key press

        if (ch == 224)
        { // Arrow keys come in two parts
            int arrowKey = _getch();

            if (moveTiles(arrowKey))
            {
                addRandomTile();
                printGrid();
            }
            else
            {
                cout << "No tiles moved. Try another direction.\n";
            }
        }

        if (isGameOver())
        {
            cout << "\nGame Over! No more moves available.\n";
            break;
        }
    }

    return 0;
}
