import java.util.ArrayList;

public class TTTPlayerProAI extends Player {

    /**
     * Constucts a new TTTPlayerProAI
     * @param name
     */
    public TTTPlayerProAI(String name) {
        super(name);
    }

    /**
     * Return the move location for the player
     * @param board the game board
     * @return the move location for the player
     */
    public String getMove(Board board) {
        MoveInfo mi = recMove( (TTTBoard) board, this.name, "");
        //System.out.println(mi.getLoc());
        return mi.getLoc();
    }

    /**
     * Performs the MinMax algorithm to determine the
     * move of this AI player.
     * @param board the game board
     * @param playerTurn the player moving
     * @return the MoveInfo for the move
     */
    private MoveInfo recMove(TTTBoard board, String playerTurn, String moveLoc) {
        MoveInfo max = new MoveInfo(moveLoc, -10);
        MoveInfo min = new MoveInfo(moveLoc, 10);
        ArrayList<String> locs = board.getEmptyLocs();
        if(board.isWinner("O")){
            //System.out.println("O wins");
            return new MoveInfo(moveLoc, 10);
        }
        else if(board.isWinner("X")){
            //System.out.println("X wins");
            return new MoveInfo(moveLoc, -10);
        }
        if(locs.size() == 0){
            //System.out.println("cats game");
            return new MoveInfo(moveLoc, 0);
        }

        for(int i=0; i< locs.size(); i++) {
            board.placePiece(locs.get(i),playerTurn);
            if (playerTurn.equals("O")) { //Is this sufficient to check if this is the right turn?
                MoveInfo move = recMove(board, "X", locs.get(i)); //Should this be X?
               if (move.getScore() > max.getScore()) {
                   max = new MoveInfo(locs.get(i), move.getScore());
              }
              //playerTurn = "X";
        }
        else {
            MoveInfo move = recMove(board, "O", locs.get(i)); //Should this be O?
            if (move.getScore() < min.getScore()) {
                min = new MoveInfo(locs.get(i), move.getScore());
            }
               //playerTurn = "O";
        }
        board.retractPiece(locs.get(i));
        //ends here
    }
        if(playerTurn.equals("O")) {
            return max;
        }
        else {
            return min;
        }

    }
}