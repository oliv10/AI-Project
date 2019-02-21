import java.util.Random;

public class C4PlayerEasyAI extends Player {

    private Random r = new Random();
    private String otherPlayer = "";

    public C4PlayerEasyAI(String name){
        super(name);
        if (name.equals("R")){
            this.otherPlayer = "Y";
        }
        else{
            this.otherPlayer = "R";
        }
    }

    public String getMove(Board board){
        for (int loc = 1; loc < 7; loc++){
            String move = Integer.toString(loc);
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
        String move = Integer.toString(r.nextInt(7)+1);
        System.out.println("AI " + name + " Moved to: " + move);
        return move;
    }

}
