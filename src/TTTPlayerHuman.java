import java.util.Scanner;

public class TTTPlayerHuman extends Player {

    private Scanner in = new Scanner(System.in);

    public TTTPlayerHuman(String name){
        super(name);
    }

    @Override
    public String getMove(Board board) {
        System.out.print(name + " Place Piece (1-9): ");
        return in.next();
    }
}
// TTTgame = new TTT(new TTTPlayerHuman