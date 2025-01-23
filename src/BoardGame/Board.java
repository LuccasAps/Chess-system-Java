package BoardGame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new IllegalArgumentException("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column) {
        if(!positionExsists(row, column)) {
            throw new IllegalArgumentException("Position not on the board");
        }
        return pieces[row][column];
    }
    public Piece piece(Position position) {
        if(!positionExsists(position)) {
            throw new IllegalArgumentException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }
    public void placePiece(Piece piece, Position position) {
        if(thereIsaAPiece(position)) {
            throw new IllegalArgumentException("there is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    private boolean positionExsists (int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExsists(Position position) {
        return positionExsists(position.getRow(), position.getColumn());
    }

    public boolean thereIsaAPiece(Position position) {
        if(!positionExsists(position)) {
            throw new IllegalArgumentException("Position not on the board");
        }
        return piece(position) != null;
    }
}
