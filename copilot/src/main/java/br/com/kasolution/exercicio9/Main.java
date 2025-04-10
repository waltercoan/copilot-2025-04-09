package br.com.kasolution.exercicio9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Snake Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 800);

            Game game = new Game(20, 20); // Tabuleiro 20x20
            GamePanel gamePanel = new GamePanel(game);
            frame.add(gamePanel);

            frame.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_UP -> {
                            if (game.getSnake().getDirection() != Direction.DOWN) {
                                game.getSnake().setDirection(Direction.UP);
                            }
                        }
                        case KeyEvent.VK_DOWN -> {
                            if (game.getSnake().getDirection() != Direction.UP) {
                                game.getSnake().setDirection(Direction.DOWN);
                            }
                        }
                        case KeyEvent.VK_LEFT -> {
                            if (game.getSnake().getDirection() != Direction.RIGHT) {
                                game.getSnake().setDirection(Direction.LEFT);
                            }
                        }
                        case KeyEvent.VK_RIGHT -> {
                            if (game.getSnake().getDirection() != Direction.LEFT) {
                                game.getSnake().setDirection(Direction.RIGHT);
                            }
                        }
                    }
                }
            });

            frame.setVisible(true);

            // Loop do jogo
            new Timer(100, e -> {
                game.update();
                gamePanel.repaint();
            }).start();
        });
    }
}

class GamePanel extends JPanel {
    private final Game game;

    public GamePanel(Game game) {
        this.game = game;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Board board = game.getBoard();
        Cell[][] grid = board.getGrid();

        int cellSize = Math.min(getWidth() / grid.length, getHeight() / grid[0].length);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                Cell cell = grid[i][j];
                switch (cell.getCellType()) {
                    case EMPTY -> g.setColor(Color.WHITE);
                    case FOOD -> g.setColor(Color.RED);
                    case SNAKE_NODE -> g.setColor(Color.GREEN);
                }
                g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
                g.setColor(Color.BLACK);
                g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize);
            }
        }
    }
}
