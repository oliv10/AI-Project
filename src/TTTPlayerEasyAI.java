import java.util.ArrayList;
import java.util.Random;

public class TTTPlayerEasyAI extends Player {

    /**
     * Constucts a new TTTPlayerEasyAI
     * @param name
     */
    public TTTPlayerEasyAI(String name){
        super(name);
    }

    /**
     * Return the move location for the player
     * @param board the game board
     * @return the move location for the player
     */
    public String getMove(Board board) {
        Random random = new Random();
        ArrayList empty = board.getEmptyLocs();
        return (String) empty.get(random.nextInt(empty.size()));
    }
}
