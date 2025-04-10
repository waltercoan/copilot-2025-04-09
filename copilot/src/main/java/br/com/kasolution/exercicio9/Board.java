package br.com.kasolution.exercicio9;

import java.util.Random;

public class Board {
    private int rows;
    private int cols;
    private Cell[][] grid;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        grid = new Cell[rows][cols];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new Cell(i, j, CellType.EMPTY);
            }
        }
    }

    public Cell generateFood() {
        Random random = new Random();
        int row, col;
        do {
            row = random.nextInt(rows);
            col = random.nextInt(cols);
        } while (grid[row][col].getCellType() != CellType.EMPTY);
        grid[row][col].setCellType(CellType.FOOD);
        return grid[row][col];
    }

    public Cell[][] getGrid() {
        return grid;
    }
}