package br.com.kasolution.exercicio9;

import java.util.LinkedList;

public class Snake {
    private LinkedList<Cell> body;
    private Direction direction;

    public Snake(Cell initialPosition) {
        body = new LinkedList<>();
        body.add(initialPosition);
        direction = Direction.RIGHT; // Direção inicial
    }

    public LinkedList<Cell> getBody() {
        return body;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void grow(Cell newCell) {
        body.addFirst(newCell);
    }

    public void move(Cell newCell) {
        body.addFirst(newCell);
        body.removeLast();
    }
}