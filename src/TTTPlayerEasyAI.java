import java.util.ArrayList;
import java.util.Random;

public class TTTPlayerEasyAI extends Player {

    private Random r = new Random();
    private String otherPlayer = "";

    /**
     * Constucts a new TTTPlayerEasyAI
     * @param name
     */
    public TTTPlayerEasyAI(String name){
        super(name);
        if (name.equals("X")){
            this.otherPlayer = "O";
        }
        else{
            this.otherPlayer = "X";
        }
    }

    /**
     * Return the move location for the player
     * @param board the game board
     * @return the move location for the player
     */
    public String getMove(Board board) {
        ArrayList locs = board.getEmptyLocs();
        for (Object loc: locs){
            String move = loc.toString();
            board.placePiece(move, name);
            if (board.isWinner(name)){
                board.retractPiece(move);
                System.out.println("AI " + name + " Moved to: " + move);
                return move;
            }
            else if (!board.isWinner(name)){
                board.retractPiece(move);
                board.placePiece(move, otherPlayer);
                if (board.isWinner(otherPlayer)){
                    board.retractPiece(move);
                    System.out.println("AI " + name + " Moved to: " + move);
                    return move;
                }
                else{
                    board.retractPiece(move);
                }
            }
        }
        String move = locs.get(r.nextInt(locs.size())).toString();
        System.out.println("AI " + name + " Moved to: " + move);
        return move;
    }
}
