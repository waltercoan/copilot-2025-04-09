package br.com.kasolution.exercicio9;

import javax.swing.JOptionPane;

public class Game {
    private Board board;
    private Snake snake;

    public Game(int rows, int cols) {
        board = new Board(rows, cols);
        snake = new Snake(board.getGrid()[rows / 2][cols / 2]);
        board.generateFood();
    }

    public void update() {
        Snake snake = getSnake();
        Cell head = snake.getBody().getFirst();
        int newRow = head.getRow();
        int newCol = head.getCol();

        switch (snake.getDirection()) {
            case UP -> newRow--;
            case DOWN -> newRow++;
            case LEFT -> newCol--;
            case RIGHT -> newCol++;
        }

        // Verifica colisões com bordas ou com o próprio corpo
        if (newRow < 0 || newRow >= board.getGrid().length || newCol < 0 || newCol >= board.getGrid()[0].length ||
            board.getGrid()[newRow][newCol].getCellType() == CellType.SNAKE_NODE) {
            // Fim de jogo
            JOptionPane.showMessageDialog(null, "Game Over!");
            System.exit(0);
        }

        Cell nextCell = board.getGrid()[newRow][newCol];

        if (nextCell.getCellType() == CellType.FOOD) {
            snake.grow(nextCell);
            board.generateFood();
        } else {
            snake.move(nextCell);
        }

        // Atualiza o tipo das células
        for (Cell cell : snake.getBody()) {
            cell.setCellType(CellType.SNAKE_NODE);
        }
        head.setCellType(CellType.EMPTY);
    }

    public Board getBoard() {
        return board;
    }

    public Snake getSnake() {
        return snake;
    }
}