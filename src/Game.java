public abstract class Game {

    protected Player player1;
    protected Player player2;
    protected Board board;
    protected int turn = 1;

    public Game(Player p1, Player p2, Board b){
        player1 = p1;
        player2 = p2;
        board = b;
    }

    public abstract void run();

    public int getTurn(){
        return turn;
    }

    public void move(){
        if (turn == 1){
            String move = player1.getMove(board);
            board.placePiece(move, player1.name);
            turn = 2;
        }
        else{
            String move = player2.getMove(board);
            board.placePiece(move, player2.name);
            turn = 1;
        }
    }

    public void win(Player p){
        System.out.println(p.name + " Wins!");
    }

}
