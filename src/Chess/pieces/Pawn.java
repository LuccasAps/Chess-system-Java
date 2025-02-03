package Chess.pieces;

import BoardGame.Board;
import BoardGame.Position;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.Color;

public class Pawn extends ChessPiece {

        private ChessMatch chessMatch;

        public Pawn(Board board, Color color, ChessMatch chessMatch) {
            super(board, color);
            this.chessMatch = chessMatch;
        }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat  = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        if(getColor() == Color.WHITE){
            p.setValues(position.getRow() - 1, position.getColumn());
            if(getBoard().positionExsists(p) && !getBoard().thereIsAPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() - 2, position.getColumn());
            Position p2 = new Position(position.getRow() - 1, position.getColumn());
            if(getBoard().positionExsists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExsists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() - 1, position.getColumn() - 1);
            if(getBoard().positionExsists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() - 1, position.getColumn() + 1);
            if(getBoard().positionExsists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }

            // #special move en passant white

            if(position.getRow() == 3){
                Position left = new Position(position.getRow(), position.getColumn() - 1);
                if(getBoard().positionExsists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()){
                    mat[left.getRow() - 1][left.getColumn()] = true;
                }
                Position rigth = new Position(position.getRow(), position.getColumn() + 1);
                if(getBoard().positionExsists(rigth) && isThereOpponentPiece(rigth) && getBoard().piece(rigth) == chessMatch.getEnPassantVulnerable()){
                    mat[rigth.getRow() - 1][rigth.getColumn()] = true;
                }
            }
        }
        else {
            p.setValues(position.getRow() + 1, position.getColumn());
            if(getBoard().positionExsists(p) && !getBoard().thereIsAPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() + 2, position.getColumn());
            Position p2 = new Position(position.getRow() + 1, position.getColumn());
            if(getBoard().positionExsists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExsists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() + 1, position.getColumn() - 1);
            if(getBoard().positionExsists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() + 1, position.getColumn() + 1);
            if(getBoard().positionExsists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            // #special move en passant black

            if(position.getRow() == 4){
                Position left = new Position(position.getRow(), position.getColumn() - 1);
                if(getBoard().positionExsists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()){
                    mat[left.getRow() + 1][left.getColumn()] = true;
                }
                Position rigth = new Position(position.getRow(), position.getColumn() + 1);
                if(getBoard().positionExsists(rigth) && isThereOpponentPiece(rigth) && getBoard().piece(rigth) == chessMatch.getEnPassantVulnerable()){
                    mat[rigth.getRow() + 1][rigth.getColumn()] = true;
                }
            }
        }

        return mat;
    }

    @Override
    public String toString(){
        return "P";
    }
}
