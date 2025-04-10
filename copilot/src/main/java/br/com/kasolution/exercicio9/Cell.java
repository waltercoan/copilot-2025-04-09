package br.com.kasolution.exercicio9;

public class Cell {
    private int row;
    private int col;
    private CellType cellType;

    public Cell(int row, int col, CellType cellType) {
        this.row = row;
        this.col = col;
        this.cellType = cellType;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public CellType getCellType() {
        return cellType;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }
}