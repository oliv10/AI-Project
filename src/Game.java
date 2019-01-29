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
            turn = 2;
        }
        else{
            turn = 1;
        }
    }

    public void win(Player p){
        System.out.println(p.name + " Wins!");
    }

}
