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

        if (playerTurn.equals("X")) {
            MoveInfo move = recMove(board, "O", moveLoc);
            if (move.getScore() > max.getScore()) {
                max = new MoveInfo(moveLoc, move.getScore());
            }
        } else {
            MoveInfo move = recMove(board, "O", moveLoc);
            if (move.getScore() < min.getScore())
                min = new MoveInfo(moveLoc, move.getScore());
        }
        board.retractPiece(moveLoc);
        if(playerTurn.equals("X"))
          return max;
          else
              return min;

    }
}